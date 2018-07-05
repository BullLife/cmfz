package com.csh.cmfz.service;

import com.csh.cmfz.entity.Picture;

import java.util.List;

/**
 * Created by Administrator on 2018/7/5.
 */
public interface PictureService {
    public Integer addPicture(Picture picture);

    public Integer removePictureById(String id);

    public Integer modifyPicture(Picture picture);

    public  Integer queryCount();

    public List<Picture> queryAllPicturesByPage(Integer begin,Integer end);

    public Picture queryPictureById(String id);
}
