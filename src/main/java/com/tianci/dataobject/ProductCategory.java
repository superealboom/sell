package com.tianci.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 类目
 * Create by tianci
 * 2018/11/7 14:22
 */
@Entity
@DynamicUpdate
@Data
@Proxy(lazy=false)
public class ProductCategory {

    /*类目ID*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;
    /*类目名称*/
    private String categoryName;
    /*类目编号 */
    private Integer categoryType;

    public ProductCategory() {
    }

    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }
}
