package org.summer2025.ruslan.Service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.summer2025.ruslan.Entity.Order;
import org.summer2025.ruslan.Entity.Product;
import org.summer2025.ruslan.Repository.OrderRepository;
import org.summer2025.ruslan.Repository.ProductRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public OrderService(OrderRepository orderRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    @Transactional
    public Order createOrder(List<Long> productIds) {
        List<Product> products = productRepository.findAllById(productIds);
        Double totalCost = products.stream()
                .mapToDouble(Product::getPrice)
                .sum();
        Order order = new Order();
        order.setProducts(products);
        order.setTotalCost(totalCost);
        order.setCreatedAt(LocalDateTime.now());
        return orderRepository.save(order);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }

    public void deleteById(Long id) {
        orderRepository.deleteById(id);
    }

    @Transactional
    public Order updateOrder(Long id, List<Long> productIds) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        List<Product> products = productRepository.findAllById(productIds);
        double totalCost = products.stream()
                .mapToDouble(Product::getPrice)
                .sum();
        order.setProducts(products);
        order.setTotalCost(totalCost);
        order.setCreatedAt(LocalDateTime.now());
        return orderRepository.save(order);
    }
}
