package stock.component;

import java.util.function.Function;

public enum StockFunction {

    S1(value -> (int) (0.98 * value)),
    S2(value -> (int) (0.99 * value)),
    S3(value -> value),
    S4(value -> (int) (1.01 * value)),
    S5(value -> (int) (1.02 * value)),;

    private final Function<Integer, Integer> function;

    StockFunction(Function<Integer, Integer> function) {
        this.function = function;
    }

    public Function<Integer, Integer> getFunction() {
        return function;
    }

    public int apply(int value) {
        return function.apply(value);
    }

    public StockFunction down() {
        int i = Integer.parseInt(this.name().replace("S", ""));
        int max = Math.max(1, i - 1);
        return StockFunction.valueOf(String.format("S%d", max));
    }

    public StockFunction up() {
        int len = StockFunction.values().length;
        int i = Integer.parseInt(this.name().replace("S", ""));
        int min = Math.min(len, i + 1);
        return StockFunction.valueOf(String.format("S%d", min));
    }
}
