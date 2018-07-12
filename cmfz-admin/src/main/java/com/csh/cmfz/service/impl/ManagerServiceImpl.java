package com.csh.cmfz.service.impl;

import com.csh.cmfz.dao.ManagerDao;
import com.csh.cmfz.entity.Manager;
import com.csh.cmfz.service.ManagerService;
import com.csh.cmfz.util.Codec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description
 * @Author 程少华
 * @Date 2018/7/4 13:20
 **/
@Service
@Transactional
public class ManagerServiceImpl implements ManagerService{

    @Autowired
    private ManagerDao md;

    public Integer addManager(Manager mgr) {
        String pwd = Codec.encryption(mgr.getMgrPwd()+mgr.getMgrSalt());
        mgr.setMgrPwd(pwd);
        return md.insertManager(mgr);
    }

    @Transactional(propagation= Propagation.SUPPORTS,readOnly=true)
    public Manager queryManagerByName(String mgrName) {
        return md.selectManagerByName(mgrName);
    }
}
