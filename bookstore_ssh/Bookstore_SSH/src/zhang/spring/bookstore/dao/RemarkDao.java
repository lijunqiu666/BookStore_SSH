package zhang.spring.bookstore.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import zhang.spring.bookstore.entities.Remark;

@Repository
public interface RemarkDao {
	
	/**
	 * 获取管理员的的所有的留言
	 * @return
	 */
	public List<Remark> getAllRemarks();
	
	
	/**
	 * 
	 */
	public void deleteRemark();
}
