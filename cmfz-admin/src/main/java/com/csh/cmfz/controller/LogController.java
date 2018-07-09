package com.csh.cmfz.controller;

import com.csh.cmfz.entity.Log;
import com.csh.cmfz.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Author 程少华
 * @Date 2018/7/9 20:40
 **/
@Controller
@RequestMapping("/log")
public class LogController {
    @Autowired
    private LogService logService;

    @RequestMapping("/getlogs")
    public @ResponseBody Map<String,Object> getAllLogs(Integer page, Integer rows){
        List<Log> logs = logService.queryAllLog((page - 1) * rows, rows);
        Integer count = logService.queryCount();
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("total",count);
        map.put("rows",logs);
        return map;
    }
}
