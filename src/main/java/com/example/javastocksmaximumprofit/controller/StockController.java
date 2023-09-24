package com.example.javastocksmaximumprofit.controller;

import com.example.javastocksmaximumprofit.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class StockController {

    private final StockService stockService;

    @GetMapping("/stocks/{symbol}")
    public Mono<String> getStockData(@PathVariable String symbol) {
        return stockService.fetchStockData(symbol);
    }

}
