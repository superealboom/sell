package com.tianci.dto;

import lombok.Data;

/**
 * Create by tianci
 * 2018/11/19 14:47
 */
@Data
public class CartDTO {
    /* 商品ID */
    private String productId;
    /* 商品库存 */
    private Integer productStock;

    public CartDTO(String productId, Integer productStock) {
        this.productId = productId;
        this.productStock = productStock;
    }
}
