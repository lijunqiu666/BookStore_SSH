package zhang.spring.bookstore.dao;

import zhang.spring.bookstore.entities.orderStatus;

public interface OrderStatusDao {

	
	/**
	 * �޸Ķ���״̬
	 * @param orderStatus
	 */
	public void updateStatus(orderStatus orderStatus);
	/**
	 * ����id��ȡorderstatus
	 * @param id
	 * @return
	 */
	public orderStatus getStatusById(Integer id);
	
	
}
