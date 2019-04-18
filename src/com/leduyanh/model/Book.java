
package com.leduyanh.model;

public class Book {
    private int book_id;
    private String title;
    private String author;
    private int amount;
    private String introduce;
    private int category_id;

    public int getBook_id() {
        return book_id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getAmount() {
        return amount;
    }

    public String getIntroduce() {
        return introduce;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }
    
}
