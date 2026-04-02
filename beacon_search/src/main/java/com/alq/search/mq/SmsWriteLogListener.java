package com.alq.search.mq;

import com.alq.common.constant.RabbitMQConstants;
import com.alq.common.model.StandardSubmit;
import com.alq.common.util.JsonUtil;
import com.alq.search.service.SearchService;
import com.alq.search.utils.SearchUtils;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.ZoneOffset;
import java.util.Map;

/**
 * @author
 * @description
 */
@Component
@Slf4j
public class SmsWriteLogListener {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Autowired
    private SearchService searchService;

    @RabbitListener(queues = RabbitMQConstants.SMS_WRITE_LOG)
    public void consume(StandardSubmit submit, Channel channel, Message message) throws IOException {
        log.info("接收到存储日志的信息   submit = {}", submit);
        Map<String, Object> doc = OBJECT_MAPPER.readValue(
                JsonUtil.obj2JSON(submit),
                new TypeReference<Map<String, Object>>() {
                }
        );
        if (submit.getSendTime() != null) {
            doc.put("sendTime", submit.getSendTime().toInstant(ZoneOffset.of("+8")).toEpochMilli());
        }
        searchService.index(SearchUtils.getCurrYearIndex(), submit.getSequenceId().toString(), JsonUtil.obj2JSON(doc));
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
    }
}
