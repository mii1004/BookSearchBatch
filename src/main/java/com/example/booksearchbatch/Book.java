package com.example.booksearchbatch;

public class Book {
    private String title;
    private String creator;
    private String publisher;
    private String subject;

    private Book() {
    }

    public Book(String title, String creator, String publisher, String subject) {
        this.title = title;
        this.creator = creator;
        this.publisher = publisher;
        this.subject = subject;
    }

    public String toCsvRecord() {
        return title + "," + creator + "," + publisher + "," + subject;
    }

    @Override
    public String toString() {
        return "title:" + title + " creator:" + creator + " publisher:" + publisher + " subject:" + subject;
    }
}
