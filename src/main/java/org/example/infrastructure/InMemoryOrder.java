package org.example.infrastructure;

import org.example.domain.entities.Order;
import org.example.domain.entities.repository.OrderRepository;

import java.util.ArrayList;
import java.util.List;

public class InMemoryOrder implements OrderRepository {

    private List<Order> orders = new ArrayList<>();

    @Override
    public void save(Order order) {
        orders.add(order);
    }

}
