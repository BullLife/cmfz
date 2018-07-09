package com.csh.cmfz.dao;

import com.csh.cmfz.entity.Log;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2018/7/9.
 */
public interface LogDao {
    public Integer insertLog(@Param("log") Log log);

    public List<Log> selectAllLogsOnPage(@Param("begin") Integer begin, @Param("end") Integer end);

    public Integer selectCount();
}
