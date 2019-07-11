package zhang.spring.bookstore.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import zhang.spring.bookstore.entities.Manager;
import zhang.spring.bookstore.entities.User;

public interface ManagerService {

	/**
	 * 判断是否存在该manager
	 * @param managername
	 * @return
	 */
	public boolean isHave(String managername);
	
	
	/**
	 * 登入
	 * @param name
	 * @param password
	 * @return
	 */
	public String doLogin(String name,String password);


	/**
	 * 管理者登入验证
	 * @param mgrname
	 * @param map
	 * @param mgrpassword
	 * @return
	 */
	public String vaildManager(String mgrname, Map<String, Object> map, String mgrpassword);


	/**
	 * 今网站注册的人数
	 * @return
	 */
	public List<User> getTodayUsers(Date date);

	
	/**
	 * 昨儿注册网站的人数
	 * @param date
	 * @return
	 */
	public List<User> getLastDayUsers(Date date);


	/**
	 * 获取管理员
	 * @param mgrname
	 * @return
	 */
	public Manager getManager(String mgrname);


	/**
	 * 上传图书图片
	 * @param multipartFile
	 */
	public String doImgUpload(MultipartFile multipartFile);
	
	
}
