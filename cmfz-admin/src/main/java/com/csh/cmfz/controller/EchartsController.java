package com.csh.cmfz.controller;

import com.csh.cmfz.entity.EchartsChina;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 数据分析
 * @Author 程少华
 * @Date 2018/7/9 14:15
 **/
@Controller
@RequestMapping("/echarts")
public class EchartsController {

    @RequestMapping(value = "/china",method = RequestMethod.POST)
    public @ResponseBody List<EchartsChina> getChina(){
        List<EchartsChina> list = new ArrayList<EchartsChina>();
        list.add(new EchartsChina("北京","100"));
        list.add(new EchartsChina("河南","80"));
        list.add(new EchartsChina("澳门","60"));
        list.add(new EchartsChina("台湾","55"));
        list.add(new EchartsChina("香港","12"));
        list.add(new EchartsChina("海南","2131"));
        list.add(new EchartsChina("广东","12"));
        list.add(new EchartsChina("福建","32"));
        list.add(new EchartsChina("广西","57"));
        list.add(new EchartsChina("上海","99"));
        return list;
    }
}
