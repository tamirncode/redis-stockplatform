package com.example.stockplatform.stockapp.dao;

import com.example.stockplatform.stockapp.model.Stock;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RedisStocksRepository extends CrudRepository<Stock, String> {}

