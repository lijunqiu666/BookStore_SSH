package zhang.spring.bookstore.test;

import java.util.Date;
import java.util.Set;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import zhang.spring.bookstore.dao.OrderStatusDao;
import zhang.spring.bookstore.dao.TradeDAO;
import zhang.spring.bookstore.dao.TradeItemDAO;
import zhang.spring.bookstore.dao.UserDAO;
import zhang.spring.bookstore.entities.Book;
import zhang.spring.bookstore.entities.Trade;
import zhang.spring.bookstore.entities.TradeItem;
import zhang.spring.bookstore.entities.User;
import zhang.spring.bookstore.entities.orderStatus;

public class TestTradedao {
	private TradeDAO tradeDAO=null;
	private UserDAO userDAO=null;
	private TradeItemDAO tradeItemDAO=null;
	private OrderStatusDao orderStatusDao=null;
	private ApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");
	{
		tradeDAO=ctx.getBean(TradeDAO.class);
		tradeItemDAO=ctx.getBean(TradeItemDAO.class);
		userDAO=ctx.getBean(UserDAO.class);
		orderStatusDao=ctx.getBean(OrderStatusDao.class);
	}
	@Test
	public void testsetStatus(){
		tradeItemDAO.setStatus(9, 2);
	}
	@Test
	public void testupdatestatues(){
		TradeItem tradeItem = tradeItemDAO.getTradeItem(9);
		System.out.println(tradeItem);
		orderStatus statusById = orderStatusDao.getStatusById(4);
		tradeItem.setOrderstatus(statusById);
	}
	@Test
	public void testgetTradesWithUserId(){
		User user = userDAO.getUser("zhangyukang");
		Set<Trade> trades = tradeDAO.getTrades(user);
		for(Trade trade:trades){
			Set<TradeItem> items = tradeItemDAO.getTradeItemsWithTrade(trade);
			int size = items.size();
			System.out.println("½»Ò×Ïî"+size);
			System.out.println(trades);
		}
	}
	@Test
	public void testinsert(){
		Trade trade2=new Trade();
		trade2.setTradeTime(new Date());
		trade2.setUser(userDAO.getUser("zhangyukang"));
		Integer id = tradeDAO.insert(trade2);
		System.out.println(id);
		
		
	}
	
}
