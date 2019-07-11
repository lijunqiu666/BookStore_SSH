package zhang.spring.bookstore.dao.impl;

import java.io.Serializable;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;

import zhang.spring.bookstore.dao.TradeDAO;
import zhang.spring.bookstore.entities.Trade;
import zhang.spring.bookstore.entities.User;
/**
 * 
 * @ClassName:  TradeDAOimp   
 * @Description:TODO 
 * @author: ZhangYuKang
 * @date:   2019年5月25日 上午10:44:21
 */
@Repository
public class TradeDAOimp extends BaseDao<Trade> implements TradeDAO {

	@Override
	public Integer insert(Trade trade) {
		Integer tradeId = (Integer)getSession().save(trade);
		return tradeId;
	}

	

	@Override
	public Trade getTrade(Integer id) {
		Trade trade = (Trade) getSession().get(Trade.class, id);
		return trade;
	}



	@Override
	public Set<Trade> getTrades(User user) {
		List<Trade> list = getSession().createQuery("from  Trade  where user=?  order by tradeTime desc ").setEntity(0, user).list();
		Set<Trade> trades=new LinkedHashSet(list);
		return trades;
	}

}
