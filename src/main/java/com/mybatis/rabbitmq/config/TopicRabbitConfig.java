package com.mybatis.rabbitmq.config;

import com.mybatis.rabbitmq.Receiver;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Queue;

/**
 * Created by yunkai on 2017/7/12.
 */
@Configuration
public class TopicRabbitConfig {

    public final static String TOPIC_ONE = "topic.one";
    public final static String TOPIC_TWO = "topic.two";
    public final static String TOPIC_EXCHANGE = "topicExchange";

    @Bean
    public Queue queue_one(){
        return new Queue(TOPIC_ONE);
    }

    @Bean
    public Queue queue_two(){
        return new Queue(TOPIC_TWO);
    }

    @Bean
    TopicExchange exchange(){
        return new TopicExchange(TOPIC_EXCHANGE);
    }

    @Bean
    Binding bindingExchangeOne(Queue queue_one, TopicExchange exchange){
        return BindingBuilder.bind(queue_one).to(exchange).with("topic.one");
    }

    @Bean
    Binding bindingExchangeTwo(Queue queue_two, TopicExchange exchange){
        //# 表示零个或多个词
        //* 表示一个词
        return BindingBuilder.bind(queue_two).to(exchange).with("topic.#");
    }

}
