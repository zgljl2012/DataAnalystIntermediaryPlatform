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
<link href="publics/css/plugins/date/bootstrap-datetimepicker.min.css" rel="stylesheet"/>

<link rel="stylesheet" type="text/css" href="publics/css/zg-common.css">
<link rel="stylesheet" type="text/css" href="publics/css/plugins/star/star-rating.min.css">
<%
	headerPage="USER_CENTER";
%>
</head>
<body>
	<!--导航栏-->
	<%@include file="/include/validate.jsp" %>
    <%@include file="/include/header.jsp" %>
    <div class="container">
    <div class="row">
    <div class="panel panel-default">
    	<div class="panel-heading">编辑项目</div>
    	<div class="panel-body">
    	<div id="toubiao"></div>
    <div class="container">
	<form action="" method="post" onsubmit="return doc.onNewProject(this, true)">
	<input name="projectId" class="display_none" value='${data.get("t40").get("F01") }'>
	<div class="row mt20 tc">
		<div class="col-sm-1"></div>
		<div class="col-sm-2 tc">
			<span class="fr">项目名称：</span>
			<span class="red fr lh15">*</span>
			
		</div>
		<div class="col-sm-2 tc">
			<input style="width:100%;" value='${data.get("t40").get("F02") }' class="m-input-form-control" name="projectName" type="text" placeholder="字数大于4少于20" maxlength=20 onblur="doc.checkProjectName(this)">
			<span error class="display_none red fl"></span>
		</div>
		<div class="col-sm-2 tc">
			<span class="fr">意向价格：</span>
		</div>
		<div class="col-sm-3">
			<input style="width:80%;"  value='${data.get("t40").get("F03") }' class="fl m-input-form-control" name="willPrice" type="text" placeholder="可选面议" maxlength=10 onblur="doc.checkWillPrice(this);">
			<span class="fl ml5"><input type="checkbox" checked >面议</span>
			<span error class="display_none red fl"></span>
		</div>
		<div class="col-sm-2"></div>
	</div>
	<div class="row mt20 tc">
		<div class="col-sm-1"></div>
		<div class="col-sm-2 tc">
			<span class="fr">招标天数：</span>
			<span class="red fr lh15">*</span>
		</div>
		<div class="col-sm-2 tc">
			<input style="width:100%;" value="${data.get("t40").get("F17") }" class="m-input-form-control" name="bidDays" type="text" placeholder="请输入招标天数" maxlength=10 onblur="doc.checkBidDays(this)">
			<span error class="display_none red fl"></span>
		</div>
		<div class="col-sm-2 tc">
			<span class="fr">希望完成时间：</span>
			<span class="red fr lh15">*</span>
		</div>
		<div class="col-sm-3">
			<input style="width:80%;" value='${data.get("t40").get("F12") }' readonly date type="text" name="timeLimit" 
			class="fl m-input-form-control" placeholder="请输入希望完成日期" 
			maxlength=10 onblur="doc.checkTimeLimit(this, true)"
			onchange="doc.checkTimeLimit(this, true)"
			>
			<span error class="display_none red fl"></span>
		</div>
		<div class="col-sm-2"></div>
	</div>
	<hr>
	<div class="row tc mt10">
		<div class="col-sm-12 tc">
			<span class="red lh15">*</span>
			<span class="fs12">项目描述</span><br>
		    <textarea name="projectDescription" class="mt10" placeholder="请输入项目描述（不少于10字，少于500字）" 
		    	class="form-control m-input-form-control" rows="8" cols="80"
		    	onblur="doc.checkProjectDescription(this)"
		   >${data.get("t40").get("F13") }</textarea><br>
		   <span error class="display_none red"></span>
		</div>
	</div>
	<hr>
	<div class="row tc mt10">
		<input type="submit" class="btn btn-primary"  value="提交">
	</div>
	</form>
</div>
    </div></div></div></div>
    <!--底部导航栏-->
   <%@include file="/include/footer.jsp" %>
   <%--对话框 --%>
   <%@include file="/include/dialog.jsp" %>
  	<%@include file="/include/star.jsp" %>
   <script>
   function goToTopXX(obj){
	    var _targetTop = $('#'+obj).offset().top;//获取位置
	    jQuery("html,body").animate({scrollTop:_targetTop},300);//跳转
	}
   var doc = {};
   require(["jquery-2.1.1"], function() {
	   require(["bootstrap"], function() {
		   require(["publics/js/plugins/date/bootstrap-datetimepicker.min.js"],function(){
			   require(["publics/js/plugins/date/bootstrap-datetimepicker.zh-CN.js"], 
					   function(){
				   require(["user/project/newProject","dialog"], function(_doc, dialog){
					   var data = eval('('+'${data}'+')');
					   doc = _doc;
					   console.log(data);
					   if(data.t40.F03 == 0.0) {
							$("#mianyi").html("面议"); 
					   }
				   });
				})
		   })
	   });
   });
   </script>
</body>
</html>