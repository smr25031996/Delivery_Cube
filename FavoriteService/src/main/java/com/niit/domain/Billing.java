package com.niit.domain;

public class Billing {
    private String NameOnCard;
    private long cardNumber;
    private String expiryMonth;
    private String expiryYear;
    private int CVV;

    public Billing(String nameOnCard, long cardNumber, String expiryMonth, String expiryYear, int cVV) {
        NameOnCard = nameOnCard;
        this.cardNumber = cardNumber;
        this.expiryMonth = expiryMonth;
        this.expiryYear = expiryYear;
        this.CVV = cVV;
    }

    public Billing() {
    }

    @Override
    public String toString() {
        return "Billing{" +
                "NameOnCard='" + NameOnCard + '\'' +
                ", cardNumber=" + cardNumber +
                ", expiryMonth='" + expiryMonth + '\'' +
                ", expiryYear='" + expiryYear + '\'' +
                ", cVV=" + CVV +
                '}';
    }

    public String getNameOnCard() {
        return NameOnCard;
    }

    public void setNameOnCard(String nameOnCard) {
        NameOnCard = nameOnCard;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpiryMonth() {
        return expiryMonth;
    }

    public void setExpiryMonth(String expiryMonth) {
        this.expiryMonth = expiryMonth;
    }

    public String getExpiryYear() {
        return expiryYear;
    }

    public void setExpiryYear(String expiryYear) {
        this.expiryYear = expiryYear;
    }

    public int getCVV() {
        return CVV;
    }

    public void setCVV(int CVV) {
        this.CVV = CVV;
    }
}
