package com.csh.cmfz.entity;

import java.io.Serializable;

public class User  implements Serializable {
  private String userId;
  private String userName;
  private String userBuddhishName; //法名
  private String userPassword;
  private String userSex;
  private String userHeadPic;
  private String userAddress;
  private String userPhone;
  private String userSignature;  //签名
  private Long userStatus;
  private String guruId;

    public User() {
    }

  @Override
  public String toString() {
    return "User{" +
            "userId='" + userId + '\'' +
            ", userName='" + userName + '\'' +
            ", userBuddhishName='" + userBuddhishName + '\'' +
            ", userPassword='" + userPassword + '\'' +
            ", userSex='" + userSex + '\'' +
            ", userHeadPic='" + userHeadPic + '\'' +
            ", userAddress='" + userAddress + '\'' +
            ", userPhone='" + userPhone + '\'' +
            ", userSignature='" + userSignature + '\'' +
            ", userStatus=" + userStatus +
            ", guruId='" + guruId + '\'' +
            '}';
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getUserBuddhishName() {
    return userBuddhishName;
  }

  public void setUserBuddhishName(String userBuddhishName) {
    this.userBuddhishName = userBuddhishName;
  }

  public String getUserPassword() {
    return userPassword;
  }

  public void setUserPassword(String userPassword) {
    this.userPassword = userPassword;
  }

  public String getUserSex() {
    return userSex;
  }

  public void setUserSex(String userSex) {
    this.userSex = userSex;
  }

  public String getUserHeadPic() {
    return userHeadPic;
  }

  public void setUserHeadPic(String userHeadPic) {
    this.userHeadPic = userHeadPic;
  }

  public String getUserAddress() {
    return userAddress;
  }

  public void setUserAddress(String userAddress) {
    this.userAddress = userAddress;
  }

  public String getUserPhone() {
    return userPhone;
  }

  public void setUserPhone(String userPhone) {
    this.userPhone = userPhone;
  }

  public String getUserSignature() {
    return userSignature;
  }

  public void setUserSignature(String userSignature) {
    this.userSignature = userSignature;
  }

  public Long getUserStatus() {
    return userStatus;
  }

  public void setUserStatus(Long userStatus) {
    this.userStatus = userStatus;
  }

  public String getGuruId() {
    return guruId;
  }

  public void setGuruId(String guruId) {
    this.guruId = guruId;
  }
}
