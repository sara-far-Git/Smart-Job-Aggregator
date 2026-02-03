package com.sara.jobagent.service;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.springframework.stereotype.Service;

import java.io.InputStream;

@Service
public class ResumeParserService {

    public String extractText(String filename, InputStream input) throws Exception {

        if (filename.endsWith(".pdf")) {
            return parsePdf(input);
        }

        if (filename.endsWith(".docx")) {
            return parseDocx(input);
        }

        if (filename.endsWith(".txt")) {
            return new String(input.readAllBytes());
        }

        throw new RuntimeException("Unsupported file type");
    }


    private String parsePdf(InputStream input) throws Exception {
        PDDocument doc = PDDocument.load(input);
        PDFTextStripper stripper = new PDFTextStripper();
        String text = stripper.getText(doc);
        doc.close();
        return text;
    }

    private String parseDocx(InputStream input) throws Exception {
        XWPFDocument doc = new XWPFDocument(input);
        XWPFWordExtractor extractor = new XWPFWordExtractor(doc);
        String text = extractor.getText();
        doc.close();
        return text;
    }
}
