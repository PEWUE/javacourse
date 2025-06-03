import generator.OrderGenerator;
import model.Order;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    private static final List<Order> orders = new OrderGenerator().generate();

    public static void main(String[] args) {
        List<String> popularProducts = getPopularProducts();

        popularProducts.forEach(System.out::println);
    }

    public static List<String> getPopularProducts() {
        return orders.stream()
                .collect(Collectors.groupingBy(
                        order -> order.getProduct().getName(),
                        Collectors.mapping(Order::getClient, Collectors.toSet())
                ))
                .entrySet().stream()
                .filter(entry -> entry.getValue().size() > 3)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}
