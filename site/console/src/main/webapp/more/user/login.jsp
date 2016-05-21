<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page import="com.zgljl2012.framework.util.StringHelper" %>
<!DOCTYPE html>
<html lang="zh">
<head>
<title>登录-<%=variableManage.getValue(SystemVariable.SITENAME) %></title>
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
<%
	if(ljlSession != null) {
		if(ljlSession.isLogined()) {
			controller.redirect(response, "index.jsp");
		}
	}
	headerPage="LOGIN";// 验证码图片链接
	String verifyCodeLink = 
		"/console/verifyCode?createTypeFlag=l&width=120&height=30&count="
		+ variableManage.getValue(SystemVariable.VERIFYCODE_LENGTH);
	String username = (String)request.getAttribute("username");
	String hint = (String)request.getAttribute("hint");
	boolean isFirst = false;
	if(StringHelper.isEmpty(username)||StringHelper.isEmpty(hint)) {
		isFirst = true;
	}
%>
</head>
<body>
	<!--导航栏-->
    <%@include file="/include/header.jsp" %>
    <div class="container">
    	<div class="panel panel-default">
    	<div class="panel-heading">用户登录</div>
    	<div class="panel-body">
    	<form action="/console/login" method="post" onsubmit="return validate(this)">
    		<div class="row tc">
    			<div class="col-sm-2">&nbsp;</div>
    			<div class="col-sm-2 tr">
    				<span class="red">*</span>
    				<span class="mr5">用户名:</span>
    			</div>
    			<div class="col-sm-6 tl">
    				<input type="text" name="username" maxlength="18" placeholder="用户名/邮箱" onblur="checkUsername()"/>
    				<p error class="red"></p>
    			</div>
    		</div>
    		<div class="row tc mt10">
    			<div class="col-sm-2">&nbsp;</div>
    			<div class="col-sm-2 tr">
    				<span class="red">*</span>
    				<span class="mr5">密码:</span>
    			</div>
    			<div class="col-sm-6 tl">
    				<input type="password" name="password" maxlength="18" placeholder="密码" onblur="checkPwd()"/>
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
    				<input type="submit" value="登录" class="btn btn-primary"/>
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
   <script type="text/javascript" src="publics/js/user/login.js"></script>
   <script>
   
   // 更换验证码
   function changeVerifyCode() {
	   $("img[name='verifyCodeImg']").attr("src", "<%=verifyCodeLink%>&date="+new Date());
   }
   
   // 初始化
   $(function() {
       var username = '<%=username%>';
       var hint='<%=hint%>'
       var isFirst = <%=isFirst%>
       if(!isFirst) {
    	   $("input[name='username']").val(username);
    	   $("#modalTitle").html("温馨提示");
   		   $("#modalBody").html(hint);
   		   $("#modalOk").click(function(){});
   		   $("#modalDialog").modal("show");
       }
   });
   
   </script>
</body>
</html>