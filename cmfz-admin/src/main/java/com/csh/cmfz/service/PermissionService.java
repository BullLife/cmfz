package com.csh.cmfz.service;

import com.csh.cmfz.entity.Permission;

import java.util.List;

/**
 * Created by Administrator on 2018/7/12.
 */
public interface PermissionService {

    public List<Permission> queryPermissionByManagerName(String mgrName);

}
