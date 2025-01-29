package com.cdac.Acts.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cdac.Acts.Services.DocumentService;
import com.cdac.Acts.entities.Document;

import java.util.List;

@RestController
@RequestMapping("/api/documents")
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    // Get Document by ID
    @GetMapping("/{documentId}")
    public ResponseEntity<Document> getDocumentById(@PathVariable int documentId) {
        return documentService.getDocumentById(documentId);
    }

    // Create a new document
    @PostMapping
    public ResponseEntity<Document> createDocument(@RequestBody Document document) {
        return documentService.createDocument(document);
    }

    // Edit a document
    @PutMapping("/{documentId}")
    public ResponseEntity<Document> updateDocument(@PathVariable int documentId, @RequestBody Document document) {
        return documentService.updateDocument(documentId, document);
    }

    // Delete a document
    @DeleteMapping("/{documentId}")
    public ResponseEntity<String> deleteDocument(@PathVariable int documentId) {
        return documentService.deleteDocument(documentId);
    }

    // Get all documents for a user
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Document>> getDocumentsByUserId(@PathVariable int userId) {
        return documentService.getDocumentsByUserId(userId);
    }
}
