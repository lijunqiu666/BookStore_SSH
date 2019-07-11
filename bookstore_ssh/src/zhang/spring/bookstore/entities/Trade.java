package zhang.spring.bookstore.entities;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;
/**
 * 
 * @ClassName:  Trade   
 * @Description:一次交易
 * @author: ZhangYuKang
 * @date:   2019年5月25日 上午10:46:42
 */
public class Trade {
	
	//Trade 对象对应的 id
	private Integer tradeId;
	
	//交易关联的user
	private User user;
	
	//交易的时间
	private Date tradeTime;
	
	//Trade 关联的多个 TradeItem
	private Set<TradeItem> items = new LinkedHashSet<TradeItem>();

	public Integer getTradeId() {
		return tradeId;
	}

	public void setTradeId(Integer tradeId) {
		this.tradeId = tradeId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getTradeTime() {
		return tradeTime;
	}

	public void setTradeTime(Date tradeTime) {
		this.tradeTime = tradeTime;
	}

	public Set<TradeItem> getItems() {
		return items;
	}

	public void setItems(Set<TradeItem> items) {
		this.items = items;
	}
	
	public Trade() {

	}

	@Override
	public String toString() {
		return "Trade [tradeId=" + tradeId + ", tradeTime=" + tradeTime + "]";
	}

	
	
	
}

