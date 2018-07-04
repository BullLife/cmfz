package com.csh.cmfz.entity;

import java.io.Serializable;

/**
 * 音频表
 */
public class Audio implements Serializable {
  private String audioId;
  private String audioName;
  private String audioSinger;  //演唱者
  private String audioCompose; //作曲
  private String audioArrangement; //编曲
  private String audioProducer;  //监制
  private String audioSize;
  private String audioAddress;
  private Long audioCount;  //下载次数
  private String albumId;

  public Audio() {
  }

  @Override
  public String toString() {
    return "Audio{" +
            "audioId='" + audioId + '\'' +
            ", audioName='" + audioName + '\'' +
            ", audioSinger='" + audioSinger + '\'' +
            ", audioCompose='" + audioCompose + '\'' +
            ", audioArrangement='" + audioArrangement + '\'' +
            ", audioProducer='" + audioProducer + '\'' +
            ", audioSize='" + audioSize + '\'' +
            ", audioAddress='" + audioAddress + '\'' +
            ", audioCount=" + audioCount +
            ", albumId='" + albumId + '\'' +
            '}';
  }

  public String getAudioId() {
    return audioId;
  }

  public void setAudioId(String audioId) {
    this.audioId = audioId;
  }

  public String getAudioName() {
    return audioName;
  }

  public void setAudioName(String audioName) {
    this.audioName = audioName;
  }

  public String getAudioSinger() {
    return audioSinger;
  }

  public void setAudioSinger(String audioSinger) {
    this.audioSinger = audioSinger;
  }

  public String getAudioCompose() {
    return audioCompose;
  }

  public void setAudioCompose(String audioCompose) {
    this.audioCompose = audioCompose;
  }

  public String getAudioArrangement() {
    return audioArrangement;
  }

  public void setAudioArrangement(String audioArrangement) {
    this.audioArrangement = audioArrangement;
  }

  public String getAudioProducer() {
    return audioProducer;
  }

  public void setAudioProducer(String audioProducer) {
    this.audioProducer = audioProducer;
  }

  public String getAudioSize() {
    return audioSize;
  }

  public void setAudioSize(String audioSize) {
    this.audioSize = audioSize;
  }

  public String getAudioAddress() {
    return audioAddress;
  }

  public void setAudioAddress(String audioAddress) {
    this.audioAddress = audioAddress;
  }

  public Long getAudioCount() {
    return audioCount;
  }

  public void setAudioCount(Long audioCount) {
    this.audioCount = audioCount;
  }

  public String getAlbumId() {
    return albumId;
  }

  public void setAlbumId(String albumId) {
    this.albumId = albumId;
  }
}
