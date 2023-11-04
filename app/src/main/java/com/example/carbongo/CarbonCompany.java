package com.example.carbongo;

public class CarbonCompany {
    private String name;
    private double credits;
    // private double[] emissionsPer
    private double allTimeEmissions;


    private Transaction[] transactions;

    public CarbonCompany(String name, double credits, double allTimeEmissions, Transaction[] transactions) {
        this.name = name;
        this.credits = credits;
        this.allTimeEmissions = allTimeEmissions;
        this.transactions = transactions;
    }




    public Transaction sellCreditsTo(CarbonCompany buyer, double creds){
        // Do stripe stuff
        this.credits -= creds;
        buyer.credits += creds;
        return new Transaction(buyer, this, creds);
    }

    public Transaction buyCreditsFrom(CarbonCompany seller, double creds){
        // Do stripe stuff
        credits += creds;
        seller.credits -= creds;
        return new Transaction(this, seller, creds);
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

    public Transaction[] getTransactions() {
        return transactions;
    }

    public void setTransactions(Transaction[] transactions) {
        this.transactions = transactions;
    }
}
