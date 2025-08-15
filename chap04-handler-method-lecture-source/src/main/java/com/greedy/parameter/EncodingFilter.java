package com.greedy.parameter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/*webFilter어노테이션을 사용하거나 xml에 필터를 등록해 필터 적용 범위를 준다.*/
@WebFilter("/*")
public class EncodingFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest hrequest = (HttpServletRequest) request;
		if("POST".equals(hrequest.getMethod())) {
			hrequest.setCharacterEncoding("UTF-8");
		}
		
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {}

}
