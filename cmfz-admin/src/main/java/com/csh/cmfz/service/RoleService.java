package com.csh.cmfz.service;

import com.csh.cmfz.entity.Role;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2018/7/12.
 */
public interface RoleService {

    public List<Role> queryRoleByManagerName(String mgrName);

}
