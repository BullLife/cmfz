package com.csh.cmfz.dao;

import com.csh.cmfz.entity.Manager;
import org.apache.ibatis.annotations.Param;

/**
 * 管理员
 * @Author 程少华
 * Created by Administrator on 2018/7/4.
 */
public interface ManagerDao {
    /**
     * 向数据库中插入管理员用户
     * @Author 程少华
     * @param mgr 向数据库中插入的管理员信息
     */
    public Integer insertManager(@Param("mgr") Manager mgr);
    /**
     * 根据id查找管理员用户
     * @Author 程少华
     * @param id  查询的条件
     */
    public Manager selectManagerById(String id);
}
