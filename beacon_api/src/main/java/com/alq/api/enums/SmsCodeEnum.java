package com.alq.api.enums;

import lombok.Getter;

/**
 * @Auther: 
 * @Date: 2026/3/30 - 03 - 30 - 12:37
 * @Description: com.alq.api.enums
 * @version: 1.0
 */
@Getter
public enum SmsCodeEnum {
    PARAMETER_ERROR(-10,"参数不合法！");

    private Integer code;
    private String msg;

    SmsCodeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
