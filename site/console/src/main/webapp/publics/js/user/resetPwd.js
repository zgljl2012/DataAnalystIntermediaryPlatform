
var global = {};

$(function(){
	global.oldPwdPass = false;
});

/**
 * 用于登录时调用的Js函数
 */
function validate(form) {
	if(checkOldPwd()&&checkPwd()&&global.oldPwdPass) {
		return true;
	}
	return false;
}

/**
 * 验证密码
 */
function checkOldPwd() {
	var pwd = $("input[name='old_password']").val();
	var p = $("input[name='old_password']").nextAll("p");
	if(pwd == "") {
		p.html("请输入原密码");
		return false;
	}
	$.ajax({
		url:resetPwdUrl,
		data:{"type":"oldPwd","oldPwd":pwd},
		type:"post",
		success:function(data) {
			data = eval('('+data+')');
			if(data.success == "false") {
				p.html("原密码错误");
				global.oldPwdPass = false;
			} else {
				p.html("");
				global.oldPwdPass = true;
			}
		},error:function() {
			showAlert("网络连接出错，请刷新重试！");
		}
		
	})
	return global.oldPwdPass;
}

/**
 * 验证密码
 */
function checkPwd() {
	// 验证密码
	var pwd = $("input[name='new_password']").val();
	var p = $("input[name='new_password']").nextAll("p");
	if(pwd == "") {
		p.html("请输入新密码");
		return false;
	} else {
		if(!regPwd.test(pwd)) {
			p.html("新密码不符合规则");
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
	var pwd = $("input[name='new_password']").val();
	var rePwd = $("input[name='re_password']").val();
	var p = $("input[name='re_password']").nextAll("p");
	console.log(pwd);
	console.log(rePwd);
	if(rePwd != pwd) {
		p.html("两次密码输入不一致！");
		return false;
	} else {
		p.html("");
	}
	return true;
}
