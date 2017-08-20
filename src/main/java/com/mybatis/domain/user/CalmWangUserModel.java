package com.mybatis.domain.user;

import java.io.Serializable;

/**
 * 用户model
 *
 * Created by yunkai on 2017/5/24.
 */
public class CalmWangUserModel implements Serializable{

    private Short ID;

    private String user_name; //用户名称

    private String user_phone;//用户联系方式

    public Short getID() {
        return ID;
    }

    public void setID(Short ID) {
        this.ID = ID;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }
}
