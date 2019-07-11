package zhang.spring.bookstore.dao.impl;

import org.springframework.stereotype.Repository;

import zhang.spring.bookstore.dao.ManagerDao;
import zhang.spring.bookstore.entities.Manager;
/**
 * 
 * @ClassName:  ManagerDaoimp   
 * @Description:TODO 
 * @author: ZhangYuKang
 * @date:   2019年5月25日 上午10:44:12
 * 
 */
@Repository
public class ManagerDaoimp extends BaseDao<Manager> implements ManagerDao {

	@Override
	public long getCountbyName(String managerName) {
		long count = 
				(long) getSession().createQuery("select count(*) from Manager where mgrName=?").setString(0, managerName).uniqueResult();
		return count;
	}

	@Override
	public Manager getManager(String managerName) {
		Manager  manager= 
				(Manager) getSession().createQuery("from Manager where mgrName=?").setString(0, managerName).uniqueResult();
		return manager;
	}


}
