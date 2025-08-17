package com.greedy.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class StopWatchInterceptor implements HandlerInterceptor {		//원래는 미완성 메소드가 있었지만 버전이 바뀐 이후부터 default메소드로 바뀌면서 오버라이딩 강제성이 없어짐
	
	private final MenuService menuService;
	
	@Autowired
	public StopWatchInterceptor(MenuService menuService) {
		this.menuService = menuService;
	}
	
	/* 전처리 메소드 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) 
			throws Exception {
				
		System.out.println("preHandler 호출함...");
		
		long startTime = System.currentTimeMillis();
		
		request.setAttribute("startTime", startTime);
		
		/* true이면 컨트롤러를 이어서 호출한다. false이면 핸들러 메소드를 호출하지 않음. */
		return true;
	}
	
	/* 후처리 메소드 
	 * 중간에 Exception이 발생하면 실행을 하지 않는다.*/
	@Override
	public void postHandle(HttpServletRequest request, 
			HttpServletResponse response, Object handler, ModelAndView modelAndView) {
		System.out.println("posthandler 호출함...");
		
		long startTime = (Long) request.getAttribute("startTime");
		request.removeAttribute("startTime");
		
		long endTime = System.currentTimeMillis();
		
		modelAndView.addObject("interval", endTime - startTime);
		
	}
	
	/* 마자막에 호출하는 메소드*/
	@Override
	public void afterCompletion(HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler, 
			Exception ex) {
		
		System.out.println("afterCompletion 호출함...");
		
		menuService.method();
	}

}
