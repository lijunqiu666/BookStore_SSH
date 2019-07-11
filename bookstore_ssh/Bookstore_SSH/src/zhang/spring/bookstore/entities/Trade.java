package zhang.spring.bookstore.entities;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;
/**
 * 
 * @ClassName:  Trade   
 * @Description:һ�ν���
 * @author: ZhangYuKang
 * @date:   2019��5��25�� ����10:46:42
 */
public class Trade {
	
	//Trade �����Ӧ�� id
	private Integer tradeId;
	
	//���׹�����user
	private User user;
	
	//���׵�ʱ��
	private Date tradeTime;
	
	//Trade �����Ķ�� TradeItem
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

