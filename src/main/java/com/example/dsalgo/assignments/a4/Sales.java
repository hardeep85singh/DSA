package com.example.dsalgo.assignments.a4;

public class Sales {

    // Constants for the values of each sale
    public static final int JUNIOR_PRICE = 5;
    public static final int TEEN_PRICE = 10;
    public static final int MEDIUM_PRICE = 12;
    public static final int BIG_PRICE = 15;
    public static final int FAMILY_PRICE = 20;

    // Attributes to keep track of the number of each sale
    private int juniorCount;
    private int teenCount;
    private int mediumCount;
    private int bigCount;
    private int familyCount;

    // Default constructor
    public Sales() {
        // Initialize counts to zero
    }

    // Constructor with 5 integer parameters to set the number of each sale category
    public Sales(int juniorCount, int teenCount, int mediumCount, int bigCount, int familyCount) {
        this.juniorCount = juniorCount;
        this.teenCount = teenCount;
        this.mediumCount = mediumCount;
        this.bigCount = bigCount;
        this.familyCount = familyCount;
    }

    // Copy constructor
    public Sales(Sales other) {
        this.juniorCount = other.juniorCount;
        this.teenCount = other.teenCount;
        this.mediumCount = other.mediumCount;
        this.bigCount = other.bigCount;
        this.familyCount = other.familyCount;
    }

    // Accessor and mutator methods for all attributes...
    public int getJuniorCount() {
        return this.juniorCount;
    }

    public void setJuniorCount(int juniorCount) {
        this.juniorCount = juniorCount;
    }

    public int getTeenCount() {
        return this.teenCount;
    }

    public void setTeenCount(int teenCount) {
        this.teenCount = teenCount;
    }

    public int getMediumCount() {
        return this.mediumCount;
    }

    public void setMediumCount(int mediumCount) {
        this.mediumCount = mediumCount;
    }

    public int getBigCount() {
        return this.bigCount;
    }

    public void setBigCount(int bigCount) {
        this.bigCount = bigCount;
    }

    public int getFamilyCount() {
        return this.familyCount;
    }

    public void setFamilyCount(int familyCount) {
        this.familyCount = familyCount;
    }

    // Add sales method
    public void addSales(int junior, int teen, int medium, int big, int family) {
        this.juniorCount += junior;
        this.teenCount += teen;
        this.mediumCount += medium;
        this.bigCount += big;
        this.familyCount += family;
    }

    // Calculate total sales value
    public int salesTotal() {
        return (juniorCount * JUNIOR_PRICE) +
                (teenCount * TEEN_PRICE) +
                (mediumCount * MEDIUM_PRICE) +
                (bigCount * BIG_PRICE) +
                (familyCount * FAMILY_PRICE);
    }

    // toString method
    @Override
    public String toString() {
        return String.format("%d x $%d + %d x $%d + %d x $%d + %d x $%d + %d x $%d",
                             juniorCount, JUNIOR_PRICE, teenCount, TEEN_PRICE, mediumCount, MEDIUM_PRICE,
                             bigCount, BIG_PRICE, familyCount, FAMILY_PRICE);
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
        Sales other = (Sales) obj;
        return juniorCount == other.juniorCount &&
                teenCount == other.teenCount &&
                mediumCount == other.mediumCount &&
                bigCount == other.bigCount &&
                familyCount == other.familyCount;
    }
}
