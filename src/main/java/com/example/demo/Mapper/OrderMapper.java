package com.example.demo.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.Entity.RedHand;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper extends BaseMapper<RedHand> {
//    @Select("INSERT INTO `order` VALUES (#{id},#{userId},#{productId},#{count},#{money},#{status})")
//    void createOrder(Order order);
}
