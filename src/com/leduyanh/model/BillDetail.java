
package com.leduyanh.model;

public class BillDetail {
    private int bill_detail_id;
    private int bill_id;
    private int book_id;
    private String date_pay;
    private String fined;

    public int getBill_detail_id() {
        return bill_detail_id;
    }

    public void setBill_detail_id(int bill_detail_id) {
        this.bill_detail_id = bill_detail_id;
    }

    public int getBill_id() {
        return bill_id;
    }

    public void setBill_id(int bill_id) {
        this.bill_id = bill_id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getDate_pay() {
        return date_pay;
    }

    public void setDate_pay(String date_pay) {
        this.date_pay = date_pay;
    }

    public String getFined() {
        return fined;
    }

    public void setFined(String fined) {
        this.fined = fined;
    }
    
}
