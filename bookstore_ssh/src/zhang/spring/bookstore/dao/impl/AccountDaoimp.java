package zhang.spring.bookstore.dao.impl;

import org.springframework.stereotype.Repository;

import zhang.spring.bookstore.dao.AccountDAO;
import zhang.spring.bookstore.entities.Account;
import zhang.spring.bookstore.entities.User;
/**
 * 
 * @ClassName:  AccountDaoimp   
 * @Description:TODO 
 * @author: ZhangYuKang
 * @date:   2019年5月25日 上午10:45:27
 */
@Repository
public class AccountDaoimp extends BaseDao<Account> implements AccountDAO {

	@Override
	public void updateBalance(Integer id, float amount) {
		getSession().createQuery("update Account set balance=balance-? where id=?").setFloat(0, amount)
					.setInteger(1, id).executeUpdate();
	}

	@Override
	public Account getAccount(Integer id) {
		Account account = (Account) getSession().get(Account.class,id );
		return account;
	}

	@Override
	public void saveAccount(Account account) {
		getSession().save(account);
		
	}

}
