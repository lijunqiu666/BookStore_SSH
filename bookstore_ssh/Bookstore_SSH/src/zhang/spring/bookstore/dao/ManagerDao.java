package zhang.spring.bookstore.dao;

import zhang.spring.bookstore.entities.Manager;
/**
 * 
 * @ClassName:  ManagerDao   
 * @Description:����ԱDAO
 * @author: ZhangYuKang
 * @date:   2019��5��25�� ����10:41:56
 */
public interface ManagerDao {
	/**
	 * ��ѯ���ݿ���manger�Ƿ����
	 * 
	 * @param managerName
	 */
	public long  getCountbyName(String managerName);
	
	/**
	 * ����������ȡ����Ա
	 * 
	 * @param managerName
	 * @return
	 */
	public Manager getManager(String managerName);
	
	

}
