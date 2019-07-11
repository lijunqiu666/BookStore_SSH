package zhang.spring.bookstore.dao;

import java.util.Collection;
import java.util.Set;

import zhang.spring.bookstore.entities.Trade;
import zhang.spring.bookstore.entities.TradeItem;
/**
 * 
 * @ClassName:  TradeItemDAO   
 * @Description:交易项DAO 
 * @author: ZhangYuKang
 * @date:   2019年5月25日 上午10:42:30
 */
public interface TradeItemDAO {

	/**
	 * 批量保存 TradeItem 对象
	 * @param items
	 */
	public abstract void batchSave(Collection<TradeItem> items);

	/**
	 * 根据 trade 获取和其关联的 TradeItem 的集合
	 * @param tradeId
	 * @return
	 */
	public abstract Set<TradeItem> getTradeItemsWithTrade(Trade trade);

}

