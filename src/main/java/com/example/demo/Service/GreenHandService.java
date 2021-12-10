package com.example.demo.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.Entity.GreenHand;

import java.util.List;

public interface GreenHandService extends IService<GreenHand> {
    GreenHand greenHandSql(Integer age);
}
