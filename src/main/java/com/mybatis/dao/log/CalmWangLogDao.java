package com.mybatis.dao.log;

import com.mybatis.domain.log.CalmWangLogModel;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * log dao
 *
 * Created by yunkai on 2017/7/20.
 */
@Mapper
@Component
public interface CalmWangLogDao {

    @Insert("INSERT INTO `calmwang_t_log`(`id`, `user_id`, `state`) VALUES(NULL, #{userId}, 2)")
    public void saveLog(@Param("userId")Short userId);


    @Update("UPDATE `calmwang_t_log` SET `state` = 1 WHERE `id`= #{id}")
    public void updateState(@Param("id")Short id);

    @Select("SELECT * FROM `calmwang_t_log` WHERE `state` = 2")
    List<CalmWangLogModel> findList();
}
