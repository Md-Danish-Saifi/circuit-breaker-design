package com.circuitbreaker.user_service.repoeitory;

import com.circuitbreaker.user_service.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,Integer> {

}
