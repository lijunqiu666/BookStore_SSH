package zhang.spring.bookstore.dao;

import java.util.Set;

import zhang.spring.bookstore.entities.Trade;
import zhang.spring.bookstore.entities.User;
/**
 * 
 * @ClassName:  TradeDAO   
 * @Description:交易DAO
 * @author: ZhangYuKang
 * @date:   2019年5月25日 上午10:42:16
 */
public interface TradeDAO {

	
	public Trade getTrade(Integer id);
	
	/**
	 * 向数据表中插入 Trade 对象
	 * 
	 * @param trade
	 */
	public abstract Integer insert(Trade trade);

	/**
	 * 根据 userId 获取和其关联的 Trade 的集合
	 * 
	 * @param userId
	 * @return
	 */
	public abstract Set<Trade> getTrades(User user);

}