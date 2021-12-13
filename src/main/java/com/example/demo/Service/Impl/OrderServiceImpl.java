package com.example.demo.Service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.Entity.RedHand;
import com.example.demo.Mapper.OrderMapper;
import com.example.demo.Service.OrderService;
import com.example.demo.feign.AccountApi;
import com.example.demo.feign.StockApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

@Service("OrderService")
public class OrderServiceImpl extends ServiceImpl<OrderMapper, RedHand> implements OrderService {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    private OrderService orderService;
    @Resource
    private StockApi stockApi;
    @Resource
    private AccountApi accountApi;

    /**
     * 创建订单
     *
     * @param order
     * @return 测试结果：
     * 1.添加本地事务：仅仅扣减库存
     * 2.不添加本地事务：创建订单，扣减库存
     */
    @Override
//    @GlobalTransactional(name = "fsp-create-order", rollbackFor = Exception.class)
    public void create(RedHand redHand) {
        LOGGER.info("------->交易开始");
        //本地方法
//        orderMapper.createOrder(order);
        System.out.println(redHand);
        orderService.save(redHand);
        LOGGER.info("订单处理完毕。");
        //远程方法 扣减库存
        stockApi.decrease(redHand.getProductId(), redHand.getCount());
        //远程方法 扣减账户余额
//        LOGGER.info("------->扣减账户开始order中");
//        accountApi.decrease(redHand.getUserId(), redHand.getMoney());
//        LOGGER.info("------->扣减账户结束order中");
//        LOGGER.info("------->交易结束");
    }

    /**
     * 修改订单状态
     */
    @Override
    public void update(Long userId, BigDecimal money, Integer status) {
        LOGGER.info("修改订单状态，入参为：userId={},money={},status={}", userId, money, status);
        orderService.update(userId, money, status);
    }
}
