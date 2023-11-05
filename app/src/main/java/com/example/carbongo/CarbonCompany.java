package com.example.carbongo;

public class CarbonCompany {
    private String name;
    private double credits;
    // private double[] emissionsPer
    private double allTimeEmissions;

    public CarbonCompany(String name, double credits, double allTimeEmissions) {
        this.name = name;
        this.credits = credits;
        this.allTimeEmissions = allTimeEmissions;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCredits() {
        return credits;
    }

    public void setCredits(double credits) {
        this.credits = credits;
    }

    public double getAllTimeEmissions() {
        return allTimeEmissions;
    }

    public void setAllTimeEmissions(double allTimeEmissions) {
        this.allTimeEmissions = allTimeEmissions;
    }

}
