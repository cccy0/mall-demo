package com.cccy.mall.tiny.service;

import com.cccy.mall.tiny.common.api.CommonResult;
import com.cccy.mall.tiny.dto.OrderParam;
import org.springframework.transaction.annotation.Transactional;

/**
 * 前台订单管理Service
 * @author Zhai
 * 2020/9/2 23:36
 */

public interface OmsPortalOrderService {
    /**
     * 根据提交信息生成订单
     */
    @Transactional
    CommonResult generateOrder(OrderParam orderParam);

    /**
     * 取消单个超时订单
     */
    @Transactional
    void cancelOrder(Long orderId);
}
