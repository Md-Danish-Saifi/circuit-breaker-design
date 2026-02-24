package com.circuitbreaker.user_service.controller;

import com.circuitbreaker.user_service.entity.ProductEntity;
import com.circuitbreaker.user_service.entity.UserEntity;
import com.circuitbreaker.user_service.repoeitory.UserRepository;
import com.circuitbreaker.user_service.service.UserService;
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
public class UserController {

    @Autowired
    UserRepository repository;
    @Autowired
    UserService service;

    @PostConstruct
    public void initUserTable(){
        repository.saveAll(Stream.of(
                new UserEntity(1, "Gems", "121, interpole", "8678967"),
                new UserEntity(2, "bond", "pantis, 11", "7965789"),
                new UserEntity(3, "denial", "33,japant", "7696796"),
                new UserEntity(4, "vicky", "12 topanta house", "6789676"),
                new UserEntity(5, "lotin", "78 pantloon ca", "6789678"),
                new UserEntity(6, "lui", "99 pantrasia wa", "9768968")
        ).collect(Collectors.toList()));
    }
    @GetMapping("all-user")
        public List<UserEntity> getAllUser(){
            return repository.findAll();
    }
    @GetMapping("get-user")
    public Optional<UserEntity> getUserById(@RequestParam String userId){
        return repository.findById(Integer.valueOf(userId));
    }
    @GetMapping("delete-user")
    public List<UserEntity> DeleteUserById(@RequestParam String userId){
        repository.deleteById(Integer.valueOf(userId));
        return repository.findAll();
    }
    @GetMapping("user-product")
    public List<?> getAllUserProduct(){
       return service.getUserProduct();
        
    }

}
