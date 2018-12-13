package com.tianci.service.Impl;

import com.tianci.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Create by tianci
 * 2018/11/8 10:48
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {

    @Autowired
    private CategoryServiceImpl categoryService;

    @Test
    public void findOne() {
        ProductCategory productCategory = categoryService.findOne(1);
        System.out.println(productCategory.toString());
        Assert.assertEquals(new Integer(1), productCategory.getCategoryId());
    }

    @Test
    public void findAll() {
        List<ProductCategory> productCategoryList = categoryService.findAll();
        Assert.assertNotEquals(0,productCategoryList.size());
    }

    @Test
    public void findByCategoryTypeIn() {
        List<Integer> integerList = Arrays.asList(1,2,3,4);
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(integerList);
        Assert.assertNotEquals(0,productCategoryList);
    }

    @Test
    public void save() {
        ProductCategory productCategory = categoryService.save(new ProductCategory("今日上新", 4));
        Assert.assertNotNull(productCategory);
    }
}