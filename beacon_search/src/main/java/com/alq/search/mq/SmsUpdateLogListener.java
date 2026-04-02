package com.alq.search.mq;

import com.alq.common.constant.RabbitMQConstants;
import com.alq.common.model.StandardReport;
import com.alq.search.service.SearchService;
import com.alq.search.utils.SearchUtils;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author
 * @description
 */
@Component
@Slf4j
public class SmsUpdateLogListener {

    @Autowired
    private SearchService searchService;

    @RabbitListener(queues = {RabbitMQConstants.SMS_GATEWAY_DEAD_QUEUE})
    public void consume(StandardReport report, Channel channel, Message message) throws IOException {
        try {
            log.info("【搜素模块-修改日志】 接收到修改日志的消息 report = {}", report);
            SearchUtils.set(report);
            Map<String, Object> doc = new HashMap<>();
            doc.put("reportState", report.getReportState());
            searchService.update(SearchUtils.getCurrYearIndex(), report.getSequenceId().toString(), doc);
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } finally {
            SearchUtils.remove();
        }
    }
}