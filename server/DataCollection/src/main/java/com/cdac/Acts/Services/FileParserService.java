package com.cdac.Acts.Services;

import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.tika.Tika;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cdac.Acts.Repositories.DocumentsRepository;
import com.cdac.Acts.Repositories.LanguageRepository;
import com.cdac.Acts.Repositories.SentenceRepository;
import com.cdac.Acts.entities.Document;
import com.cdac.Acts.entities.Language;
import com.cdac.Acts.entities.Sentence;


@Service
public class FileParserService {

    @Autowired
    private SentenceRepository sentencesRepository;

    @Autowired
    private DocumentsRepository documentsRepository;

    @Autowired
    private LanguageRepository languageRepository;

    public void parseAndSaveFile(MultipartFile file, Long userId) throws Exception {
        // Save document metadata
        Document document = saveDocumentMetadata(file, userId);

        // Determine file type and parse the file
        String fileType = file.getContentType();
        List<Sentence> sentences = new ArrayList<>();

        Long defaultLanguageId = 1L; // Replace with your logic to select the language
        Language language = languageRepository.findById(defaultLanguageId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid language ID"));

        if (fileType != null && fileType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
            sentences = parseExcelFile(file.getInputStream(), document.getDocumentId(), language.getLanguageId());
        } else {
            sentences = parseOtherFile(file.getInputStream(), document.getDocumentId(), language.getLanguageId());
        }

        // Save sentences to the database
        sentencesRepository.saveAll(sentences);
    }

    private Document saveDocumentMetadata(MultipartFile file, Long userId) throws Exception {
        String filePath = "path/to/storage/" + file.getOriginalFilename(); // Replace with actual storage logic

        // Save the file to a storage location (not implemented in this example)
        file.transferTo(new java.io.File(filePath));

        Document document = new Document();
        document.setUserId(userId);
        document.setFileName(file.getOriginalFilename());
        document.setFilePath(filePath);
       

        return documentsRepository.save(document);
    }

    private List<Sentence> parseExcelFile(InputStream inputStream, Long documentId, Long languageId) throws Exception {
        List<Sentence> sentences = new ArrayList<>();
        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheetAt(0);

        for (Row row : sheet) {
            if (row.getRowNum() == 0) continue; // Skip header row

            Cell sentenceCell = row.getCell(0);
            Cell translationCell = row.getCell(1);

            if (sentenceCell != null) {
                Sentence sentence = new Sentence();
                sentence.setOriginalSentence(sentenceCell.getStringCellValue());
                sentence.setDocumentId(documentId);
                sentence.setLanguageId(languageId);
                sentence.setCreatedAt(LocalDateTime.now());

                if (translationCell != null) {
                    sentence.setTranslation(translationCell.getStringCellValue());
                }

                sentences.add(sentence);
            }
        }

        workbook.close();
        return sentences;
    }

    private List<Sentence> parseOtherFile(InputStream inputStream, Long documentId, Long languageId) throws Exception {
        List<Sentence> sentences = new ArrayList<>();
        Tika tika = new Tika();
        String content = tika.parseToString(inputStream);

        for (String line : content.split("\n")) {
            if (!line.trim().isEmpty()) {
                Sentence sentence = new Sentence();
                sentence.setOriginalSentence(line.trim());
                sentence.setDocumentId(documentId);
                sentence.setLanguageId(languageId);
                sentence.setCreatedAt(LocalDateTime.now());
                sentences.add(sentence);
            }
        }

        return sentences;
    }
}
