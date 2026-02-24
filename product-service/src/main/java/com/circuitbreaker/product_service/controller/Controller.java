package com.circuitbreaker.product_service.controller;

import com.circuitbreaker.product_service.entity.Entity;
import com.circuitbreaker.product_service.repository.ProductRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class Controller {

    @Autowired
    ProductRepository repository;

    @PostConstruct
    public void initProductTable(){
        repository.saveAll(Stream.of(
                new Entity(1, "Jeans", "pant", 200),
                new Entity(2, "Jeans", "pant", 200),
                new Entity(3, "Jeans", "pant", 200),
                new Entity(4, "Jeans", "pant", 200),
                new Entity(5, "Jeans", "pant", 200),
                new Entity(6, "Jeans", "pant", 200)
        ).collect(Collectors.toList()));
    }
@GetMapping("all-product")
    public List<Entity> getAllProduct(){
        return repository.findAll();
}
    @GetMapping("get-product")
    public Optional<Entity> getProductById(@RequestParam String productId){
        return repository.findById(Integer.valueOf(productId));
    }
    @GetMapping("delete-product")
    public List<Entity> DeleteProductById(@RequestParam String productId){
        repository.deleteById(Integer.valueOf(productId));
        return repository.findAll();
    } 

}
