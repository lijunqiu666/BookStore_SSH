package zhang.spring.bookstore.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import zhang.spring.bookstore.dao.ManagerDao;
import zhang.spring.bookstore.entities.Manager;

public class TestManager {
	private ApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");
	private ManagerDao managerDao=null;
	{
		managerDao=ctx.getBean(ManagerDao.class);
	}
	@Test
	public void testgetmanagercount(){
		long countbyName = managerDao.getCountbyName("zhangyukang");
		System.out.println(countbyName);
	}
	
	@Test
	public void testmanager(){
		Manager manager = managerDao.getManager("zhangyukang");
		System.out.println(manager);
	}
}
