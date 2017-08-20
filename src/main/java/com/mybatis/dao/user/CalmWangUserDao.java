package com.mybatis.dao.user;

import com.mybatis.domain.user.CalmWangUserModel;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * user dao
 *
 * Created by yunkai on 2017/5/24.
 */
@Mapper
@Component
public interface CalmWangUserDao {

    @Select("SELECT id, user_name, user_phone FROM calmwang_t_user")
    List<CalmWangUserModel> findAll();

//    @Select("<script>"+
//                "SELECT id, user_name, user_phone FROM calmwang_t_user " +
//                "<where> 1=1 " +
//                "<if test=\"name != null\"> AND user_name = #{name}</if>" +
//                "<if test=\"phone != null\"> AND user_phone = #{phone}</if>" +
//                "</where>"+
//            "</script>")

    @Select(" SELECT id, user_name, user_phone FROM calmwang_t_user WHERE 1=1 AND user_name = #{param1}")
    List<CalmWangUserModel>  getByNameAndPhone(@Param("name")String name, @Param("phone")String phone);

    @Insert("INSERT INTO calmwang_t_user(id, user_name, user_phone) VALUES(NULL, #{name}, #{phone})")
    void saveUser(@Param("name")String name, @Param("phone")String phone);

    @Select(" SELECT id, user_name, user_phone FROM `calmwang_t_user` WHERE 1=1 AND `id` = #{id}")
    CalmWangUserModel getById(@Param("id")Short id);

    @Select("SELECT LAST_INSERT_ID() AS ID")
    public Short last_insert_id();

    @Update("UPDATE `calmwang_t_user` SET `user_name`= #{name} WHERE `id`= #{id}")
    void update(@Param("name") String name, @Param("id") Short id);
}
