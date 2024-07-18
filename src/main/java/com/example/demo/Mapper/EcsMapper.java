package com.example.demo.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.DAO.Ecs;

import com.example.demo.DAO.GreenHand;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface EcsMapper extends BaseMapper<Ecs> {

    @Select("select priceNumber from uncloud_ecs where coreNumber = #{coreNumber} and memNumber= #{memNumber} and yearNumber=#{yearNumber};")
    Float getBySpe(Integer coreNumber,Integer memNumber,Integer yearNumber);
}
