package com.cdac.Acts.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="sentences")
public class Sentence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="sentence_id")
    private Integer sentenceId;

    @Column(name="document_id")
    private Integer documentId;
    
    @Column(name="sentence_text")
    private String originalSentence;

    @Column(name="translation_text")
    private String translation;

    @Column(name="sentence_language_id")
	private byte sourcelanguageId;
    
    @Column(name="translation_language_id")
    private byte targetlanguageId;

	public Integer getSentenceId() {
		return sentenceId;
	}

	public void setSentenceId(Integer sentenceId) {
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

	public Integer getDocumentId() {
		return documentId;
	}

	public void setDocumentId(Integer documentId) {
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
	public Sentence(Integer sentenceId, String originalSentence, String translation, Integer documentId, byte sourcelanguageId,byte targetlanguageId,
			LocalDateTime createdAt) {
		super();
		this.sentenceId = sentenceId;
		this.originalSentence = originalSentence;
		this.translation = translation;
		this.documentId = documentId;
		this.sourcelanguageId = sourcelanguageId;
		this.targetlanguageId = targetlanguageId;
	}

	public Sentence() {
	}

    
}
