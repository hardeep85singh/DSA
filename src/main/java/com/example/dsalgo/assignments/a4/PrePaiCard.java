package com.example.dsalgo.assignments.a4;

public class PrePaiCard {
    // Attributes
    private String cardType;
    private String cardHolderId;
    private int expiryDay;
    private int expiryMonth;

    // Default constructor
    public PrePaiCard() {
        // Initialize to default values
    }

    // Constructor with 4 parameters to set initial values, with validation
    public PrePaiCard(String cardType, String cardHolderId, int expiryDay, int expiryMonth) {
        this.cardType = cardType;
        this.cardHolderId = cardHolderId;
        setExpiryDay(expiryDay);
        setExpiryMonth(expiryMonth);
    }

    // Copy constructor
    public PrePaiCard(PrePaiCard other) {
        this.cardType = other.cardType;
        this.cardHolderId = other.cardHolderId;
        this.expiryDay = other.expiryDay;
        this.expiryMonth = other.expiryMonth;
    }

    // Accessor methods...
    public String getCardType() {
        return this.cardType;
    }

    public String getCardHolderId() {
        return this.cardHolderId;
    }

    public int getExpiryDay() {
        return this.expiryDay;
    }

    public int getExpiryMonth() {
        return this.expiryMonth;
    }

    // Mutator method for expiryDay with validation
    public void setExpiryDay(int day) {
        if (day >= 1 && day <= 31) {
            this.expiryDay = day;
        } else {
            this.expiryDay = 0;
        }
    }

    // Mutator method for expiryMonth with validation
    public void setExpiryMonth(int month) {
        if (month >= 1 && month <= 12) {
            this.expiryMonth = month;
        } else {
            this.expiryMonth = 0;
        }
    }

    // toString method
    @Override
    public String toString() {
        return String.format("%s - %s - %02d/%02d",
                             cardType, cardHolderId, expiryDay, expiryMonth);
    }

    // equals method
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PrePaiCard other = (PrePaiCard) obj;
        return cardType.equals(other.cardType) &&
                cardHolderId.equals(other.cardHolderId) &&
                expiryDay == other.expiryDay &&
                expiryMonth == other.expiryMonth;
    }
}

