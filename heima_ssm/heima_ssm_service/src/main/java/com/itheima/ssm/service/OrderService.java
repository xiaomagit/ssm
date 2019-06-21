package com.itheima.ssm.service;

import com.itheima.ssm.dao.OrdersDao;
import com.itheima.ssm.domain.Orders;
import org.springframework.stereotype.Service;

import java.util.List;

public interface OrderService {

    /**
     * 查询所有订单信息
     * @return
     */
    public List<Orders> findAll(int page,int size) throws Exception;


    /**
     * 订单详情查询
     * @param id
     * @return
     * @throws Exception
     */
    public Orders findById(String id) throws Exception;

}
