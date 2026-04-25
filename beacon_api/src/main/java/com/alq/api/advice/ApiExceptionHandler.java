package com.alq.api.advice;


import com.alq.api.filter.util.R;
import com.alq.api.vo.ResultVO;
import com.alq.common.exception.ApiException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author alq
 * @description
 */
@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(ApiException.class)
    public ResultVO apiException(ApiException ex){
        return R.error(ex);
    }


}
