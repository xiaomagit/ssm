package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TravellerDao {

    @Select("select * from order_traveller ot,traveller t where ot.travellerId = t.id and orderId =#{ordersId}")
    public List<Traveller> findByOrderId(String ordersId) throws Exception;

}
