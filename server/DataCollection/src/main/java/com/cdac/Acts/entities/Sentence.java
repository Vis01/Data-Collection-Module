package com.cdac.Acts.entities;

import java.time.LocalDateTime;

<<<<<<< HEAD

=======
>>>>>>> 6c116af2847faee897a2dfaf71c19c1e9e050611
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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

    private byte sourcelanguageId;

    private byte targetlanguageId;
    
<<<<<<< HEAD
    @Enumerated(EnumType.STRING)
    private Status status = Status.PENDING;
    
=======
>>>>>>> 6c116af2847faee897a2dfaf71c19c1e9e050611
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

	public byte getSourcelanguageId() {
		return sourcelanguageId;
	}

	public void setSourceLanguageId(byte sourcelanguageId) {
		this.sourcelanguageId= sourcelanguageId;
	}

	public byte getTargetlanguageId() {
		return targetlanguageId;
	}

	public void setTargetlanguageId(byte targetlanguageId) {
		this.targetlanguageId = targetlanguageId;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
<<<<<<< HEAD
	public Status getStatus() {
		return status;
	}



	public void setStatus(Status status) {
		this.status = status;
	}
	
	public Sentence(Long sentenceId, String originalSentence, String translation, Long documentId, byte sourcelanguageId,byte targetlanguageId,
			LocalDateTime createdAt,Status status) {
=======

	public Sentence(Long sentenceId, String originalSentence, String translation, Long documentId, byte sourcelanguageId,byte targetlanguageId,
			LocalDateTime createdAt) {
>>>>>>> 6c116af2847faee897a2dfaf71c19c1e9e050611
		super();
		this.sentenceId = sentenceId;
		this.originalSentence = originalSentence;
		this.translation = translation;
		this.documentId = documentId;
		this.sourcelanguageId = sourcelanguageId;
		this.targetlanguageId = targetlanguageId;
		this.createdAt = createdAt;
<<<<<<< HEAD
		this.status = status;
=======
>>>>>>> 6c116af2847faee897a2dfaf71c19c1e9e050611
	}

	public Sentence() {
	}

    
}
