package zhang.spring.bookstore.entities;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @ClassName:  Manager   
 * @Description:管理员
 * @author: ZhangYuKang
 * @date:   2019年5月25日 上午10:46:01
 */
public class Manager {
	
	private Integer mgrId;
	
	private String mgrName;
	
	private String mgrPassword;
	
	private Set<Remark> Remarks=new HashSet<>();
	
	

	public Integer getMgrId() {
		return mgrId;
	}

	public void setMgrId(Integer mgrId) {
		this.mgrId = mgrId;
	}

	public Set<Remark> getRemarks() {
		return Remarks;
	}

	public void setRemarks(Set<Remark> remarks) {
		Remarks = remarks;
	}

	public String getMgrName() {
		return mgrName;
	}

	public void setMgrName(String mgrName) {
		this.mgrName = mgrName;
	}

	public String getMgrPassword() {
		return mgrPassword;
	}

	public void setMgrPassword(String mgrPassword) {
		this.mgrPassword = mgrPassword;
	}
	
	public Manager() {
		// TODO Auto-generated constructor stub
	}
	
	
}
