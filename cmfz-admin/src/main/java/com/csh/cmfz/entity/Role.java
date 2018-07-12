package com.csh.cmfz.entity;

import java.io.Serializable;

/**
 * @Description TODO
 * @Author 程少华
 * @Date 2018/7/12 19:29
 **/
public class Role implements Serializable{
    private String id;
    private String roleName;
    private String roleTag;

    @Override
    public String toString() {
        return "Role{" +
                "id='" + id + '\'' +
                ", roleName='" + roleName + '\'' +
                ", roleTag='" + roleTag + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleTag() {
        return roleTag;
    }

    public void setRoleTag(String roleTag) {
        this.roleTag = roleTag;
    }
}
