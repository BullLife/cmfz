package com.csh.cmfz.dao;

import com.csh.cmfz.entity.Article;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Administrator on 2018/7/8.
 */
public interface ArticleDao {
    public Integer insertArticle(@Param(value = "article") Article article);
}
