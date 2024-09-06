package com.example.demo.service;

import com.example.demo.model.Plan;

public class CallingPlan extends Plan {
    private String minutes;

    public static final CallingPlan FULL_CALLING_PLAN = new CallingPlan(
            "Full Calling",
            15.99,
            "Make as many calls as needed! no limit.",
            "Unlimited"
    );

    public CallingPlan(String name, double price, String description, String minutes) {
        super(name, price, description);
        this.minutes = minutes;
    }

    public String getMinutes() {
        return minutes;
    }

    public void setMinutes(String minutes) {
        this.minutes = minutes;
    }

    @Override
    public String toString() {
        return "CallingPlan [minutes=" + minutes + ", " + super.toString() + "]";
    }
}