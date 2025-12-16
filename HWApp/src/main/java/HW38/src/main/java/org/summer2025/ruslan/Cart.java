package org.summer2025.ruslan;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("prototype")
public class Cart {
    private final List<Product> items = new ArrayList<>();

    public void addProduct(Product product) {
        if (product != null) items.add(product);
    }

    public void removeProductById(int id) {
        items.removeIf(p -> p.getId() == id);
    }

    public List<Product> getItems() {
        return new ArrayList<>(items);
    }
}