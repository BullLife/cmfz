package com.csh.cmfz.service;

import com.csh.cmfz.entity.Guru;

import java.util.List;

/**
 * Created by Administrator on 2018/7/6.
 */
public interface GuruService {

    public Integer addGuru(Guru guru);

    public void addSomeGuru(List<Guru> gurus);

    public Integer modifyGuru(Guru guru);

    public Integer queryCount();

    public List<Guru> queryGurusOnPage(Integer begin, Integer end);

    public Integer queryCountByTrim(Guru guru);

    public List<Guru> queryGurusByTrim(Integer begin, Integer end,Guru guru);

    public Guru queryGuruById(String id);
}
