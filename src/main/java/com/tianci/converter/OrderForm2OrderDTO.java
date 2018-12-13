package com.tianci.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tianci.dataobject.OrderDetail;
import com.tianci.dto.OrderDTO;
import com.tianci.enums.ResultEnum;
import com.tianci.exception.SellException;
import com.tianci.form.OrderForm;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by tianci
 * 2018/11/20 17:24
 */
@Slf4j
public class OrderForm2OrderDTO {

    public static OrderDTO convert(OrderForm orderForm) {
        Gson gson = new Gson();

        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());

        List<OrderDetail> orderDetailList = new ArrayList<>();
        try {
            orderDetailList = gson.fromJson(orderForm.getItems(), new TypeToken<List<OrderDetail>>(){}.getType());
        } catch (Exception e) {
            log.error("【对象转换】错误，String={}", orderForm.getItems());
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        orderDTO.setOrderDetailList(orderDetailList);
//        BeanUtils.copyProperties(orderForm, orderDTO);
        return orderDTO;
    }

}
