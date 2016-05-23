<%@page language="java" contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html lang="zh">
  <head>
	<%@include file="/include/meta.jsp" %>

    <title>用户管理-<%=variableManage.getValue(SystemVariable.SITENAME) %></title>

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
	<%@include file="/include/validate.jsp" %>
  <body>
  	
    <!--导航栏-->
    <%@include file="/include/header.jsp" %>
    <div class="container">
    <div class="panel panel-default">
    	<div class="panel-heading">用户管理</div>
    	<div class="panel-body">
    	<ul id="myTab" class="nav nav-tabs">
		   <li class="active"><a href="#front_user" data-toggle="tab">用户管理</a></li>
		   <li><a href="#console_user" data-toggle="tab">管理员</a></li>
		   <li><a href="#console_user_group" data-toggle="tab">管理员组</a></li>
		</ul>
		<div id="userTab" class="tab-content">
			<div id="front_user" class="tab-pane fade in active">
				<%@include file="/include/user/frontUser.jsp" %>
			</div>
			<div id="console_user" class="tab-pane fade">
				<%@include file="/include/user/consoleUser.jsp" %>
			</div>
			<div id="console_user_group" class="tab-pane fade">
				<%@include file="/include/user/consoleUserGroup.jsp" %>
			</div>
		</div>
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
