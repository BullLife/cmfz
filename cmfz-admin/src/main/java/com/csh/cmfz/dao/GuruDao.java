package com.csh.cmfz.dao;

import com.csh.cmfz.entity.Guru;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2018/7/6.
 */
public interface GuruDao {
    /**
     * 插入上师信息
     * @param guru 上师信息
     * @return
     */
    public Integer insertGuru(@Param("guru")Guru guru);

    /**
     *  修改上师信息
     * @param guru 要修改的上师信息
     * @return
     */
    public Integer updateGuru(@Param("guru")Guru guru);

    /**
     * 查询数据库中所有上师信息的总条数
     * @return
     */
    public Integer selectCount();

    /**
     * 分页查询数据库中上师信息
     * @param begin 起始条数
     * @param end 结束条数
     * @return
     */
    public List<Guru> selectGurusOnPage(@Param("begin")Integer begin,@Param("end") Integer end);

    /**
     * 条件查询数据库中符合条件的上师信息的总条数
     * @param guru 模糊条件封装的对象
     * @return
     */
    public Integer selectCountByTrim(@Param("guru")Guru guru);


    /**
     * 模糊条件查找数据库中上师信息
     * @param begin 起始条数
     * @param end 结束条数
     * @param guru 模糊条件封装的对象
     * @return
     */
    public List<Guru> selectGurusByTrim(@Param("begin")Integer begin,@Param("end") Integer end,@Param("guru")Guru guru);

    /**
     * 根据ID查找上师信息
     * @param id 上师ID
     * @return
     */
    public Guru selectGuruById(String id);
}
