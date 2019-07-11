package zhang.spring.bookstore.dao.impl;


import org.springframework.stereotype.Repository;

import zhang.spring.bookstore.dao.OrderStatusDao;
import zhang.spring.bookstore.entities.TradeItem;
import zhang.spring.bookstore.entities.orderStatus;

@Repository
public class OrderStatusDaoImpl extends BaseDao<orderStatus> implements OrderStatusDao{

	

	@Override
	public orderStatus getStatusById(Integer id) {
		orderStatus orderStatus =(orderStatus) getSession().get(orderStatus.class, id);
		return orderStatus;
	}

	@Override
	public void updateStatus(orderStatus orderStatus) {
		getSession().update(orderStatus);
	}

}
