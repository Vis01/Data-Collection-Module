package com.cdac.Acts.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="globaldatabase")
public class GlobalDatabase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="global_id")
    private Integer globalId;

    @Lob
    @Column(name="sentence_text", columnDefinition = "TEXT")
    private String sentenceText;

    @Lob
    @Column(name="translation_text" ,columnDefinition = "TEXT")
    private String translationText;

    @ManyToOne
    @JoinColumn(name = "sentence_language_id", nullable = false)
    private Language sentenceLanguage;

    @ManyToOne
    @JoinColumn(name = "translation_language_id", nullable = false)
    private Language translationLanguage;

    @ManyToOne
    @JoinColumn(name = "added_by", nullable = false)
    private User addedBy;

    @Column(name="added_date")
    private LocalDateTime addedDate = LocalDateTime.now();

	public Integer getGlobalId() {
		return globalId;
	}

	public void setGlobalId(Integer globalId) {
		this.globalId = globalId;
	}

	public String getSentenceText() {
		return sentenceText;
	}

	public void setSentenceText(String sentenceText) {
		this.sentenceText = sentenceText;
	}

	public String getTranslationText() {
		return translationText;
	}

	public void setTranslationText(String translationText) {
		this.translationText = translationText;
	}

	public Language getSentenceLanguage() {
		return sentenceLanguage;
	}

	public void setSentenceLanguage(Language sentenceLanguage) {
		this.sentenceLanguage = sentenceLanguage;
	}

	public Language getTranslationLanguage() {
		return translationLanguage;
	}

	public void setTranslationLanguage(Language translationLanguage) {
		this.translationLanguage = translationLanguage;
	}

	public User getAddedBy() {
		return addedBy;
	}

	public void setAddedBy(User addedBy) {
		this.addedBy = addedBy;
	}

	public LocalDateTime getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(LocalDateTime addedDate) {
		this.addedDate = addedDate;
	}

	public GlobalDatabase(Integer globalId, String sentenceText, String translationText, Language sentenceLanguage,
			Language translationLanguage, User addedBy, LocalDateTime addedDate) {
		super();
		this.globalId = globalId;
		this.sentenceText = sentenceText;
		this.translationText = translationText;
		this.sentenceLanguage = sentenceLanguage;
		this.translationLanguage = translationLanguage;
		this.addedBy = addedBy;
		this.addedDate = addedDate;
	}

	public GlobalDatabase() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}