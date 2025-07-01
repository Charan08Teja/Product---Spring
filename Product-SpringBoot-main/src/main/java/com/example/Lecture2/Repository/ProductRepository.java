package com.example.Lecture2.Repository;

import com.example.Lecture2.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository {
    private final List<Product> products = new ArrayList<>();
    private long currentId = 1;

    public Product save(Product product) {
        product.setId(currentId++);
        products.add(product);
        return product;
    }

    public Optional<Product> findById(Long id) {
        return products.stream().filter(p -> p.getId().equals(id)).findFirst();
    }

    public List<Product> findAll() {
        return new ArrayList<>(products);
    }
}
