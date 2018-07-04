package com.csh.cmfz.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 计数器表
 */
public class Counter implements Serializable {
  private String counterId;
  private String counterName;
  private Long count;
  private Date counterDate;
  private String categoryId;
  private String userId;

  public Counter() {
  }

  @Override
  public String toString() {
    return "Counter{" +
            "counterId='" + counterId + '\'' +
            ", counterName='" + counterName + '\'' +
            ", count=" + count +
            ", counterDate=" + counterDate +
            ", categoryId='" + categoryId + '\'' +
            ", userId='" + userId + '\'' +
            '}';
  }

  public String getCounterId() {
    return counterId;
  }

  public void setCounterId(String counterId) {
    this.counterId = counterId;
  }

  public String getCounterName() {
    return counterName;
  }

  public void setCounterName(String counterName) {
    this.counterName = counterName;
  }

  public Long getCount() {
    return count;
  }

  public void setCount(Long count) {
    this.count = count;
  }

  public Date getCounterDate() {
    return counterDate;
  }

  public void setCounterDate(Date counterDate) {
    this.counterDate = counterDate;
  }

  public String getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(String categoryId) {
    this.categoryId = categoryId;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }
}
