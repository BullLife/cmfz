package com.csh.cmfz.service.impl;

import com.csh.cmfz.dao.ArticleDao;
import com.csh.cmfz.entity.Article;
import com.csh.cmfz.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public Integer queryCount() {
        return articleDao.selectCount();
    }

    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public List<Article> queryAllArticlesOnPage(Integer begin, Integer end) {
        return articleDao.selectAllArticleOnPage(begin, end);
    }

    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public Article queryArticleById(String id) {
        return articleDao.selectArticleById(id);
    }

    @Override
    public Integer modifyAtricle(Article article) {
        return articleDao.updateAtricle(article);
    }
}
