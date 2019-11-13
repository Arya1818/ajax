package com.ajax.test.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class EncodingFilter
 */
@WebFilter(filterName="/EncodingFilter", urlPatterns= {"*"})
public class EncodingFilter implements Filter {

   
    public EncodingFilter() {
        System.out.println("난 자동 실행됨"); //서블릿과 다르게 먼저 메모리를 생성
    }


	public void destroy() {
	
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8"); //web.xml에 setting하는게 더 좋음
//		HttpServletRequest req = (HttpServletRequest)request; 여기를 거치고 가는것을 콘솔창에 찍히는걸 보고 알수있음.
//		System.out.println(req.getRequestURI());
		
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
