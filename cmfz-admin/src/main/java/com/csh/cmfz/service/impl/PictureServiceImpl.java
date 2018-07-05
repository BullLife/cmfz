package com.csh.cmfz.service.impl;/**
 * Created by Administrator on 2018/7/5.
 */

import com.csh.cmfz.dao.PictureDao;
import com.csh.cmfz.entity.Picture;
import com.csh.cmfz.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description TODO
 * @Author 程少华
 * @Date 2018/7/5 17:53
 **/
@Service
@Transactional
public class PictureServiceImpl implements PictureService {

    @Autowired
    private PictureDao pictureDao;

    @Override
    public Integer addPicture(Picture picture) {
        return pictureDao.insertPicture(picture);
    }

    @Override
    public Integer removePictureById(String id) {
        return pictureDao.deletePictureById(id);
    }

    @Override
    public Integer modifyPicture(Picture picture) {
        return pictureDao.updatePicture(picture);
    }

    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public Integer queryCount() {
        return pictureDao.selectCount();
    }

    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public List<Picture> queryAllPicturesByPage(Integer begin, Integer end) {
        return pictureDao.selectAllPictureByPage(begin,end);
    }

    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public Picture queryPictureById(String id) {
        return pictureDao.selectPictureById(id);
    }
}
