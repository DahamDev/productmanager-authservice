package com.productmanager.authenticator.repository;

import com.productmanager.authenticator.entitiy.UserEntitiy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.User;

public interface UserRepository extends CrudRepository<UserEntitiy, Integer> {
    UserEntitiy findByUsername(String username);

}
