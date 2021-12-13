package com.example.demo.Service.Impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.Entity.GreenHand;
import com.example.demo.Mapper.GreenHandMapper;
import com.example.demo.Service.GreenHandService;
import com.example.demo.feign.StockApi;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import io.seata.sqlparser.SQLRecognizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.rmi.runtime.NewThreadAction;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.lang.reflect.Constructor;
import java.util.List;


@Service("GreenHandService")
public class GreenHandServiceImpl extends ServiceImpl<GreenHandMapper, GreenHand> implements GreenHandService {
    @Resource
    GreenHandMapper greenHandMapper;
    @Autowired
    StockApi stockApi;
    @Autowired
    GreenHandService greenHandService;

    @Override
    @GlobalTransactional(name = "fsp-create-order", rollbackFor = Exception.class)
    public GreenHand greenHandSql(Integer age){
        GreenHand greenHand1 = greenHandService.getOne(new QueryWrapper<GreenHand>().eq("AGE",age));
        greenHand1.setCity("lalalan");
        greenHandService.updateById(greenHand1);
        System.out.println(greenHand1);
        GreenHand greenHand  =  stockApi.getGreenHand(age);
        System.out.println(RootContext.getXID());
//        throw  new RuntimeException("123");
        return greenHand;
    }



//    @Override
//    @GlobalTransactional(name = "fsp-create-order", rollbackFor = Exception.class)
//    public GreenHand greenHandSql(Integer age){
//        GreenHand greenHand  =  greenHandMapper.greenHandSql(age);
//        return greenHand;
//    }
}