<%@page language="java" contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html lang="zh">
  <head>
	<%@include file="/include/meta.jsp" %>

    <title>宣传管理-<%=variableManage.getValue(SystemVariable.SITENAME) %></title>

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
    	headerPage = "COMPAIGN";
    %>
  </head>
<%@include file="/include/validate.jsp" %>
  <body>
  	
    <!--导航栏-->
    <%@include file="/include/header.jsp" %>
    <div class="container">
    <div class="panel panel-default">
    	<div class="panel-heading">宣传管理</div>
    	<div class="panel-body">
    	<ul id="myTab" class="nav nav-tabs">
		   <li class="active">
		      <a href="#letter" data-toggle="tab">
		                     发送站内信
		      </a>
		   </li>
		   <li>
		   	  <a href="#adv" data-toggle="tab">
		                     广告管理
		      </a>
		   </li>
		</ul>
		<div class="tab-content">
			<div id="letter" class="tab-pane in active">
			<form action="sendLetter" method="post">
				<br>
				<input name="username" placeholder="请输入收信人用户名" type="text" required>
				<input name="title" placeholder="请输入站内信标题" type="text" required>
				<textarea class="mt10" rows="5" cols="120" name="content" placeholder="请输入站内信内容" required></textarea>
				<br>
				<input type="submit" class="button btn-primary mt10" value="发送">
			</form>
			</div>
			<div id="adv" class="tab-pane in">
				<%@include file="/include/system/ad.jsp" %>
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
