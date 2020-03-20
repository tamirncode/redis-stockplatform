package com.example.stockplatform.stockapp.pubsub;

import com.example.stockplatform.stockapp.model.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleAfterCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

@Component
@RepositoryEventHandler(Stock.class)
public class PaymentEventHandler {

    @Autowired
    private RedisStockPublisher publisher;

    @HandleAfterCreate
    public void handlePaymentSave( Stock stock) {
        publisher.publish(stock);
    }
}