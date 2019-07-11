package zhang.spring.bookstore.handers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import zhang.spring.bookstore.entities.Book;
import zhang.spring.bookstore.entities.Manager;
import zhang.spring.bookstore.entities.User;
import zhang.spring.bookstore.service.BookService;
import zhang.spring.bookstore.service.ManagerService;
import zhang.spring.bookstore.service.UserService;
import zhang.spring.bookstore.web.CriteriaBook;
import zhang.spring.bookstore.web.CriteriaUser;
import zhang.spring.bookstore.web.Page;
@RequestMapping("/manager")
@Controller
public class ManagerHander {

	@Autowired
	private ManagerService ManagerService=null;
	
	@Autowired
	private BookService BookService=null;
	
	@Autowired
	private UserService UserService=null;
	
	@RequestMapping(value="/doaddbook",method=RequestMethod.POST)
	public String doAddBook(Book book,@RequestParam("file") MultipartFile multipartFile) throws IOException{
		//上传图书的对应的图片
		String filename = ManagerService.doImgUpload(multipartFile);
		//设置图书上传的时间为当前时间
		book.setPublishingDate(new Date());
		book.setImgpath(filename);
		book.setRemark("0");
		BookService.inertBook(book);
		return "forward:/manager/tomanagerbooks";
		
	}
	
	/**
	 * 点击发货
	 */
	@RequestMapping(value="/sendGoods")
	public String sendGoods(@RequestParam("username") String username,@RequestParam("tradeitemid") Integer tradeitemid){
		ManagerService.sendGoods(tradeitemid);
		return "forward:/manager/getuserorders";
	}
	/**
	 * 查看用户的订单信息
	 * @param map
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/getuserorders", method = RequestMethod.GET)
	public String getUserOrders(Map<String, Object> map, HttpServletRequest request) {
		UserService.getUserInfo(request);
		return "/manager/orders";
	}
	/**
	 * 去管理用户 的页面
	 * @return
	 */
	@RequestMapping("/tomanagerusers")
	public String getUsers(@RequestParam(value="pageNo",defaultValue="1") Integer pageNo
	,HttpServletRequest request,Map<String, Object> map){
		//username
		String username=request.getParameter("username");
		
		CriteriaUser cu=new CriteriaUser();
		cu.setPageNo(pageNo);
		cu.setUsername(username);
		Page<User> page = UserService.getUsers(cu);
		
		map.put("page",page);
		return "/manager/managerusers";
	}
	/**
	 * 准备图书
	 * @param request
	 * @param map
	 */
	@ModelAttribute
	public void  getBook(HttpServletRequest request,Map<String, Object> map){
		String id = request.getParameter("id");
		if(id!=null){
			Book book = BookService.getBook(Integer.parseInt(id.trim()));
			map.put("book", book);
		}else{
			map.put("book", new Book());
		}
	}
	/**
	 * 删除图书
	 * @param book
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/dodeletebook")
	public String deleteBooks(Book book){
		int  flag=BookService.deleteBook(book);
		return String.valueOf(flag);
	}
	/**
	 * 更新图书
	 * @return
	 */
	@RequestMapping("/doupdatebook")
	public String doUpdateBook(Book book){
		if(book!=null){
			int flag = BookService.updateBook(book);
			//返回更新成功
			if(flag>0){
				return "forward:/manager/tomanagerbooks";
			}
		}
		//返回0更新失败
		return "redirect:/error.jsp";
	}
	/**
	 * 编辑图书的信息
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/editbook")
	public Book editBook(Book book){
		return book;
	}
	/**
	 * 去管理图书页面
	 * @return
	 */
	@RequestMapping("/tomanagerbooks")
	public String toManagerbooks(@RequestParam(value = "minprice", defaultValue = "0") Integer minprice,
			@RequestParam(value = "maxprice", defaultValue = "10000") Integer maxprice,
			@RequestParam(value = "pagenumber", defaultValue = "1") Integer pagenumber, Map<String, Object> map,
			HttpServletRequest request) {

		String keyword = request.getParameter("keyword");
		// 封装查询条件
		CriteriaBook cb = new CriteriaBook(minprice, maxprice, keyword, pagenumber);
		Page<Book> page = BookService.getPage(cb);
		map.put("page", page);
		return "/manager/managerbooks";
	}
	/**
	 * 管理员注销登入
	 * @param session
	 * @return
	 */
	@RequestMapping("/dologout")
	public String doLogout(HttpSession session){
		session.removeAttribute("Manager");
		return "redirect:/manager/tologin";
	}
	/**
	 * 回到管理中心
	 * @return
	 */
	@RequestMapping("/backtocenter")
	public String toMangerCenter(HttpSession session,Map<String, Object> map){
		Manager manager = (Manager) session.getAttribute("Manager");
		if(manager!=null){
			prepareData(manager.getMgrName(), map,session);			
		}
		return "/manager/index";
	}
	/**
	 * 管理员登入
	 * @param mgrname
	 * @param map
	 * @param mgrpassword
	 * @return
	 */
	@RequestMapping("/dologin")
	public String doLogin(@RequestParam("managerName") String mgrname,Map<String, Object> map
			,@RequestParam("managerPassword") String mgrpassword,HttpSession session){
		
		String message = ManagerService.vaildManager(mgrname, map, mgrpassword);
		if(!"".equals(message)){
			return message;
		}
		//准备首页的数据
		prepareData(mgrname, map,session);
		
		return "/manager/index";
	}
	private void prepareData(String mgrname, Map<String, Object> map,HttpSession session) {
		//准备首页的数据,前n本热门图书,根据销量排行
		List<Book> hotbooks=BookService.getTopBooks(5);
		map.put("hotbooks", hotbooks);
		//返回昨日注册的用户的人数
		List<User> todayUsers= ManagerService.getLastDayUsers(new Date());
		
		//返回今日注册用户的人数
		List<User> todayu = ManagerService.getTodayUsers(new Date());
		List<User> lastdayu=ManagerService.getLastDayUsers(new Date());
		//最近注册的用户
		List<User> Ruser=new ArrayList<>();
		Ruser.addAll(todayu);
		Ruser.addAll(lastdayu);
		map.put("user", Ruser);
		
		map.put("today",todayu.size());
		map.put("lastday",lastdayu.size());
		//将此管理员保存在sesison中
		session.setAttribute("Manager", ManagerService.getManager(mgrname));
		
	}
	
	/**
	 * 去管理员登入入页面
	 * @return
	 */
	@RequestMapping("/tologin")
	public String toLogin(){
		return "manager/login";
	}
	
}
