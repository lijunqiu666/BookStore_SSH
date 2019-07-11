package zhang.spring.bookstore.entities;

import java.util.Date;

/**
 * 
 * @ClassName:  Book   
 * @Description:图书 
 * @author: ZhangYuKang
 * @date:   2019年5月25日 上午10:45:51
 */
public class Book {
	//id
	private Integer id;
	//作者
	private String author;
	//书名
	private String title;
	//价格
	private float price;
	//图片路径
	private String imgpath;
	//出版时间
	private Date publishingDate;
	//销量
	private int salesAmount;
	//库存
	private int storeNumber;
	//评论数
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
