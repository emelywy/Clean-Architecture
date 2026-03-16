package org.example.usecase;

import org.example.domain.entities.Order;
import org.example.domain.entities.OrderItem;
import org.example.domain.entities.Product;
import org.example.domain.entities.repository.OrderRepository;
import org.example.domain.entities.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

public class CreateOrderUseCase {

    private ProductRepository productRepository;
    private OrderRepository orderRepository;

    public CreateOrderUseCase(ProductRepository productRepository, OrderRepository orderRepository) {
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
    }

    public Order createOrder(int productId, int quantity) {

        Product product = productRepository.findById(productId);
        if (product == null) {
            throw new RuntimeException("Product not found");
        }

        if (!product.isAvailable(quantity)) {
            throw new RuntimeException("Not enough");
        }

        product.reduceStock(quantity);
        OrderItem item = new OrderItem(product, quantity);

        List<OrderItem> items = new ArrayList<>();
        items.add(item);
        Order order = new Order(items);

        orderRepository.save(order);
        return order;
    }

}
