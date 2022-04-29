package com.example.tradestore.tradestore.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity //It tells this class represents database table
public class Trade {

    @Id //It tells that it is a primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)//This makes the field auto-incremented
    private int Id;

    private int tradeId;
    private int version;
    private int cpId;
    private int bookId;
    private Date maturityDate;
    private Date createdDate;
    private boolean expiry;

    
    public int getId() {
        return this.Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getTradeId() {
        return this.tradeId;
    }

    public void setTradeId(int tradeId) {
        this.tradeId = tradeId;
    }

    public int getVersion() {
        return this.version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getCpId() {
        return this.cpId;
    }

    public void setCpId(int cpId) {
        this.cpId = cpId;
    }

    public int getBookId() {
        return this.bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public Date getMaturityDate() {
        return this.maturityDate;
    }

    public void setMaturityDate(Date maturityDate) {
        this.maturityDate = maturityDate;
    }

    public Date getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public boolean isExpiry() {
        return this.expiry;
    }

    public void setExpiry(boolean expiry) {
        this.expiry = expiry;
    }


}