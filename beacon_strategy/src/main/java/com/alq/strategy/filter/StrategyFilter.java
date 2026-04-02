package com.alq.strategy.filter;

import com.alq.common.model.StandardSubmit;

/**
 * @author 
 * @description
 */
public interface StrategyFilter {

    /**
     * 校验！！！！
     * @param submit
     */
    void strategy(StandardSubmit submit);
}
