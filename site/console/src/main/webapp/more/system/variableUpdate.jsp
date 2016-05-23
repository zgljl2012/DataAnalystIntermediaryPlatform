<%@page language="java" contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html lang="zh">
  <head>
	<%@include file="/include/meta.jsp" %>

    <title>常量配置-<%=variableManage.getValue(SystemVariable.SITENAME) %></title>

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
    	headerPage = "SYSTEM";
    %>
  </head>
<%@include file="/include/validate.jsp" %>
  <body>
  	
    <!--导航栏-->
    <%@include file="/include/header.jsp" %>
    <div class="container">
    <div class="panel panel-default">
    	<div class="panel-heading">常量配置</div>
    	<div class="panel-body">
    		<div>
    		<div>
    			<form action="variable/update" method="post">
    			<input type="text" class="display_none" name="key" value="${bean.getKey()}" >
    			<div class="red mt10">ID：<span>${bean.getKey()}</span></div>
    			<div class="mt10">名称：<span>${bean.getName()}</span></div>
    			<div class="mt10"><span>值：</span>
    			<input type="text" name="value" value="${bean.getValue()}" size="80"></div>
    			<input type="submit" class="btn btn-primary mt10"  value="提交"/>
    			</form>
    		</div>
    		</div>
    	</div>
    </div>
    </div>
    
    
   <!--底部导航栏-->
   <%@include file="/include/footer.jsp" %>
   <script>
   require(["jquery-2.1.1"],function(){
	   require(["bootstrap.min"], function() {
		   
	   })
   })
   </script>
  </body>
</html>
