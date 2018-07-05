package com.csh.cmfz.controller;/**
 * Created by Administrator on 2018/7/5.
 */

import com.csh.cmfz.entity.Menu;
import com.csh.cmfz.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Method;
import java.util.List;

/**
 * @Description TODO
 * @Author 程少华
 * @Date 2018/7/5 10:51
 **/
@Controller
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @RequestMapping(value = "/getmenus",method = RequestMethod.GET)
    public @ResponseBody List<Menu> getAllMenus(){
        return menuService.queryAllMenus();
    }

}
