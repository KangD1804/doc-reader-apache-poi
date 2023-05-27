package com.example.demo.controller;

import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileInputStream;
import java.io.IOException;

@RestController
@CrossOrigin("http://localhost:3000/")
public class DocumentController {

    @GetMapping("/document")
    public String getDocumentText() throws IOException {
        String filePath = "E:\\Download\\HAMEÇONS-MAORIS-comprehension-ecrite.docx";
        FileInputStream fileInputStream = new FileInputStream(filePath);
        XWPFDocument document = new XWPFDocument(fileInputStream);
        XWPFWordExtractor extractor = new XWPFWordExtractor(document);
        String text = extractor.getText();
        extractor.close();
        document.close();
        return text;
    }
}
