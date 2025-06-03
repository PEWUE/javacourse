package model;

import java.math.BigDecimal;
import java.util.Objects;

public class Product {
    private final String name;
    private final ProductCategory category;
    private final BigDecimal price;

    public Product(String name, ProductCategory category, BigDecimal price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getName() { return name; }
    public ProductCategory getCategory() { return category; }
    public BigDecimal getPrice() { return price; }

    @Override
    public String toString() {
        return name + " " + category + " (" + price + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name) && category == product.category && Objects.equals(price, product.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, category, price);
    }
}