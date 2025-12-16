package org.summer2025.ruslan.Controller;

import org.springframework.web.bind.annotation.*;
import org.summer2025.ruslan.Model.Order;
import org.summer2025.ruslan.Repository.OrderRepository;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable("id") Long id) {
        return orderRepository.getOrderById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }

    @GetMapping("/all")
    public List<Order> getAllOrders() {
        return orderRepository.getAllOrders();
    }

    @PostMapping
    public String addOrder(@RequestBody Order order) {
        order.setCreationDate(LocalDateTime.now());
        orderRepository.addOrder(order);
        return "Order added successfully!";
    }
}
