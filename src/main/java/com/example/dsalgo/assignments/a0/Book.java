package com.example.dsalgo.assignments.a0;

public class Book {
    private String title;
    private String author;
    private long ISBN;
    private double price;

    private static int count;

    public Book(String title, String author, long ISBN, double price) {

        this.author = author;
        this.ISBN = ISBN;
        this.title = title;
        this.price = price;
        count++;
    }

    //when this method is called it returns the title
    public String getTitle() {
        return title;
    }

    // when this method is called it returns the author
    public String getAuthor() {
        return author;
    }

    public long getISBN() {
        return ISBN;
    }

    public double getPrice() {
        return price;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setISBN(long iSBN) {
        ISBN = iSBN;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public static int findNumberOfCreatedBooks() {
        return count;
    }

    public boolean equals(Book that) {
        return this.author.equalsIgnoreCase(that.author) && this.title.equalsIgnoreCase(
                that.title) && this.ISBN == that.ISBN && this.price == that.price;
    }

    public String toString() {
        return "Title: " + this.title + "\nAuthor: " + this.author + "\nISBN: " + this.ISBN + "\nPrice: " + this.price;

    }
}

