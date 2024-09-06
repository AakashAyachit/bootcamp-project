package com.example.demo.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.PlanService;
import com.example.demo.service.PlanSelectionResponse;

@RestController
@RequestMapping("/api/plans")
public class PlanController {

    @Autowired
    private PlanService planService;

    @GetMapping("/select-plan")
    public ResponseEntity<PlanSelectionResponse> getAllPlans() {
        return ResponseEntity.ok(planService.getAllPlans());
    }

//    @GetMapping("/test")
//    public ResponseEntity<String> testEndpoint() {
//        return ResponseEntity.ok("helo");
//    }
}
