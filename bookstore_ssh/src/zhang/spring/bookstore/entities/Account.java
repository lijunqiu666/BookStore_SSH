package zhang.spring.bookstore.entities;

import java.util.Date;

/**
 * 
 * @ClassName:  Account   
 * @Description:账户
 * @author: ZhangYuKang
 * @date:   2019年5月25日 上午10:45:40
 */

public class Account {
	//主键
	private Integer id;
	//账户余额
	private float balance;
	//账号
	private String accountId;
	//账户密码
	private String password;
	//账户创建的时间
	private Date createTime;
	
	//账户对应的用户(一对一)
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
