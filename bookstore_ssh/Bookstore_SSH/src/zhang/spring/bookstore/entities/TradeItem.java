package zhang.spring.bookstore.entities;
/**
 * 
 * @ClassName:  TradeItem   
 * @Description:������
 * @author: ZhangYuKang
 * @date:   2019��5��25�� ����10:46:56
 */
public class TradeItem {

	private Integer tradeItemId;
	
	//�� TradeItem ������ Book
	private Book book;
	
	private int quantity;
	
	//�� TradeItem ������ Book �� bookId
	private Integer bookId;

	private Trade trade;

	public Integer getTradeItemId() {
		return tradeItemId;
	}

	public void setTradeItemId(Integer tradeItemId) {
		this.tradeItemId = tradeItemId;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public Trade getTrade() {
		return trade;
	}

	public void setTrade(Trade trade) {
		this.trade = trade;
	}

	public TradeItem() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "TradeItem [tradeItemId=" + tradeItemId + ", book=" + book + ", quantity=" + quantity + ", bookId="
				+ bookId + ", trade=" + trade + "]";
	}

	
	

}
