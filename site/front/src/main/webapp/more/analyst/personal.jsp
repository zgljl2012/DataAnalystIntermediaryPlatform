<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page import="com.zgljl2012.common.database.enums.Gender" %>
<!DOCTYPE html>
<html lang="zh">
<head>
<title>个人主页-<%=variableManage.getValue(SystemVariable.SITENAME) %></title>
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
	headerPage="FXSSC";
%>
</head>
<body>
	<!--导航栏-->
    <%@include file="/include/header.jsp" %>
    <div class="container">
    <div class="row">
    <div class="panel panel-default">
    	<div class="panel-heading">${data.get("t10").get("F02")}&nbsp;&nbsp;的个人主页</div>
    	<div class="panel-body">
    <div id="fxsInfo" class="tab-content">
   <div class="tab-pane fade in active" id="baseInfo">
      <div class="row mt20">
      	<div class="col-sm-2">
      		<img src="publics/images/noface.gif" width="150" height="150" class="display_block cp border_eee" name="headImg"/>
      	</div>
      	<div class="col-sm-10">
      		<div class="row mt20">
      			<div class="col-sm-5">
      				<span>用&nbsp;&nbsp;户&nbsp;&nbsp;名:</span>
      				<input class="m-input-form-control" type="text" name="username" value="${data.get("t10").get("F02")}" maxlength="18" disabled/>
      			</div>
      			<div class="col-sm-5">
      				<span>真实姓名:</span>
      				<input class="m-input-form-control" type="text" name="realName" value="${data.get("t20").get("F02")}" maxlength="18" disabled/>
      			</div>
      		</div>
      		<div class="row mt25">
      			<div class="col-sm-5">
      				<span>邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱:</span>
      				<input class="m-input-form-control" type="text" name="email" value="${data.get("t10").get("F03")}" maxlength="18" disabled/>
      			</div>
      			<div class="col-sm-5">
      				<span>出生日期:</span>
      				<input class="m-input-form-control" id="bornDate" readonly disabled class="dateTime" type="text" name="bornDate" value="${data.get("t20").get("F04")}">
      			</div>
      		</div>
      		<div class="row mt20">
      			<div class="col-sm-5 fl">
      				<span>性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别:</span>
      				<select class="m-input-form-control" name="gender" value='${data.get("t20").get("F03")}' disabled>
      					<option value="BM">保密</option>
      					<option value="NAN">男</option>
      					<option value="NV">女</option>
      				</select>
      			</div>
      			<div class="col-sm-5 fl">
      				<span>学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;历:</span>
      				<select name="degree" class="m-input-form-control" value='${data.get("t20").get("F10")}' disabled placeholder="学历">
      					<option value="DZ">大专</option>
      					<option value="BK">本科</option>
      					<option value="SS">硕士</option>
      					<option value="BS">博士</option>
      					<option value="BSH">博士后</option>
      					<option value="QT">其它</option>
      				</select>
      			</div>
      		</div>
      		<div class="row mt20">
      			<div class="col-sm-10">
	      			<span>毕业院校:</span>
	      			<input class="m-input-form-control" type="text" name="school" value='${data.get("t20").get("F07")}' maxlength="40" style="width:78.9%" disabled/>
      			</div>
      		</div>
      		
      		<div class="row mt20">
      			<div class="col-sm-5 fl">
      				<span>毕业时间:</span>
      				<input class="m-input-form-control" readonly disabled class="dateTime" type="text" name="employDate" value='${data.get("t20").get("F06") }'>
      			</div>
      		</div>
      	</div>
      </div>
      <hr>
      <div class="row">
      	<div class="row tc">
      		<span class="fs15 ml10 gray">个人简介</span>
      	</div>
      	<div class="row mt10 tc">
      		<textarea class="m-input-form-control"  
      		disabled name="personalIntroduce" style="width:75%;height:180px;" 
      		placeholder="请您对自己作一个简单的介绍，100字左右" maxlength=250>
      			${data.get("t20").get("F05") }
      		</textarea>
      	</div>
      </div>
      <hr>
      <div class="row">
      	<div class="row tc">
      		<span class="fs15 ml10 gray">从业经历</span>
      	</div>
      	<div class="row mt10 tc">
      		<span class="gray">当前公司:</span>
	      	<input class="m-input-form-control"  placeholder="可填写自由职业" type="text" name="commany" value='${data.get("t20").get("F08") }' maxlength="60" style="width:70.8%;" disabled/>
      	</div>
      	</div>
      </div>
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
   var data = eval('('+'${data}'+')');
   if(data.t20.F09) {
	   $("img[name=headImg]").attr("src","/front/uploadHeadImage?filePath="+data.t20.F09);
   }
   </script>
</body>
</html>