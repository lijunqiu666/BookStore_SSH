package zhang.spring.bookstore.test;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import zhang.spring.bookstore.dao.AccountDAO;
import zhang.spring.bookstore.dao.TradeDAO;
import zhang.spring.bookstore.dao.TradeItemDAO;
import zhang.spring.bookstore.dao.UserDAO;
import zhang.spring.bookstore.entities.Account;
import zhang.spring.bookstore.entities.Trade;
import zhang.spring.bookstore.entities.User;
import zhang.spring.bookstore.service.ManagerService;
import zhang.spring.bookstore.service.UserService;
import zhang.spring.bookstore.web.CriteriaUser;
import zhang.spring.bookstore.web.Page;

public class TestUserdao {
	private TradeItemDAO tradeItemDAO=null;
	private TradeDAO tradeDAO=null;
	private UserDAO userDAO=null;
	private ManagerService managerService=null;
	private AccountDAO accountDAO=null;
	private ApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");
	{
		userDAO=ctx.getBean(UserDAO.class);
		tradeDAO=ctx.getBean(TradeDAO.class);
		tradeItemDAO=ctx.getBean(TradeItemDAO.class);
		managerService=ctx.getBean(ManagerService.class);
		accountDAO=ctx.getBean(AccountDAO.class);
	}
	@Test
	public void testsaveacocuntwithuser(){
		for(int i=0;i<100;i++){
			User user=new User();
			user.setUsername("zhangyukang"+i);
			user.setBirth(new Date());
			user.setAddress("beijing"+i+"street");
			user.setCreateTime(new Date());
			user.setPassword("123456");
			user.setSex("男");
			user.setEmail("zyk@qq.com");
			user.setPhonenumber("3053161401");
			Account account=new Account();
			account.setBalance(100);
			account.setPassword("123456");
			account.setCreateTime(new Date());
			account.setAccountId("305316");
			account.setUser(user);
			user.setAccount(account);
			accountDAO.saveAccount(account);
			userDAO.saveUser(user);
		}
		
	}
	@Test
	public void testsaveuser(){
		
		for(int i=0;i<10;i++){
			User user=new User();
			user.setUsername("zhangyukang"+i);
			Account account=new Account();
			account.setBalance(100+i);
			account.setCreateTime(new Date());
			account.setPassword("123456");
			user.setAccount(account);
			//accountDAO.saveAccount(account);
			userDAO.saveUser(user);;
			
		}
	}
	@Test
	public void testgetuserpage(){
		CriteriaUser  cu=new CriteriaUser();
		cu.setPageNo(2);
		//cu.setUsername("12");
		Page<User> page = userDAO.getPage(cu);
		System.out.println(page.getList());
		System.out.println("当前第:"+page.getPageNo());
		System.out.println("上一页:"+page.getPrevPage());
		System.out.println("下一页:"+page.getNextPage());
		System.out.println("总共:"+page.getTotalItemNumber());
	}
	
	@Test
	public void testgetTodayUser(){
		List<User> todayUsers = managerService.getTodayUsers(new Date());
		System.out.println(todayUsers);
	}
	@Test
	public void testgetgetLastUser(){
		List<User> todayUsers = managerService.getLastDayUsers(new Date());
		System.out.println(todayUsers);
	}
	@Test
	public void testgetuser2(){
		User user = userDAO.getUser("zhangyukang");
		Date createTime = user.getCreateTime();
		System.out.println(createTime);
	}
	@Test
	public void testgetusr(){
		User user = userDAO.getUser("zhangyukang");
		System.out.println(user);
		Account account = user.getAccount();
		System.out.println(account);
	}
	@Test
	public void testgetuseraccount(){
		User user = userDAO.getUser("zhangyukang");
		Account account = user.getAccount();
		
	}
	@Test
	public void testgetuserbyusername(){
		User user = userDAO.getUser("zhangyukang");
		System.out.println(user.getUsername());
	}
	@Test
	public void testgetuser(){
		User user = userDAO.getUser("zhangyukang");
		System.out.println(user);
		String accountId = user.getAccount().getAccountId();
		System.out.println(accountId);
	}
	//获取用户的余额
	@Test
	public void testgetusrbalance(){
		User user = userDAO.getUser("justinbieber");
		System.out.println(user.getAccount().getBalance());
		float balance = user.getAccount().getBalance();
		System.out.println(balance);
	}
	@Test
	public void testgettrade(){
		
	}
	@Test
	public void testaccount(){
		//创建一个账户,余额有100
		//User user=new User("peter3", 12, "女", "北京", "fdsaf@163.com", new Date(), "123456", null);
		//Account account=new Account("111111",100, "123456", new Date());
		//创建一个用户
		//user.setAccount(account);
		//account.setUser(user);
		//userDAO.saveUser(user);
		
	}
	@Test
	public void testaccountdao(){
		
	}
	@Test
	public void testgetuserbalance(){
		float userBalance = userDAO.getUserBalance(1);
		System.out.println(userBalance);
	}
	@Test
	public void testGetcount() {
		List<User> users = userDAO.getAllUser();
		System.out.println(users);
	}

	@Test
	public void testGetUser() {
		User user = userDAO.getUser("zhangyukang");
		System.out.println(user);
	}

	
	@Test
	public void testGetAllUser() {
		List<User> users = userDAO.getAllUser();
		System.out.println(users);
	}

}
