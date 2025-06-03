package generator;

import model.Product;
import model.ProductCategory;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class ProductGenerator {
    public List<Product> generate() {
        return Arrays.asList(
                new Product("Wireless Mouse", ProductCategory.ELECTRONICS, new BigDecimal("19.99")),
                new Product("Bluetooth Headphones", ProductCategory.ELECTRONICS, new BigDecimal("49.99")),
                new Product("LED Light Bulbs (Pack of 4)", ProductCategory.HOME, new BigDecimal("12.99")),
                new Product("Cordless Drill", ProductCategory.DIY, new BigDecimal("59.90")),
                new Product("Yoga Mat", ProductCategory.SPORTS, new BigDecimal("25.00")),
                new Product("Organic Green Tea (100g)", ProductCategory.GROCERY, new BigDecimal("6.49")),
                new Product("Dog Chew Toy", ProductCategory.PETS, new BigDecimal("8.99")),
                new Product("Men’s Running Shoes", ProductCategory.CLOTHING, new BigDecimal("39.99")),
                new Product("Hair Dryer 2000W", ProductCategory.BEAUTY, new BigDecimal("27.95")),
                new Product("Modern Wall Clock", ProductCategory.HOME, new BigDecimal("21.99")),
                new Product("Notebook A5 - 100 sheets", ProductCategory.STATIONERY, new BigDecimal("3.49")),
                new Product("Camping Tent 2-Person", ProductCategory.OUTDOORS, new BigDecimal("89.90")),
                new Product("Smartphone Stand", ProductCategory.ELECTRONICS, new BigDecimal("7.99")),
                new Product("Electric Kettle 1.7L", ProductCategory.HOME_APPLIANCES, new BigDecimal("34.99")),
                new Product("Anti-Stress Coloring Book", ProductCategory.BOOKS, new BigDecimal("9.99")),
                new Product("Car Phone Holder", ProductCategory.AUTOMOTIVE, new BigDecimal("13.50")),
                new Product("Garden Hose 15m", ProductCategory.GARDEN, new BigDecimal("22.90")),
                new Product("Laptop Sleeve 15.6\"", ProductCategory.ACCESSORIES, new BigDecimal("17.49")),
                new Product("Wireless Keyboard", ProductCategory.ELECTRONICS, new BigDecimal("29.95")),
                new Product("Watercolor Paint Set", ProductCategory.ART_SUPPLIES, new BigDecimal("14.20"))
        );
    }
}