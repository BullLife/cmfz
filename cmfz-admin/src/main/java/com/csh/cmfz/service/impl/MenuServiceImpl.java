package com.csh.cmfz.service.impl;/**
 * Created by Administrator on 2018/7/5.
 */

import com.csh.cmfz.dao.MenuDao;
import com.csh.cmfz.entity.Menu;
import com.csh.cmfz.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description TODO
 * @Author 程少华
 * @Date 2018/7/5 10:36
 **/
@Service
@Transactional
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuDao menuDao;

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Menu> queryAllMenus() {
        return menuDao.selectAllMenus();
    }
}
