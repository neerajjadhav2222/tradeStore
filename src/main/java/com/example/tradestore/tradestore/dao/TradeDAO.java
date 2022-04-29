package com.example.tradestore.tradestore.dao;

import java.util.List;

import com.example.tradestore.tradestore.model.Trade;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TradeDAO extends CrudRepository<Trade,Integer>{
    
    List<Trade> findByTradeId(int tradeId);
}

/*public class AddTradeDAO extends JpaRepositoriesAutoConfiguration{
    public int version;
    public int cpId;
    public int bookId;
    public Date maturityDate;
    public boolean expiry;

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

}*/
