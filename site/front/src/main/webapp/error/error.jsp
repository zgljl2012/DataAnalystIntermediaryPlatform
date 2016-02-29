<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html lang="zh">
<head>
<title>500-<%=variableManage.getValue(SystemVariable.SITENAME) %></title>
<%@include file="/include/meta.jsp" %>
<!-- Bootstrap core CSS -->
<link href="publics/css/bootstrap.min.css" rel="stylesheet">

<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<link href="publics/css/ie10-viewport-bug-workaround.css" rel="stylesheet">
<link href="publics/css/offcanvas.css" rel="stylesheet">
<link href="publics/css/zg-common.css" rel="stylesheet"/>
<link href="publics/css/app.css" rel="stylesheet"/>
<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
<!--[if lt IE 9]><script src="js/ie8-responsive-file-warning.js"></script><![endif]-->
<script src="publics/js/ie-emulation-modes-warning.js"></script>
 
<script type="text/javascript" src="publics/js/jquery.min.js"></script>
<script type="text/javascript" src="publics/js/bootstrap.min.js"></script>
<%
	headerPage="REGISTER";
%>
</head>
<body>
	<%--导航栏--%>
    <%@include file="/include/header.jsp" %>
    <div class="container">
    	<div class="panel panel-default">
    	<div class="panel-heading">系统错误</div>
    	<div class="panel-body">
    		<p class="red tc fs20 mt20 mb20">
    		<%
	    		String exp = "系统发生错误";
    			Object o = request.getAttribute("exp");
    			if(o != null) {
    				exp = (String)o;
    			}
				out.write(exp);
    		%>
    		</p>
    	</div>
    </div>
	<%--底部导航栏--%>
    <%@include file="/include/footer.jsp" %>
    <%--对话框 --%>
    <%@include file="/include/dialog.jsp" %>
</body>
</html>