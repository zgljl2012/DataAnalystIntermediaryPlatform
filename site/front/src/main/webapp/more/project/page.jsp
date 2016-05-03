<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page import="com.zgljl2012.common.database.enums.Gender" %>
<%@ page import="com.zgljl2012.modules.project.BidManage" %>
<%@ page import="com.zgljl2012.framework.util.JSON" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html lang="zh">
<head>
<title>项目主页-<%=variableManage.getValue(SystemVariable.SITENAME) %></title>
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

<link rel="stylesheet" type="text/css" href="publics/css/zg-common.css">
<script src="publics/js/jquery.min.js"></script>
<script src="publics/js/plugins/template/jquery.tmpl.min.js"></script>
<%
	headerPage="XMSC";
	BidManage bidManage = controller.getServiceManage().getService(BidManage.class);
	boolean isMatch = false;
	if(ljlSession.isLogined()) {
		isMatch = bidManage.isMatch(
			Integer.parseInt(
				(String)(((JSON)((JSON)
				request.getAttribute("data")).get("t40")).get("F01"))),
			ljlSession.getUserId());
	}
	request.setAttribute("isMatch", isMatch);
%>
</head>
<body>
	<!--导航栏-->
    <%@include file="/include/header.jsp" %>
    <div class="container">
    <div class="row">
    <div class="panel panel-default">
    	<div class="panel-heading">${data.get("t40").get("F02")}</div>
    	<div class="panel-body">
    	<div class="row">
	    	<div class="col-sm-6 fs20 ml15 mt10 orange">
	    		${data.get("t40").get("F02")}
		    	<div class="fs06 mt20 red">
		    		预算：<label id="mianyi">￥${ data.get("t40").get("F03")}元</label>
		    	</div>
		    	<div class="fs06 mt20 wh400 gray">项目描述：</div>
		    	<div class="fs06 mt5 wh400 gray">
		    	${ data.get("t40").get("F13") }
		    	</div>
	    	</div>
	    	<div class="col-sm-4 fs12 mt10">
	    	<div>期望完成时间：<span class="red">${ data.get("t40").get("F12") }</span></div>
	    		<c:choose>
	    		<c:when test='${data.get("t40").get("F05").equals("TBZ")}'>
	    			<div class="mt10">剩余天数：${data.get("t40").get("F17") }</div>
	    		</c:when>
	    		</c:choose>
	    	</div>
    	</div>
    	<hr>
    	<div class="row">
    		<div class="col-sm-12 fs12 mt5">
    			<div class="ml15">我要投标：</div>
    			<form action="" method="post">
    			<div class="ml15 mt5">
    				<textarea name="solution" cols="80" rows="6" placeholder="请输入项目需求提出您的解决方案，解决方案只有雇主可见（登录后可提交）"></textarea>
    			</div>
    			<div class="mt5 col-sm-4">
    				<input type="text" name="quote_price" class="m-input-form-control" placeholder="请输入您的报价">
    				<input type="button" id="release" value="发布" class="btn btn-primary" <%if(!ljlSession.isLogined()) out.println("disabled"); %>>
    			</div>
    			</form>
    		</div>
    	</div>
    	<hr>
    	<div class="row">
    		<table class="table table-hover" id="project-bid-table">
    		<script type="text/x-jquery-tmpl" id="project-bid-item-tmpl">
    		{{each(i, d) data}}
				{{if d!=null}}
				<tr>
					<td class="opacity-black-position">
						<div class="col-sm-12">
							<span class="lightblue fs12 col-sm-4">{{= d.username }}</span>
							<span class="col-sm-4 fr">投标时间：<label>{{= d.F05 }}</label></span>
							<span class="col-sm-3">报价：<label>{{= d.F04 }}</label>元</span>
						</div>
						<div class="col-sm-12">
							<span class="col-sm-12 fs08 gray">投标：<span>
							<div class="row">
							<pre class="col-sm-12 fs10 gray pre-comment">
								{{= d.comment }}
							</pre>
							</div>
						</div>
						<div class="display_none select-buttons tc">
   	 						<input type="button" value="中标">
   	 						<input type="button" value="删除">
   	 						<input type="button" value="私信">
   						</div>
					</td>
				</tr>
			{{/if}}
			{{/each}}
    		</script>
    		</table>
    	</div>
 </div></div></div></div>
    <!--底部导航栏-->
   <%@include file="/include/footer.jsp" %>
   <%--对话框 --%>
   <%@include file="/include/dialog.jsp" %>
   <script>
   var data = eval('('+'${data}'+')');
   if(data.t40.F03 == 0.0) {
		$("#mianyi").html("面议"); 
   }
   require(["publics/js/project/page.js","publics/js/bootstrap.min.js"], function(page){
	   var projectId = "${data.get('t40').get('F01')}";
	   page.list(projectId, function(data){
		   page.showbids(data, $("#project-bid-item-tmpl"), $("#project-bid-table"));
		   $(".opacity-black-position").mouseover(function(){
		   	   if("${isMatch}"=="true") {
		   		   $(this).find(".select-buttons").show();
		   	   }
		   });
		   $(".opacity-black-position").mouseout(function(){
		   	   if("${isMatch}"=="true") {
		   		   $(this).find(".select-buttons").hide();
		   	   }
		   });
	   });
	   $("#release").click(function(){
		  var e1 = $("textarea[name=solution]");
		  var e2 = $("input[name=quote_price]");
		  if(page.checkComment(e1)&&page.checkPrice(e2)) {
			  page.bid("${data.get('t40').get('F01')}",e2.val(), e1.val());
		  } 
	   });
   })
   </script>
</body>
</html>