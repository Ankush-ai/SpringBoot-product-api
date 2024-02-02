package com.example.demo.service;

import com.example.demo.entities.productEntity;

import java.util.List;

public interface productService {
    productEntity create(productEntity productentity);
    productEntity update(productEntity productentity, int id);
    void delete(int id);
    productEntity getById(int id);
    List<productEntity> getAll();
}