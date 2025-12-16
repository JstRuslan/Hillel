package org.summer2025.ruslan.Repository;

import org.springframework.stereotype.Repository;
import org.summer2025.ruslan.Model.Order;

import java.util.*;

@Repository
public class OrderRepository {
    private final Map<Long, Order> orders = new HashMap<>();

    public Optional<Order> getOrderById(Long id) {
        return Optional.ofNullable(orders.get(id));
    }

    public List<Order> getAllOrders() {
        return new ArrayList<>(orders.values());
    }

    public void addOrder(Order order) {
        orders.put(order.getId(), order);
    }
}
