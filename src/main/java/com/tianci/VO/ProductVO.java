package com.tianci.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * 商品(包含类目)
 * Create by tianci
 * 2018/11/8 16:02
 */
@Data
public class ProductVO {

    /*类目名称*/
    @JsonProperty("name")
    private String categoryName;
    /*类目编号*/
    @JsonProperty("type")
    private Integer categoryType;
    /*类目下所属食物集合*/
    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;
}
