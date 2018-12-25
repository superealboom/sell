package com.tianci.form;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Create by tianci
 * 2018/12/21 11:14
 */
@Data
public class productForm {

    /*产品ID*/
    private String productId;
    /*商品名称*/
    private String productName;
    /*单价*/
    private BigDecimal productPrice;
    /*库存*/
    private Integer productStock;
    /*描述*/
    private String productDescription;
    /*小图*/
    private String productIcon;
    /*类目编号*/
    private Integer categoryType;
}
