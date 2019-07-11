package zhang.spring.bookstore.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import zhang.spring.bookstore.dao.AccountDAO;
import zhang.spring.bookstore.dao.UserDAO;
import zhang.spring.bookstore.entities.Account;
import zhang.spring.bookstore.entities.User;

public class TestAccountDaoimp {

	private AccountDAO accountDAO=null;
	private UserDAO userDAO=null;
	private ApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");
	{
		accountDAO=ctx.getBean(AccountDAO.class);		
		userDAO=ctx.getBean(UserDAO.class);
	}
	
	@Test
	public void testupdateBalance(){
		User user = userDAO.getUser("zhangyukang");
		accountDAO.updateBalance(user.getAccount().getId(), 1);
	}
	@Test
	public void testgetuser(){
		User user = userDAO.getUser("zhangyukang");
		System.out.println(user.getAccount());
	}
	@Test
	public void testgetaccount2(){
		Account account = userDAO.getUser("zhangyukang").getAccount();
		System.out.println(account.getBalance());
	}
	@Test
	public void testgetaccount(){
		Account account = accountDAO.getAccount(1);
		System.out.println(account);
	}
}
