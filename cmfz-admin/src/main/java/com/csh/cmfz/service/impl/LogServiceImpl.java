package com.csh.cmfz.service.impl;

import com.csh.cmfz.dao.LogDao;
import com.csh.cmfz.entity.Category;
import com.csh.cmfz.entity.Log;
import com.csh.cmfz.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description TODO
 * @Author 程少华
 * @Date 2018/7/9 18:46
 **/
@Service
@Transactional
public class LogServiceImpl implements LogService {
    @Autowired
    private LogDao logDao;

    @Override
    public Integer augmentLog(Log log) {
        return logDao.insertLog(log);
    }

    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public List<Log> queryAllLog(Integer begin, Integer end) {
        return logDao.selectAllLogsOnPage(begin,end);
    }

    @Override
    public Integer queryCount() {
        return logDao.selectCount();
    }
}
