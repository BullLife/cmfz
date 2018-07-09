package com.csh.cmfz.service;

import com.csh.cmfz.entity.Log;

import java.util.List;

/**
 * Created by Administrator on 2018/7/9.
 */
public interface LogService {

    public Integer augmentLog(Log log);

    public List<Log> queryAllLog(Integer begin,Integer end);

    public Integer queryCount();
}
