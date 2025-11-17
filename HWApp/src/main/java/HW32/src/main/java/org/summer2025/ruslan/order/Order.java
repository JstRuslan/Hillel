package org.summer2025.ruslan.order;


import lombok.Getter;

@Getter
public class Order {
    private final int orderNumber;
    private final String name;

    public Order(int orderNumber, String name) {
        this.orderNumber = orderNumber;
        this.name = name;
    }

    @Override
    public String toString() {
        return "{ "+ orderNumber +" | " + name + " }";
    }
}
