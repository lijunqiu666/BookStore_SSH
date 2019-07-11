package zhang.spring.bookstore.service.impl;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zhang.spring.bookstore.dao.AccountDAO;
import zhang.spring.bookstore.dao.BookDAO;
import zhang.spring.bookstore.dao.TradeDAO;
import zhang.spring.bookstore.dao.TradeItemDAO;
import zhang.spring.bookstore.dao.UserDAO;
import zhang.spring.bookstore.entities.Account;
import zhang.spring.bookstore.entities.Book;
import zhang.spring.bookstore.entities.ShoppingCart;
import zhang.spring.bookstore.entities.ShoppingCartItem;
import zhang.spring.bookstore.entities.Trade;
import zhang.spring.bookstore.entities.TradeItem;
import zhang.spring.bookstore.entities.User;
import zhang.spring.bookstore.service.UserService;
import zhang.spring.bookstore.web.BookStoreWebUtils;
import zhang.spring.bookstore.web.CriteriaUser;
import zhang.spring.bookstore.web.Page;
@Service
public class UserServiceimpl implements UserService{

	@Autowired
	private UserDAO userdao=null;
	
	@Autowired
	private BookDAO bookdao=null;
	
	@Autowired
	private AccountDAO accountdao=null;
	
	@Autowired
	private TradeDAO tradedao=null;
	
	@Autowired
	private TradeItemDAO tradeitemdao=null;
	
	@Override
	public User isHave(String username) {
		User user = userdao.getUser(username);
		if(user!=null){
			return user;
		}else{
			return null;
		}
	}

	@Override
	public boolean UsernameIsMatchPassword(User user, String password) {
		if(password.equals(user.getPassword())){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean isHaveAccount(String accountId, String username) {
		//获取用户的账户
		User user = userdao.getUser(username);
		Account useraccount=user.getAccount();
		if(useraccount==null){
			return false;
		}else{	
			if(accountId.trim().equals(useraccount.getAccountId())){
				return true;
			}else {
				return false;
			}
		}
		
	}

	@Override
	public boolean passwordIsRight(String password, User user) {
		if(!password.trim().equals(user.getAccount().getPassword())){
			return false;
		}
		return true;
	}

	@Override
	public String userBalanceIsEn(User user, ShoppingCart shoppingCart) {
		//获取购物车中的所有的图书
		float totalMoney = shoppingCart.getTotalMoney();
		if(user!=null){
			//用户的余额
			float balance = user.getAccount().getBalance();
			System.out.println("balance:"+balance);
			//比较用户的余额,和他搜买的书是否
			if(balance<totalMoney){
				return "对不起,您的余额不足";
			}
		}
		return "";
	}
	
	
	@Override
	public void doPayCash(ShoppingCart shoppingCart, User user,HttpServletRequest request) {
		//用户账户的余额更新
		float totalMoney = shoppingCart.getTotalMoney();
		System.out.println("totalmoney:"+totalMoney);
		accountdao.updateBalance(user.getAccount().getId(), totalMoney);
		//图书的库存减少
		Collection<ShoppingCartItem> items = shoppingCart.getItems();
		bookdao.batchUpdateStoreNumberAndSalesAmount(items);
	
		//向trade表中插入交易记录
		Trade trade=new Trade();
		trade.setTradeTime(new Date());
		trade.setUser(user);
		//保存Trade
		tradedao.insert(trade);
		Set<TradeItem> tradeitems=new HashSet<>();
		for(ShoppingCartItem Cartitem:items){
			TradeItem tradeItem=new TradeItem();
			Book book = Cartitem.getBook();
			int quantity = Cartitem.getQuantity();
			
			tradeItem.setBookId(book.getId());
			tradeItem.setQuantity(quantity);
			tradeItem.setTrade(trade);
			
			tradeitems.add(tradeItem);
		}
		//向tradeitem中插入记录
		tradeitemdao.batchSave(tradeitems);
		//清空购物车
		BookStoreWebUtils.getShoppingCart(request).clear();
	}

	@Override
	public void getUserInfo(HttpServletRequest request) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("User");
		user=userdao.getUser(user.getUsername());
		Set<Trade> trades = tradedao.getTrades(user);
		//装配Trade
		
		for(Trade trade:trades){
			Set<TradeItem> items=new HashSet<>();
			Set<TradeItem> tradeitems = tradeitemdao.getTradeItemsWithTrade(trade);
			for(TradeItem item:tradeitems){
				item.setBook(bookdao.getBook(item.getBookId()));
				items.add(item);
			}
			trade.setItems(items);
		}
		user.setTrades(trades);
		session.setAttribute("User", user);
	}

	@Override
	public String doRegitster(User user) {
		//验证:判断数据表中是否已经存在该用户名
		User exuser = isHave(user.getUsername());
		if(exuser!=null){
			return "该用户名已被占用";
		}
		//设置注册时间
		user.setCreateTime(new Date());
		userdao.saveUser(user);
		return "";
	}

	@Override
	public User doUpdate(User user) {
		User user2 = userdao.doUpdate(user);
		return user2;
	}

	@Override
	public User getUser(String username) {
		User user = userdao.getUser(username);
		return user;
	}

	@Override
	public Page<User> getUsers(CriteriaUser cu) {
		Page<User> page = userdao.getPage(cu);
		return page;
	}

	

	

}
