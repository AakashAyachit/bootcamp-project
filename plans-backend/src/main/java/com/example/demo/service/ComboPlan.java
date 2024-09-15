package com.example.demo.service;

import com.example.demo.model.Plan;

public class ComboPlan extends Plan {
    private String minutes;
    private String dataLimit;
    private boolean tvIncluded;

    public static final ComboPlan PREMIUM_COMBO_PLAN = new ComboPlan(
            "Premium Combo",
            79.99,
            "Unlimited minutes, unlimited data, TV service included with selected channels.",
            "Unlimited",  
            "Unlimited",  
            true          
    );

    public ComboPlan(String name, double price, String description, String minutes, String dataLimit, boolean tvIncluded) {
        super(name, price, description);
        this.minutes = minutes;
        this.dataLimit = dataLimit;
        this.tvIncluded = tvIncluded;
    }

    public String getMinutes() {
        return minutes;
    }

    public void setMinutes(String minutes) {
        this.minutes = minutes;
    }

    public String getDataLimit() {
        return dataLimit;
    }

    public void setDataLimit(String dataLimit) {
        this.dataLimit = dataLimit;
    }

    public boolean isTvIncluded() {
        return tvIncluded;
    }

    public void setTvIncluded(boolean tvIncluded) {
        this.tvIncluded = tvIncluded;
    }

    @Override
    public String toString() {
        return "ComboPlan [minutes=" + minutes + 
               ", dataLimit=" + dataLimit + 
               ", tvIncluded=" + tvIncluded + 
               ", " + super.toString() + "]";
    }
}
