
/**
 * 用于注册时调用的Js函数
 */
function validate(form) {
	
	if(checkUsername()&&checkVerifyCode()&&checkEmail()
			&&checkPwd()&&checkRePwd()&&checkUserType()) {
		var p = $("input[name='username']").nextAll("p");
		if(!isUsernameOk) {
			p.html("用户名已被占用，请重新输入");
			return false;
		} else {
			p.html("");
		}
		var p = $("input[name='email']").nextAll("p");
		if(!isEmailOk) {
			p.html("此邮箱已被注册，请重新输入");
			return false;
		} else {
			p.html("");
		}
		// 弹出对话框询问用户是否确定选择企业或分析师
		var userType = $("input[name='userType']:checked").val();
		userType = "QY" == userType ? "企业" : "分析师";
		$("#modalTitle").html("温馨提示");
		$("#modalBody").html("用户类型一旦设定将不得更改，您目前选择的是<span class='red fs12'>"
				+userType+"</span>，确定不再更改？");
		var tmpForm = form;
		$("#modalOk").click(function(){
			tmpForm.submit();// 提交表单
		});
		$("#modalDialog").modal("show");
	}
	return false;
}

/**
 * 验证用户名是否已存在
 */
function checkUsername() {
	// 验证用户名
	var username = $("input[name='username']").val();
	var p = $("input[name='username']").nextAll("p");
	if(username == "") {
		p.html("请输入用户名");
		return false;
	} else {
		if(!regUsername.test(username)) {
			p.html("用户名不符合规则");
			return false;
		} else {
			p.html("");
		}
	}
	if(!isUsernameOk)
	$.ajax({
		url:checkUsernameUrl,
		data:{username:username},
		success:function(data) {
			data = eval('('+data+')');
			var p = $("input[name='username']").nextAll("p");
			if(data.result == 0) {
				isUsernameOk = true;
				p.html("");
			} else {
				isUsernameOk = false;
				p.html("用户名已被占用，请重新输入");
			}
		},
		error:function(err) {
			console.log(err);
		}
	});
	return true;
}

/**
 * 验证邮箱是否已存在
 */
function checkEmail() {
	// 验证邮箱地址
	var email = $("input[name='email']").val();
	var p = $("input[name='email']").nextAll("p");
	if(email == "") {
		p.html("请输入邮箱地址");
		return false;
	} else {
		if(!regEmail.test(email)) {
			p.html("请输入正确的邮箱地址！");
			return false;
		} else {
			p.html("");
		}
	}
	if(!isEmailOk)
	$.ajax({
		url:checkEmailUrl,
		data:{email:email},
		success:function(data) {
			data = eval('('+data+')');
			var p = $("input[name='email']").nextAll("p");
			if(data.result == 0) {
				isEmailOk = true;
				p.html("");
			} else {
				isEmailOk = false;
				p.html("此邮箱已被注册，请重新输入");
			}
		},
		error:function(err) {
			console.log(err);
		}
	});
	return true;
}

/**
 * 检查验证码
 * @returns {Boolean}
 */
function checkVerifyCode() {
	// 验证是否输入了验证码
	var verifyCode = $("input[name='verifyCode']").val();
	var p = $("input[name='verifyCode']").nextAll("p");
	if(verifyCode == "") {
		p.html("请输入验证码");
		return false;
	} else {
		p.html("");
	}
	return true;
}

/**
 * 验证密码
 */
function checkPwd() {
	// 验证密码
	var pwd = $("input[name='password']").val();
	var p = $("input[name='password']").nextAll("p");
	if(pwd == "") {
		p.html("请输入密码");
		return false;
	} else {
		if(!regPwd.test(pwd)) {
			p.html("密码不符合规则");
			return false;
		} else {
			p.html("");
		}
	}
	return true;
}

/**
 * 验证确认密码
 */
function checkRePwd() {
	// 验证确认密码
	if(!checkPwd()) {return false;}
	var pwd = $("input[name='password']").val();
	var rePwd = $("input[name='repeatpwd']").val();
	var p = $("input[name='repeatpwd']").nextAll("p");
	if(rePwd != pwd) {
		p.html("两次密码输入不一致！");
		return false;
	} else {
		p.html("");
	}
	return true;
}

/**
 * 验证用户类型
 */
function checkUserType() {
	// 验证用户类型
	var userType = $("input[name='userType']:checked").val();
	var p = $("input[name='userType']").nextAll("p");
	console.log($("input[name='userType']:checked").length);
	if($("input[name='userType']:checked").length==0||userType == "") {
		p.html("请选择您的用户类型，用户类型一旦设定将不得更改！");
		return false;
	} else {
		p.html("");
	}
	return true;
}
