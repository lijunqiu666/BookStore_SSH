package zhang.spring.bookstore.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import zhang.spring.bookstore.entities.Book;
import zhang.spring.bookstore.entities.ShoppingCart;
import zhang.spring.bookstore.web.CriteriaBook;
import zhang.spring.bookstore.web.Page;

public interface BookService {

	//���ݲ�ѯ��������Page
	public Page<Book> getPage(CriteriaBook cb);
	
	//����id��ȡͼ��
	public Book getBook(Integer id);

	//�ж�ͼ��Ŀ���Ƿ����
	public String checkstoreNumberisEn(ShoppingCart shoppingCart);

	//��������ͼ��
	public List<Book> getTopBooks(int i);

	//����ͼ��
	public int updateBook(Book book);

	//ɾ��ͼ��
	public int deleteBook(Book book);

	//�ϴ�ͼ��
	public void inertBook(Book book);
	
}
