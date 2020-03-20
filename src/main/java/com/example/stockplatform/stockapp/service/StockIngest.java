package com.example.stockplatform.stockapp.service;

import com.example.stockplatform.stockapp.model.Stock;
import com.example.stockplatform.stockapp.pubsub.RedisStockPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * This class is incharge to periodically ingest stocks
 * lets assume : DELL, AAPL, GOOGL, AMAZON , FB and Microsoft.
 * API call example
 * https://cloud.iexapis.com/stable/stock/<STOCK>/quote?token=pk_d209b82f42e44bb5846434227218655d
 */
@Component
public class StockIngest {

    private final String URL= "https://cloud.iexapis.com/stable/stock/%s/quote?token=pk_d209b82f42e44bb5846434227218655d";

    @Autowired
    RedisStockPublisher publisher;

    @Autowired
    StockService stockService;

    public void StockIngest(){}

    @Scheduled(fixedRate = 5000)
    public void ingestStock() {
        RestTemplate restTemplate = new RestTemplate();
        String stockUrl = String.format(URL,ClientStock.randomStock().name());
        System.out.println("Getting Stock info for\n " + stockUrl);
        Stock stock = restTemplate.getForObject(stockUrl,Stock.class);
        stockService.insertNewStock(stock);
        publisher.publish(stock);
    }

    public enum ClientStock {
        DELL,
        AAPL,
        GOOGL,
        AMZN,
        MSFT,
        FB;

        private static final List<ClientStock> VALUES =
                Collections.unmodifiableList(Arrays.asList(values()));
        private static final int SIZE = VALUES.size();
        private static final Random RANDOM = new Random();

        public static ClientStock randomStock()  {
            return VALUES.get(RANDOM.nextInt(SIZE));
        }
    }
}
