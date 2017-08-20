package com.mybatis.timer;

import com.mybatis.domain.log.CalmWangLogModel;
import com.mybatis.domain.user.CalmWangUserModel;
import com.mybatis.service.log.CalmWangLogServiceI;
import com.mybatis.service.user.CalmWangUserServiceI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by yunkai on 2017/8/9.
 */
@Component
public class rollbackLogTimer {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CalmWangLogServiceI calmWangLogService;

    @Autowired
    private CalmWangUserServiceI calmWangUserService;

    @Scheduled(cron="0 0/1 * * * ?")
    public void rollbackErrorLog(){
        List<CalmWangLogModel> logs = calmWangLogService.findList();
        if(logs != null && logs.size() > 0){
            for(CalmWangLogModel log : logs){
                try {
                    CalmWangUserModel user = calmWangUserService.getById(log.getUser_id());
                    if (user != null && user.getID() != 0) {
                        user.setUser_name(user.getUser_name() + "_NEW");
                    } else {
                        user = new CalmWangUserModel();
                        user.setUser_name("新用户");
                        user.setUser_phone("11111111111");
                        calmWangUserService.saveUser(user.getUser_name(), user.getUser_phone());
                    }
                    calmWangLogService.update(log.getID());
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}
