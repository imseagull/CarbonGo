package com.example.carbongo;

public class Offer {
    private CarbonCompany seller;


    private double price;
    private double credits;

    private final long TIME;

    public Offer(CarbonCompany seller, double price, double credits) {
        this.seller = seller;
        this.price = price;
        this.credits = credits;
        this.TIME = System.currentTimeMillis();
    }

    public CarbonCompany getSeller() {
        return seller;
    }

    public long getTIME() {
        return TIME;
    }

    public void setSeller(CarbonCompany seller) {
        this.seller = seller;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getCredits() {
        return credits;
    }

    public void setCredits(double credits) {
        this.credits = credits;
    }
}
