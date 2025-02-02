package com.cdac.Acts.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cdac.Acts.repository.DocumentsRepository;
import com.cdac.Acts.entities.Document;

import java.util.List;
import java.util.Optional;

@Service
public class DocumentService {

    @Autowired
    private DocumentsRepository documentRepository;

    // Get Document by ID
    public ResponseEntity<Document> getDocumentById(Long documentId) {
        Optional<Document> document = documentRepository.findById(documentId);
        return document.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Create a new Document
    public ResponseEntity<Document> createDocument(Document document) {
        Document savedDocument = documentRepository.save(document);
        return ResponseEntity.status(201).body(savedDocument);
    }

    // Edit an existing Document
    public ResponseEntity<Document> updateDocument(Long documentId, Document document) {
        Optional<Document> existingDocument = documentRepository.findById(documentId);
        if (existingDocument.isPresent()) {
            document.setDocumentId(documentId);  // Ensure the documentId is set
            Document updatedDocument = documentRepository.save(document);
            return ResponseEntity.ok(updatedDocument);
        }
        return ResponseEntity.notFound().build();
    }

    // Delete Document
    public ResponseEntity<String> deleteDocument(Long documentId) {
        Optional<Document> existingDocument = documentRepository.findById(documentId);
        if (existingDocument.isPresent()) {
            documentRepository.deleteById(documentId);
            return ResponseEntity.ok("Document deleted successfully.");
        }
        return ResponseEntity.notFound().build();
    }

    // Get all documents for a user
    public ResponseEntity<List<Document>> getDocumentsByUserId(int userId) {
        List<Document> documents = documentRepository.findByUserId(userId);
        return documents.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(documents);
    }
}
