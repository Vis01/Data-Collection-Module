package com.cdac.Acts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdac.Acts.entities.User;

//Repository interface for User entity, providing database access methods
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    User findByUsername(String username);
    boolean existsByUsername(String username);
}