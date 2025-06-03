package model;

import java.util.Objects;

public class Order {
    private final Client client;
    private final Product product;
    private final int quantity;
    private final Region region;

    public Order(Client client, Product product, int quantity, Region region) {
        this.client = client;
        this.product = product;
        this.quantity = quantity;
        this.region = region;
    }

    public Client getClient() { return client; }
    public Product getProduct() { return product; }
    public int getQuantity() { return quantity; }
    public Region getRegion() { return region; }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return quantity == order.quantity && Objects.equals(client, order.client) && Objects.equals(product, order.product) && region == order.region;
    }

    @Override
    public int hashCode() {
        return Objects.hash(client, product, quantity, region);
    }
}