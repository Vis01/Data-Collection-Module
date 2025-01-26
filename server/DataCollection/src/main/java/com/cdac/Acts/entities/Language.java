package com.cdac.Acts.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long languageId;

    private String languageCode;

    private String languageName;

	public Long getLanguageId() {
		return languageId;
	}

	public void setLanguageId(Long languageId) {
		this.languageId = languageId;
	}

	public String getLanguageCode() {
		return languageCode;
	}

	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}

	public String getLanguageName() {
		return languageName;
	}

	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}

	public Language(Long languageId, String languageCode, String languageName) {
		super();
		this.languageId = languageId;
		this.languageCode = languageCode;
		this.languageName = languageName;
	}

	public Language() {
	}

    
}