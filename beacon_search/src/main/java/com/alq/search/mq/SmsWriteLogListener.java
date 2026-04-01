package com.alq.search.mq;

import com.alq.common.constant.RabbitMQConstants;
import com.alq.common.model.StandardSubmit;
import com.alq.common.util.JsonUtil;
import com.alq.search.service.SearchService;
import com.alq.search.utils.SearchUtils;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author alq
 * @description
 */
@Component
@Slf4j
public class SmsWriteLogListener {

    @Autowired
    private SearchService searchService;

    @RabbitListener(queues = RabbitMQConstants.SMS_WRITE_LOG)
    public void consume(StandardSubmit submit, Channel channel, Message message) throws IOException {
        log.info("接收到存储日志的信息   submit = {}", submit);
        searchService.index(SearchUtils.getCurrYearIndex(), submit.getSequenceId().toString(), JsonUtil.obj2JSON(submit));
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
    }
}