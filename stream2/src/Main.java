import generator.OrderGenerator;
import model.Order;
import model.Product;
import model.ProductCategory;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static final List<Order> orders = new OrderGenerator().generate();

    public static void main(String[] args) {
        List<String> popularProducts = getPopularProducts();
//        popularProducts.forEach(System.out::println);

        Map<String, BigDecimal> totalSpendByCustomer = getTotalSpendByCustomer();
//        totalSpendByCustomer.forEach((name, value)-> System.out.println(name + " - " + value));

        Map<ProductCategory, Set<String>> regionsByProductCategory = getRegionsByProductCategory();
//        regionsByProductCategory.forEach((category,regionSet) -> System.out.println(category + " - " + regionSet));

        Optional<Product> mostExpensiveProduct = getMostExpensiveProduct();
//        mostExpensiveProduct.ifPresent(System.out::println);

        Map<String, Boolean> regionsWithElectronicsOrders = getRegionsWithElectronicsOrders();
        regionsWithElectronicsOrders.forEach((region, bool) -> System.out.println(region + " " + bool));

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

    public static Map<String, BigDecimal> getTotalSpendByCustomer() {
        return orders.stream()
                .collect(Collectors.groupingBy(
                        order -> order.getClient().getFullName(),
                        Collectors.reducing(
                                BigDecimal.ZERO,
                                order -> order.getProduct().getPrice().multiply(BigDecimal.valueOf(order.getQuantity())),
                                BigDecimal::add
                        )
                ));
    }

    public static Map<ProductCategory, Set<String>> getRegionsByProductCategory() {
        return orders.stream()
                .collect(Collectors.groupingBy(
                        order -> order.getProduct().getCategory(),
                        Collectors.mapping(order -> order.getRegion().getStateFullname(), Collectors.toSet())
                ));
    }

    public static Optional<Product> getMostExpensiveProduct() {
        return orders.stream()
                .map(Order::getProduct)
                .distinct()
                .max(Comparator.comparing(Product::getPrice));
    }

    public static Map<String,Boolean> getRegionsWithElectronicsOrders() {
        return orders.stream()
                .collect(Collectors.groupingBy(
                        order -> order.getRegion().getStateFullname(),
                        Collectors.collectingAndThen(
                                Collectors.mapping(
                                        order -> order.getProduct().getCategory(),
                                        Collectors.toSet()
                                ),
                                category -> category.contains(ProductCategory.ELECTRONICS)
                        )
                ));
    }
}
