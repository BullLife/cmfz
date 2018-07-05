package com.csh.cmfz.dao;

import com.csh.cmfz.entity.Picture;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 轮播图的相关方法
 * Created by Administrator on 2018/7/5.
 */
public interface PictureDao {
    /**
     * 向数据库中插入一张图片
     * @param picture 要插入的数据
     * @return
     */
    public Integer insertPicture(@Param("pic") Picture picture);
    /**
     * 根据ID删除数据库中一张照片
     * @param id 依据ID
     * @return
     */
    public Integer deletePictureById(String id);
    /**
     * 修改数据库中的照片数据
     * @param picture
     * @return
     */
    public Integer updatePicture(@Param("pic") Picture picture);

    /**
     * 查询数据库中所有数据的总行数
     * @return
     */
    public Integer selectCount();

    /**
     * 分页查询数据库中的所有照片数据
     * @return
     */
    public List<Picture> selectAllPictureByPage(@Param("begin")Integer begin,@Param("end")Integer end);

    /**
     * 根据ID查找数据库中的照片
     * @param id
     * @return
     */
    public Picture selectPictureById(String id);
}
