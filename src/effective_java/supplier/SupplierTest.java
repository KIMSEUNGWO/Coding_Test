package effective_java.supplier;

import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SupplierTest {

    public static void main(String[] args) {

        Supplier<Double> supplier = () -> new Random().nextGaussian();

        List<Double> list = Stream.generate(supplier)
            .limit(10)
            .collect(Collectors.toList());

        list.remove(0);
    }
}
