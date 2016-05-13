<%@page language="java" contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html lang="zh">
  <head>
	<%@include file="/include/meta.jsp" %>

    <title>系统管理-<%=variableManage.getValue(SystemVariable.SITENAME) %></title>

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

  <body>
  	
    <!--导航栏-->
    <%@include file="/include/header.jsp" %>
    <div class="container">
    <div class="panel panel-default">
    	<div class="panel-heading">系统管理</div>
    	<div class="panel-body">
    	<ul id="myTab" class="nav nav-tabs">
		   <li class="active">
		      <a href="#variable" data-toggle="tab">
		                     常量配置
		      </a>
		   </li>
		</ul>
		<div class="tab-content">
			<div id="variable" class="tab-pane in active">
				<div id="loading" class="row tc">
					<img src="publics/images/loadingBig.gif"></img>
				</div>
				<div class="row">
				<table class="table table-hover" id="tmplTable" style="width:95%;">
					<tr>
						<th>ID</th>
						<th>名字</th>
						<th>值</th>
						<th>操作</th>
					</tr>
					<script id="tmplData" type="text/x-jquery-tmpl">
				{{each(i, d) data}}
				{{if d!=null}}
				<tr>
					<td>{{= d.key}}</td>
					<td>{{= d.name}}</td>
					<td>{{= d.value}}</td>
					<td class="cp"><a href="variable/update?key={{= d.key}}">修改</a></td>
				</tr>
				{{/if}}
				{{/each}}
				</script>
				</table>
				</div>
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
		   require(["system/variable"],function(va){
			   va.list(function(data) {
				   $("#loading").hide();
				   va.tmpl(data, $("#tmplData"), $("#tmplTable"));
			   });
		   })
	   })
   })
   </script>
  </body>
</html>
