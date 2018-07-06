package com.csh.cmfz.service.impl;

import com.csh.cmfz.dao.GuruDao;
import com.csh.cmfz.entity.Guru;
import com.csh.cmfz.service.GuruService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description TODO
 * @Author 程少华
 * @Date 2018/7/6 16:40
 **/
@Service
@Transactional
public class GuruServiceImpl implements GuruService {
    @Autowired
    private GuruDao guruDao;

    @Override
    public Integer addGuru(Guru guru) {
        return guruDao.insertGuru(guru);
    }

    @Override
    public Integer modifyGuru(Guru guru) {
        return guruDao.updateGuru(guru);
    }

    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public Integer queryCount() {
        return guruDao.selectCount();
    }

    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public List<Guru> queryGurusOnPage(Integer begin, Integer end) {
        return guruDao.selectGurusOnPage(begin,end);
    }

    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public Integer queryCountByTrim(Guru guru) {
        return guruDao.selectCountByTrim(guru);
    }

    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public List<Guru> queryGurusByTrim(Integer begin, Integer end, Guru guru) {
        return guruDao.selectGurusByTrim(begin,end,guru);
    }

    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public Guru queryGuruById(String id) {
        return guruDao.selectGuruById(id);
    }
}
