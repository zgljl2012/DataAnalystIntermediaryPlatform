<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html lang="zh">
<head>
<title>项目市场-<%=variableManage.getValue(SystemVariable.SITENAME) %></title>
<%@include file="/include/meta.jsp" %>
<!-- Bootstrap core CSS -->
    <link href="publics/css/bootstrap.min.css" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="publics/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="publics/css/offcanvas.css" rel="stylesheet">
    
    <link href="publics/css/app.css" rel="stylesheet"/>
    
    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="publics/js/ie-emulation-modes-warning.js"></script>
	<%
		headerPage="XMSC";
	%>
</head>
<body>
	<!--导航栏-->
    <%@include file="/include/header.jsp" %>
    <%--搜索条件框--%>
    <div class="container">
    	<div class="panel panel-default">
    	<div class="panel-heading">筛选条件</div>
    	<div class="panel-body">
    		<div class="row">
    			<div class="col-xs-1">发布时间</div>
    			<div class="col-xs-10">
    				<span class="col-xs-1"><a href="#">全部</a></span>
    				<span class="col-xs-1"><a href="#">一天内</a></span>
    				<span class="col-xs-1"><a href="#">七天内</a></span>
    				<span class="col-xs-1"><a href="#">一月内</a></span>
    				<span class="col-xs-1"><a href="#">半年内</a></span>
    				<span class="col-xs-1"><a href="#">一年内</a></span>
    			</div>
    			<hr>
    		</div>
    		<div class="row">
    			<div class="col-xs-1">完成期限</div>
    			<div class="col-xs-10">
    				<span class="col-xs-1"><a href="#">全部</a></span>
    				<span class="col-xs-1"><a href="#">一天内</a></span>
    				<span class="col-xs-1"><a href="#">三天内</a></span>
    				<span class="col-xs-1"><a href="#">七天内</a></span>
    				<span class="col-xs-1"><a href="#">一月内</a></span>
    				<span class="col-xs-1"><a href="#">其他</a></span>
    			</div>
    			<hr>
    		</div>
    		<div class="row">
    			<div class="col-xs-1">项目状态</div>
    			<div class="col-xs-10">
    				<span class="col-xs-1"><a href="#">全部</a></span>
  					<span class="col-xs-1"><a href="#">投标中</a></span>
  					<span class="col-xs-1"><a href="#">已完成</a></span>
  					<span class="col-xs-1"><a href="#">进行中</a></span>
    			</div>
    			<hr>
    		</div>
    		<div class="row">
    			<div class="col-xs-1">企业状态</div>
    			<div class="col-xs-10">
    				<span class="col-xs-1"><a href="#">全部</a></span>
  					<span class="col-xs-1"><a href="#">已认证</a></span>
  					<span class="col-xs-1"><a href="#">未认证</a></span>
    			</div>
    		</div>
    	</div>
    	</div>
    </div>
    
    <%--企业项目列表 --%>
	<div class="container">
    	<div class="panel panel-default">
    	<div class="panel-heading">所有项目</div>
    	<div class="panel-body">
	
		</div>
		</div>
	</div>    
    <!--底部导航栏-->
   <%@include file="/include/footer.jsp" %>
</body>
</html>