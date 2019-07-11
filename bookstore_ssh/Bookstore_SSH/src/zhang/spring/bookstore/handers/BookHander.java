package zhang.spring.bookstore.handers;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import zhang.spring.bookstore.entities.Book;
import zhang.spring.bookstore.entities.ShoppingCart;
import zhang.spring.bookstore.service.BookService;
import zhang.spring.bookstore.web.BookStoreWebUtils;
import zhang.spring.bookstore.web.CriteriaBook;
import zhang.spring.bookstore.web.Page;

@Controller
public class BookHander {
	private static final String Books = "books";

	@Autowired
	private BookService bookService = null;

	/**
	 * �޸Ĺ��ﳵ�й����������
	 * @param id
	 * @param number
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/updateitem", method = RequestMethod.POST)
	public Map<String, Object> updateItemQuantity(@RequestParam("id") Integer id,
			@RequestParam("number") Integer number, HttpServletRequest request) {
		BookStoreWebUtils.getShoppingCart(request).updateItemQuantity(id, number);
		Map<String, Object> map = new HashMap<>();
		// ��ȡ���º�Ĺ��ﳵ
		float totalMoney = BookStoreWebUtils.getShoppingCart(request).getTotalMoney();
		int bookNumber = BookStoreWebUtils.getShoppingCart(request).getBookNumber();
		map.put("totalMoney", totalMoney);
		map.put("bookNumber", bookNumber);

		return map;
	}

	/**
	 * ɾ�����ﳵ�еĹ�����
	 * @return
	 */
	@RequestMapping(value = "/deleteitem", method = RequestMethod.GET)
	public String deleteShoppingCartItem(@RequestParam("id") Integer id, HttpServletRequest request) {
		BookStoreWebUtils.getShoppingCart(request).removeItem(id);
		return "forward:/getcartinfo";
	}
	/**
	 * ��չ��ﳵ
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/cleancart", method = RequestMethod.GET)
	public String cleanCart(HttpServletRequest request) {
		BookStoreWebUtils.getShoppingCart(request).clear();
		return "forward:/getcartinfo";
	}
	/**
	 * �鿴���ﳵ
	 * @param map
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/getcartinfo", method = RequestMethod.GET)
	public String getCartInfo(Map<String, Object> map, HttpServletRequest request) {
		map.put("Cart", BookStoreWebUtils.getShoppingCart(request));
		return "shoppingcart";
	}

	/**
	 * ���빺�ﳵ
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/addtocart", method = RequestMethod.GET)
	public String addtoCart(HttpServletRequest request, @RequestParam("id") Integer id) {
		Book book = bookService.getBook(id);
		BookStoreWebUtils.getShoppingCart(request).addBook(book);
		ShoppingCart shoppingCart = BookStoreWebUtils.getShoppingCart(request);
		return "forward:/getbooks";
	}

	/**
	 * �鿴ͼ�����ϸ��Ϣ
	 * @return
	 */
	@RequestMapping(value = "/getbookinfo", method = RequestMethod.GET)
	public String getBookInfo(@RequestParam("id") Integer id, Map<String, Object> map) {
		Book book = bookService.getBook(id);
		map.put("book", book);
		return "bookinfo";
	}
	/**
	 * ����ͼ��ҳ��
	 * @param minprice
	 * @param maxprice
	 * @param pagenumber
	 * @param map
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/getpage",method=RequestMethod.GET)
	public Page<Book> getPage(@RequestParam(value = "minprice", defaultValue = "0") Integer minprice,
			@RequestParam(value = "maxprice", defaultValue = "10000") Integer maxprice,
			@RequestParam(value = "pagenumber", defaultValue = "1") Integer pagenumber, Map<String, Object> map,
			HttpServletRequest request){
		String keyword = request.getParameter("keyword");
		// ��װ��ѯ����
		CriteriaBook cb = new CriteriaBook(minprice, maxprice, keyword, pagenumber);
		Page<Book> page = bookService.getPage(cb);
		return page;
	}
	
	/**
	 * ����ǰ�˴������Ĳ�ѯ��������Page
	 * @param map
	 * @return:����һ��Page����,����Jackson
	 */
	@RequestMapping(value = "/getbooks")
	public String getBooks(@RequestParam(value = "minprice", defaultValue = "0") Integer minprice,
			@RequestParam(value = "maxprice", defaultValue = "10000") Integer maxprice,
			@RequestParam(value = "pagenumber", defaultValue = "1") Integer pagenumber, Map<String, Object> map,
			HttpServletRequest request) {

		String keyword = request.getParameter("keyword");
		// ��װ��ѯ����
		CriteriaBook cb = new CriteriaBook(minprice, maxprice, keyword, pagenumber);
		Page<Book> page = bookService.getPage(cb);
		map.put("page", page);
		return Books;
	}

	/**
	 * �쳣������
	 * @return
	 */
	@ExceptionHandler(value = RuntimeException.class)
	public String HanderException() {
		return "redirect:/error.jsp";
	}
}
