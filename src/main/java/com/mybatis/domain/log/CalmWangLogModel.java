package com.mybatis.domain.log;

/**
 * 消息队列未处理成功的log表
 *
 * Created by yunkai on 2017/7/20.
 */
public class CalmWangLogModel {

    private Short ID;

    private Short user_id; //未成功的用户ID

    private Short state;//是否Task已将未成功的数据处理  1.已处理;2.未处理

    public Short getID() {
        return ID;
    }

    public void setID(Short ID) {
        this.ID = ID;
    }

    public Short getUser_id() {
        return user_id;
    }

    public void setUser_id(Short user_id) {
        this.user_id = user_id;
    }

    public Short getState() {
        return state;
    }

    public void setState(Short state) {
        this.state = state;
    }
}
