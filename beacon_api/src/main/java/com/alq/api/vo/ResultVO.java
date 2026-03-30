package com.alq.api.vo;

import lombok.Data;

/**
 * @Auther: alq
 * @Date: 2026/3/30 - 03 - 30 - 12:22
 * @Description: com.alq.api.vo
 * @version: 1.0
 */
@Data
public class ResultVO {

    private Integer code;

    private String msg;

    private Integer count;

    private Long fee;

    private String uid;

    private String sid;
}
