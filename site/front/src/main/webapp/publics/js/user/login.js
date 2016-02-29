/**
 * 用于登录时调用的Js函数
 */
function validate(form) {
	if(checkUsername()&&checkPwd()&&checkVerifyCode()) {
		return true;
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
		p.html("");
	}
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
