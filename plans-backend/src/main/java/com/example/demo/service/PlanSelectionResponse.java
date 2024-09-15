package com.example.demo.service;

import java.util.List;

public class PlanSelectionResponse {
    private CallingPlan callingPlan;
    private List<DataPlan> dataPlans;
    private ComboPlan comboPlan;

    public PlanSelectionResponse(CallingPlan callingPlan, List<DataPlan> dataPlans, ComboPlan comboPlan) {
        this.callingPlan = callingPlan;
        this.dataPlans = dataPlans;
        this.comboPlan = comboPlan;
    }

    public CallingPlan getCallingPlan() {
        return callingPlan;
    }

    public void setCallingPlan(CallingPlan callingPlan) {
        this.callingPlan = callingPlan;
    }

    public List<DataPlan> getDataPlans() {
        return dataPlans;
    }

    public void setDataPlans(List<DataPlan> dataPlans) {
        this.dataPlans = dataPlans;
    }

    public ComboPlan getComboPlan() {
        return comboPlan;
    }

    public void setComboPlan(ComboPlan comboPlan) {
        this.comboPlan = comboPlan;
    }
}
