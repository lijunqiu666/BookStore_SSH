package zhang.spring.bookstore.entities;
/**
 * 
 * @ClassName:  ShoppingCartItem   
 * @Description:������ 
 * @author: ZhangYuKang
 * @date:   2019��5��25�� ����10:46:31
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
	 * ���ظ���Ʒ�ڹ��ﳵ�е�Ǯ��
	 * @return
	 */
	public float getItemMoney(){
		return book.getPrice() * quantity;
	}
	
	/**
	 * ʹ��Ʒ���� + 1
	 */
	public void increment(){
		quantity++;
	}

	@Override
	public String toString() {
		return "ShoppingCartItem [book=" + book + ", quantity=" + quantity + "]";
	}
	
	
	
}
