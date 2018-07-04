package com.csh.cmfz.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 文章表
 */
public class Article implements Serializable {
  private String articleId;
  private String articleName;
  private String introduction;
  private String articlePic; //文章照片的路径
  private Date publishDate;
  private String guruId;

  public Article() {
  }

  @Override
  public String toString() {
    return "Article{" +
            "articleId='" + articleId + '\'' +
            ", articleName='" + articleName + '\'' +
            ", introduction='" + introduction + '\'' +
            ", articlePic='" + articlePic + '\'' +
            ", publishDate=" + publishDate +
            ", guruId='" + guruId + '\'' +
            '}';
  }

  public String getArticleId() {
    return articleId;
  }

  public void setArticleId(String articleId) {
    this.articleId = articleId;
  }

  public String getArticleName() {
    return articleName;
  }

  public void setArticleName(String articleName) {
    this.articleName = articleName;
  }

  public String getIntroduction() {
    return introduction;
  }

  public void setIntroduction(String introduction) {
    this.introduction = introduction;
  }

  public String getArticlePic() {
    return articlePic;
  }

  public void setArticlePic(String articlePic) {
    this.articlePic = articlePic;
  }

  public Date getPublishDate() {
    return publishDate;
  }

  public void setPublishDate(Date publishDate) {
    this.publishDate = publishDate;
  }

  public String getGuruId() {
    return guruId;
  }

  public void setGuruId(String guruId) {
    this.guruId = guruId;
  }
}
