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
			<div id="loading" class="row tc">
				<img src="publics/images/loadingBig.gif"></img>
			</div>
			
			
			<div class="container" id="target">
				<div class="row">
				<div class="col-sm-3">
					<span><input type="checkbox" name="select_all" value="0" class="cp" onchange="selectAll(this)"></span>
					<span>全选</span>
					<span class="ml10"><a onclick="del()" class="cp">删除</a></span>
					<span>
						<select name="readed" class="ml20" onchange="changeReaded(this)">
							<option value="all">全部消息</option>
							<option value="readed">已读消息</option>
							<option value="unreaded">未读消息</option>
						</select>
					</span>
				</div>
				</div>
				<br>
				<div id="noDataHint" class="row tc orange fs15 mt10 display_none">暂无数据</div>
				<script id="tmpl" type="text/x-jquery-tmpl">
				{{each(i, d) data}}
                {{if d!=null }}
				<div class="row mtr">
				<div class="row mtr-item" onclick="show(this, {{= id}}, '{{= readed}}')">
				<div class="col-sm-3">
					<span><input type="checkbox" name="lid" value="{{= id}}"></span>
				</div>
				<div class="col-sm-6">
					<span {{= readed=='false'?"style=font-weight:bold;":"" }}>{{= title}}</span>
				</div>
				<div class="col-sm-3">
					<span>{{= timestamp}}</span>
				</div>
				</div>
				<div class="row display_none w90 mtr-content">
					<div class="col-sm-12">
					<pre style="background:transparent;border-color:transparent;">{{= content}}</pre></div>
				</div>
				</div>
				{{/if}}
 				{{/each}}
				</script>
			</div>
			
			<%-- 分页 --%>
			<div class="row col-sm-12 fl">
			<ul class="pagination fs08 ml30 mt10 cp" name="paging">
				<li>
					<a href="#" aria-label="Previous">
						<span aria-hidden="true">&laquo;</span>
					</a>
				</li>
				<li>
					<a href="#" aria-label="Next">
						<span aria-hidden="true">&raquo;</span>
					</a>
				</li>
			</ul>
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
		   	   $("#loading").hide();
		   	   $("ul[name=paging]").hide();
		   	   letter.load($("#tmpl"), $("#target"), function(data){
		   		   if(data==null||data.count==0||
		   				   data.data==null||data.data.length==0) {
		   			   $("#noDataHint").show();
		   			   $("ul[name=paging]").hide();
		   			   return;
		   		   }
		   		   $("#noDataHint").hide();
		   		   $("ul[name=paging]").show();
		   		   document.show = letter.show;
		   		   document.selectAll = letter.selectAll;
		   		   document.changeReaded = letter.changeReaded;
		   		   document.del = letter.del;
		   	   });
		   });
	   })
   })
   </script>
 </body>
</html>