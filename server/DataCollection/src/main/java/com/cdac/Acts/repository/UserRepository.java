package com.cdac.Acts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdac.Acts.entities.User;

<<<<<<< HEAD

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
=======
//Repository interface for User entity, providing database access methods
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
>>>>>>> 6c116af2847faee897a2dfaf71c19c1e9e050611
    User findByUsername(String username);
    boolean existsByUsername(String username);
}