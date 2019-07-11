package zhang.spring.bookstore.test;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import zhang.spring.bookstore.dao.BookDAO;
import zhang.spring.bookstore.entities.Book;
import zhang.spring.bookstore.entities.ShoppingCartItem;
import zhang.spring.bookstore.service.BookService;
import zhang.spring.bookstore.web.CriteriaBook;
import zhang.spring.bookstore.web.Page;

public class Testbookdao {
	private ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
	private BookDAO bookDAO = null;
	private BookService bookService = null;
	{
		bookDAO = ctx.getBean(BookDAO.class);
		bookService = ctx.getBean(BookService.class);
	}
	@Test
	public void testgetAllSalesAmount(){
		long allSalesAmount = bookDAO.getAllSalesAmount();
		System.out.println(allSalesAmount);
	}
	@Test
	public void insertimg(){
		  // This is the path where the file's name you want to take.
        String path = "E://Uploadfiles//spring_bookstore//img";
        List<String> imgs = getFile(path);
	}
	//获取文件夹中的所有的img的文件名
	private static List<String> getFile(String path) {
        // get file list where the path has
		List<String> imgs=new ArrayList<>();
        File file = new File(path);
        // get the folder list
        File[] array = file.listFiles();

        for (int i = 0; i < array.length; i++) {
            if (array[i].isFile()) {
                //System.out.println(array[i].getName());
                imgs.add(array[i].getName());
            } else if (array[i].isDirectory()) {
                getFile(array[i].getPath());
            }
        }
        return imgs;
    }
	@Test
	public void testgetallbooks(){
		 String path = "E://Uploadfiles//spring_bookstore//img";
		Book book=new Book();
		List<String> imgs = getFile(path);
		char i='a';
		for(String img:imgs){
			
			book.setAuthor("author"+i+""+i+"");
			book.setTitle("java"+i);
			book.setPrice(100);
			book.setPublishingDate(new Date());
			book.setSalesAmount(0);
			book.setStoreNumber(100);
			book.setRemark("0");
			book.setImgpath(img);
			bookService.inertBook(book);
			i++;
		}
	}
	@Test
	public void testgettopbooks(){
		List<Book> topBooks = bookService.getTopBooks(5);
		System.out.println(topBooks);
	}
	//更新图书的库存和销量
	@Test
	public void testbatchUpdateStoreNumberAndSalesAmount(){
		Collection<ShoppingCartItem> shoppingCartItems=new ArrayList<>();
		ShoppingCartItem shoppingCartItem=new ShoppingCartItem(bookDAO.getBook(1));
		ShoppingCartItem shoppingCartItem2=new ShoppingCartItem(bookDAO.getBook(2));
		shoppingCartItems.add(shoppingCartItem);
		shoppingCartItems.add(shoppingCartItem2);
		//更新
		
		bookDAO.batchUpdateStoreNumberAndSalesAmount(shoppingCartItems);
	}
	@Test
	public void testgetpage2() {
		CriteriaBook cb = new CriteriaBook(0, Integer.MAX_VALUE, null, 1);
		Page<Book> page = bookService.getPage(cb);
		System.out.println(page.getList());
	}

	@Test
	public void testbookservicegetpage() {
		CriteriaBook cb = new CriteriaBook(0, Integer.MAX_VALUE, null, 1);
		Page<Book> page = bookService.getPage(cb);
		System.out.println(page.getList());
	}

	@Test
	public void testbookservice() {
		Book book = bookService.getBook(2);
		System.out.println(book);
	}

	// Book
	@Test
	public void testgetpage() {
		CriteriaBook cb = new CriteriaBook(0, Integer.MAX_VALUE, 100);
		Page<Book> page = bookDAO.getPage(cb);
		System.out.println("pageno:" + page.getPageNo());
		System.out.println("pagesize:" + page.getPageSize());
		System.out.println(page.getPrevPage());
		System.out.println(page.getList());
		System.out.println(page.getNextPage());
	}

	@Test
	public void testgetTotalBookNumber() {
		CriteriaBook cb = new CriteriaBook(0, Integer.MAX_VALUE, "Peter", 1);
		long count = bookDAO.getTotalBookNumber(cb);
		System.out.println(count);
	}

	@Test
	public void testgetpagelist() {
		CriteriaBook cb = new CriteriaBook(0, Integer.MAX_VALUE, null, 1);
		List<Book> pageList = bookDAO.getPageList(cb, 3);
		System.out.println(pageList);
	}

	@Test
	public void testupdate() {
		Book book = bookDAO.getBook(2);
		book.setTitle("Peter");
		bookDAO.updatebookbyid(book);
	}

	@Test
	public void testdeletebook() {
		bookDAO.deleteByid(1);
	}

	@Test
	public void testsavebooks() {
		Book book=new Book();
		for(int i=0;i<30;i++){
			book.setAuthor("author"+i);
			book.setTitle("java"+i);
			book.setPrice(100);
			book.setPublishingDate(new Date());
			book.setSalesAmount(0);
			book.setStoreNumber(100);
			book.setRemark("0");
			book.setImgpath("1559540983564.jpg");
			bookService.inertBook(book);
		}
	}

	@Test
	public void testgetbookbyid() {
		Book book = bookDAO.getBook(2);
		System.out.println(book);
	}

	@Test
	public void testbookdao() {
		List<Book> books = bookDAO.getAllBooks();
		System.out.println(books);
	}

}
