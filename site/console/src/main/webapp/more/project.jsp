<%@page language="java" contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html lang="zh">
  <head>
	<%@include file="/include/meta.jsp" %>

    <title>首页-<%=variableManage.getValue(SystemVariable.SITENAME) %></title>

    <%@include file="/include/style.jsp" %>
    
    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="publics/js/ie-emulation-modes-warning.js"></script>
    
    
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <script type="text/javascript" src="publics/js/jquery.min.js"></script>
	<script type="text/javascript" src="publics/js/bootstrap.min.js"></script>
    
    <%
    	headerPage = "PROJECT";
    %>
  </head>

  <body>
  	
    <!--导航栏-->
    <%@include file="/include/header.jsp" %>
    <div class="container">
    <div class="panel panel-default">
    	<div class="panel-heading">项目管理</div>
    	<div class="panel-body">
    	<ul id="myTab" class="nav nav-tabs">
		   <li class="active">
		      <a href="#dsh_project" data-toggle="tab">
		                     待审核项目
		      </a>
		   </li>
		   <li role="presentation" class="dropdown">
		    <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
		      项目管理 <span class="caret"></span>
		    </a>
		    <ul class="dropdown-menu">
		      <li><a href="#running_project" data-toggle="tab">进行中项目 </a></li>
			   <li><a href="#bidding_project" data-toggle="tab">已发布项目 </a></li>
			   <li><a href="#finished_project" data-toggle="tab">已完成项目 </a></li>
		    </ul>
		  </li>
		</ul>
		<div class="tab-content">
			<div id="dsh_project" class="tab-pane in active">
				<%@include file="/include/project/dshProject.jsp" %>
			</div>
			<div id="running_project" class="tab-pane fade" >
				<%@include file="/include/project/jxzProject.jsp" %>
			</div>
			<div id="bidding_project" class="tab-pane fade" >
				<%@include file="/include/project/tbzProject.jsp" %>
			</div>
			<div id="finished_project" class="tab-pane fade" >
				<%@include file="/include/project/yjsProject.jsp" %>
			</div>
		
		</div>
		</div>
    </div>
    </div>
    
   <!--底部导航栏-->
   <%@include file="/include/footer.jsp" %>
    
  </body>
</html>
