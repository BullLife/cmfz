package com.csh.cmfz.service.impl;

import com.csh.cmfz.dao.RoleDao;
import com.csh.cmfz.entity.Role;
import com.csh.cmfz.service.RoleService;
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
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public List<Role> queryRoleByManagerName(String mgrName) {
        return roleDao.selectRoleByManageName(mgrName);
    }
}
