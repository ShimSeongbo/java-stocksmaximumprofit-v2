package com.example.javastocksmaximumprofit;

import com.example.javastocksmaximumprofit.service.StockData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaxProfitCalculatorTest {

    private MaxProfitCalculator maxProfitCalculator;

    @BeforeEach
    void setUp() {
        maxProfitCalculator = new MaxProfitCalculator();
    }

    @Test
    void testMaxProfitCalculatorWhenPricesAreIncreasing() {
        // given
        List<StockData> stockDataList = Arrays.asList(
                new StockData(LocalDate.now(), 100),
                new StockData(LocalDate.now().plusDays(1), 110),
                new StockData(LocalDate.now().plusDays(2), 120)
        );

        // when
        double profit = maxProfitCalculator.stocksMaxProfitCalculator(stockDataList);

        // then
        assertEquals(20, profit);
    }

    @Test
    void testMaxProfitCalculatorWhenPricesAreDecreasing() {
        // given
        List<StockData> stockDataList = Arrays.asList(
                new StockData(LocalDate.now(), 120),
                new StockData(LocalDate.now().plusDays(1), 110),
                new StockData(LocalDate.now().plusDays(2), 100)
        );

        // when
        double profit = maxProfitCalculator.stocksMaxProfitCalculator(stockDataList);

        // then
        assertEquals(0, profit);
    }

    @Test
    void testMaxProfitCalculatorWhenPricesAreMixed() {
        // given
        List<StockData> stockDataList = Arrays.asList(
                new StockData(LocalDate.now(), 100),
                new StockData(LocalDate.now().plusDays(1), 80),
                new StockData(LocalDate.now().plusDays(2), 110)
        );

        // when
        double profit = maxProfitCalculator.stocksMaxProfitCalculator(stockDataList);

        // then
        assertEquals(30, profit);
    }

    @Test
    void testMaxProfitCalculatorWithEmptyList() {
        // given
        List<StockData> stockDataList = Collections.emptyList();

        // when
        double profit = maxProfitCalculator.stocksMaxProfitCalculator(stockDataList);

        // then
        assertEquals(0, profit);
    }

    @Test
    void testMaxProfitCalculatorWithOneDataPoint() {
        // given
        List<StockData> stockDataList = Collections.singletonList(new StockData(LocalDate.now(), 100));

        // when
        double profit = maxProfitCalculator.stocksMaxProfitCalculator(stockDataList);

        // then
        assertEquals(0, profit);
    }
}
