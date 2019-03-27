package kr.co.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		// 로그인 할때 사용!!!! (=로그인화면으로가면서)
		System.out.println("로그인전에 확인합니다.");
		
		HttpSession session= request.getSession();
		Object login= session.getAttribute("login"); // 기존 로그인값이 있는지 없는지
		
		if(login!=null) { // 로그인값이있다= 로그인되어있다.
			session.removeAttribute("login");
			//로그아웃시켜버리기(왜냐면 기존값이 있으면 내가 새로 로그인을 못하니까)
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// 로그인 후의 작업!!
		
		HttpSession session= request.getSession(); // 세션갖고오기
		ModelMap map= modelAndView.getModelMap(); // 컨트롤러에서 model로 바인딩한 값을 갖고온다.
		Object userVO= map.get("vo"); // 나는 vo로 설정해서 vo값을 갖고옴
		
		if(userVO!=null) {
			System.out.println("로그인에 성공해서 리스트로 갑니당.");
			session.setAttribute("login", userVO); //세션바인딩 로그인값을가지고
		
			Object dest= session.getAttribute("dest");  // authinterceptor에서 바인딩한 dest값 갖고오기
			if(dest!=null) { // dest값이 있으면
				response.sendRedirect(dest.toString());	//해당주소(=dest에저장된)로이동	
			} else {
				response.sendRedirect("/"); // 리스트로이동
			}
		}
		
	}

	
}
