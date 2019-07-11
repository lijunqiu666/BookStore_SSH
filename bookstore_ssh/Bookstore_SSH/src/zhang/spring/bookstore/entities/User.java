package zhang.spring.bookstore.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

/**
 * 
 * @ClassName: User
 * @Description:用户
 * @author: ZhangYuKang
 * @date: 2019年5月25日 上午10:47:10
 */
@Component
public class User {
	// ID
	private Integer id;
	// 用户名
	@NotEmpty
	private String username;
	// 电话号码
	private String phonenumber;
	// 性别
	@NotEmpty
	private String sex;
	// 地址
	@NotEmpty
	private String address;
	// 电子邮件
	@NotEmpty
	@Email
	private String email;
	// 出生年月
	@Past
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date birth;
	// 登入密码
	@NotEmpty
	private String password;
	// 注册时间
	@Past
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date createTime;
	// 购物车
	private ShoppingCart shoppingCart = null;
	// 用户的交易
	private Set<Trade> trades = new HashSet<>();
	// 银行卡账号
	private Account account;

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public Set<Trade> getTrades() {
		return trades;
	}

	public void setTrades(Set<Trade> trades) {
		this.trades = trades;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	public User(String username, String sex, String address, String email, Date birth, String password,
			Set<Trade> trades) {
		super();
		this.username = username;
		this.sex = sex;
		this.address = address;
		this.email = email;
		this.birth = birth;
		this.password = password;
		this.trades = trades;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", phonenumber=" + phonenumber + ", sex=" + sex
				+ ", address=" + address + ", email=" + email + ", birth=" + birth + ", password=" + password + "]\n";
	}

	public User() {
		// TODO Auto-generated constructor stub
	}

}
