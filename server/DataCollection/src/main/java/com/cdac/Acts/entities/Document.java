package com.cdac.Acts.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="documents")
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="document_id")
    private Integer documentId;

    @Column(name="user_id")
    private Integer userId;

    @Column(name="file_name")
    private String fileName;

    @Column(name="upload_date")
    private LocalDateTime uploadDate = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    @Column(name="status")
    private Status status = Status.PENDING;

    @Column(name="verifier_id")
    private Integer verifierId;

    

    public Document() {
	}



	public Document(Integer documentId, Integer userId, String fileName, String filePath, LocalDateTime uploadDate,
			Status status, Integer verifierId) {
		super();
		this.documentId = documentId;
		this.userId = userId;
		this.fileName = fileName;
		this.uploadDate = uploadDate;
		this.status = status;
		this.verifierId = verifierId;
	}



	public Integer getDocumentId() {
		return documentId;
	}



	public void setDocumentId(Integer documentId) {
		this.documentId = documentId;
	}



	public Integer getUserId() {
		return userId;
	}



	public void setUserId(Integer userId) {
		this.userId = userId;
	}



	public String getFileName() {
		return fileName;
	}



	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public LocalDateTime getUploadDate() {
		return uploadDate;
	}



	public void setUploadDate(LocalDateTime uploadDate) {
		this.uploadDate = uploadDate;
	}



	public Status getStatus() {
		return status;
	}



	public void setStatus(Status status) {
		this.status = status;
	}



	public Integer getVerifierId() {
		return verifierId;
	}



	public void setVerifierId(Integer verifierId) {
		this.verifierId = verifierId;
	}



	public enum Status {
        PENDING, VERIFIED, REJECTED
    }
}
