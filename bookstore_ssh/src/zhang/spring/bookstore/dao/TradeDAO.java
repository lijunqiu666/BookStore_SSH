package zhang.spring.bookstore.dao;

import java.util.Set;

import zhang.spring.bookstore.entities.Trade;
import zhang.spring.bookstore.entities.User;
/**
 * 
 * @ClassName:  TradeDAO   
 * @Description:����DAO
 * @author: ZhangYuKang
 * @date:   2019��5��25�� ����10:42:16
 */
public interface TradeDAO {

	
	public Trade getTrade(Integer id);
	
	/**
	 * �����ݱ��в��� Trade ����
	 * 
	 * @param trade
	 */
	public abstract Integer insert(Trade trade);

	/**
	 * ���� userId ��ȡ��������� Trade �ļ���
	 * 
	 * @param userId
	 * @return
	 */
	public abstract Set<Trade> getTrades(User user);

}