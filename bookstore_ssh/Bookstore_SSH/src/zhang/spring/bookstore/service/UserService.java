package zhang.spring.bookstore.service;

import javax.servlet.http.HttpServletRequest;

import zhang.spring.bookstore.entities.ShoppingCart;
import zhang.spring.bookstore.entities.User;
import zhang.spring.bookstore.web.CriteriaUser;
import zhang.spring.bookstore.web.Page;

public interface UserService {
	
	/**
	 * �û�ע��
	 * @param user
	 * @return
	 */
	public String doRegitster(User user);
	
	/**
	 * ����Username�ж��Ƿ���ڶ�Ӧ��user
	 * @param username
	 * @return
	 */
	public User isHave(String username);
	
	/**
	 * �ж��û����������Ƿ�ƥ��
	 * @param user
	 * @param password
	 * @return
	 */
	public boolean UsernameIsMatchPassword(User user,String password);

	/**
	 * �ж��Ƿ���ڸ����п�
	 * @param accountId
	 * @param string
	 * @return
	 */
	public boolean isHaveAccount(String accountId, String string);
	
	/**
	 * �ж��Ƿ������Ƿ���ȷ
	 * @param password
	 * @param user
	 * @return
	 */
	public boolean passwordIsRight(String password, User user);
	

	/**
	 * �ж��û�������Ƿ��㹻
	 * @param user
	 * @param shoppingCart
	 * @return
	 */
	public String userBalanceIsEn(User user, ShoppingCart shoppingCart);

	/**
	 * �û�����
	 * @param shoppingCart
	 * @param user
	 * @param request
	 */
	public void doPayCash(ShoppingCart shoppingCart, User user,HttpServletRequest request);

	/**
	 * ��ȡ�û�����ϸ��Ϣ
	 * @param request
	 */
	public void getUserInfo(HttpServletRequest request);

	/**
	 * �����û�������
	 * @param user
	 * @return
	 */
	public User doUpdate(User user);

	/**
	 * �����û�����ȡ�û�
	 * @param username
	 * @return
	 */
	public User getUser(String username);

	/**
	 * ���ݲ�ѯ����,��ȡ�û����õ�page����
	 * @param cu
	 * @return
	 */
	public Page<User> getUsers(CriteriaUser cu);

}
