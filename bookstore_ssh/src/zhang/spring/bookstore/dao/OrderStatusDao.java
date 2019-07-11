package zhang.spring.bookstore.dao;

import zhang.spring.bookstore.entities.orderStatus;

public interface OrderStatusDao {

	
	/**
	 * 修改订单状态
	 * @param orderStatus
	 */
	public void updateStatus(orderStatus orderStatus);
	/**
	 * 根据id获取orderstatus
	 * @param id
	 * @return
	 */
	public orderStatus getStatusById(Integer id);
	
	
}
