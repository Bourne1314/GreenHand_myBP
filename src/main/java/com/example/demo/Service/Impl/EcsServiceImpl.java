package com.example.demo.Service.Impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.DAO.Ecs;
import com.example.demo.Mapper.EcsMapper;
import com.example.demo.Service.EcsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class EcsServiceImpl extends ServiceImpl<EcsMapper, Ecs> implements EcsService {
    @Resource
    EcsMapper ecsMapper;


}
