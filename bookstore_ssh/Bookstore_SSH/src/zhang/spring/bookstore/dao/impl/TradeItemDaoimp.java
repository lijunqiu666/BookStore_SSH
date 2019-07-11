package zhang.spring.bookstore.dao.impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;

import zhang.spring.bookstore.dao.TradeItemDAO;
import zhang.spring.bookstore.entities.Trade;
import zhang.spring.bookstore.entities.TradeItem;
/**
 * 
 * @ClassName:  TradeItemDaoimp   
 * @Description:TODO 
 * @author: ZhangYuKang
 * @date:   2019年5月25日 上午10:45:09
 */
@Repository
public class TradeItemDaoimp extends BaseDao<TradeItem> implements TradeItemDAO {

	@Override
	public void batchSave(Collection<TradeItem> items) {
		for(TradeItem item:items){
			getSession().save(item);
		}
	}

	@Override
	public Set<TradeItem> getTradeItemsWithTrade(Trade trade) {
		@SuppressWarnings("unchecked")
		List<TradeItem> list = getSession().createQuery("from TradeItem where trade=?").setEntity(0, trade).list();
		return new HashSet<>(list);
	}

}
