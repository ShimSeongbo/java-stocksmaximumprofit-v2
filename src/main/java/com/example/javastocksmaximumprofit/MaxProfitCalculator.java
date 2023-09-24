package com.example.javastocksmaximumprofit;

import com.example.javastocksmaximumprofit.service.StockData;

import java.util.ArrayList;
import java.util.List;

public class MaxProfitCalculator {

    public double maxProfitCalculator(List<StockData> stockDataList) {
        List<Long> tempList = new ArrayList<>();
        double maxProfit = 0;
        double minPrice = 0;
        double maxPrice = 0;
        int size = stockDataList.size();

        for (int i = 0; i < size - 1; i++) {
            minPrice = stockDataList.get(i).getPrice();

            for (int j = size - 1; i < j; j--) {
                maxPrice = stockDataList.get(j).getPrice();
                if (minPrice < maxPrice) {

                    tempList.set(i, (long) (maxPrice - minPrice));

                    if (maxProfit < tempList.get(i)) {
                        maxProfit = tempList.get(i);
                    }
                }
            }
        }

        return maxProfit;
    }
}
