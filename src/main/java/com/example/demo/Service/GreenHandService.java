package com.example.demo.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.Entity.GreenHand;
import org.springframework.transaction.annotation.Transactional;

public interface GreenHandService extends IService<GreenHand> {
    GreenHand greenHandSql(Integer age);
}
