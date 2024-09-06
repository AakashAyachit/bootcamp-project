package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/ocr")
public class OcrController {

    @Autowired
    private OcrService ocrService;

    @GetMapping("/verify")
    public String showUploadForm() {
    	
        // Return the Thymeleaf template for image upload
        return "uploadForm";
    }

    @PostMapping("/verify")
    public String uploadImage(@RequestParam MultipartFile file, Model model) {
        Map<String, String> response = new HashMap<>();

        if (file.isEmpty()) {
            response.put("error", "No file uploaded");
            model.addAllAttributes(response);
            return "uploadForm"; // Return the Thymeleaf template with error message
        }

        String contentType = file.getContentType();
        if (contentType == null || !contentType.startsWith("image/")) {
            response.put("error", "Invalid file type. Please upload an image.");
            model.addAllAttributes(response);
            return "uploadForm"; // Return the Thymeleaf template with error message
        }

        try {
            Path tempFilePath = Files.createTempFile("upload-", file.getOriginalFilename());
            file.transferTo(tempFilePath.toFile());

            boolean isAadhaarImage = ocrService.isAadhaarImage(tempFilePath.toFile());

            if (!isAadhaarImage) {
                Files.delete(tempFilePath);
                response.put("error", "The image does not appear to be an Aadhaar card.");
                model.addAllAttributes(response);
                return "uploadForm"; // Return the Thymeleaf template with error message
            }

            String aadhaarNumber = ocrService.extractAadhaarNumberFromImage(tempFilePath.toFile());
            Files.delete(tempFilePath);

            response.put("aadhaarNumber", aadhaarNumber);
            model.addAllAttributes(response);
            return "uploadForm"; // Return the Thymeleaf template with Aadhaar number
        } catch (IOException e) {
            response.put("error", "Error saving file: " + e.getMessage());
            e.printStackTrace();
            model.addAllAttributes(response);
            return "uploadForm"; // Return the Thymeleaf template with error message
        } catch (Exception e) {
            response.put("error", "Error occurred while performing OCR: " + e.getMessage());
            e.printStackTrace();
            model.addAllAttributes(response);
            return "uploadForm"; // Return the Thymeleaf template with error message
        }
    }
}
