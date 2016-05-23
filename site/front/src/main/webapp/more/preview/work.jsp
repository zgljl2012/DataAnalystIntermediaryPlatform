<%@page language="java" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html lang="zh">
  <head>
	<%@include file="/include/meta.jsp" %>
    <title>Python-<%=variableManage.getValue(SystemVariable.SITENAME) %></title>
    <link href="publics/css/bootstrap.min.css" rel="stylesheet">
    <link href="publics/css/zg-common.css" rel="stylesheet"/>
    <script src="publics/js/plugins/require/require.min.js" data-main="publics/js/main.js"></script>
  </head>
  <body>
  	<nav class="navbar navbar-inverse" role="navigation">
  	<div class="container mt10 white">
    	在线Python解释器
  	</div>
	</nav>
	<div class="container">
    <div class="row">
 		<div class="col-sm-6">
 		<iframe src="code/python" width="100%" height="100%"></iframe>
    	</div>
    	<div class="col-sm-6">
    	<iframe src="preview?filePath=${filePath}" width="100%" height="100%"></iframe>
    	</div>
    </div>
    </div>
    <script type="text/javascript">
    require(["jquery-2.1.1"],function(){
 	   require(["bootstrap.min"], function() {
 	       
 	   })
    })
    
    </script>
  </body>
</html>
