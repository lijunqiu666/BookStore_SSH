package zhang.spring.bookstore.interceptors;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

@Component
public class UserInterceptor implements HandlerInterceptor {
	//该方法在渲染视图完成后调用,主要用户释放资源
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object arg2, Exception arg3)
			throws Exception {

	}
	//在执行目标Hander方法后,渲染视图之前执行,可以用来修改数据
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		//request.getSession().setAttribute("locale", "zh_CN");
		
		
	}
	//在执行目标Hander方法前,用于做权限,和用户登入拦截等功能
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		// 判断Session中是否有User对象,如果没有转到登入页面,并且提示用户登入
		Object User = request.getSession().getAttribute("User");
		if (User == null) {
			
			request.setAttribute("message", "亲,请您,先登入");
			request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
			return false;
		}
		return true;
	}

}
