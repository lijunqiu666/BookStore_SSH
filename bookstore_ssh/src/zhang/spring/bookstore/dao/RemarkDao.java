package zhang.spring.bookstore.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import zhang.spring.bookstore.entities.Remark;

@Repository
public interface RemarkDao {
	
	/**
	 * ��ȡ����Ա�ĵ����е�����
	 * @return
	 */
	public List<Remark> getAllRemarks();
	
	
	/**
	 * 
	 */
	public void deleteRemark();
}
