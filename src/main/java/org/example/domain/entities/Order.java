package org.example.domain.entities;

import java.util.List;

public class Order {

    private List<OrderItem> items;
    private double totalPrice;
    private String status;

    public Order(List<OrderItem> items) {
        this.items = items;
        this.totalPrice = calculateTotal();
        this.status = "Created";
    }

    private double calculateTotal() {

        double sum = 0;

        for (OrderItem item : items) {
            sum += item.getTotalPrice();
        }
        return sum;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public String getStatus() {
        return status;
    }

}
