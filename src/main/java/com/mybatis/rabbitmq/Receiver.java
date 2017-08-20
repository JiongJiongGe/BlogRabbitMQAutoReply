package com.mybatis.rabbitmq;

import com.mybatis.domain.log.CalmWangLogModel;
import com.mybatis.domain.user.CalmWangUserModel;
import com.mybatis.service.log.CalmWangLogServiceI;
import com.mybatis.service.user.CalmWangUserServiceI;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

/**
 * Created by yunkai on 2017/7/6.
 */
@Component
public class Receiver {

    @Autowired
    private CalmWangUserServiceI calmWangUserService;

    @Autowired
    private CalmWangLogServiceI calmWangLogService;

    @RabbitListener(queues = "topic.one")
    public void topicOneReceiver(String message)
    {
            System.out.println("one begin  message = === === == " + message);
    }

    @RabbitListener(queues = "topic.two")
    public void topicTwoReceiver(Message message, List<Short> userIds) throws Exception{
        //message 消息内的信息，有body
        String messageString = message.toString();

        if(userIds != null && userIds.size() > 0){
            userIds.forEach(id ->{
                try {
                    CalmWangUserModel user = calmWangUserService.getById(id);
                    user.setUser_name(user.getUser_name() + "_NEW");
                    //模拟出错情况，当user为空时，取user.getUser_name出错
                    calmWangUserService.update(user);
                }catch (Exception e){
                    CalmWangLogModel log = new CalmWangLogModel();
                    log.setUser_id(id);
                    calmWangLogService.saveLog(id);
                }
            });
        }
    }
}
