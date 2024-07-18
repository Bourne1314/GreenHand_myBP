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

    // 当查到数据库中没有对应姓名记录时，插入
    void addEcs(Ecs ecs);
    // 当数据库中有对应姓名记录时，更新
    int updateEcsById(Ecs ecs);
    // 判断是都存在对应的姓名记录
    int selectByName(String name);
}
