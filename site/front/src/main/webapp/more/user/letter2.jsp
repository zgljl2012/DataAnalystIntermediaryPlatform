<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page import="com.zgljl2012.common.database.enums.Gender" %>
<%@ page import="com.zgljl2012.modules.project.BidManage" %>
<%@ page import="com.zgljl2012.framework.util.JSON" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html lang="zh">
<head>
<title>站内信-<%=variableManage.getValue(SystemVariable.SITENAME) %></title>
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
<!-- <script src="publics/js/ie-emulation-modes-warning.js"></script> -->
<link href="publics/css/plugins/date/bootstrap-datetimepicker.min.css" rel="stylesheet"/>

<link rel="stylesheet" type="text/css" href="publics/css/zg-common.css">
<link rel="stylesheet" type="text/css" href="publics/css/plugins/star/star-rating.min.css">
<%
	headerPage="USER_CENTER";
%>
</head>
<body>
	<!--导航栏-->
	<%@include file="/include/header.jsp" %>
    <div class="container">
    <div class="row">
    <div class="panel panel-default">
    	<div class="panel-heading">站内信</div>
    	<div class="panel-body">
    	<div class="container">
    		<div class="row">
    			<div class="col-sm-3">
    			<table class="table table-hover">
    			<tr class="cp">
    				<td>
    					<span>asd2012</span>
    					<span class="fs05 fr">10:22:06</span>
    				</td>
    			</tr>
    			<tr class="cp">
    				<td>
    					<span>asd2012</span>
    					<span class="fs05">10:22:06</span>
    				</td>
    			</tr>
    			</table>
    			</div>
    			<div class="col-sm-9">
    			<div class="row">
    			<iframe name="chat" src="more/user/chat.jsp?" width="90%" height="350px">
    			</iframe>
    			</div>
    			<div class="row mt10">
	    			<div class="col-sm-9">
	    				<input type="text" placeholder="请输入内容" width="90%"/>
	    			</div>
	    			<div class="col-sm-3">
	    				<input type="button" class="btn btn-primary" value="发送"/>
	    			</div>
    			</div>
    			</div>
    		</div>
    	</div>
    	</div>
    </div>
    </div>
    </div>
<!--底部导航栏-->
   <%@include file="/include/footer.jsp" %>
   <%--对话框 --%>
   <%@include file="/include/dialog.jsp" %>
   <script>
   require(["jquery-2.1.1"], function(){
	   require(["bootstrap.min"], function() {
		   require(["user/letter"], function(letter) {
				$("iframe[name=chat]").attr("src","more/user/chat.jsp?v="+new Date());   
		   });
	   })
   })
   </script>
 </body>
</html>