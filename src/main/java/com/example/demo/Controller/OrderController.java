/*
 *  Copyright 1999-2021 Seata.io Group.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.example.demo.Controller;

import com.example.demo.Entity.RedHand;
import com.example.demo.Service.OrderService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author IT云清
 */
@RestController
@RequestMapping("order")
public class OrderController {

    @Resource
    private OrderService orderService;

    /**
     * 创建订单
     *
     * @param redHand
     * @return
     */
    @GetMapping("create")
    public String create(RedHand redHand) {
        System.out.println("123");
        orderService.create(redHand);
        return "Create order success";
    }
    /**
     * 创建订单
     *
     * @param order
     * @return
     */
    @RequestMapping("getcreate")
    public List<RedHand> getcreate() {
        return orderService.list();

    }

//    /**
//     * 修改订单状态
//     *
//     * @param userId
//     * @param money
//     * @param status
//     * @return
//     */
//    @RequestMapping("update")
//    String update(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money,
//                  @RequestParam("status") Integer status) {
//        orderService.update(userId, money, status);
//        return "订单状态修改成功";
//    }
}
