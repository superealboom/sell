package com.tianci.enums;

import lombok.Getter;

/**
 * Create by tianci
 * 2018/11/18 18:18
 */

@Getter
public enum PayStatusEnum implements CodeEnum {

    WAIT(0,"等待支付"),
    SUCCESS(1,"支付成功"),
    ;


    private Integer code;
    private String message;


    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
