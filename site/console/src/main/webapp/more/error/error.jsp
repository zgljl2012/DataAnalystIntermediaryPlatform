<%@page language="java" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh">
  <head>
	<%@include file="/include/meta.jsp" %>

    <title>error-<%=variableManage.getValue(SystemVariable.SITENAME) %></title>

    <%@include file="/include/style.jsp" %>
    
    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="publics/js/ie-emulation-modes-warning.js"></script>
    
    
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <%
    	headerPage = "USER";
    %>
  </head>
	<%-- <%@include file="/include/validate.jsp" %> --%>
  <body>
  	
    <!--导航栏-->
    <%@include file="/include/header.jsp" %>
    <div class="container">
    <div class="panel panel-default">
    	<div class="panel-heading">错误</div>
    	<div class="panel-body">
    	<div class="red tc fs20">${error}</div>
    	</div>
    </div>
    </div>
   <!--底部导航栏-->
   <%@include file="/include/footer.jsp" %>
   <%@include file="/include/dialog.jsp" %>
    <script type="text/javascript">
    require(["jquery-2.1.1"],function(){
 	   require(["bootstrap.min"], function() {
 	   		
 	   })
    })
    
    </script>
  </body>
</html>
