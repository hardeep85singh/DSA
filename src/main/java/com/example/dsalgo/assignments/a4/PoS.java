package com.example.dsalgo.assignments.a4;

public class PoS {
    private Sales sales;
    private PrePaiCard[] prePaiCards;

    // Constructors
    public PoS() {
        // Initialize to default values
    }

    public PoS(Sales sales, PrePaiCard[] prePaiCards) {
        this.sales = sales;
        this.prePaiCards = prePaiCards;
    }

    // Method to compare total $ value of sales
    public boolean isEqualTotalSales(PoS other) {
        int totalSalesThis = (sales != null) ? sales.salesTotal() : 0;
        int totalSalesOther = (other.sales != null) ? other.sales.salesTotal() : 0;

        return totalSalesThis == totalSalesOther;
    }

    // Method to compare number of each sales category
    public boolean isEqualSalesCategories(PoS other) {
        return sales.getJuniorCount() == other.getSales().getJuniorCount()
                && sales.getTeenCount() == other.getSales().getTeenCount()
                && sales.getMediumCount() == other.getSales().getMediumCount()
                && sales.getBigCount() == other.getSales().getBigCount()
                && sales.getFamilyCount() == other.getSales().getFamilyCount();
    }

    // Method to get total $ sales of a PoS
    public int getTotalSales() {
        return (sales != null) ? sales.salesTotal() : 0;
    }

    // Method to get the number of prepaid cards in a PoS
    public int getNumberOfPrepaidCards() {
        return (prePaiCards != null) ? prePaiCards.length : 0;
    }

    // Method to add a new PrePaiCard to the PoS
    public int addPrepaidCard(PrePaiCard newCard) {
        if (prePaiCards == null) {
            prePaiCards = new PrePaiCard[]{newCard};
        } else {
            PrePaiCard[] newArray = new PrePaiCard[prePaiCards.length + 1];
            System.arraycopy(prePaiCards, 0, newArray, 0, prePaiCards.length);
            newArray[prePaiCards.length] = newCard;
            prePaiCards = newArray;
        }
        return getNumberOfPrepaidCards();
    }

    // Method to remove a pre-paid card from the PoS
    public boolean removePrepaidCard(PrePaiCard cardToRemove) {
        if (prePaiCards != null) {
            for (int i = 0; i < prePaiCards.length; i++) {
                if (prePaiCards[i].equals(cardToRemove)) {
                    PrePaiCard[] newArray = new PrePaiCard[prePaiCards.length - 1];
                    System.arraycopy(prePaiCards, 0, newArray, 0, i);
                    System.arraycopy(prePaiCards, i + 1, newArray, i, prePaiCards.length - i - 1);
                    prePaiCards = newArray;
                    return true; // Removal successful
                }
            }
        }

        return false; // Card not found or PoS has no prepaid cards
    }

    // Method to update the expiry day and month of a prepaid card
    public void updatePrepaidCardExpiry(PrePaiCard cardToUpdate, int newDay, int newMonth) {
        cardToUpdate.setExpiryDay(newDay);
        cardToUpdate.setExpiryMonth(newMonth);
    }

    // Method to add meal sales to the PoS
    public int addMealSales(int junior, int teen, int medium, int big, int family) {
        if (sales == null) {
            sales = new Sales(junior, teen, medium, big, family);
        } else {
            sales.addSales(junior, teen, medium, big, family);
        }

        return getTotalSales();
    }

    public PrePaiCard[] getPrePaiCards() {
        return prePaiCards;
    }

    public Sales getSales() {
        return sales;
    }

    // Method to compare total $ amount sales value and the number of pre-paid card
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        PoS other = (PoS) obj;
        return isEqualTotalSales(other) && getNumberOfPrepaidCards() == other.getNumberOfPrepaidCards();
    }

    // Method to represent the PoS as a string
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        if (sales != null) {
            result.append(sales.toString()).append("\n");
        } else {
            result.append("No sales information available.\n");
        }

        if (prePaiCards != null && prePaiCards.length > 0) {
//            result.append("Prepaid Cards:\n");
            for (PrePaiCard card : prePaiCards) {
                result.append(card.toString()).append("\n");
            }
        } else {
            result.append("No PrePaiCards\n");
        }

        return result.toString();
    }
}

