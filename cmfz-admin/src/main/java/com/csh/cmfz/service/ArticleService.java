package com.csh.cmfz.service;

import com.csh.cmfz.entity.Article;

import java.util.List;

/**
 * Created by Administrator on 2018/7/8.
 */
public interface ArticleService {
    public Integer addArticle(Article article);

    public Integer queryCount();

    public List<Article> queryAllArticlesOnPage(Integer begin,Integer end);

    public Article queryArticleById(String id);

    public Integer modifyAtricle(Article article);
}
