package com.example.stockplatform.stockapp.dao;

import com.example.stockplatform.stockapp.model.Stock;

import java.util.Optional;

public interface StockDao {
    Stock insertNewStock(Stock stock);
    Optional<Stock> findStockById(String stockName);
    Iterable<Stock> findAllStocks();
}
