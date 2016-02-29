<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html lang="zh">
<head>
<title>用户中心-<%=variableManage.getValue(SystemVariable.SITENAME) %></title>
<%@include file="/include/meta.jsp" %>
<!-- Bootstrap core CSS -->
<link href="publics/css/bootstrap.min.css" rel="stylesheet">

<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<link href="publics/css/ie10-viewport-bug-workaround.css" rel="stylesheet">
<link href="publics/css/offcanvas.css" rel="stylesheet">
<link href="publics/css/zg-common.css" rel="stylesheet"/>
<link href="publics/css/app.css" rel="stylesheet"/>
<link href="publics/css/date/bootstrap-datetimepicker.min.css" rel="stylesheet"/>
<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
<!--[if lt IE 9]><script src="js/ie8-responsive-file-warning.js"></script><![endif]-->
<script src="publics/js/ie-emulation-modes-warning.js"></script>
<script type="text/javascript" src="publics/js/jquery.min.js"></script>
<script type="text/javascript" src="publics/js/bootstrap.min.js"></script>
<script type="text/javascript" src="publics/js/date/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript" src="publics/js/date/bootstrap-datetimepicker.zh-CN.js"></script>
<%--验证用户有没有登录 --%>
<%@include file="/include/validate.jsp" %>
<%
	headerPage="USER_CENTER";
	String userType = ljlSession.getUserType();
%>
</head>
<body>
	<%--导航栏--%>
    <%@include file="/include/header.jsp" %>
    <%if("FXS".equals(userType)) { %>
    	<%@include file="/include/user/fxs.jsp" %>
    <%} else { %>
    	<%@include file="/include/user/qy.jsp" %>
    <%} %>
   <%--底部导航栏--%>
   <%@include file="/include/footer.jsp" %>
   <%--对话框 --%>
   <%@include file="/include/dialog.jsp" %>
   <script src="/front/publics/js/user/index.js"></script>
</body>
</html>