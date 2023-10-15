package com.example.javastocksmaximumprofit.controller;

import com.example.javastocksmaximumprofit.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class StockController {

    private final StockService stockService;

    @GetMapping("/stocks/{symbol}")
    public ResponseEntity<Mono<String>> getStockData(@PathVariable String symbol) {
        Mono<String> data = stockService.fetchStockData(symbol);
        return ResponseEntity.ok(data);
    }

    @GetMapping("/stocks/{symbol}/maxProfit")
    public Mono<ResponseEntity<Double>> getMaximumProfit(@PathVariable String symbol) {

        return stockService.fetchStockData(symbol)
                .flatMap(jsonData -> {
                    try {
                        return Mono.just(stockService.convertToStockDataList(jsonData));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                })
                .map(stockDataList -> stockService.calculateMaximumProfit(stockDataList))
                .map(maxProfit -> ResponseEntity.ok(maxProfit))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

}
