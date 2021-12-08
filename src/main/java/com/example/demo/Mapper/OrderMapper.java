package com.example.demo.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.Entity.Order;
import org.apache.ibatis.annotations.Select;

public interface OrderMapper extends BaseMapper<Order> {
    @Select("INSERT INTO `order` VALUES (#{id},#{userId},#{productId},#{count},#{money},#{status})")
    void createOrder(Order order);
}
