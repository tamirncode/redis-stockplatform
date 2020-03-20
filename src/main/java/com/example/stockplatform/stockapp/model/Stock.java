package com.example.stockplatform.stockapp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@NoArgsConstructor
@ToString
@RedisHash("Stock")
public class Stock implements Serializable {
    @Id @NotNull
    private String symbol;
    private String companyName;
    private double latestPrice;
    private double changePercent;
    private double change;
}
