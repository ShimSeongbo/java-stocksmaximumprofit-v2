package com.example.javastocksmaximumprofit.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.beans.factory.annotation.Value;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class StockService {

    private final WebClient webClient;

    @Value("${alphavantage.api.key}")
    private String ALPHA_VANTAGE_API_KEY;

    public Mono<String> fetchStockData(String symbol) {

        String url = UriComponentsBuilder
                .fromHttpUrl("https://www.alphavantage.co/query")
                .queryParam("function", "TIME_SERIES_DAILY")
                .queryParam("symbol", symbol)
                .queryParam("apikey", ALPHA_VANTAGE_API_KEY)
                .toUriString();

        return webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(String.class);
    }

}
