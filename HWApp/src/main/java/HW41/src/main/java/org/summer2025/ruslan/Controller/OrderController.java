package org.summer2025.ruslan.Controller;

import org.springframework.web.bind.annotation.*;
import org.summer2025.ruslan.Entity.Order;
import org.summer2025.ruslan.Service.OrderService;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable("id") Long id) {
        return orderService.getById(id);
    }

    @GetMapping("/all")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @PostMapping
    public Order addOrder(@RequestBody List<Long> productIds) {
        return orderService.createOrder(productIds);
    }

    @DeleteMapping("/{id}")
    public String deleteOrder(@PathVariable("id") Long id) {
        orderService.deleteById(id);
        return "Order deleted successfully!";
    }

    @PutMapping("/{id}")
    public Order updateOrder(@PathVariable("id") Long id, @RequestBody Order updatedOrder) {
        return orderService.getById(id);
    }
}
