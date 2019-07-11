package zhang.spring.bookstore.handers;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import zhang.spring.bookstore.entities.User;
import zhang.spring.bookstore.service.BookService;
import zhang.spring.bookstore.service.UserService;
import zhang.spring.bookstore.web.BookStoreWebUtils;

@Controller
public class UserHander {

	private static final String LOGIN = "login";

	@Autowired
	private UserService userService = null;

	@Autowired
	private BookService bookService = null;

//	@Autowired
//	private UserDAO userdao = null;

	/**
	 * ��ִ��Ŀ��hander�ķ���ǰ,׼��user����
	 * @param request
	 * @param map
	 */
	@ModelAttribute
	public void getUser(HttpServletRequest request, Map<String, Object> map) {
		User Suser = (User) request.getSession().getAttribute("User");
		User user = null;
		if (Suser == null) {
			user = new User();
		} else {
			user = userService.getUser(Suser.getUsername());
		}
		map.put("user", user);
	}
	/**
	 * ʹ��ajax��֤�û����Ƿ����
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/ajaxvaildataname")
	public String ajaxVaildataUserName(@RequestParam("username") String username,Map<String, Object> map
			){
		User user = userService.getUser(username.trim());
		if(user==null){
			return "0";
		}else{
			return "1";
		}
	}
	/**
	 * �û����¸�������
	 * @return
	 */
	@RequestMapping(value="/doupdateuserinfo")
	public String doUpdateUserInfo(@Valid User user, BindingResult bindingResult, Map<String, Object> map,
			HttpSession session) {
		// ��֤
		List<FieldError> fieldErrors = bindingResult.getFieldErrors();
		if (fieldErrors.size() > 0) {
			for (FieldError error : fieldErrors) {
				String fn = error.getField();
				String fm = error.getDefaultMessage();
				map.put("message", fn + ":" + fm);
				return "edituser";
			}
		}
		//����
		User newuser = userService.doUpdate(user);
		// ͬ��Session�е�User����Ϣ
		session.setAttribute("User", newuser);
		return "forward:/gotouserinfo";
	}
	/**
	 * ȥ�û���Ϣ�༭ҳ��
	 * @return
	 */
	@RequestMapping(value = "/toedituser")
	public String toEditUser(HttpServletRequest request, Map<String, Object> map) {
		return "edituser";
	}
	/**
	 * �鿴�û�����ϸ��Ϣ
	 * @param request
	 * @param map
	 * @return
	 */
	@RequestMapping("/gotouserinfo")
	public String goToUserInfo(User user, HttpServletRequest request, Map<String, Object> map) {
		map.put("user", user);
		return "userinfo";
	}

