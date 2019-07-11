package zhang.spring.bookstore.dao.impl;

import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import zhang.spring.bookstore.dao.BookDAO;
import zhang.spring.bookstore.dbutils.ReflectionUtils;
import zhang.spring.bookstore.entities.Book;
import zhang.spring.bookstore.entities.ShoppingCartItem;
import zhang.spring.bookstore.web.CriteriaBook;
import zhang.spring.bookstore.web.Page;

/**
 * 
 * @ClassName: BookDaoimp
 * @Description:实现BookDao
 * @author: ZhangYuKang
 * @date: 2019年5月25日 上午10:43:53
 */
@Repository
public class BookDaoimp extends BaseDao<Book> implements BookDAO {

	@Override
	public List<Book> getAllBooks() {
		@SuppressWarnings("unchecked")
		List<Book> books = getSession().createQuery("from Book").list();
		return books;
	}

	@Override
	public Book getBook(int id) {
		Book book = (Book) getSession().createQuery("from Book where id=?").setInteger(0, id).uniqueResult();
		return book;
	}

	@Override
	public Page<Book> getPage(CriteriaBook cb) {
		Page<Book> page = new Page<>(cb.getPageNo());

		// 总共有多少条记录
		page.setTotalItemNumber(getTotalBookNumber(cb));
		// 页面上的list<Book>
		cb.setPageNo(page.getPageNo());
		page.setList(getPageList(cb, 12));

		return page;
	}

	@Override
	public long getTotalBookNumber(CriteriaBook cb) {
		Criteria criteria = getSession().createCriteria(Book.class);
		@SuppressWarnings("unchecked")
		List<Book> books = criteria.add(Restrictions.ge("price", cb.getMinPrice()))
				.add(Restrictions.lt("price", cb.getMaxPrice()))
				.add(Restrictions.like("title", cb.getKeyWord(), MatchMode.ANYWHERE)).list();
		return books.size();
	}

	@Override
	public List<Book> getPageList(CriteriaBook cb, int pageSize) {
		Criteria criteria = getSession().createCriteria(Book.class);
		@SuppressWarnings("unchecked")
		List<Book> books = criteria.add(Restrictions.ge("price", cb.getMinPrice()))
				.add(Restrictions.lt("price", cb.getMaxPrice()))
				.add(Restrictions.like("title", cb.getKeyWord(), MatchMode.ANYWHERE))
				.setFirstResult((cb.getPageNo() - 1) * pageSize).setMaxResults(pageSize).list();
		return books;
	}

	@Override
	public int getStoreNumber(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getAllSalesAmount() {

		return 0;
	}

	@Override
	public List<Book> getTopBook(int i) {
		@SuppressWarnings("unchecked")
		List<Book> hotbooks = getSession().createQuery("from Book order by salesAmount desc").setFirstResult(0)
				.setMaxResults(i).list();
		return hotbooks;
	}

	@Override
	public void InsertBook(Book book) {
		getSession().save(book);
	}

	@Override
	public void updatebookbyid(Book book) {
		getSession().update(book);
	}

	@Override
	public void deleteByid(Integer id) {
		getSession().createQuery("delete from Book where id=?").setInteger(0, id).executeUpdate();
	}

	@Override
	public void batchUpdateStoreNumberAndSalesAmount(Collection<ShoppingCartItem> items) {
		for (ShoppingCartItem shoppingCartItem : items) {
			Integer id = shoppingCartItem.getBook().getId();
			// 1.图书库存
			// 2.图书的销量增加
			int quantity = shoppingCartItem.getQuantity();
			getSession().createQuery("update Book set storeNumber=storeNumber-?, salesAmount=salesAmount+? where id=?")
					.setInteger(0, quantity).setInteger(1, quantity).setInteger(2, id).executeUpdate();

		}
	}

}
