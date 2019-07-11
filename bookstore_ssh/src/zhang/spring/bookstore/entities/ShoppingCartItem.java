package zhang.spring.bookstore.entities;
/**
 * 
 * @ClassName:  ShoppingCartItem   
 * @Description:购物项 
 * @author: ZhangYuKang
 * @date:   2019年5月25日 上午10:46:31
 */
public class ShoppingCartItem {

	private Book book;
	private int quantity;
	

	public ShoppingCartItem(Book book) {
		this.book = book;
		this.quantity = 1;
	}
	
	public Book getBook() {
		return book;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	/**
	 * 返回该商品在购物车中的钱数
	 * @return
	 */
	public float getItemMoney(){
		return book.getPrice() * quantity;
	}
	
	/**
	 * 使商品数量 + 1
	 */
	public void increment(){
		quantity++;
	}

	@Override
	public String toString() {
		return "ShoppingCartItem [book=" + book + ", quantity=" + quantity + "]";
	}
	
	
	
}
