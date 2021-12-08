package com.example.demo.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.Entity.RedHand;

import java.math.BigDecimal;

public interface OrderService extends IService<RedHand> {

    /**
     * 创建订单
     *
     * @param order
     * @return
     */
    void create(RedHand redHand);

    /**
     * 修改订单状态
     *
     * @param userId
     * @param money
     * @param status
     */
    void update(Long userId, BigDecimal money, Integer status);

}
