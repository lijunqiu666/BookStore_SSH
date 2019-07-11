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
	 * 在执行目标hander的方法前,准备user对象
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
	 * 使用ajax验证用户名是否可用
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
	 * 用户更新个人资料
	 * @return
	 */
	@RequestMapping(value="/doupdateuserinfo")
	public String doUpdateUserInfo(@Valid User user, BindingResult bindingResult, Map<String, Object> map,
			HttpSession session) {
		// 验证
		List<FieldError> fieldErrors = bindingResult.getFieldErrors();
		if (fieldErrors.size() > 0) {
			for (FieldError error : fieldErrors) {
				String fn = error.getField();
				String fm = error.getDefaultMessage();
				map.put("message", fn + ":" + fm);
				return "edituser";
			}
		}
		//更新
		User newuser = userService.doUpdate(user);
		// 同步Session中的User的信息
		session.setAttribute("User", newuser);
		return "forward:/gotouserinfo";
	}
	/**
	 * 去用户信息编辑页面
	 * @return
	 */
	@RequestMapping(value = "/toedituser")
	public String toEditUser(HttpServletRequest request, Map<String, Object> map) {
		return "edituser";
	}
	/**
	 * 查看用户的详细信息
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
	 * 用户注册
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "doregitster", method = RequestMethod.POST)
	public String doRegitster(Map<String, Object> map, @Valid User user, BindingResult bindingResult) {
		// 判断验证是否通过
		List<FieldError> fieldErrors = bindingResult.getFieldErrors();
		if (fieldErrors.size() > 0) {
			// 验证没有通过
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
	 * 去注册页面
	 * @return
	 */
	@RequestMapping("/toregitster")
	public String toRegitster(User user, Map<String, Object> map) {
		map.put("user", user);
		return "regitster";
	}
	/**
	 * 用户退出登入
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
	 * 用户登入
	 */
	@RequestMapping(value = "/dologin", method = RequestMethod.POST)
	public String doLogin(@RequestParam("imgcode") String imgcode, @RequestParam("username") String username,
			Map<String, Object> map, @RequestParam("password") String password, HttpSession session,
			HttpServletRequest request) {
		// 判断用户名和莫密码是否为空
		if (password.equals("") || password.equals("")) {
			map.put("message", "请你填写完整的用户信息");
			return "forward:/tologin";
		}
		// 判断用户输入的验证码是否正确
		String code = (String) request.getSession().getAttribute("CHECK_CODE_KEY");
		if (!"".equals(code)) {
			if (!imgcode.equalsIgnoreCase(code)) {
				map.put("message", "你输入的验证码错误");
				return "forward:/tologin";
			}
		}
		// 判断是否存在该用户
		User user = userService.isHave(username);
		if (user == null) {
			map.put("message", "用户名不存在");
			return "forward:/tologin";
		} else {
			// 如果存在,判断用户名是否和密码匹配
			boolean ismatch = userService.UsernameIsMatchPassword(user, password);
			if (!ismatch) {
				map.put("message", "用户名与密码不匹配");
				return "forward:/tologin";
			}
		}
		// 登入成功,将用户保存在Session中
		session.setAttribute("User", user);
		user.setShoppingCart(BookStoreWebUtils.getShoppingCart(request));
		return "forward:/getbooks";
	}
	/**
	 * 去登入页面
	 */
	@RequestMapping(value = "/tologin")
	public String toLogin() {
	
		return LOGIN;
	}
	/**
	 * 用户获取自己的交易记录
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
	 * 用户支付操作
	 * @return
	 */
	@RequestMapping("/dopaycash")
	public String doPayCash(@RequestParam("accountId") String accountId, @RequestParam("password") String password,
			HttpSession session, HttpServletRequest request, Map<String, Object> map) {
		// 验证银行卡号和密码是否为空
		if (accountId.trim() == "" || password.trim() == "") {
			map.put("message", "请填写完整信息");
			return "forward:/gotopaycash";
		}
		User user = (User) request.getSession().getAttribute("User");
		user = userService.getUser(user.getUsername());
		// 验证用户是否有这银行卡
		boolean ishaveaccount = userService.isHaveAccount(accountId, user.getUsername());
		// 如果没有,返回支付页面,给出提示信息
		if (!ishaveaccount) {
			map.put("message", "不存在该账户");
			return "forward:/gotopaycash";
		}
		// 验证银行卡号和密码是否匹配
		boolean passwordIsRight = userService.passwordIsRight(password, user);
		if (!passwordIsRight) {
			map.put("message", "密码错误");
			return "forward:/gotopaycash";
		}
		// 验证库存是否充足
		String checkstoreNumberisEn = bookService.checkstoreNumberisEn(BookStoreWebUtils.getShoppingCart(request));
		if (!checkstoreNumberisEn.equals("")) {
			map.put("message", checkstoreNumberisEn);
			return "forward:/gotopaycash";
		}
		// 检验用户的余额是否足够,如果不够,返回登入页面,并且给出提示信息
		String userBalanceIsEn = userService.userBalanceIsEn(user, BookStoreWebUtils.getShoppingCart(request));
		if (!userBalanceIsEn.equals("")) {
			map.put("message", userBalanceIsEn);
			return "forward:/gotopaycash";
		}
		// 所有的验证都通过
		try {
			userService.doPayCash(BookStoreWebUtils.getShoppingCart(request), user, request);
		} catch (Exception e) {
			return "redirect:/error.jsp";
		}

		return "success";
	}

	/**
	 * 去结账页面
	 * @return
	 */
	@RequestMapping("/gotopaycash")
	public String toPayCash(Map<String, Object> map, HttpServletRequest request) {
		map.put("Cart", BookStoreWebUtils.getShoppingCart(request));
		return "paycash";
	}

}
