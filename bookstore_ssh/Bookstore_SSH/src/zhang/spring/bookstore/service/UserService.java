package zhang.spring.bookstore.service;

import javax.servlet.http.HttpServletRequest;

import zhang.spring.bookstore.entities.ShoppingCart;
import zhang.spring.bookstore.entities.User;
import zhang.spring.bookstore.web.CriteriaUser;
import zhang.spring.bookstore.web.Page;

public interface UserService {
	
	/**
	 * 用户注册
	 * @param user
	 * @return
	 */
	public String doRegitster(User user);
	
	/**
	 * 根据Username判断是否存在对应的user
	 * @param username
	 * @return
	 */
	public User isHave(String username);
	
	/**
	 * 判断用户名和密码是否匹配
	 * @param user
	 * @param password
	 * @return
	 */
	public boolean UsernameIsMatchPassword(User user,String password);

	/**
	 * 判断是否存在该银行卡
	 * @param accountId
	 * @param string
	 * @return
	 */
	public boolean isHaveAccount(String accountId, String string);
	
	/**
	 * 判断是否密码是否正确
	 * @param password
	 * @param user
	 * @return
	 */
	public boolean passwordIsRight(String password, User user);
	

	/**
	 * 判断用户的余额是否足够
	 * @param user
	 * @param shoppingCart
	 * @return
	 */
	public String userBalanceIsEn(User user, ShoppingCart shoppingCart);

	/**
	 * 用户结账
	 * @param shoppingCart
	 * @param user
	 * @param request
	 */
	public void doPayCash(ShoppingCart shoppingCart, User user,HttpServletRequest request);

	/**
	 * 获取用户的详细信息
	 * @param request
	 */
	public void getUserInfo(HttpServletRequest request);

	/**
	 * 更新用户的资料
	 * @param user
	 * @return
	 */
	public User doUpdate(User user);

	/**
	 * 根据用户名获取用户
	 * @param username
	 * @return
	 */
	public User getUser(String username);

	/**
	 * 根据查询条件,获取用户对用的page对象
	 * @param cu
	 * @return
	 */
	public Page<User> getUsers(CriteriaUser cu);

}
