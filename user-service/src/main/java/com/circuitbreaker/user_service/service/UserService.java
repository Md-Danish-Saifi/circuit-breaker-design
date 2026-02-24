package com.circuitbreaker.user_service.service;

import com.circuitbreaker.user_service.entity.ProductEntity;
import com.circuitbreaker.user_service.entity.UserEntity;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UserService {

    @Autowired
    @Lazy
    RestTemplate restTemplate;

    public static final String USER_SERVICE = "userService";
    private static final String BASE_URL="http://localhost:8080/";

    @CircuitBreaker(name = USER_SERVICE,fallbackMethod = "getAllProduct")
    public List<?> getUserProduct(){
        List<?> lst = new ArrayList<>();
      lst = restTemplate.getForObject(BASE_URL+"all-product",List.class);
      return lst;
    }

    public List<ProductEntity> getAllProduct() {
        return Stream.of(
                new ProductEntity(1, "Jeans", "pant", 200),
                new ProductEntity(2, "Jeans", "pant", 200),
                new ProductEntity(3, "Jeans", "pant", 200),
                new ProductEntity(4, "Jeans", "pant", 200),
                new ProductEntity(5, "Jeans", "pant", 200),
                new ProductEntity(6, "Jeans", "pant", 200)
        ).collect(Collectors.toList());
    }
}
