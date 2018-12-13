package com.tianci.service.Impl;

import com.tianci.dto.OrderDTO;
import com.tianci.service.OrderService;
import com.tianci.service.PayService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Create by tianci
 * 2018/12/9 11:56
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class PayServiceImplTest {

    @Autowired
    private PayService payService;

    @Autowired
    private OrderService orderService;

    @Test
    public void create() {
        OrderDTO orderDTO = orderService.findByOrderId("1542763316634641126");
        payService.create(orderDTO);
    }
}