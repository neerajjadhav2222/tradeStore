package com.example.tradestore.tradestore;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.text.DateFormat;
import java.text.ParseException;
import com.example.tradestore.tradestore.dao.TradeDAO;
import com.example.tradestore.tradestore.model.Trade;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class TradestoreApplicationTests {

	@Autowired
    TradeDAO tradeDAO;

	@Test
	public void testCreate() throws ParseException{
		Trade trade = new Trade();
		trade.setTradeId(100);
		trade.setVersion(1);
		trade.setBookId(350);
		trade.setCpId(22);
		trade.setCreatedDate(DateFormat.getDateInstance(DateFormat.SHORT).parse("10/04/20"));
		trade.setMaturityDate(DateFormat.getDateInstance(DateFormat.SHORT).parse("13/04/30")); //DD/MM/YY
		trade.setExpiry(false);
		tradeDAO.save(trade);
		assertNotNull(tradeDAO.findByTradeId(10).get(0));
	}

	@Test
	public void testSingleTrade(){
		Trade trade = tradeDAO.findById(2).get();
		assertEquals(21, trade.getCpId());

	}

	@Test
	public void testUpdate(){
		Trade updTrade = tradeDAO.findById(2).get();
		updTrade.setBookId(200);
		tradeDAO.save(updTrade);
		assertNotEquals(104, tradeDAO.findById(2).get().getBookId());
	}

}
