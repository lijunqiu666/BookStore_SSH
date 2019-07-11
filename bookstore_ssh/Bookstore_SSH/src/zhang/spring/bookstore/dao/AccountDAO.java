package zhang.spring.bookstore.dao;

import zhang.spring.bookstore.entities.Account;

public interface AccountDAO {

	/**
	 * ���� accountId ��ȡ��Ӧ�� Account ����
	 * 
	 * @param accountId
	 * @return
	 */
	public abstract Account getAccount(Integer id);

	/**
	 * ���ݴ���� accountId, amount ����ָ���˻������: �۳� amount ָ����Ǯ��
	 * 
	 * @param accountId
	 * @param amount
	 */
	public abstract void updateBalance(Integer id, float amount);
	
	/**
	 * ����һ���˻�
	 * 
	 * @param account
	 */
	public void saveAccount(Account account);
	
	
}