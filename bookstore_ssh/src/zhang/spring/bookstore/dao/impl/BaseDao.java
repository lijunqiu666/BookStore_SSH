package zhang.spring.bookstore.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import zhang.spring.bookstore.dbutils.ReflectionUtils;

@Repository
public class BaseDao<T> {

	private Class<T> type = null;

	public BaseDao() {
		this.type = ReflectionUtils.getSuperGenericType(this.getClass());
	}

	@Autowired
	private SessionFactory sessionFactory = null;

	@SuppressWarnings("unused")
	private Session session = null;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	//根据id获取对象
	@SuppressWarnings("unchecked")
	public T get(Integer id) {
		return (T) getSession().get(type, id);
	}
	//根据id删除对象
	public void delete(T t){
		getSession().delete(t);
	}
	
	
	

}
