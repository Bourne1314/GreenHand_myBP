package com.example.demo.Controller;

import com.example.demo.Config.R;
import com.example.demo.DAO.Ecs;
import com.example.demo.DAO.GreenHand;
import com.example.demo.DAO.ResponseResult;
import com.example.demo.Service.EcsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class EcsController {
    @Autowired
    EcsService ecsService;

    @RequestMapping(value="/getEcsPrice",method = RequestMethod.GET)
    public R getEcsPrice(@RequestParam("coreNumber") Integer coreNumber, @RequestParam("memNumber") Integer memNumber, @RequestParam("yearNumber") Integer yearNumber){
        Float ecs = ecsService.getBySpe(coreNumber,memNumber,yearNumber);
        R r = new R();
        return r.put("price",ecs);
    }
}