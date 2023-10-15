package com.example.javastocksmaximumprofit;

import com.example.javastocksmaximumprofit.service.StockData;

import java.util.List;

public class MaxProfitCalculator {

    public double stocksMaxProfitCalculator(List<StockData> stockDataList) {
        // 메서드 분리 예정
        if (stockDataList == null || stockDataList.size() < 2) {
            return 0.0;
        }

        double minPrice = stockDataList.get(0).getPrice();
        int minPriceIndex = 0;
        double maxProfit = 0.0;

        for (int i = 1; i < stockDataList.size(); i++) {
            double currentPrice = stockDataList.get(i).getPrice();

            if (currentPrice < minPrice) {
                minPrice = currentPrice;
                minPriceIndex = i;
            } else if (i > minPriceIndex) {
                double currentProfit = currentPrice - minPrice;
                maxProfit = Math.max(maxProfit, currentProfit);
            }
        }

        return maxProfit;
    }

}
