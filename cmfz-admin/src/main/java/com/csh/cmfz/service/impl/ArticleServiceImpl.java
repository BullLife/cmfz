package com.csh.cmfz.service.impl;

import com.csh.cmfz.dao.ArticleDao;
import com.csh.cmfz.entity.Article;
import com.csh.cmfz.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description TODO
 * @Author 程少华
 * @Date 2018/7/8 20:33
 **/
@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleDao articleDao;

    @Override
    public Integer addArticle(Article article) {
        return articleDao.insertArticle(article);
    }
}
