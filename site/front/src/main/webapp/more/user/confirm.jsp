<%@page language="java" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html lang="zh">
  <head>
	<%@include file="/include/meta.jsp" %>
    <title>邮箱验证-<%=variableManage.getValue(SystemVariable.SITENAME) %></title>
    <link href="publics/css/bootstrap.min.css" rel="stylesheet">
    <link href="publics/css/zg-common.css" rel="stylesheet"/>
    <link rel="stylesheet" href="publics/css/styles/default.css">
     <!-- Custom styles for this template -->
	<link href="publics/css/offcanvas.css" rel="stylesheet">
    
	<link href="publics/css/app.css" rel="stylesheet"/>
    <script src="publics/js/plugins/require/require.min.js" data-main="publics/js/main.js"></script>
  	
  </head>
  <body>
  	<%@include file="/include/header.jsp" %>
  	<div class="container">
    <div class="row">
  	<div class="panel panel-default">
    	<div class="panel-heading">邮箱验证</div>
    	<div class="panel-body">
    	${msg}
    	</div>
    </div>
    </div>
    </div>
  	<%@include file="/include/footer.jsp" %>
    <script type="text/javascript">
    
    require(["jquery-2.1.1"],function(){
 	   require(["bootstrap.min"], function() {
 		   require(["publics/js/code/highlight.pack.js"], function(){
 			   require(["publics/js/code/code.js"], function(){
 			   })
 		   })
 	   })
    })
    
    </script>
  </body>
</html>
