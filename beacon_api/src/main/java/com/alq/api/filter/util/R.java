package com.alq.api.filter.util;

import com.alq.api.vo.ResultVO;
import com.alq.common.exception.ApiException;

/**
 * @Auther: alq
 * @Date: 2026/3/30 - 03 - 30 - 12:22
 * @Description: com.alq.api.filter.util
 * @version: 1.0
 */
public class R {

    public static ResultVO ok(){
        ResultVO r = new ResultVO();
        r.setCode(0);
        r.setMsg("接收成功");
        return r;
    }
    public static ResultVO error(Integer code ,String msg) {
        ResultVO r = new ResultVO();
        r.setCode(code);
        r.setMsg(msg);
        return r;
    }
    public static ResultVO error(ApiException ex) {
        ResultVO r = new ResultVO();
        r.setCode(ex.getCode());
        r.setMsg(ex.getMessage());
        return r;
    }
}
