package com.example.demo.Service.Impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.Entity.GreenHand;
import com.example.demo.Mapper.GreenHandMapper;
import com.example.demo.Service.GreenHandService;
import com.example.demo.feign.StockApi;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


@Service("GreenHandService")
public class GreenHandServiceImpl extends ServiceImpl<GreenHandMapper, GreenHand> implements GreenHandService {
    @Resource
    GreenHandMapper greenHandMapper;
    @Autowired
    StockApi stockApi;

    @Override
    @GlobalTransactional(name = "fsp-create-order", rollbackFor = Exception.class)
    @Transactional
    public GreenHand greenHandSql(Integer age){
        System.out.println(age);
        GreenHand greenHand  =  stockApi.getGreenHand(age);
        throw  new RuntimeException("123");
//        return greenHand;
    }



//    @Override
//    @GlobalTransactional(name = "fsp-create-order", rollbackFor = Exception.class)
//    public GreenHand greenHandSql(Integer age){
//        GreenHand greenHand  =  greenHandMapper.greenHandSql(age);
//        return greenHand;
//    }
}