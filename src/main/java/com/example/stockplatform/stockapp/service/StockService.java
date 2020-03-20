package com.example.stockplatform.stockapp.service;

import com.example.stockplatform.stockapp.dao.RedisStocksRepository;
import com.example.stockplatform.stockapp.dao.StockDao;
import com.example.stockplatform.stockapp.model.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StockService implements StockDao {

    @Autowired
    private RedisStocksRepository repository;

    @Autowired
    public StockService(RedisStocksRepository repository){
        this.repository = repository;
    }

    @Override
    public Stock insertNewStock(Stock stock) {
        System.out.println("Saving stock to Redis DB" + stock.toString());
        return repository.save(stock);
    }

    @Override
    public Optional<Stock> findStockById(String stockName) {
        return repository.findById(stockName);
    }

    @Override
    public Iterable<Stock> findAllStocks() {
        return repository.findAll();
    }
}
