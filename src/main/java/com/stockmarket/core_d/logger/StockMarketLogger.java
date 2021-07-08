package com.stockmarket.core_d.logger;

public interface StockMarketLogger {
    StockMarketLogger log(String message,Object ...parameters);

    StockMarketLogger info();

    StockMarketLogger debug();

    StockMarketLogger warn();

    StockMarketLogger error();
}
