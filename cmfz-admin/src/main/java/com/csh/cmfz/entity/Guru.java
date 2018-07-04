package com.csh.cmfz.entity;

import java.io.Serializable;

/**
 * 上师表
 */
public class Guru implements Serializable {
  private String guruId;
  private String guruName;
  private String guruPic;
  private String guruSummary; //简介

  public Guru() {
  }

  @Override
  public String toString() {
    return "Guru{" +
            "guruId='" + guruId + '\'' +
            ", guruName='" + guruName + '\'' +
            ", guruPic='" + guruPic + '\'' +
            ", guruSummary='" + guruSummary + '\'' +
            '}';
  }

  public String getGuruId() {
    return guruId;
  }

  public void setGuruId(String guruId) {
    this.guruId = guruId;
  }

  public String getGuruName() {
    return guruName;
  }

  public void setGuruName(String guruName) {
    this.guruName = guruName;
  }

  public String getGuruPic() {
    return guruPic;
  }

  public void setGuruPic(String guruPic) {
    this.guruPic = guruPic;
  }

  public String getGuruSummary() {
    return guruSummary;
  }

  public void setGuruSummary(String guruSummary) {
    this.guruSummary = guruSummary;
  }
}
