package com.cdac.Acts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdac.Acts.entities.Document;

@Repository
public interface DocumentsRepository extends JpaRepository<Document, Long> {
<<<<<<< HEAD
    List<Document> findByUserId(Long userId);
=======
    List<Document> findByUserId(int userId);
>>>>>>> 6c116af2847faee897a2dfaf71c19c1e9e050611
}
