package com.example.carbongo;

public class Transaction {
    private CarbonCompany buyer;

    private CarbonCompany seller;

    private double price;
    private double credits;

    private final long TIME;



    public Transaction(CarbonCompany buyer, CarbonCompany seller, double price, double credits) {
        this.buyer = buyer;
        this.seller = seller;
        this.price = price;
        this.credits = credits;
        this.TIME = System.currentTimeMillis();
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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

    public long getTime(){return TIME;}
}
