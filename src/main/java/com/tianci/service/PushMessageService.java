package com.tianci.service;

import com.tianci.dto.OrderDTO;

/**
 * Create by tianci
 * 2019/2/7 16:06
 */
public interface PushMessageService {

    public void orderStatus(OrderDTO orderDTO);
}
