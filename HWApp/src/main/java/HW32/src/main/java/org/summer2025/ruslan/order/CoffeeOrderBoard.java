package org.summer2025.ruslan.order;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;

public class CoffeeOrderBoard {
    private static final Logger logger = LoggerFactory.getLogger(CoffeeOrderBoard.class);
    private final List<Order> orders = new LinkedList<>();
    private int orderNumber = 1;

    public CoffeeOrderBoard() {
    }

    public void addOrder(String name) {
        Order order = new Order(orderNumber++, name);
        orders.add(order);
        logger.info("Add order: {}", order);
    }

    public void deliver() {
        if (orders.isEmpty()) {
            logger.warn("Tried give the order but the queue is empty");
            return;
        }
        Order order = orders.remove(0);
        logger.info("Order out: {}", order);
    }

    public void deliver(int orderNumber) {
        try {
            if (orders.isEmpty()) {
                logger.warn("Tried give the order but the queue is empty");
                return;
            }
            for (Order order : orders) {
                if (order.getOrderNumber() == orderNumber) {
                    orders.remove(order);
                    logger.info("Order out: {}", order);
                    return;
                }
            }
            throw new IllegalArgumentException("Error when search order");
        } catch (Exception e){
            logger.error("Order not found: {}", e.getMessage(),e);
        }
    }

    public void draw(){
        if (orders.isEmpty()) {
            logger.info("The queue is empty");
            return;
        } else {
            System.out.println("Num | Name");
            for (Order order : orders) {
                System.out.println(order);
            }
            logger.info("Queue displayed with {} orders", orders.size());
        }
    }
}
