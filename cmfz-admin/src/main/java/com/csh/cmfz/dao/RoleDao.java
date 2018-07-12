package com.csh.cmfz.dao;

import com.csh.cmfz.entity.Role;

import java.util.List;

/**
 * Created by Administrator on 2018/7/12.
 */
public interface RoleDao {

    public List<Role> selectRoleByManageName(String mgrName);
}
