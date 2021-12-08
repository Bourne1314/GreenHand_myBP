package com.example.demo.Service.Impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.Entity.GreenHand;
import com.example.demo.Mapper.GreenHandMapper;
import com.example.demo.Service.GreenHandService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service("GreenHandService")
public class GreenHandServiceImpl extends ServiceImpl<GreenHandMapper, GreenHand> implements GreenHandService {
    @Resource
    GreenHandMapper greenHandMapper;

    @Override
    @GlobalTransactional(name = "fsp-create-order", rollbackFor = Exception.class)
    public GreenHand greenHandSql(Integer age){
        GreenHand greenHand  =  greenHandMapper.greenHandSql(age);
        return greenHand;
    }
}