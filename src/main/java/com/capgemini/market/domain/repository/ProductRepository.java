package com.capgemini.market.domain.repository;

import com.capgemini.market.domain.service.Product;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


public interface ProductRepository {
    List<Product> getAll();
    Optional<List<Product>> getByCategory(int categoryId);
    Optional<List<Product>> getScaaseProducts(int quantity, boolean active);
    Optional<Product> getProduct(int productId);
    Product save (Product product);
    void delete(int productId);
}
