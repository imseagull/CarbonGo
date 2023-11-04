package com.example.carbongo;

public class Transaction {
    private CarbonCompany buyer;

    private CarbonCompany seller;

    private double credits;

    public Transaction(CarbonCompany buyer, CarbonCompany seller, double credits) {
        this.buyer = buyer;
        this.seller = seller;
        this.credits = credits;
    }

    public CarbonCompany getBuyer() {
        return buyer;
    }

    public void setBuyer(CarbonCompany buyer) {
        this.buyer = buyer;
    }

    public CarbonCompany getSeller() {
        return seller;
    }

    public void setSeller(CarbonCompany seller) {
        this.seller = seller;
    }

    public double getCredits() {
        return credits;
    }

    public void setCredits(double credits) {
        this.credits = credits;
    }
}
