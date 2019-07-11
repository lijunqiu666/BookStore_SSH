package zhang.spring.bookstore.entities;

import java.util.Date;

/**
 * 
 * @ClassName:  Account   
 * @Description:�˻�
 * @author: ZhangYuKang
 * @date:   2019��5��25�� ����10:45:40
 */

public class Account {
	//����
	private Integer id;
	//�˻����
	private float balance;
	//�˺�
	private String accountId;
	//�˻�����
	private String password;
	//�˻�������ʱ��
	private Date createTime;
	
	//�˻���Ӧ���û�(һ��һ)
	private User user;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Account(String accountId, float balance, String password, Date createTime) {
		super();
		this.accountId=accountId;
		this.balance = balance;
		this.password = password;
		this.createTime = createTime;
	}
	public Account() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", balance=" + balance + ", accountId=" + accountId + ", password=" + password
				+ ", createTime=" + createTime + " ]";
	}
	

}
