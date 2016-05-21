<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page import="com.zgljl2012.framework.util.StringHelper" %>
<!DOCTYPE html>
<html lang="zh">
<head>
<title>修改密码-<%=variableManage.getValue(SystemVariable.SITENAME) %></title>
<%@include file="/include/meta.jsp" %>
<!-- Bootstrap core CSS -->
<link href="publics/css/bootstrap.min.css" rel="stylesheet">

<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<link href="publics/css/ie10-viewport-bug-workaround.css" rel="stylesheet">
<link href="publics/css/offcanvas.css" rel="stylesheet">
<link href="publics/css/app.css" rel="stylesheet"/>
<link href="publics/css/zg-common.css" rel="stylesheet"/>
<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
<!--[if lt IE 9]><script src="js/ie8-responsive-file-warning.js"></script><![endif]-->
<script src="publics/js/ie-emulation-modes-warning.js"></script>
  
<script type="text/javascript" src="publics/js/jquery.min.js"></script>
<script type="text/javascript" src="publics/js/bootstrap.min.js"></script>
<%--验证用户有没有登录 --%>
<%@include file="/include/validate.jsp" %>
<%
	headerPage = "USER_CENTER";
	String verifyCodeLink = 
		"/console/verifyCode?createcreateTypeFlag=n&width=120&height=30&count="
		+ variableManage.getValue(SystemVariable.VERIFYCODE_LENGTH);	
	Object success = request.getAttribute("success");
	System.out.println(success);
	if(success != null) {
		request.setAttribute("first", false);
	} else {
		request.setAttribute("first", true);
	}
%>
</head>
<body>
	<!--导航栏-->
    <%@include file="/include/header.jsp" %>
    <div class="container">
    	<div class="panel panel-default">
    	<div class="panel-heading">修改密码</div>
    	<div class="panel-body">
    	<form action="/console/user/resetPwd" method="post" onsubmit="return validate(this)">
    		<div class="row tc">
    			<div class="col-sm-2">&nbsp;</div>
    			<div class="col-sm-2 tr">
    				<span class="red">*</span>
    				<span class="mr5">原密码:</span>
    			</div>
    			<div class="col-sm-6 tl">
    				<input type="password" name="old_password" maxlength="18" placeholder="原密码" onblur="checkOldPwd()"/>
    				<p error class="red"></p>
    			</div>
    		</div>
    		<div class="row tc mt10">
    			<div class="col-sm-2">&nbsp;</div>
    			<div class="col-sm-2 tr">
    				<span class="red">*</span>
    				<span class="mr5">新密码:</span>
    			</div>
    			<div class="col-sm-6 tl">
    				<input type="password" name="new_password" maxlength="18" placeholder="新密码" onblur="checkPwd()"/>
    				<p error class="red"></p>
    			</div>
    		</div>
    		<div class="row tc mt10">
    			<div class="col-sm-2">&nbsp;</div>
    			<div class="col-sm-2 tr">
    				<span class="red">*</span>
    				<span class="mr5">确认密码:</span>
    			</div>
    			<div class="col-sm-6 tl">
    				<input type="password" name="re_password" maxlength="18" placeholder="确认密码" onblur="checkRePwd()"/>
    				<p error class="red"></p>
    			</div>
    		</div>
    		<div class="row tc mt10">
    			<div class="col-sm-2">&nbsp;</div>
    			<div class="col-sm-2 tr">
    				<span class="red">*</span>
    				<span class="mr5">验证码</span>
    			</div>
    			<div class="col-sm-6 tl">
    				<input type="text" name="verifyCode" value="" 
    					maxlength="<%=variableManage.getValue(SystemVariable.VERIFYCODE_LENGTH)%>"
    					onblur="checkVerifyCode()"
    					placeholder="验证码"/>
    				<img name="verifyCodeImg" alt="换一张" src=
    					"<%=verifyCodeLink%>"
    					onclick="changeVerifyCode()"
    					/>
    				<a onclick="changeVerifyCode()" class="cp">看不清楚？换一张</a>
    				<p error class="red"></p>
    			</div>
    		</div>
    		<div class="row tc mt20">
    			<div class="col-sm-9 tc">
    				<input type="submit" value="确定" class="btn btn-primary"/>
    			</div>
    		</div>
    		</form>
    	</div>
    	</div>
    </div>
    <%--对话框 --%>
    <%@include file="/include/dialog.jsp" %>
    <%--底部导航栏--%>
   <%@include file="/include/footer.jsp" %>
   <script type="text/javascript" src="publics/js/common/dialog.js"></script>
   <script>
   <%--密码验证正则表达式--%>
   var regPwd = /^(?![a-zA-Z0-9]+$)(?![^a-zA-Z/D]+$)(?![^0-9/D]+$).{6,18}$/;
   var resetPwdUrl = "/console/user/resetPwd";
   if("${first}" == "false") {
	   if("${success}" == "false") {
		   showAlert("${description}");
	   } else {
		   showDialog("${description}", function() {
			  window.location.href="/console/user"; 
		   });
	   }
   }
   // 更换验证码
   function changeVerifyCode() {
	   $("img[name='verifyCodeImg']").attr("src", "<%=verifyCodeLink%>&date="+new Date());
   }
   </script>
   <script type="text/javascript" src="publics/js/user/resetPwd.js"></script>
</body>
</html>