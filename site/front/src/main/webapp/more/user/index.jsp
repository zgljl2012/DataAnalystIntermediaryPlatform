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

<link href="publics/css/plugins/date/bootstrap-datetimepicker.min.css" rel="stylesheet"/>
<link href="publics/css/plugins/fileInput/fileinput.css" rel="stylesheet"/>

<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
<!--[if lt IE 9]><script src="publics/js/ie8-responsive-file-warning.js"></script><![endif]-->
<script type="text/javascript" src="publics/js/jquery.min.js"></script>
<script type="text/javascript" src="publics/js/bootstrap.min.js"></script>
<script type="text/javascript" src="publics/js/plugins/date/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript" src="publics/js/plugins/date/bootstrap-datetimepicker.zh-CN.js"></script>
<script type="text/javascript" src="publics/js/plugins/fileInput/fileinput.min.js"></script>
<script type="text/javascript" src="publics/js/plugins/fileInput/fileinput_locale_zh.js"></script>
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
   <%if("FXS".equals(userType)) { %>
    	<script src="/front/publics/js/user/index.js"></script>
    <%} else { %>
    	<script src="/front/publics/js/user/qy.js"></script>
    <%} %>
   <script src="/front/publics/js/common/dialog.js"></script>
   <script>
   <%--用户类型--%>
   var userType = '<%=userType%>';
   <%--用户名验证正则表达式 --%>
   var regUsername = /^[a-zA-Z][a-zA-Z0-9_]{5,18}$/;
   <%--分析师基础资料修改地址--%>
   var fxsBaseInfoUpdateUrl = "/front/user/fxsUpdate";
   <%--分析师基础资料获取Url--%>
   var fxsBaseInfoUrl = "user/fxsBaseInfo";
   <%--分析师从业经历获取Url--%>
   var fxsWorkExperience = "user/workExperience";
   <%--分析师从业经历管理URL，获取分页信息和删除经历--%>
   var fxsWorkExperienceManage = "user/workExperienceManage";
   <%--企业信息更新URL--%>
   var qyUpdateInfoUrl = "user/updateQyInfo";
   </script>
</body>
</html>