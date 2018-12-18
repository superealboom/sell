package com.tianci.enums;

import lombok.Getter;

/**
 * Create by tianci
 * 2018/11/18 18:14
 */

@Getter
public enum OrderStatusEnum implements CodeEnum {
    NEW(0,"新下单"),
    FINISHED(1,"完结"),
    CANCEL(2,"取消"),
    ;

    private Integer code;
    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
