package com.mybatis.service.user;

import com.mybatis.domain.user.CalmWangUserModel;

import java.util.List;

/**
 * user service
 *
 * Created by yunkai on 2017/5/24.
 */
public interface CalmWangUserServiceI {

    /**
     * 获取所有用户信息
     *
     * @return
     */
    public List<CalmWangUserModel> findUserList();

    /**
     * 通过用户名获取用户
     *
     * @param name
     * @return
     */
    public List<CalmWangUserModel>  getByName(String name);

    /**
     * 保存用户信息
     *
     * @param userName 用户名称
     * @param userPhone 用户联系方式
     */
    public Short saveUser(String userName, String userPhone);

    /**
     * 通过用户Id获取对象
     *
     * @param id
     * @return
     */
    public CalmWangUserModel getById(Short id);

    /**
     * 更新用户
     *
     * @param user
     */
    public void update(CalmWangUserModel user);
}
