package zhang.spring.bookstore.dao;

import zhang.spring.bookstore.entities.Manager;
/**
 * 
 * @ClassName:  ManagerDao   
 * @Description:管理员DAO
 * @author: ZhangYuKang
 * @date:   2019年5月25日 上午10:41:56
 */
public interface ManagerDao {
	/**
	 * 查询数据库中manger是否存在
	 * 
	 * @param managerName
	 */
	public long  getCountbyName(String managerName);
	
	/**
	 * 根据姓名获取管理员
	 * 
	 * @param managerName
	 * @return
	 */
	public Manager getManager(String managerName);
	
	

}
