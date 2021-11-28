package com.example.demo.Service.Impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.DAO.GreenHand;
import com.example.demo.Mapper.GreenHandMapper;
import com.example.demo.Service.GreenHandService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class GreenHandServiceImpl extends ServiceImpl<GreenHandMapper, GreenHand> implements GreenHandService {
    @Resource
    GreenHandMapper greenHandMapper;

    @Override
    public GreenHand greenHandSql(Integer age){
        GreenHand greenHand  =  greenHandMapper.greenHandSql(age);
        return greenHand;
    }
}