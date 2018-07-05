package com.csh.cmfz.dao;

import com.csh.cmfz.entity.Manager;
import com.csh.cmfz.entity.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 菜单栏查找
 * @Author 程少华
 * Created by Administrator on 2018/7/5.
 */
public interface MenuDao {
    /**
     * 查找所有菜单项
     * @Author 程少华
     */
    public List<Menu> selectAllMenus();
}
