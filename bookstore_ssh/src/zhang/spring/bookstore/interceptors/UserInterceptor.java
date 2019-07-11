package zhang.spring.bookstore.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import zhang.spring.bookstore.entities.User;

@Component
public class UserInterceptor implements HandlerInterceptor {
	// �÷�������Ⱦ��ͼ��ɺ����,��Ҫ�û��ͷ���Դ
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object arg2, Exception arg3)
			throws Exception {

	}

	// ��ִ��Ŀ��Hander������,��Ⱦ��ͼ֮ǰִ��,���������޸�����
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// request.getSession().setAttribute("locale", "zh_CN");

	}

	// ��ִ��Ŀ��Hander����ǰ,������Ȩ��,���û��������صȹ���
	@Override
	public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			Object arg2) throws Exception {
		String homeUrl = httpServletRequest.getContextPath();
		// �ж�Session���Ƿ���User����,���û��ת������ҳ��,������ʾ�û�����
		User User = (User) httpServletRequest.getSession().getAttribute("User");
		if (User == null) {
			//�����ajax����
			if (httpServletRequest.getHeader("x-requested-with") != null
					&& httpServletRequest.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")) {
				httpServletResponse.setHeader("SESSIONSTATUS", "TIMEOUT");
				httpServletRequest.setAttribute("message", "��!,�����ȵ���.");
				httpServletResponse.setHeader("CONTEXTPATH", homeUrl + "/tologin");
				return false;
			}else{
				//�������ajax����,���û���û�е���������,������ﳵ
				httpServletRequest.getRequestDispatcher("/tologin").forward(httpServletRequest, httpServletResponse);
				return false;				
			}
		}else{
			return true;			
		}
	}

}
