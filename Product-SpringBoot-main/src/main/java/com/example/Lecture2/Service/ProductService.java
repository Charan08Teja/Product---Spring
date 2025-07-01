package com.example.Lecture2.Service;

import com.example.Lecture2.Product;
import com.example.Lecture2.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public Product createProduct(Product product){
        if(product.getName() == null || product.getName().isEmpty()){
            throw new IllegalArgumentException("Product name cannot be empty");
        }
        return productRepository.save(product);
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
}
