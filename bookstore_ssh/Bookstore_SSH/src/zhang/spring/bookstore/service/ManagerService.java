package zhang.spring.bookstore.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import zhang.spring.bookstore.entities.Manager;
import zhang.spring.bookstore.entities.User;

public interface ManagerService {

	/**
	 * �ж��Ƿ���ڸ�manager
	 * @param managername
	 * @return
	 */
	public boolean isHave(String managername);
	
	
	/**
	 * ����
	 * @param name
	 * @param password
	 * @return
	 */
	public String doLogin(String name,String password);


	/**
	 * �����ߵ�����֤
	 * @param mgrname
	 * @param map
	 * @param mgrpassword
	 * @return
	 */
	public String vaildManager(String mgrname, Map<String, Object> map, String mgrpassword);


	/**
	 * ����վע�������
	 * @return
	 */
	public List<User> getTodayUsers(Date date);

	
	/**
	 * ���ע����վ������
	 * @param date
	 * @return
	 */
	public List<User> getLastDayUsers(Date date);


	/**
	 * ��ȡ����Ա
	 * @param mgrname
	 * @return
	 */
	public Manager getManager(String mgrname);


	/**
	 * �ϴ�ͼ��ͼƬ
	 * @param multipartFile
	 */
	public String doImgUpload(MultipartFile multipartFile);
	
	
}
