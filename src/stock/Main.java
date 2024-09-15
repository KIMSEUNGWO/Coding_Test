package stock;

import stock.component.Stock;
import stock.component.StockMarket;

public class Main {


    public static void main(String[] args) {
        StockMarket market = new StockMarket();

        market.addStock(new Stock("주식이름", 1000));
        market.addStock(new Stock("다른거", 1500));
        market.showStockList();

        for (int i = 0; i < 100; i++) {
             market.updateStockMarket();
             market.updateStocks();
             market.showStockList();
        }
    }
}
