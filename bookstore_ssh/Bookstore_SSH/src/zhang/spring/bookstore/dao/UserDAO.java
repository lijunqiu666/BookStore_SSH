package zhang.spring.bookstore.dao;

import java.util.Date;
import java.util.List;

import zhang.spring.bookstore.entities.User;
import zhang.spring.bookstore.web.CriteriaUser;
/**
 * 
 * @ClassName:  UserDAO   
 * @Description:�û�DAO
 * @author: ZhangYuKang
 * @date:   2019��5��25�� ����10:42:46
 */
import zhang.spring.bookstore.web.Page;
public interface UserDAO {
	
	/**
	 * �����û���Ϣ
	 * 
	 * @param user
	 * @return
	 */
	public User doUpdate(User user);
	
	/**
	 * ��ȡ�û������
	 * 
	 * @param id
	 * @return
	 */
	public float getUserBalance(Integer id);
	/**
	 * ����һ��username,���������д�username������
	 * 
	 * @param usename
	 */
	public long getcount(String username);

	/**
	 * �����û�����ȡ User ����
	 * 
	 * @param username
	 * @return
	 */
	public abstract User getUser(String username);

	
	/**
	 * ����һ��User
	 * 
	 * @param user
	 */
	public abstract void saveUser(User user);
	
	/**
	 * ��ȡ���е�User
	 */
	public List<User> getAllUser();

	/**
	 * ����ָ��ʱ��ע���û��ļ���
	 * 
	 * @param date
	 * @return
	 */
	public List<User> getTodayUser(Date date);

	/**
	 * ����ָ��ʱ��ע���û��ļ���
	 * 
	 * @param date
	 * @return
	 */
	public List<User> getLastUser(Date date);
	
	/**
	 * ����һ������ѯ������Page
	 * 
	 * @param cu
	 * @return
	 */
	public Page<User> getPage(CriteriaUser cu);
	
	/**
	 * ����user��pageList����
	 * 
	 * @param cb
	 * @param pageSize
	 * @return
	 */
	public abstract List<User> getPageList(CriteriaUser cu, int pageSize);
	
	/**
	 * �����û����ܼ�¼��
	 * 
	 * @param cb
	 * @return
	 */
	public abstract long getTotalUserNumber(CriteriaUser cu);
}

