
package com.leduyanh.model;

public class Bill {
    private int bill_id;
    private int reader_id;
    private int user_id;
    private String deposit;
    private String date;
    private String date_hen;

    public String getDate_hen() {
        return date_hen;
    }

    public void setDate_hen(String date_hen) {
        this.date_hen = date_hen;
    }

    public int getBill_id() {
        return bill_id;
    }

    public void setBill_id(int bill_id) {
        this.bill_id = bill_id;
    }

    public int getReader_id() {
        return reader_id;
    }

    public void setReader_id(int reader_id) {
        this.reader_id = reader_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getDeposit() {
        return deposit;
    }

    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    
}
