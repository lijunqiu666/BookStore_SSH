package zhang.spring.bookstore.dao;

import java.util.Collection;
import java.util.Set;

import zhang.spring.bookstore.entities.Trade;
import zhang.spring.bookstore.entities.TradeItem;
import zhang.spring.bookstore.entities.orderStatus;
/**
 * 
 * @ClassName:  TradeItemDAO   
 * @Description:������DAO 
 * @author: ZhangYuKang
 * @date:   2019��5��25�� ����10:42:30
 */
public interface TradeItemDAO {

	/**
	 * ���ö�����״̬
	 * @param status
	 */
	public void setStatus(Integer itemid,Integer statusid);
	/**
	 * �������� TradeItem ����
	 * @param items
	 */
	public abstract void batchSave(Collection<TradeItem> items);

	/**
	 * ���� trade ��ȡ��������� TradeItem �ļ���
	 * @param tradeId
	 * @return
	 */
	public abstract Set<TradeItem> getTradeItemsWithTrade(Trade trade);
	
	/**
	 * ��ȡ��������
	 * @param tradeitemid
	 */
	public TradeItem getTradeItem(Integer tradeitemid);

}

