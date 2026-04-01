package com.alq.strategy.filter;

import com.alq.common.model.StandardSubmit;

/**
 * @author alq
 * @description
 */
public interface StrategyFilter {

    /**
     * 校验！！！！
     * @param submit
     */
    void strategy(StandardSubmit submit);
}
