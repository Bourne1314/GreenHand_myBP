package com.example.demo.Mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.Entity.GreenHand;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface GreenHandMapper extends BaseMapper<GreenHand> {
    @Select("select * from GREEN_HAND where AGE = #{age}")
    GreenHand greenHandSql(Integer age);

//    @Insert("insert into GREEN_HAND ")
//    insertByHand(GreenHand greenHand);
}
