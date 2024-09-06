package com.example;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class OcrService {

    private final ITesseract tesseract;

    public OcrService() {
        tesseract = new Tesseract();
        tesseract.setDatapath("C:\\Tess4J\\tessdata");
        tesseract.setLanguage("eng");
    }

    public boolean isAadhaarImage(File imageFile) {
        try {
            String extractedText = tesseract.doOCR(imageFile);
            return extractedText.contains("DOB") || extractedText.contains("YoB") || extractedText.contains("Male") || extractedText.contains("MALE") || extractedText.contains("Female") || extractedText.contains("FEMALE") ;
        } catch (TesseractException e) {
            throw new RuntimeException("Error performing OCR: " + e.getMessage(), e);
        }
    }

    public String extractAadhaarNumberFromImage(File imageFile) {
        try {
            String extractedText = tesseract.doOCR(imageFile);
            return extractAadhaarNumber(extractedText);
        } catch (TesseractException e) {
            throw new RuntimeException("Error performing OCR: " + e.getMessage(), e);
        }
    }

    private String extractAadhaarNumber(String text) {
        Pattern pattern = Pattern.compile("\\b\\d{4} \\d{4} \\d{4}\\b");
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            return matcher.group(0).replaceAll(" ", ""); 
        }
        return "Aadhaar number not found";
    }
}
