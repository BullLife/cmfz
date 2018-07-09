package com.csh.cmfz.entity;

import java.io.Serializable;

/**
 * @Description TODO
 * @Author 程少华
 * @Date 2018/7/9 14:21
 **/
public class EchartsChina implements Serializable {
    private String name;
    private String value;

    public EchartsChina() {
    }

    public EchartsChina(String name, String value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String toString() {
        return "EchartsChina{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
