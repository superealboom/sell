package com.tianci.service;

import com.tianci.dataobject.ProductCategory;

import java.util.List;

/**
 * 类目
 * Create by tianci
 * 2018/11/8 10:19
 */
public interface CategoryService {

    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);
}
