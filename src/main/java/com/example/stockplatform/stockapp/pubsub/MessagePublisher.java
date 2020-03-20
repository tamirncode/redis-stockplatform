package com.example.stockplatform.stockapp.pubsub;

import com.example.stockplatform.stockapp.model.Stock;

public interface MessagePublisher {
    void publish(Stock stock);
}

