package com.example.demo.model;

import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.example.demo.service.CallingPlan;
import com.example.demo.service.ComboPlan;
import com.example.demo.service.DataPlan;
import com.example.demo.service.PlanSelectionResponse;

@Service
public class PlanService {

    public PlanSelectionResponse getAllPlans() {
        return new PlanSelectionResponse(
            CallingPlan.FULL_CALLING_PLAN, 
            Arrays.asList(DataPlan.BASIC_PLAN, DataPlan.ADVANCED_PLAN), 
            ComboPlan.PREMIUM_COMBO_PLAN
        );
    }
}