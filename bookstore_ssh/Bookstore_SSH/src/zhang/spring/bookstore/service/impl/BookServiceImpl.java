package zhang.spring.bookstore.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import zhang.spring.bookstore.dao.BookDAO;
import zhang.spring.bookstore.entities.Book;
import zhang.spring.bookstore.entities.ShoppingCart;
import zhang.spring.bookstore.entities.ShoppingCartItem;
import zhang.spring.bookstore.service.BookService;
import zhang.spring.bookstore.web.CriteriaBook;
import zhang.spring.bookstore.web.Page;
@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDAO bookdao=null;
	
	@Override
	public Page<Book> getPage(CriteriaBook cb) {
		return bookdao.getPage(cb);
	}

	@Override
	public Book getBook(Integer id) {
		return bookdao.getBook(id);
	}

	@Override
	public String checkstoreNumberisEn(ShoppingCart shoppingCart) {
		
		Collection<ShoppingCartItem> items = shoppingCart.getItems();
		for (ShoppingCartItem item : items) {
			int quantity = item.getQuantity();
			Integer id = item.getBook().getId();
			int storeNumber = bookdao.getBook(id).getStoreNumber();
			String title = bookdao.getBook(id).getTitle();
			if (quantity > storeNumber) {
				return title+"µÄ¿â´æ²»×ã";
			}
		}
		return "";
	}

	@Override
	public List<Book> getTopBooks(int i) {
		List<Book> topBook = bookdao.getTopBook(i);
		return topBook;
	}

	@Override
	public int updateBook(Book book) {
		try {
			bookdao.updatebookbyid(book);			
		} catch (Exception e) {
			return 0;
		}
		
		return 1;
	}

	@Override
	public int deleteBook(Book book) {
		try {
			bookdao.deleteByid(book.getId());			
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		return 1;
	}

	@Override
	public void inertBook(Book book) {
		bookdao.InsertBook(book);
	}

}
