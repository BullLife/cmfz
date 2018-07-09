package com.csh.cmfz.dao;

import com.csh.cmfz.entity.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2018/7/8.
 */
public interface ArticleDao {
    /**
     * 文章插入
     * @param article
     * @return 受影响的行数
     */
    public Integer insertArticle(@Param(value = "article") Article article);

    public Integer selectCount();
    /**
     * 查询所有文章（分页）
     * @param begin
     * @param end
     * @return
     */
    public List<Article> selectAllArticleOnPage(@Param("begin")Integer begin,@Param("end") Integer end);

    /**
     * 根据ID查找文章
     * @param id
     * @return
     */
    public Article selectArticleById(String id);

    /**
     * 更新文章
     * @param article
     * @return
     */
    public Integer updateAtricle(@Param("article") Article article);
}
