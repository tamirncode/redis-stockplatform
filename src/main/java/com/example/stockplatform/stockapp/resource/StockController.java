package com.example.stockplatform.stockapp.resource;

import com.example.stockplatform.stockapp.model.Stock;
import com.example.stockplatform.stockapp.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/stocks")
public class StockController {

    private final StockService stockService;

    @Autowired
    public StockController(StockService studentService) {
        this.stockService = studentService;
    }

    /**
     * Get all Students
     * @return
     */
    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Stock> getAllStocks(){
        return stockService.findAllStocks();
    }

    /**
     * Get Stock By ID
     * @param stockName
     * @return
     */
    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE,
            path = "{stockId}"
    )
    public Stock getStockById(@PathVariable("stockId") String stockName){
        Optional<Stock> stock = stockService.findStockById(stockName);
        return stock.orElse(null);
    }
}
