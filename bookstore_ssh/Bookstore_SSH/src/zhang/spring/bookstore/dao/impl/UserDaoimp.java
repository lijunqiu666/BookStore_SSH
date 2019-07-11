package zhang.spring.bookstore.dao.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import zhang.spring.bookstore.dao.UserDAO;
import zhang.spring.bookstore.entities.Book;
import zhang.spring.bookstore.entities.User;
import zhang.spring.bookstore.web.CriteriaBook;
import zhang.spring.bookstore.web.CriteriaUser;
import zhang.spring.bookstore.web.Page;
/**
 * 
 * @ClassName:  UserDaoimp   
 * @Description:TODO 
 * @author: ZhangYuKang
 * @date:   2019年5月25日 上午10:44:28
 */
@Repository
public class UserDaoimp extends BaseDao<User> implements UserDAO {

	@Override
	public long getcount(String username) {
		long count = 
				(long) getSession().createQuery("from User where username=?").setString(0, username).uniqueResult();
		return count;
	}

	@Override
	public User getUser(String username) {
		User user = 
				(User) getSession().createQuery("from User where username=?").setString(0, username).uniqueResult();
		return user;
	}

	@Override
	public void saveUser(User user) {
		getSession().save(user);
	}

	@Override
	public List<User> getAllUser() {
		List<User> users = getSession().createQuery("from User").list();
		return users;
	}

	@Override
	public float getUserBalance(Integer id) {
		float balance = get(id).getAccount().getBalance();
		return balance;
	}

	@Override
	public User doUpdate(User user) {
		try {
			getSession().saveOrUpdate(user);
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		User user2 = (User) getSession().get(User.class, user.getId());
		
		return user2;
	}

	@Override
	public List<User> getLastUser(Date date) {
		
		//Calendar calendar =new GregorianCalendar();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(calendar.DATE, -1);
		Date  lastdate = calendar.getTime();
		
		List<User> users = getSession().createQuery("from User where createTime< ? and createTime>=?")
				.setDate(0, date).setDate(1, lastdate).list();
		return users;
	}

	@Override
	public List<User> getTodayUser(Date date) {
		List<User> users = getSession().createQuery("from User where createTime=?")
				.setDate(0, date).list();
		return users;
	}

	@Override
	public Page<User> getPage(CriteriaUser cu) {
		
		Page<User> page = new Page<>(cu.getPageNo());

		// 总共有多少条记录
		page.setTotalItemNumber(getTotalUserNumber(cu));
		// 页面上的list<Book>
		cu.setPageNo(page.getPageNo());
		page.setList(getPageList(cu, 10));
		return page;
	}

	

	@Override
	public List<User> getPageList(CriteriaUser cu, int pageSize) {
		Criteria criteria = getSession().createCriteria(User.class);
		@SuppressWarnings("unchecked")
		List<User> users = criteria.add(Restrictions.like("username", cu.getUsername(), MatchMode.ANYWHERE))
				.setFirstResult((cu.getPageNo() - 1) * pageSize).setMaxResults(pageSize).list();
		return users;
	}

	@Override
	public long getTotalUserNumber(CriteriaUser cu) {
		Criteria criteria=getSession().createCriteria(User.class);
		@SuppressWarnings("unchecked")
		List<Book> books = criteria.add(Restrictions.like("username",cu.getUsername(), MatchMode.ANYWHERE)).list();
		return books.size();
	}


}
