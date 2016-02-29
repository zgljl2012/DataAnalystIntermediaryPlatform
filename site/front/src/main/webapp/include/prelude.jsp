<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page import="com.zgljl2012.framework.variable.VariableManage"%>
<%@ page import="com.zgljl2012.framework.controller.Controller" %>
<%@ page import="com.zgljl2012.common.variable.SystemVariable" %>
<%@ page import="com.zgljl2012.framework.servlet.session.LjlSession" %>
<%
	Controller controller = (Controller)application.getAttribute("controller");
	// 常量管理类
	VariableManage variableManage = controller.getVariableManage();
	// 定制的Session
	LjlSession ljlSession = controller.getSession(session);
	String path = request.getContextPath(); 
	// 获得项目完全路径（假设你的项目叫MyApp，那么获得到的地址就是http://localhost:8080/MyApp/）: 
	String basePath = request.getScheme()+"://"+request.getServerName()
		+":"+request.getServerPort()+path+"/";
	// header上面的主页面，SY（首页），QYSC（企业市场），FXSSC（分析师市场）
	String headerPage = "SY";
%>
<base href=" <%=basePath%>">
    