package com.tianci.dataobject;

import lombok.Data;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * 商品信息
 * Create by tianci
 * 2018/11/8 11:41
 */
@Entity
@Data
@Proxy(lazy=false)
public class ProductInfo {
    /*产品ID*/
    @Id
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
    /*状态，0正常，1下架*/
    private Integer productStatus;
    /*类目编号*/
    private Integer categoryType;

    public ProductInfo() {
    }
}
