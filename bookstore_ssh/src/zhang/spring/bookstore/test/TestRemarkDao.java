package zhang.spring.bookstore.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import zhang.spring.bookstore.dao.RemarkDao;
import zhang.spring.bookstore.entities.Remark;

public class TestRemarkDao {
	private RemarkDao remarkDao=null;
	private ApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");
	{
		remarkDao=ctx.getBean(RemarkDao.class);
	}

	@Test
	public void testgetAllRemarks(){
		List<Remark> allRemarks = remarkDao.getAllRemarks();
		for(Remark remark:allRemarks){
			System.out.println(remark.getManager().getMgrName());
			System.out.println(remark.getContent());
			System.out.println(remark.getCreateTime());
		}
	}
}
