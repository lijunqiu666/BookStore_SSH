package zhang.spring.bookstore.dao;

import java.util.Collection;
import java.util.List;

import zhang.spring.bookstore.entities.Book;
import zhang.spring.bookstore.entities.ShoppingCartItem;
import zhang.spring.bookstore.web.CriteriaBook;
import zhang.spring.bookstore.web.Page;

public interface BookDAO {

	/**
	 * 获取所有图书
	 * 
	 * @return
	 */
	public List<Book> getAllBooks();

	/**
	 * 根据 id 获取指定 Book 对象
	 * 
	 * @param id
	 * @return
	 */
	public abstract Book getBook(int id);

	/**
	 * 根据传入的 CriteriaBook 对象返回对应的 Page 对象
	 * 
	 * @param cb
	 * @return
	 */
	public abstract Page<Book> getPage(CriteriaBook cb);

	/**
	 * 根据传入的 CriteriaBook 对象返回其对应的记录数
	 * 
	 * @param cb
	 * @return
	 */
	public abstract long getTotalBookNumber(CriteriaBook cb);

	/**
	 * 根据传入的 CriteriaBook 和 pageSize 返回当前页对应的 List
	 * 
	 * @param cb
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public abstract List<Book> getPageList(CriteriaBook cb, int pageSize);

	/**
	 * 返回指定 id 的 book 的 storeNumber 字段的值
	 * 
	 * @param id
	 * @return
	 */
	public abstract int getStoreNumber(Integer id);

	/**
	 * 获取n本书图书中的总销量
	 */
	public long getAllSalesAmount();

	/**
	 * 获取前n本图书
	 * 
	 * @param i
	 * @return
	 */
	public List<Book> getTopBook(int i);

	/**
	 * 插入图书
	 * 
	 * @param book
	 */
	public void InsertBook(Book book);

	/**
	 * 更新图书
	 */
	public void updatebookbyid(Book book);

	/**
	 * 根据id删除图书
	 * 
	 * @param id
	 */
	public void deleteByid(Integer id);

	/**
	 * 根据传入的 ShoppingCartItem 的集合, 批量更新 books 数据表的 storenumber 和 salesnumber
	 * 字段的值
	 * 
	 * @param items
	 */
	public abstract void batchUpdateStoreNumberAndSalesAmount(Collection<ShoppingCartItem> items);

}