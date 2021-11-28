package com.example.demo.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.DAO.GreenHand;

public interface GreenHandService extends IService<GreenHand> {
    GreenHand greenHandSql(Integer age);
}
