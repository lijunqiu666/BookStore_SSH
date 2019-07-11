package zhang.spring.bookstore.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import zhang.spring.bookstore.dao.BookDAO;
import zhang.spring.bookstore.dao.TradeDAO;
import zhang.spring.bookstore.dao.TradeItemDAO;
import zhang.spring.bookstore.entities.Trade;
import zhang.spring.bookstore.entities.TradeItem;

public class TestTradeItemDao {
	private TradeDAO tradeDAO=null;
	private TradeItemDAO tradeItemDAO=null;
	private ApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");
	private BookDAO bookDAO=null;
	{
		tradeItemDAO=ctx.getBean(TradeItemDAO.class);
		bookDAO=ctx.getBean(BookDAO.class);
		tradeDAO=ctx.getBean(TradeDAO.class);
	}
	@Test
	public void testgetTradeItemsWithTrade(){
		Trade trade = tradeDAO.getTrade(51);
		Set<TradeItem> items = tradeItemDAO.getTradeItemsWithTrade(trade);
		System.out.println(items.size());
	}
	@Test
	public void testbatchSave(){
		Collection<TradeItem> items=new ArrayList<>();
		TradeItem item1=new TradeItem();
		item1.setQuantity(1);
		item1.setBook(bookDAO.getBook(1));
		item1.setTrade(tradeDAO.getTrade(2));
		items.add(item1);
		
		TradeItem item2=new TradeItem();
		item2.setQuantity(1);
		item2.setBook(bookDAO.getBook(1));
		item2.setTrade(tradeDAO.getTrade(2));
		items.add(item2);
		
		tradeItemDAO.batchSave(items);
	}

}
