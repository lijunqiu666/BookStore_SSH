package zhang.spring.bookstore.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import zhang.spring.bookstore.entities.ShoppingCart;

/**
 * 
 * @ClassName:  BookStoreWebUtils   
 * @Description:���ﳵ������
 * @author: ZhangYuKang
 * @date:   2019��5��25�� ����10:48:49
 */
public class BookStoreWebUtils {
	
	/**
	 * ��ȡ���ﳵ����: �� session �л�ȡ, �� session ��û�иĶ���.
	 * �򴴽�һ���µĹ��ﳵ����, ���뵽 session ��.
	 * ����, ��ֱ�ӷ���. 
	 * @param request
	 * @return
	 */
	public static ShoppingCart getShoppingCart(HttpServletRequest request){
		HttpSession session = request.getSession();
		
		ShoppingCart sc = (ShoppingCart) session.getAttribute("ShoppingCart");
		if(sc == null){
			sc = new ShoppingCart();
			session.setAttribute("ShoppingCart", sc);
		}
		
		return sc;
	}
	
}
