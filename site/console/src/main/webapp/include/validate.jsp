<%@page language="java" contentType="text/html; charset=utf-8"%>
<%@page import="java.util.Enumeration"%>
<%@ page import="com.zgljl2012.framework.servlet.session.LjlSession" %>
<%
	// 如果用户没有登录，就跳转到登录界面
	if(!ljlSession.isLogined()) {
		controller.redirect(response, "/front/more/user/login.jsp");
		return;
	}
%>
