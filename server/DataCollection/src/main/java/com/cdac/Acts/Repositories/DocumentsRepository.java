package com.cdac.Acts.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdac.Acts.entities.Document;

@Repository
public interface DocumentsRepository extends JpaRepository<Document, Integer> {

	List<Document> findByUserId(int userId);
}
