package com.example.demo.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.productEntity;

@RestController
@RequestMapping("/v1/products")
public class productController {

    @Autowired
    private com.example.demo.service.productService productService;
//    localhost:8080/v1/products/test
    @GetMapping("/test")
    public String getApi() {
        return "success";
    }
    
//    loclhost:8080/v1/products/
    @PostMapping("/")
    public ResponseEntity<productEntity> createProduct(@RequestBody productEntity productentity) {
        productEntity createdProduct = productService.create(productentity);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }
    
    
//    localhost:8080/v1/products/1
    @GetMapping("/{id}")
    public ResponseEntity<productEntity> getProductById(@PathVariable int id) {
        try {
            productEntity product = productService.getById(id);
            return new ResponseEntity<>(product, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
//    localhost:8080/v1/products/getAll
    @GetMapping("/getAll")
    public ResponseEntity<List<productEntity>> getAllProducts() {
        List<productEntity> allProducts = productService.getAll();
        return new ResponseEntity<>(allProducts, HttpStatus.OK);
    }
//    localhost:8080/v1/products/1
    @PutMapping("/{id}")
    public ResponseEntity<productEntity> updateProduct(@RequestBody productEntity productentity, @PathVariable int id) {
        productEntity updatedProduct = productService.update(productentity, id);
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }
//    localhost:8080/v1/products/1
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteProduct(@PathVariable int id) {
        productService.delete(id);
        Map<String, String> message = Map.of("k1", "message", "v1", "message deleted successfully");
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
