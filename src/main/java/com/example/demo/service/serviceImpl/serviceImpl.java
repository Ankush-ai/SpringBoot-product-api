package com.example.demo.service.serviceImpl;

import com.example.demo.entities.productEntity;
import com.example.demo.repository.productRepository;
import com.example.demo.service.productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class serviceImpl implements productService {

    private final productRepository productrepository;

    @Autowired
    public serviceImpl(productRepository productrepository) {
        this.productrepository = productrepository;
    }

    @Override
    public productEntity create(productEntity productentity) {
        return this.productrepository.save(productentity);
    }

    @Override
    public productEntity update(productEntity productentity, int id) {
        productEntity existingProduct = this.productrepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found "));
        
        existingProduct.setName(productentity.getName());
        existingProduct.setPrice(productentity.getPrice());
        existingProduct.setDescription(productentity.getDescription());

        return this.productrepository.save(existingProduct);
    }

    @Override
    public void delete(int id) {
        this.productrepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found "));
        this.productrepository.deleteById(id);
    }

    @Override
    public productEntity getById(int id) {
        return this.productrepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found "));
    }

    @Override
    public List<productEntity> getAll() {
        return this.productrepository.findAll();
    }
}
