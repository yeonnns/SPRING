package com.githrd.www.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 회원 관련 요청을 할 때
 * 로그인이 되어 있는 경우는 메인 페이지로 돌려보내는 작업을 처리할 
 * 인터셉터
 * @author	김소연	
 * @since	2022.06.24
 * @version	v.1.0
 * 
 * 		작업이력 ]
 * 			2022/06/24	-	담당자	:	김소연
 * 									클래스 제작
 *
 */


public class LoginCheckInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler)
			throws Exception {
		if(req.getSession().getAttribute("SID") != null) {
			resp.sendRedirect("/www/main.blp");
			return false; // 요청처리함수 실행 X
		}
		return true;	// 요청 처리함수 실행 
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

}