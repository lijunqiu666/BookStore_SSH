package zhang.spring.bookstore.dao;

import java.util.Collection;
import java.util.List;

import zhang.spring.bookstore.entities.Book;
import zhang.spring.bookstore.entities.ShoppingCartItem;
import zhang.spring.bookstore.web.CriteriaBook;
import zhang.spring.bookstore.web.Page;

public interface BookDAO {

	/**
	 * ��ȡ����ͼ��
	 * 
	 * @return
	 */
	public List<Book> getAllBooks();

	/**
	 * ���� id ��ȡָ�� Book ����
	 * 
	 * @param id
	 * @return
	 */
	public abstract Book getBook(int id);

	/**
	 * ���ݴ���� CriteriaBook ���󷵻ض�Ӧ�� Page ����
	 * 
	 * @param cb
	 * @return
	 */
	public abstract Page<Book> getPage(CriteriaBook cb);

	/**
	 * ���ݴ���� CriteriaBook ���󷵻����Ӧ�ļ�¼��
	 * 
	 * @param cb
	 * @return
	 */
	public abstract long getTotalBookNumber(CriteriaBook cb);

	/**
	 * ���ݴ���� CriteriaBook �� pageSize ���ص�ǰҳ��Ӧ�� List
	 * 
	 * @param cb
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public abstract List<Book> getPageList(CriteriaBook cb, int pageSize);

	/**
	 * ����ָ�� id �� book �� storeNumber �ֶε�ֵ
	 * 
	 * @param id
	 * @return
	 */
	public abstract int getStoreNumber(Integer id);

	/**
	 * ��ȡn����ͼ���е�������
	 */
	public long getAllSalesAmount();

	/**
	 * ��ȡǰn��ͼ��
	 * 
	 * @param i
	 * @return
	 */
	public List<Book> getTopBook(int i);

	/**
	 * ����ͼ��
	 * 
	 * @param book
	 */
	public void InsertBook(Book book);

	/**
	 * ����ͼ��
	 */
	public void updatebookbyid(Book book);

	/**
	 * ����idɾ��ͼ��
	 * 
	 * @param id
	 */
	public void deleteByid(Integer id);

	/**
	 * ���ݴ���� ShoppingCartItem �ļ���, �������� books ���ݱ�� storenumber �� salesnumber
	 * �ֶε�ֵ
	 * 
	 * @param items
	 */
	public abstract void batchUpdateStoreNumberAndSalesAmount(Collection<ShoppingCartItem> items);

}