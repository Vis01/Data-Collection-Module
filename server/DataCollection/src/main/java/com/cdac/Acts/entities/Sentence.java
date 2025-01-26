package com.cdac.Acts.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Sentence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sentenceId;

    private String originalSentence;

    private String translation;

    private Long documentId;

    private Long languageId;

    private LocalDateTime createdAt;

	public Long getSentenceId() {
		return sentenceId;
	}

	public void setSentenceId(Long sentenceId) {
		this.sentenceId = sentenceId;
	}

	public String getOriginalSentence() {
		return originalSentence;
	}

	public void setOriginalSentence(String originalSentence) {
		this.originalSentence = originalSentence;
	}

	public String getTranslation() {
		return translation;
	}

	public void setTranslation(String translation) {
		this.translation = translation;
	}

	public Long getDocumentId() {
		return documentId;
	}

	public void setDocumentId(Long documentId) {
		this.documentId = documentId;
	}

	public Long getLanguageId() {
		return languageId;
	}

	public void setLanguageId(Long languageId) {
		this.languageId = languageId;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public Sentence(Long sentenceId, String originalSentence, String translation, Long documentId, Long languageId,
			LocalDateTime createdAt) {
		super();
		this.sentenceId = sentenceId;
		this.originalSentence = originalSentence;
		this.translation = translation;
		this.documentId = documentId;
		this.languageId = languageId;
		this.createdAt = createdAt;
	}

	public Sentence() {
	}

    
}
