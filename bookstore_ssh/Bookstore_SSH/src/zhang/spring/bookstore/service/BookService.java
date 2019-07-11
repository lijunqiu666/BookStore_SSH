package zhang.spring.bookstore.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import zhang.spring.bookstore.entities.Book;
import zhang.spring.bookstore.entities.ShoppingCart;
import zhang.spring.bookstore.web.CriteriaBook;
import zhang.spring.bookstore.web.Page;

public interface BookService {

	//根据查询条件返回Page
	public Page<Book> getPage(CriteriaBook cb);
	
	//根据id获取图书
	public Book getBook(Integer id);

	//判断图书的库存是否充足
	public String checkstoreNumberisEn(ShoppingCart shoppingCart);

	//返回热门图书
	public List<Book> getTopBooks(int i);

	//更新图书
	public int updateBook(Book book);

	//删除图书
	public int deleteBook(Book book);

	//上传图书
	public void inertBook(Book book);
	
}
