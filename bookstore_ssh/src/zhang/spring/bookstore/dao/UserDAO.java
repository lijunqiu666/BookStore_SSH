package zhang.spring.bookstore.dao;

import java.util.Date;
import java.util.List;

import zhang.spring.bookstore.entities.User;
import zhang.spring.bookstore.web.CriteriaUser;
/**
 * 
 * @ClassName:  UserDAO   
 * @Description:用户DAO
 * @author: ZhangYuKang
 * @date:   2019年5月25日 上午10:42:46
 */
import zhang.spring.bookstore.web.Page;
public interface UserDAO {
	
	/**
	 * 更新用户信息
	 * 
	 * @param user
	 * @return
	 */
	public User doUpdate(User user);
	
	/**
	 * 获取用户的余额
	 * 
	 * @param id
	 * @return
	 */
	public float getUserBalance(Integer id);
	/**
	 * 传入一个username,返回数据中此username的人数
	 * 
	 * @param usename
	 */
	public long getcount(String username);

	/**
	 * 根据用户名获取 User 对象
	 * 
	 * @param username
	 * @return
	 */
	public abstract User getUser(String username);

	
	/**
	 * 保存一个User
	 * 
	 * @param user
	 */
	public abstract void saveUser(User user);
	
	/**
	 * 获取所有的User
	 */
	public List<User> getAllUser();

	/**
	 * 返回指定时间注册用户的集合
	 * 
	 * @param date
	 * @return
	 */
	public List<User> getTodayUser(Date date);

	/**
	 * 返回指定时间注册用户的集合
	 * 
	 * @param date
	 * @return
	 */
	public List<User> getLastUser(Date date);
	
	/**
	 * 返回一个带查询条件的Page
	 * 
	 * @param cu
	 * @return
	 */
	public Page<User> getPage(CriteriaUser cu);
	
	/**
	 * 返回user的pageList集合
	 * 
	 * @param cb
	 * @param pageSize
	 * @return
	 */
	public abstract List<User> getPageList(CriteriaUser cu, int pageSize);
	
	/**
	 * 返回用户的总记录数
	 * 
	 * @param cb
	 * @return
	 */
	public abstract long getTotalUserNumber(CriteriaUser cu);
}

