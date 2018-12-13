package com.tianci.controller;

import com.lly835.bestpay.model.PayResponse;
import com.tianci.dto.OrderDTO;
import com.tianci.enums.ResultEnum;
import com.tianci.exception.SellException;
import com.tianci.service.OrderService;
import com.tianci.service.PayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * 支付
 * Create by tianci
 * 2018/12/1 9:57
 */

@Controller
@Slf4j
@RequestMapping("pay")
public class PayController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private PayService payService;

    @GetMapping("create")
    public ModelAndView create(@RequestParam("orderId") String orderId,
                               @RequestParam("returnUrl") String returnUrl,
                               Map<String, Object> map) {

        OrderDTO orderDTO = orderService.findByOrderId(orderId);
        if(orderDTO == null) {
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }

        //2.发起支付
        PayResponse payResponse = payService.create(orderDTO);
        map.put("payResponse", payResponse);
        map.put("returnUrl", returnUrl);
        return new ModelAndView("/pay/create",map);
    }


    @PostMapping("/notify")
    public ModelAndView notify(@RequestBody String notifyData) {
        payService.notify(notifyData);

        //返回给微信处理结果
        return new ModelAndView("/pay/success");
    }
}
