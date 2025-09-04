package com.codewithmosh.store.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.codewithmosh.store.models.Product;
import com.codewithmosh.store.models.User;
import com.codewithmosh.store.repository.ProductRepository;
import com.codewithmosh.store.repository.UserRepository;

@Service
public class ProductService {

    private final ProductRepository productRepo;
    private final UserRepository userRepo;

    @ResponseStatus(HttpStatus.NOT_FOUND)
    public class ResourceNotFoundException extends RuntimeException {

        public ResourceNotFoundException(String message) {
            super(message);
        }
    }

    public ProductService(ProductRepository productRepo, UserRepository userRepo) {
        this.productRepo = productRepo;
        this.userRepo = userRepo;
    }

    public Product createProduct(Long userId, Product product) {
        User user = userRepo.findById(userId).orElseThrow(()
                -> new RuntimeException("User not found"));
        product.setUser(user);
        return productRepo.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public Product getProduct(Long id) {
        return productRepo.findById(id)
                .orElseThrow(()
                -> new ResourceNotFoundException("Product not found with id " + id));
    }

    public Product updateProduct(Long id, Product updatedProduct) {
        Product product = getProduct(id);
        product.setName(updatedProduct.getName());
        product.setPrice(updatedProduct.getPrice());
        return productRepo.save(product);
    }

    public void deleteProduct(Long id) {
        productRepo.deleteById(id);
    }
}
