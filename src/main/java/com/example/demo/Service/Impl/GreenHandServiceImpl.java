package com.example.demo.Service.Impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.Entity.GreenHand;
import com.example.demo.Mapper.GreenHandMapper;
import com.example.demo.Service.GreenHandService;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


@Service("GreenHandService")
public class GreenHandServiceImpl extends ServiceImpl<GreenHandMapper, GreenHand> implements GreenHandService {
    @Resource
    GreenHandMapper greenHandMapper;
    @Resource
    GreenHandService greenHandService;

    @Override
    @Transactional
    public GreenHand greenHandSql(Integer age){
        GreenHand greenHand  =  greenHandMapper.greenHandSql(age);
        greenHand.setAge(greenHand.getAge()+1);
        greenHand.setId(greenHand.getId()+301);
        greenHand.setCity("gre"+greenHand.getAge());
        System.out.println(greenHand);
        greenHandService.save(greenHand);
//        System.out.println();
        GreenHand greenHand1 = greenHandService.getById(greenHand.getId());
//        throw new RuntimeException("321");
        System.out.println("====end====");
        return greenHand1;
    }
}