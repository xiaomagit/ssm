package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Product;

import java.util.List;

public interface ProductDao {

    /**
     * 查询所有商品
     * @return
     * @throws Exception
     */
    public List<Product> findAll() throws Exception;

}
