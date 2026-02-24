package com.circuitbreaker.product_service.repository;

import com.circuitbreaker.product_service.entity.Entity;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface ProductRepository extends JpaRepository<Entity,Integer> {
}
