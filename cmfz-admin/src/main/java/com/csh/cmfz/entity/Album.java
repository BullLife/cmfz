package com.csh.cmfz.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 专辑表
 * @author 程少华
 */
public class Album implements Serializable {
  private String albumId;
  private String albumName;
  private String albumAuthor;
  private String albumCv; //播音
  private Long albumCount; //集数
  private Double albumScore; //评分
  private String albumPic;
  private Date publishDate;
  private String albumContent; //内容简介

  public Album() {
  }

  @Override
  public String toString() {
    return "Album{" +
            "albumId='" + albumId + '\'' +
            ", albumName='" + albumName + '\'' +
            ", albumAuthor='" + albumAuthor + '\'' +
            ", albumCv='" + albumCv + '\'' +
            ", albumCount=" + albumCount +
            ", albumScore=" + albumScore +
            ", albumPic='" + albumPic + '\'' +
            ", publishDate=" + publishDate +
            ", albumContent='" + albumContent + '\'' +
            '}';
  }

  public String getAlbumId() {
    return albumId;
  }

  public void setAlbumId(String albumId) {
    this.albumId = albumId;
  }

  public String getAlbumName() {
    return albumName;
  }

  public void setAlbumName(String albumName) {
    this.albumName = albumName;
  }

  public String getAlbumAuthor() {
    return albumAuthor;
  }

  public void setAlbumAuthor(String albumAuthor) {
    this.albumAuthor = albumAuthor;
  }

  public String getAlbumCv() {
    return albumCv;
  }

  public void setAlbumCv(String albumCv) {
    this.albumCv = albumCv;
  }

  public Long getAlbumCount() {
    return albumCount;
  }

  public void setAlbumCount(Long albumCount) {
    this.albumCount = albumCount;
  }

  public Double getAlbumScore() {
    return albumScore;
  }

  public void setAlbumScore(Double albumScore) {
    this.albumScore = albumScore;
  }

  public String getAlbumPic() {
    return albumPic;
  }

  public void setAlbumPic(String albumPic) {
    this.albumPic = albumPic;
  }

  public Date getPublishDate() {
    return publishDate;
  }

  public void setPublishDate(Date publishDate) {
    this.publishDate = publishDate;
  }

  public String getAlbumContent() {
    return albumContent;
  }

  public void setAlbumContent(String albumContent) {
    this.albumContent = albumContent;
  }
}
