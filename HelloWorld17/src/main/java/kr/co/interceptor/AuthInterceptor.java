package kr.co.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session= request.getSession();
		Object login= session.getAttribute("login");
		
		if(login==null) {
			saveDest(request); // 사용자 생성메서드
			response.sendRedirect("/user/login");
			return false; // 로그인이 되어있지 않으니 진행하지 말라(=false)
		}
		
		// 로그인이 되어있을때 진행하라(=true)
		return true;
	}

	private void saveDest(HttpServletRequest request) {
		String uri= request.getRequestURI();
		String query= request.getQueryString();
		
		if(query==null || query.equals("null")) {
			query="";
		} else {
			query="?"+query; // uri와 query를 합칠때 ? 가 있어야함.
		}
		
		String dataMethod= request.getMethod();
		if(dataMethod.equalsIgnoreCase("GET")) {
			request.getSession().setAttribute("dest", uri+query);
		} // 내가 진행하려는 방향(=어디페이지에갈것인가)이 세션에 바인딩됨
		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// 로그인 후의 작업!!
		
		/*
		 * HttpSession session= request.getSession(); // 세션갖고오기 ModelMap map=
		 * modelAndView.getModelMap(); // 컨트롤러에서 model로 바인딩한 값을 갖고온다. Object userVO=
		 * map.get("vo"); // 나는 vo로 설정해서 vo값을 갖고옴
		 * 
		 * if(userVO!=null) { System.out.println("로그인에 성공해서 리스트로 갑니당.");
		 * session.setAttribute("login", userVO); //세션바인딩 로그인값을가지고
		 * response.sendRedirect("/board/list"); // 리스트로간다. }
		 */
	}

	
}
