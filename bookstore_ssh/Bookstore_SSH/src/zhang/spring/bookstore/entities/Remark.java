package zhang.spring.bookstore.entities;

import java.util.Date;

public class Remark {
	private Integer remarkId;
	
	private String content;
	
	private Date createTime;
	
	private Manager manager;
	

	public Integer getRemarkId() {
		return remarkId;
	}

	public void setRemarkId(Integer remarkId) {
		this.remarkId = remarkId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	
	
	public Remark() {
		// TODO Auto-generated constructor stub
	}

}
