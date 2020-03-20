package com.example.stockplatform.stockapp.pubsub;

import com.example.stockplatform.stockapp.dao.RedisStocksRepository;
import com.example.stockplatform.stockapp.model.Stock;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class RedisMessageSubscriber implements MessageListener {

    ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private RedisStocksRepository repository;


    public void onMessage(final Message message, final byte[] pattern) {
        try {
            System.out.println("Message received: " + new String(message.getBody()));
            Stock stockChange = objectMapper.readValue(message.toString(), Stock.class);
            Stock stockDB = repository.findById(stockChange.getSymbol()).get();

            if ( stockChange.getChangePercent()- stockDB.getChangePercent() > 0.05){
                System.out.println("Stock : "+ stockDB.getSymbol()+" price has changed in 0.05%");
            }

            //Could add another Subscriber
            if ( stockChange.getLatestPrice()- stockDB.getLatestPrice() > 0.1){
                System.out.println("Stock : "+ stockDB.getSymbol()+" price has changed in more than 0.1");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}