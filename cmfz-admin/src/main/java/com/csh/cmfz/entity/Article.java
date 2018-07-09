package com.csh.cmfz.entity;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;

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
  @JSONField(format = "yyyy-MM-dd : hh:mm:ss")
  @DateTimeFormat(style = "yyyy-MM-dd : hh:mm:ss")
  private Date publishDate;
  private String guruId;
  private String articleStatus;
  private String guruName;

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
            ", articleStatus='" + articleStatus + '\'' +
            ", guruName='" + guruName + '\'' +
            '}';
  }

  public String getGuruName() {
    return guruName;
  }

  public void setGuruName(String guruName) {
    this.guruName = guruName;
  }

  public String getArticleStatus() {
    return articleStatus;
  }

  public void setArticleStatus(String articleStatus) {
    this.articleStatus = articleStatus;
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
