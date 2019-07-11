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
	//�÷�������Ⱦ��ͼ��ɺ����,��Ҫ�û��ͷ���Դ
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object arg2, Exception arg3)
			throws Exception {

	}
	//��ִ��Ŀ��Hander������,��Ⱦ��ͼ֮ǰִ��,���������޸�����
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		//request.getSession().setAttribute("locale", "zh_CN");
		
		
	}
	//��ִ��Ŀ��Hander����ǰ,������Ȩ��,���û��������صȹ���
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		// �ж�Session���Ƿ���User����,���û��ת������ҳ��,������ʾ�û�����
		Object User = request.getSession().getAttribute("User");
		if (User == null) {
			
			request.setAttribute("message", "��,����,�ȵ���");
			request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
			return false;
		}
		return true;
	}

}
