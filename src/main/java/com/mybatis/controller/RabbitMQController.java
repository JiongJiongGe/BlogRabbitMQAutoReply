package com.mybatis.controller;

import com.mybatis.domain.user.CalmWangUserModel;
import com.mybatis.rabbitmq.config.TopicRabbitConfig;
import com.mybatis.service.user.CalmWangUserServiceI;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * rabbitmq
 *
 * Created by yunkai on 2017/7/7.
 */
@RestController
@RequestMapping("rabbit")
public class RabbitMQController{

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private CalmWangUserServiceI calmWangUserService;

    @GetMapping(value = "send/simple/message")
    public String send_one(){
        String context = "Hi, I am message one";
        System.out.println("Sender : " + context);
        //队列ID
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        rabbitTemplate.convertAndSend(TopicRabbitConfig.TOPIC_EXCHANGE,"topic.one",context, correlationData);
        return "success";
    }

    /**
     * rabbit模拟给用户发送消息
     *
     * @return
     */
    @GetMapping(value = "send/message")
    public String send_two(){
        List<Short> lists = new ArrayList<Short>();
        //模拟给用户发送消息，此处用获取user name来模拟过程
        for(Short i = 1; i < 7; i++){
            lists.add(i);
        }
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        rabbitTemplate.convertAndSend(TopicRabbitConfig.TOPIC_EXCHANGE, "topic.two", lists , correlationData);
        List<CalmWangUserModel> users = calmWangUserService.findUserList();
        return "success";
    }
}
