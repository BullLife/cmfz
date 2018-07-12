package com.csh.cmfz.service;

import com.csh.cmfz.entity.Manager;

/**
 * Created by Administrator on 2018/7/4.
 */
public interface ManagerService {
    /**
     * 向数据库中插入管理员用户
     * @Author 程少华
     * @param mgr 向数据库中插入的管理员信息
     */
    public Integer addManager(Manager mgr);
    /**
     * 根据id查找管理员用户
     * @Author 程少华
     * @param mgrName  查询的条件
     */
    public Manager queryManagerByName(String mgrName);
}
