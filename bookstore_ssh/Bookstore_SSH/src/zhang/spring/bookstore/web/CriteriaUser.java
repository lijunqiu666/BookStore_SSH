package zhang.spring.bookstore.web;
/**
 * ��װ��ѯ�û��Ĳ�ѯ����
 * @author Administrator
 *
 */
public class CriteriaUser {
	
	private int pageNo=1;
	
	private int pageSize=10;
	
	//ģ�� ��ѯ���û���
	private String username;
	
	//��С����
	private Integer minAge;
	
	//�������
	private Integer maxAge;

	public String getUsername() {
		if(username==null){
			return "%%";
		}
		return "%"+username+"%";
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getMinAge() {
		return minAge;
	}

	public void setMinAge(Integer minAge) {
		this.minAge = minAge;
	}

	public Integer getMaxAge() {
		return maxAge;
	}

	public void setMaxAge(Integer maxAge) {
		this.maxAge = maxAge;
	}
	
	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public CriteriaUser() {
		// TODO Auto-generated constructor stub
	}
	
	
}
