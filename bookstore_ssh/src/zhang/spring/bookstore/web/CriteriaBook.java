package zhang.spring.bookstore.web;
/**
 * 
 * @ClassName:  CriteriaBook   
 * @Description:��װ�˴�ҳ��Ĳ�ѯ���� 
 * @author: ZhangYuKang
 * @date:   2019��5��25�� ����10:48:02
 */
public class CriteriaBook {

	private float minPrice = 0;
	private float maxPrice = Integer.MAX_VALUE;
	private String keyWord;
	
	public String getKeyWord() {
		if(keyWord==null){
			return "%%";
		}
		return "%"+keyWord+"%";
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	private int pageNo;

	public float getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(float minPrice) {
		this.minPrice = minPrice;
	}

	public float getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(float maxPrice) {
		this.maxPrice = maxPrice;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public CriteriaBook(float minPrice, float maxPrice, int pageNo) {
		super();
		this.minPrice = minPrice;
		this.maxPrice = maxPrice;
		this.pageNo = pageNo;
	}

	public CriteriaBook(float minPrice, float maxPrice, String keyWord, int pageNo) {
		super();
		this.minPrice = minPrice;
		this.maxPrice = maxPrice;
		this.keyWord = keyWord;
		this.pageNo = pageNo;
	}
	
	
	
}
