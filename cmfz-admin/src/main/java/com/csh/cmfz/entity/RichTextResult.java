package com.csh.cmfz.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @Description TODO
 * @Author 程少华
 * @Date 2018/7/8 17:49
 **/
public class RichTextResult implements Serializable{
    private int errno;
    private List<String> data;

    @Override
    public String toString() {
        return "RichTextResult{" +
                "errno=" + errno +
                ", data=" + data +
                '}';
    }

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }
}
