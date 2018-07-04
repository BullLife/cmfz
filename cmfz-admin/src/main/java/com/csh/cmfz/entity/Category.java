package com.csh.cmfz.entity;

import java.io.Serializable;

/**
 * 分类表（功课记录功能）
 */
public class Category implements Serializable {
  private String categoryId;
  private String categoryName;
  private String userId;

  public Category() {
  }

  @Override
  public String toString() {
    return "Category{" +
            "categoryId='" + categoryId + '\'' +
            ", categoryName='" + categoryName + '\'' +
            ", userId='" + userId + '\'' +
            '}';
  }

  public String getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(String categoryId) {
    this.categoryId = categoryId;
  }

  public String getCategoryName() {
    return categoryName;
  }

  public void setCategoryName(String categoryName) {
    this.categoryName = categoryName;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }
}
