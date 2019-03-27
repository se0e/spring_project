package kr.co.interceptor;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

// 인터셉터는 클래스기반
public class SampleInterceptor extends HandlerInterceptorAdapter {

	//실행전
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("preHandle입니다");
		HandlerMethod hMethod= (HandlerMethod) handler;
		Method a= hMethod.getMethod();
		System.out.println(a);
		
		Object b= hMethod.getBean();
		System.out.println(b);
		return true;
	} // 반환값이 true: 서비스를 진행하라 / false: 서비스를 진행하지 말아라

	//실행후
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("postHandle입니다.");
		modelAndView.setViewName("home");
		modelAndView.addObject("serverTime", "OK");
	}

	
}
