package com.example.tradestore.tradestore.controller;

import java.util.List;
import java.util.Date;
import java.util.Optional;

import com.example.tradestore.tradestore.dao.TradeDAO;
import com.example.tradestore.tradestore.dto.trade.AddTradeDTO;
import com.example.tradestore.tradestore.exception.IllegalMaturityDateException;
import com.example.tradestore.tradestore.exception.LowerVersionException;
import com.example.tradestore.tradestore.model.Trade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TradeController {

    @Autowired
    TradeDAO tradeDAO;

    @GetMapping(value = "/home")
    public String home() {
        return "home";
    }

    @GetMapping(value = "/getTrade/{tradeId}")
    public Trade getTrade(@PathVariable int tradeId) {

        // tradeDAO.save(addTradeDAO);
        // return 100;
        Optional<Trade> trade = tradeDAO.findById(tradeId);
        return trade.get();
    }

    @PostMapping(value = "/addTrade")
    public int addTrade(@RequestBody AddTradeDTO trade) {

        List<Trade> existingTrades = tradeDAO.findByTradeId(trade.tradeId);
        try {
           if(trade.getMaturityDate().before(new Date())){
                throw new IllegalMaturityDateException("Maturity date cannot be lower than created date");
           }else{
            if (!existingTrades.isEmpty()) {
                Trade existingTradeValue = existingTrades.get(existingTrades.size()-1);
               // if(existingTradeValue.getMaturityDate().before(Date, WhenClause ){}
                if (existingTradeValue.getVersion() == trade.version ) {

                    existingTradeValue.setBookId(trade.getBookId());
                    existingTradeValue.setCpId(trade.getCpId());
                    existingTradeValue.setMaturityDate(trade.getMaturityDate());
                    existingTradeValue.setExpiry(trade.isExpiry());
                    existingTradeValue.setCreatedDate(new Date());
                    return tradeDAO.save(existingTradeValue).getId();
                } else if (existingTradeValue.getVersion() > trade.version) {
                    throw new LowerVersionException("Current version lower than the existing version");
                } else {
                    Trade trade2 = new Trade();
                    trade2.setBookId(trade.getBookId());
                    trade2.setCpId(trade.getCpId());
                    trade2.setMaturityDate(trade.getMaturityDate());
                    trade2.setVersion(trade.getVersion());
                    trade2.setExpiry(trade.isExpiry());
                    trade2.setCreatedDate(new Date());
                    trade2.setTradeId(trade.getTradeId());
                    return tradeDAO.save(trade2).getId();
                }

            } else {
                Trade trade2 = new Trade();
                trade2.setBookId(trade.getBookId());
                trade2.setCpId(trade.getCpId());
                trade2.setMaturityDate(trade.getMaturityDate());
                trade2.setVersion(trade.getVersion());
                trade2.setExpiry(trade.isExpiry());
                trade2.setCreatedDate(new Date());
                trade2.setTradeId(trade.getTradeId());
                return tradeDAO.save(trade2).getId();
            }
           }
        }
        catch (LowerVersionException exception) {
            return 0;
        }
        catch (IllegalMaturityDateException exception){
            return 0;
        }

    }
}
