package com.mybatis.service.log;

import com.mybatis.domain.log.CalmWangLogModel;

import java.util.List;

/**
 * Created by yunkai on 2017/7/20.
 */
public interface CalmWangLogServiceI {

    /**
     * 保存rabbitmq处理失败消息的userId信息
     *
     * @param userId
     */
    public void saveLog(Short userId);

    /**
     * 发现Log集合
     * @return
     */
    public List<CalmWangLogModel> findList();

    public void update(Short id);
}
