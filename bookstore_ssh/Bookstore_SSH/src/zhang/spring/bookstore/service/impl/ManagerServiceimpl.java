package zhang.spring.bookstore.service.impl;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import zhang.spring.bookstore.dao.ManagerDao;
import zhang.spring.bookstore.dao.UserDAO;
import zhang.spring.bookstore.entities.Manager;
import zhang.spring.bookstore.entities.User;
import zhang.spring.bookstore.service.ManagerService;
@Repository
public class ManagerServiceimpl implements ManagerService{

	@Autowired
	private ManagerDao  ManagerDao=null;
	
	@Autowired
	private UserDAO UserDAO=null;
	
	@Override
	public boolean isHave(String managername) {
		long countbyName = ManagerDao.getCountbyName(managername);
		if(countbyName>0){
			return true;
		}
		return false;
	}

	@Override
	public String doLogin(String name, String password) {
		//�ж�������˺�����
		Manager manager = ManagerDao.getManager(name);
		if(!password.trim().equals(manager.getMgrPassword()) ){
			return "�������";
		}else{
			return "";
		}
	}

	public String vaildManager(String mgrname, Map<String, Object> map, String mgrpassword) {
		//��֤����Ա����Ϣ�Ƿ���д����
		if(mgrname.trim().equals("")||mgrpassword.trim().equals("")){
			map.put("message", "����д������Ϣ");
			return "forward:/manager/tologin";
		}
		//�ж��ǹ����ڸù���Ա
		boolean have = isHave(mgrname);
		if(!have){
			map.put("message", "�����ڸù���Ա");
			return "forward:/manager/tologin";
		}
		//��֤����Ա����������Ƿ�ƥ��
		String doLogin = doLogin(mgrname, mgrpassword);
		if(!doLogin.equals("")){
			map.put("message", doLogin);
			return "forward:/manager/tologin";
		}
		return "";
	}

	@Override
	public List<User> getTodayUsers(Date date) {
		List<User> users=UserDAO.getTodayUser(date);
		return users;
	}

	@Override
	public List<User> getLastDayUsers(Date date) {
		List<User> users=UserDAO.getLastUser(date);
		return users;
	}

	@Override
	public Manager getManager(String mgrname) {
		Manager manager = ManagerDao.getManager(mgrname);
		return manager;
	}

	@Override
	public String doImgUpload(MultipartFile multipartFile) {
		InputStream inputStream=null;
		OutputStream outputStream=null;
		String fn=null;
		try {
			inputStream = multipartFile.getInputStream();
			String originalFilename = multipartFile.getOriginalFilename();
			//��ȡ�ļ��ĺ�׺��
			String sn=originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
			fn = System.currentTimeMillis()+"."+sn;
			//�ϴ���
			String dir="E:\\Uploadfiles\\spring_bookstore\\img"+"\\"+fn;
			
			outputStream = new FileOutputStream(dir);
			byte[] b=new byte[1024];
			int len=0;
			while((len=inputStream.read(b))!=-1){
				outputStream.write(b, 0, len);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(outputStream!=null){
				try {
					outputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
			}if(inputStream!=null){
				try {
					inputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
			}
		}
		return fn;
	}

}
