package zhang.spring.bookstore.dao;

import zhang.spring.bookstore.entities.Account;

public interface AccountDAO {

	/**
	 * 根据 accountId 获取对应的 Account 对象
	 * 
	 * @param accountId
	 * @return
	 */
	public abstract Account getAccount(Integer id);

	/**
	 * 根据传入的 accountId, amount 更新指定账户的余额: 扣除 amount 指定的钱数
	 * 
	 * @param accountId
	 * @param amount
	 */
	public abstract void updateBalance(Integer id, float amount);
	
	/**
	 * 新增一个账户
	 * 
	 * @param account
	 */
	public void saveAccount(Account account);
	
	
}