package com.example.demo;

import com.example.demo.DAO.GreenHand;
import com.example.demo.Mapper.GreenHandMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private GreenHandMapper greenHandMapper;
    @Test
    void ListGreenHand() {
        System.out.println("----------------菜鸟test--------------");
        List<GreenHand> greenHandList = greenHandMapper.selectList(null);
        for(GreenHand greenHand:greenHandList)
        {
            System.out.println(greenHand);
        }
    }
    @Test
    void insertGreenHand(){
        System.out.println("--------------菜鸟表insert-------------");
        GreenHand greenHand = new GreenHand();
        greenHand.setId(10);
        greenHand.setAge(7);
        greenHand.setName("神秘的菜鸟");
        greenHand.setCity("江苏连云港");
        greenHand.setEducation("大学本科");
        greenHand.setTel("18969255555");
        greenHand.setCodeLanguage("c#");
        System.out.println(greenHand);
        greenHandMapper.insert(greenHand);
    }
    @Test
    void deleteGreenHand(){
        System.out.println("--------------菜鸟表delete--------------");
        greenHandMapper.deleteById(10);
    }
    @Test
    void updateGreenHand(){
        System.out.println("--------------菜鸟表update--------------");

    }
//    @Test
//    public void testPage() {
//        // Step1：创建一个 Page 对象
//        Page<GreenHand> page = new Page<>();
//        // Page<User> page = new Page<>(2, 5);
//        // Step2：调用 mybatis-plus 提供的分页查询方法
//        userService.page(page, null);
//        // Step3：获取分页数据
//        System.out.println(page.getCurrent()); // 获取当前页
//        System.out.println(page.getTotal()); // 获取总记录数
//        System.out.println(page.getSize()); // 获取每页的条数
//        System.out.println(page.getRecords()); // 获取每页数据的集合
//        System.out.println(page.getPages()); // 获取总页数
//        System.out.println(page.hasNext()); // 是否存在下一页
//        System.out.println(page.hasPrevious()); // 是否存在上一页
//    }

}
