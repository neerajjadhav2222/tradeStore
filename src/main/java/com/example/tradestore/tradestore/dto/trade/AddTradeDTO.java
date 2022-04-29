package com.example.tradestore.tradestore.dto.trade;

import java.util.Date;

public class AddTradeDTO {

    public int tradeId;
    public int version;
    public int cpId;
    public int bookId;
    public Date maturityDate;
    public boolean expiry;

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

    public boolean isExpiry() {
        return this.expiry;
    }

    public void setExpiry(boolean expiry) {
        this.expiry = expiry;
    }
}