	/**
	 * �û�ע��
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "doregitster", method = RequestMethod.POST)
	public String doRegitster(Map<String, Object> map, @Valid User user, BindingResult bindingResult) {
		// �ж���֤�Ƿ�ͨ��
		List<FieldError> fieldErrors = bindingResult.getFieldErrors();
		if (fieldErrors.size() > 0) {
			// ��֤û��ͨ��
			for (FieldError error : fieldErrors) {
				String message = error.getDefaultMessage();
				String field = error.getField();
				map.put("message", field + ":" + message);
				return "forward:/toregitster";
			}
		}
		String message = userService.doRegitster(user);
		if (!message.equals("")) {
			map.put("message", message);
			return "forward:/toregitster";
		}
		return "forward:/getbooks";
	}
	/**
	 * ȥע��ҳ��
	 * @return
	 */
	@RequestMapping("/toregitster")
	public String toRegitster(User user, Map<String, Object> map) {
		map.put("user", user);
		return "regitster";
	}
	/**
	 * �û��˳�����
	 * @param session
	 * @return
	 */
	@RequestMapping("/logout")
	public String doLogout(HttpSession session, HttpServletRequest request) {
		session.removeAttribute("User");
		BookStoreWebUtils.getShoppingCart(request).clear();
		return "forward:/getbooks";
	}
	/**
	 * �û�����
	 */
	@RequestMapping(value = "/dologin", method = RequestMethod.POST)
	public String doLogin(@RequestParam("imgcode") String imgcode, @RequestParam("username") String username,
			Map<String, Object> map, @RequestParam("password") String password, HttpSession session,
			HttpServletRequest request) {
		// �ж��û�����Ī�����Ƿ�Ϊ��
		if (password.equals("") || password.equals("")) {
			map.put("message", "������д�������û���Ϣ");
			return "forward:/tologin";
		}
		// �ж��û��������֤���Ƿ���ȷ
		String code = (String) request.getSession().getAttribute("CHECK_CODE_KEY");
		if (!"".equals(code)) {
			if (!imgcode.equalsIgnoreCase(code)) {
				map.put("message", "���������֤�����");
				return "forward:/tologin";
			}
		}
		// �ж��Ƿ���ڸ��û�
		User user = userService.isHave(username);
		if (user == null) {
			map.put("message", "�û���������");
			return "forward:/tologin";
		} else {
			// �������,�ж��û����Ƿ������ƥ��
			boolean ismatch = userService.UsernameIsMatchPassword(user, password);
			if (!ismatch) {
				map.put("message", "�û��������벻ƥ��");
				return "forward:/tologin";
			}
		}
		// ����ɹ�,���û�������Session��
		session.setAttribute("User", user);
		user.setShoppingCart(BookStoreWebUtils.getShoppingCart(request));
		return "forward:/getbooks";
	}
	/**
	 * ȥ����ҳ��
	 */
	@RequestMapping(value = "/tologin")
	public String toLogin() {
	
		return LOGIN;
	}
	/**
	 * �û���ȡ�Լ��Ľ��׼�¼
	 * @param map
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/gethistory", method = RequestMethod.GET)
	public String getTradeHistory(Map<String, Object> map, HttpServletRequest request) {
		userService.getUserInfo(request);
		return "history";
	}
	/**
	 * �û�֧������
	 * @return
	 */
	@RequestMapping("/dopaycash")
	public String doPayCash(@RequestParam("accountId") String accountId, @RequestParam("password") String password,
			HttpSession session, HttpServletRequest request, Map<String, Object> map) {
		// ��֤���п��ź������Ƿ�Ϊ��
		if (accountId.trim() == "" || password.trim() == "") {
			map.put("message", "����д������Ϣ");
			return "forward:/gotopaycash";
		}
		User user = (User) request.getSession().getAttribute("User");
		user = userService.getUser(user.getUsername());
		// ��֤�û��Ƿ��������п�
		boolean ishaveaccount = userService.isHaveAccount(accountId, user.getUsername());
		// ���û��,����֧��ҳ��,������ʾ��Ϣ
		if (!ishaveaccount) {
			map.put("message", "�����ڸ��˻�");
			return "forward:/gotopaycash";
		}
		// ��֤���п��ź������Ƿ�ƥ��
		boolean passwordIsRight = userService.passwordIsRight(password, user);
		if (!passwordIsRight) {
			map.put("message", "�������");
			return "forward:/gotopaycash";
		}
		// ��֤����Ƿ����
		String checkstoreNumberisEn = bookService.checkstoreNumberisEn(BookStoreWebUtils.getShoppingCart(request));
		if (!checkstoreNumberisEn.equals("")) {
			map.put("message", checkstoreNumberisEn);
			return "forward:/gotopaycash";
		}
		// �����û�������Ƿ��㹻,�������,���ص���ҳ��,���Ҹ�����ʾ��Ϣ
		String userBalanceIsEn = userService.userBalanceIsEn(user, BookStoreWebUtils.getShoppingCart(request));
		if (!userBalanceIsEn.equals("")) {
			map.put("message", userBalanceIsEn);
			return "forward:/gotopaycash";
		}
		// ���е���֤��ͨ��
		try {
			userService.doPayCash(BookStoreWebUtils.getShoppingCart(request), user, request);
		} catch (Exception e) {
			return "redirect:/error.jsp";
		}

		return "success";
	}

	/**
	 * ȥ����ҳ��
	 * @return
	 */
	@RequestMapping("/gotopaycash")
	public String toPayCash(Map<String, Object> map, HttpServletRequest request) {
		map.put("Cart", BookStoreWebUtils.getShoppingCart(request));
		return "paycash";
	}

}
