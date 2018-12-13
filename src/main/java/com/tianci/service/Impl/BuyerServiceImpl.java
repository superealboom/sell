package com.tianci.service.Impl;

import com.tianci.dto.OrderDTO;
import com.tianci.enums.ResultEnum;
import com.tianci.exception.SellException;
import com.tianci.service.BuyerService;
import com.tianci.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Create by tianci
 * 2018/11/21 11:03
 */
@Service
@Slf4j
public class BuyerServiceImpl implements BuyerService {

    @Autowired
    OrderService orderService;

    @Override
    public OrderDTO findOrderOne(String openid, String orderId) {
        return checkOrderOwner(openid, orderId);
    }

    @Override
    public OrderDTO cancelOrder(String openid, String orderId) {
        OrderDTO orderDTO = checkOrderOwner(openid, orderId);
        if (orderDTO == null) {
            log.error("【取消订单】 查不到订单，OrderId={}",orderId);
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
        }
        return orderService.cancel(orderDTO);
    }

    private OrderDTO checkOrderOwner(String openid, String orderId) {
        OrderDTO orderDTO = orderService.findByOrderId(orderId);
        if (orderDTO == null) {
            return null;
        }
        //判断是否是自己的订单
        if (orderDTO.getOrderId().equalsIgnoreCase(openid)) {
            log.error("【查询订单】 订单的openid不一致. openid={}, orderDTO={}", openid, orderDTO);
            throw new SellException(ResultEnum.ORDER_OWNER_ERROR);
        }
        return orderDTO;
    }
}
