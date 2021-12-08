package com.example.demo.Controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.Entity.GreenHand;
import com.example.demo.Service.GreenHandService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class GreenHandController {
    @Resource
    GreenHandService greenHandService;

    @RequestMapping(value="/getGreenHand",method = RequestMethod.GET)
    public List<GreenHand> list(){
        System.out.println("--------------菜鸟表list-------------");
        List<GreenHand> greenHands = greenHandService.list();
        return greenHands;
    }

    @RequestMapping(value="/getGreenHandBySql",method = RequestMethod.GET)
    public GreenHand listBySql(@RequestParam Integer age){
        System.out.println("--------------菜鸟表list-------------");
        GreenHand greenHand = greenHandService.greenHandSql(age);
        return greenHand;
    }

    @RequestMapping(value="/addGreenHand",method = RequestMethod.POST)
    public Boolean addGreenHand(@RequestBody GreenHand greenHand){
        System.out.println("--------------菜鸟表insert-------------");
        Boolean isSuccess = greenHandService.save(greenHand);
        return isSuccess;
    }

    @RequestMapping(value="/removeGreenHandById",method = RequestMethod.DELETE)
    public Boolean removeGreenHandById(@RequestParam Integer Id){
        System.out.println("--------------菜鸟表delete-------------");
        Boolean isSuccess = greenHandService.removeById(Id);
        return isSuccess;
    }

    @RequestMapping(value="/updateGreenHandById",method = RequestMethod.POST)
    public Boolean updateGreenHandById(@RequestBody GreenHand greenHand){
        System.out.println("--------------菜鸟表update-------------");
        Boolean isSuccess = greenHandService.updateById(greenHand);
        return isSuccess;
    }

    @RequestMapping(value="/listGreenHandByPage",method = RequestMethod.GET)
    public List<GreenHand> listByPage(@RequestParam Integer page,Integer size){
        System.out.println("--------------菜鸟表listByPage-------------");
        IPage<GreenHand> greenHandIPage = new Page<>(page,size);
        greenHandIPage = greenHandService.getBaseMapper().selectPage(greenHandIPage,null);
        List<GreenHand> greenHands = greenHandIPage.getRecords();
        return greenHands;
    }
}