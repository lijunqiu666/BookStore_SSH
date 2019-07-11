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
		//��ȡ�û����˻�
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
		//��ȡ���ﳵ�е����е�ͼ��
		float totalMoney = shoppingCart.getTotalMoney();
		if(user!=null){
			//�û������
			float balance = user.getAccount().getBalance();
			System.out.println("balance:"+balance);
			//�Ƚ��û������,������������Ƿ�
			if(balance<totalMoney){
				return "�Բ���,��������";
			}
		}
		return "";
	}
	
	
	@Override
	public void doPayCash(ShoppingCart shoppingCart, User user,HttpServletRequest request) {
		//�û��˻���������
		float totalMoney = shoppingCart.getTotalMoney();
		System.out.println("totalmoney:"+totalMoney);
		accountdao.updateBalance(user.getAccount().getId(), totalMoney);
		//ͼ��Ŀ�����
		Collection<ShoppingCartItem> items = shoppingCart.getItems();
		bookdao.batchUpdateStoreNumberAndSalesAmount(items);
	
		//��trade���в��뽻�׼�¼
		Trade trade=new Trade();
		trade.setTradeTime(new Date());
		trade.setUser(user);
		//����Trade
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
		//��tradeitem�в����¼
		tradeitemdao.batchSave(tradeitems);
		//��չ��ﳵ
		BookStoreWebUtils.getShoppingCart(request).clear();
	}

	@Override
	public void getUserInfo(HttpServletRequest request) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("User");
		user=userdao.getUser(user.getUsername());
		Set<Trade> trades = tradedao.getTrades(user);
		//װ��Trade
		
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
		//��֤:�ж����ݱ����Ƿ��Ѿ����ڸ��û���
		User exuser = isHave(user.getUsername());
		if(exuser!=null){
			return "���û����ѱ�ռ��";
		}
		//����ע��ʱ��
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
