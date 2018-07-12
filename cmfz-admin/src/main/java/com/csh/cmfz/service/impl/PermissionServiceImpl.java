package com.csh.cmfz.service.impl;

import com.csh.cmfz.dao.PermissionDao;
import com.csh.cmfz.entity.Permission;
import com.csh.cmfz.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description TODO
 * @Author 程少华
 * @Date 2018/7/12 19:50
 **/
@Service
@Transactional
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionDao permissionDao;

    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public List<Permission> queryPermissionByManagerName(String mgrName) {
        return permissionDao.selectPermissionByManageName(mgrName);
    }
}
