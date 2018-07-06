package com.csh.cmfz.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Menu implements Serializable{
  private String menuId;
  private String menuName;
  private String menuCode;
  private String menuIcon;
  private String menuUrl;
  private String menuLevel;
  private String menuParentId;
  //该一级菜单下 所有的二级菜单
  private List<Menu> menus = new ArrayList<Menu>();

  public Menu() {
  }

  @Override
  public String toString() {
    return "Menu{" +
            "menuId='" + menuId + '\'' +
            ", menuName='" + menuName + '\'' +
            ", menuCode='" + menuCode + '\'' +
            ", menuIcon='" + menuIcon + '\'' +
            ", menuUrl='" + menuUrl + '\'' +
            ", menuLevel='" + menuLevel + '\'' +
            ", menuParentId='" + menuParentId + '\'' +
            ", menus=" + menus +
            '}';
  }

  public List<Menu> getMenus() {
    return menus;
  }

  public void setMenus(List<Menu> menus) {
    this.menus = menus;
  }

  public String getMenuId() {
    return menuId;
  }

  public void setMenuId(String menuId) {
    this.menuId = menuId;
  }

  public String getMenuName() {
    return menuName;
  }

  public void setMenuName(String menuName) {
    this.menuName = menuName;
  }

  public String getMenuCode() {
    return menuCode;
  }

  public void setMenuCode(String menuCode) {
    this.menuCode = menuCode;
  }

  public String getMenuIcon() {
    return menuIcon;
  }

  public void setMenuIcon(String menuIcon) {
    this.menuIcon = menuIcon;
  }

  public String getMenuUrl() {
    return menuUrl;
  }

  public void setMenuUrl(String menuUrl) {
    this.menuUrl = menuUrl;
  }

  public String getMenuLevel() {
    return menuLevel;
  }

  public void setMenuLevel(String menuLevel) {
    this.menuLevel = menuLevel;
  }

  public String getMenuParentId() {
    return menuParentId;
  }

  public void setMenuParentId(String menuParentId) {
    this.menuParentId = menuParentId;
  }
}
