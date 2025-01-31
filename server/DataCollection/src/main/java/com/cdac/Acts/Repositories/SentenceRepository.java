package com.cdac.Acts.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdac.Acts.entities.Sentence;

@Repository
public interface SentenceRepository extends JpaRepository<Sentence, Integer> {

	List<Sentence> findByDocumentId(int documentId);
   // List<Sentence> findByDocumentId(Long documentId);
    
}