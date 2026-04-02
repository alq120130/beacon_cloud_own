package com.alq.monitor.task;


import com.alq.monitor.client.CacheClient;
import com.alq.monitor.util.MailUtil;
import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.mail.MessagingException;
import java.util.Map;
import java.util.Set;

/**
 * @author
 * @version V1.0.0
 */
@Component
@Slf4j
public class MonitorClientBalanceTask {

    // 客户余额限制，小于500 大洋，直接发送信息
    private final long balanceLimit = 500000;

    private final String CLIENT_BALANCE_PATTERN = "client_balance:*";

    private final String BALANCE = "balance";

    private final String EMAIL = "extend1";

    private String text = "客户您好，你在【烽火短信平台】内的余额仅剩余%s元，请您及时补充金额，避免影响你您的短信发送！！";

    @Autowired
    private CacheClient cacheClient;

    @Autowired
    private MailUtil mailUtil;

    @XxlJob("monitorClientBalanceTask")
    public void monitor() throws MessagingException {
        //1、查询客户余额信息。
        Set<String> keys = cacheClient.keys(CLIENT_BALANCE_PATTERN);

        for (String key : keys) {
            Map map = cacheClient.hGetAll(key);
            // 为了防止 balance 字段也不存在导致报空指针，最好也加个判空（视你的数据严谨度而定）
            Object balanceObj = map.get(BALANCE);
            if (balanceObj == null) {
                continue;
            }

            Long balance =  Long.parseLong(balanceObj.toString());
            String email = (String) map.get(EMAIL);

            // 2、判断余额是否小于限制，并且！邮箱地址不能为空，才能发送邮件
            if(balance < balanceLimit){
                if (StringUtils.hasText(email)) {
                    mailUtil.sendEmail(email,"【烽火短信平台】提醒您余额不足。",String.format(text,balance/1000));
                } else {
                    // 如果没有配置邮箱，可以打印个日志记录一下，而不是让程序直接崩溃
                    log.warn("客户 {} 余额不足，但未配置邮箱，无法发送通知邮件！", key);
                }
            }
        }
    }

}
