package com.example.demo.service;

import com.example.demo.model.Plan;

public class DataPlan extends Plan {
    private int dataLimit;
    
    public static final DataPlan BASIC_PLAN = new DataPlan(
            "Basic", 
            20.99, 
            "300Mbps for 10GB/day, then 4Mbps", 
            5 
    );

    public static final DataPlan ADVANCED_PLAN = new DataPlan(
            "Advanced", 
            35.99, 
            "1000Mbps for 150GB/day, then 50Mbps", 
            150 
    );

    public DataPlan(String name, double price, String description, int dataLimit) {
        super(name, price, description);
        this.dataLimit = dataLimit;
    }

    public int getDataLimit() {
        return dataLimit;
    }

    public void setDataLimit(int dataLimit) {
        this.dataLimit = dataLimit;
    }

    @Override
    public String toString() {
        return "DataPlan [dataLimit=" + (dataLimit == Integer.MAX_VALUE ? "Unlimited" : dataLimit + "GB/day") + ", " + super.toString() + "]";
    }
}
