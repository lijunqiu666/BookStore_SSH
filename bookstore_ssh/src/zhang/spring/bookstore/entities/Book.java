package zhang.spring.bookstore.entities;

import java.util.Date;

/**
 * 
 * @ClassName:  Book   
 * @Description:ͼ�� 
 * @author: ZhangYuKang
 * @date:   2019��5��25�� ����10:45:51
 */
public class Book {
	//id
	private Integer id;
	//����
	private String author;
	//����
	private String title;
	//�۸�
	private float price;
	//ͼƬ·��
	private String imgpath;
	//����ʱ��
	private Date publishingDate;
	//����
	private int salesAmount;
	//���
	private int storeNumber;
	//������
	private String remark;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getImgpath() {
		return imgpath;
	}
	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}
	public Date getPublishingDate() {
		return publishingDate;
	}
	public void setPublishingDate(Date publishingDate) {
		this.publishingDate = publishingDate;
	}
	public int getSalesAmount() {
		return salesAmount;
	}
	public void setSalesAmount(int salesAmount) {
		this.salesAmount = salesAmount;
	}
	public int getStoreNumber() {
		return storeNumber;
	}
	public void setStoreNumber(int storeNumber) {
		this.storeNumber = storeNumber;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", author=" + author + ", imgpath=" + imgpath + ", title=" + title + ", price="
				+ price + ", publishingDate=" + publishingDate + ", salesAmount=" + salesAmount + ", storeNumber="
				+ storeNumber + ", remark=" + remark + "]\n";
	}
	public Book() {
		// TODO Auto-generated constructor stub
	}
	public Book(String author, String title, float price, String imgpath, Date publishingDate, int salesAmount,
			int storeNumber, String remark) {
		super();
		this.author = author;
		this.title = title;
		this.price = price;
		this.imgpath = imgpath;
		this.publishingDate = publishingDate;
		this.salesAmount = salesAmount;
		this.storeNumber = storeNumber;
		this.remark = remark;
	}
	
	
		
}
