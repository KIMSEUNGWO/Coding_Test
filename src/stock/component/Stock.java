package stock.component;

import java.util.function.Function;

public class Stock {

    private String name;
    private int price;

    public Stock(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public void update(Function<Integer, Integer> function) {
        double rand = Math.random() * 0.1;
        double extra = price * rand;
        if ((Math.random() * 100) < 50) extra *= -1;
        price = (int) (function.apply(price) + extra);
    }

    public void show() {
        System.out.println("Name: " + name + " Price: " + price);
    }
}
