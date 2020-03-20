package com.example.stockplatform.stockapp.pubsub;

import com.example.stockplatform.stockapp.model.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Service;

@Service
public class RedisStockPublisher implements MessagePublisher {

    @Autowired
    private RedisTemplate<String, Stock> redisTemplate;
    @Autowired
    private ChannelTopic topic;

    public RedisStockPublisher() {
    }

    public void publish(Stock message) {
        redisTemplate.convertAndSend(topic.getTopic(), message);
    }
}

