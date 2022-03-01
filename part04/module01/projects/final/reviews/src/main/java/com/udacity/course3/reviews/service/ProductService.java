package com.udacity.course3.reviews.service;

import com.udacity.course3.reviews.entity.Product;
import com.udacity.course3.reviews.exception.NotFoundException;
import com.udacity.course3.reviews.repository.ProductRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public void save(Product product) {
        this.productRepository.save(product);
    }

    public Product findById(Long id) {
        return this.productRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("Product not found."));
    }

    public List<Product> findAll() {
        return this.productRepository.findAll();
    }
}
