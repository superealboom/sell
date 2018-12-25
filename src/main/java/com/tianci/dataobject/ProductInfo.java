package com.tianci.dataobject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tianci.enums.ProductStatusEnum;
import com.tianci.utils.EnumUtil;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品信息
 * Create by tianci
 * 2018/11/8 11:41
 */
@Entity
@Data
@Proxy(lazy=false)
@DynamicUpdate
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
    private Integer productStatus = ProductStatusEnum.UP.getCode();
    /*类目编号*/
    private Integer categoryType;

    private Date createTime;

    private Date updateTime;

    @JsonIgnore
    public ProductStatusEnum getProductStatusEnum() {
        return EnumUtil.getBycode(productStatus, ProductStatusEnum.class);
    }
}
