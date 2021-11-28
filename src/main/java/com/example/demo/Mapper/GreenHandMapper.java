package com.example.demo.Mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.DAO.GreenHand;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface GreenHandMapper extends BaseMapper<GreenHand> {
    @Select("select * from green_hand where AGE = #{age}")
    GreenHand greenHandSql(Integer age);
}
