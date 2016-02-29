<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html lang="zh">
<head>
<title>注册-<%=variableManage.getValue(SystemVariable.SITENAME) %></title>
<%@include file="/include/meta.jsp" %>
<!-- Bootstrap core CSS -->
<link href="publics/css/bootstrap.min.css" rel="stylesheet">

<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<link href="publics/css/ie10-viewport-bug-workaround.css" rel="stylesheet">
<link href="publics/css/offcanvas.css" rel="stylesheet">
<link href="publics/css/zg-common.css" rel="stylesheet"/>
<link href="publics/css/app.css" rel="stylesheet"/>
<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
<!--[if lt IE 9]><script src="js/ie8-responsive-file-warning.js"></script><![endif]-->
<script src="publics/js/ie-emulation-modes-warning.js"></script>
 
<script type="text/javascript" src="publics/js/jquery.min.js"></script>
<script type="text/javascript" src="publics/js/bootstrap.min.js"></script>
<%
	headerPage="REGISTER";
	// 验证码图片链接
	String verifyCodeLink = 
		"/front/verifyCode?createcreateTypeFlag=n&width=120&height=30&count="
		+ variableManage.getValue(SystemVariable.VERIFYCODE_LENGTH);
	
	String username = (String)request.getAttribute("username");
	String email = (String)request.getAttribute("email");
	String userType = (String)request.getAttribute("userType");
	String hint = (String)request.getAttribute("hint");
	boolean isFirst = false;
	if((username==null||username.trim().length()==0)||
			(email==null||email.trim().length()==0)||
			(userType==null||userType.trim().length()==0)||
			(hint==null||hint.trim().length()==0)) {
		isFirst = true;
	}
%>
</head>
<body>
	<!--导航栏-->
    <%@include file="/include/header.jsp" %>
    <div class="container">
    	<div class="panel panel-default">
    	<div class="panel-heading">用户注册</div>
    	<div class="panel-body">
    	<form action="/front/register" method="post" onsubmit="return validate(this)">
    		<div class="row tc">
    			<div class="col-sm-2">&nbsp;</div>
    			<div class="col-sm-2 tr">
    				<span class="red">*</span>
    				<span class="mr5">用户名:</span>
    			</div>
    			<div class="col-sm-6 tl">
    				<input type="text" name="username" maxlength="18" onblur="checkUsername()"/>
    				<span class="red ml10">可使用字母、数字、下划线，6-18位且以字母开头</span>
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
    				<input type="password" name="password" maxlength="18" onblur="checkPwd()"/>
    				<span class="red ml10">字母+数字+特殊符号，6-18位</span>
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
    				<input type="password" name="repeatpwd" maxlength="18" onblur="checkRePwd()"/>
    				<p error class="red"></p>
    			</div>
    		</div>
    		<div class="row tc mt10">
    			<div class="col-sm-2">&nbsp;</div>
    			<div class="col-sm-2 tr">
    				<span class="red">*</span>
    				<span class="mr5">邮箱:</span>
    			</div>
    			<div class="col-sm-6 tl">
    				<input type="text" name="email" onblur="checkEmail()"/>
    				<span class="red ml10">请输入您的常用邮箱地址</span>
    				<p error class="red"></p>
    			</div>
    		</div>
    		<div class="row tc mt10">
    			<div class="col-sm-2">&nbsp;</div>
    			<div class="col-sm-2 tr">
    				<span class="red">*</span>
    				<span class="mr5">用户类型:</span>
    			</div>
    			<div class="col-sm-6 tl">
    				<input type="radio" name="userType" value="" class="display_none"/>
    				<input type="radio" name="userType" value="QY" class="mr5"/><span class="ml5">企业</span>
    				<input type="radio" name="userType" value="FXS" class="ml10"/><span class="ml5">分析师</span>
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
    					/>
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
    				<input type="submit" value="注册" class="btn btn-primary"/>
    			</div>
    		</div>
    		</form>
    	</div>
    	</div>
    </div>
    
    <%--对话框 --%>
    <div class="modal fade" id="modalDialog" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
         <div class="modal-header">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">
                  &times;
            </button>
            <h4 class="modal-title" id="modalTitle">
               模态框（Modal）标题
            </h4>
         </div>
         <div class="modal-body" id="modalBody">
            在这里添加一些文本
         </div>
         <div class="modal-footer tc">
            <button type="button" class="btn btn-default" 
               data-dismiss="modal" id="modalCancel">取消
            </button>
            <button type="button" class="btn btn-primary" data-dismiss="modal" id="modalOk">
               	确定
            </button>
         </div>
      </div><!-- /.modal-content -->
</div></div><!-- /.modal -->
    
    <!--底部导航栏-->
   <%@include file="/include/footer.jsp" %>
   <script type="text/javascript" src="publics/js/user/register.js"></script>
   <script>
   <%--用户名验证正则表达式 --%>
   var regUsername = /^[a-zA-Z][a-zA-Z0-9_]{5,18}$/;
   <%--密码验证正则表达式--%>
   var regPwd = /^(?![a-zA-Z0-9]+$)(?![^a-zA-Z/D]+$)(?![^0-9/D]+$).{6,18}$/;
   <%--邮箱验证正则表达式--%>
   var regEmail = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/;
   <%--用户名是否可用--%>
   var isUsernameOk = false;
   var checkUsernameUrl = "/front/checkUsername";
   <%--邮箱是否可用--%>
   var isEmailOk = false;
   var checkEmailUrl = "/front/checkEmail";
   
   // 更换验证码
   function changeVerifyCode() {
	   $("img[name='verifyCodeImg']").attr("src", "<%=verifyCodeLink%>&date="+new Date());
   }
   
   // 初始化
   $(function() {
       var username = '<%=username%>';
       var email = '<%=email%>';
       var userType = '<%=userType%>';
       var hint = '<%=hint%>';
       var isFirst = <%=isFirst%>
       if(!isFirst) {
    	   $("input[name='username']").val(username);
    	   $("input[name='email']").val(email);
    	   $("input[value="+userType+"]").attr("checked", true);
    	   $("#modalTitle").html("温馨提示");
   		   $("#modalBody").html(hint);
   		   $("#modalOk").click(function(){});
   		   $("#modalDialog").modal("show");
       }
   });
   
   </script>
</body>
</html>