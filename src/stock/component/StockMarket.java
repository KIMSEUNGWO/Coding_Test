package stock.component;

import java.util.ArrayList;
import java.util.List;

public class StockMarket {


    private StockFunction function = StockFunction.S3;
    private final List<Stock> stockList = new ArrayList<>();

    public void updateStockMarket() {
        int rand = (int) (Math.random() * 100);
        if (rand <= 10) {
            function = function.down();
        } else if (rand <= 20) {
            function = function.up();
        }

    }
    public void addStock(Stock stock) {
        stockList.add(stock);
    }

    public void updateStocks() {
        System.out.println("Market : " + function.name());
        for (Stock stock : stockList) {
            stock.update(function.getFunction());
        }
    }

    public void showStockList() {
        for (Stock stock : stockList) {
            stock.show();
        }
        System.out.println();
    }
}
