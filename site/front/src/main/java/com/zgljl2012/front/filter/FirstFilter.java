package com.zgljl2012.front.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 *@author 廖金龙
 *@version 2016年2月27日下午11:44:14
 */
@WebFilter(servletNames={"*"},filterName="filter")
public class FirstFilter implements Filter{
	
	private String encoding = "UTF-8";
	
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest res, ServletResponse req,
			FilterChain chain) throws IOException, ServletException {
		res.setCharacterEncoding(encoding);
		req.setCharacterEncoding(encoding);
		chain.doFilter(res, req);
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
