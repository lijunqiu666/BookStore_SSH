package zhang.spring.bookstore.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import zhang.spring.bookstore.dao.RemarkDao;
import zhang.spring.bookstore.entities.Remark;
@Repository
public class RemarkDaoimpl extends BaseDao<Remark> implements RemarkDao  {

	@Override
	public List<Remark> getAllRemarks() {
		List<Remark> remarks = getSession().createQuery("from Remark order by createTime").list();
		return remarks;
	}

	@Override
	public void deleteRemark() {
		// TODO Auto-generated method stub
		
	}

}
