
// 全局变量
var global = new Object();

$(function(){
	if(userType == 'FXS') {
		initFxs();
	}
});

/**
 * 当用户为分析师时调用此初始化
 */
function initFxs() {
	//初始化日期控件
	$('#bornDate').datetimepicker({  
	    language:  'zh-CN',  
	    weekStart: 1,  
	    todayBtn:  1,  
	    autoclose: 1,  
	    todayHighlight: 1,  
	    startView: 2,  
	    minView: 2,  
	    forceParse: 0,
	    format:"yyyy-mm-dd"
	});
	
	// 初始化数据
	$.ajax({
		type:"get",
		url:fxsBaseInfoUrl,
		success:function(data){
			data = eval('('+data+')');
			$("input[name='username']").val(data.t10.F02);
			$("input[name='realName']").val(data.t20.F02);
			$("input[name='bornDate']").val(data.t20.F04);
			$("input[name='email']").val(data.t10.F03);
			$("select[name='gender']").val(data.t20.F03);
			// 初始化
			global.map = [];
			global.map["username"] = $("input[name='username']").val();
			global.map["realName"] = $("input[name='realName']").val();
			global.map["bornDate"] = $("input[name='bornDate']").val();
			global.map["gender"] = $("select[name='gender']").val();
			global.map["email"] = $("input[name='email']").val();
			// 设置用户状态
			global.userStatus = data.t10.F08; 
		},
		error:function(err) {
			console.log(err);
			showAlert("网络连接出错！请刷新重试！");
		}
	});
}

/**
 * 使一个input变成可编辑的
 * @param name input的name
 * @param a_hint1 标签a的提示1
 * @param a_hint2 标签a的提示2
 * @param callback 完成后的回调函数
 */
function edit(name, a_hint1, a_hint2, callback) {
	var e = $("input[name="+name+"]");
	if(name=="gender") {
		e = $("select[name="+name+"]")
	}
	var a = e.nextAll("a[edit]");
	if(a.html() == a_hint1) {
		e.removeAttr("disabled");
		a.html(a_hint2);
		// 追加一个取消按钮
		if(!a.nextAll("a[cancel]").length) {
			a.after("<a class='cp ml5' cancel onclick=cancel(\'"+name+"\',\'"+a_hint1+"\')>取消</a>")
		}
	} else {
		if(callback) {
			if(callback.apply([],[])){
				// 使用ajax传回后台更新
				$.ajax({
					type:"post",
					url:fxsBaseInfoUpdateUrl,
					data:{name:name, value:e.val()},
					success:function(data) {
						data = eval('('+data+')');
						showAlert(data.description);
						if(data.status == 1) {
							global.map[name] = e.val();
							e.attr("disabled","disabled");
							a.html(a_hint1);
							// 去掉取消按钮
							if(a.nextAll("a[cancel]").length) {
								a.nextAll("a[cancel]").remove();
							}
						}
					},
					error:function(err) {
						showAlert("网络连接出错！请刷新重试！");
					}
				});
			}
		}
	}
}

/**
 * 分析师取消按钮
 * @param name
 * @param a_hint1
 */
function cancel(name, a_hint1) {
	var e = $("input[name="+name+"]");
	if(name=="gender") {
		e = $("select[name="+name+"]")
	}
	e.val(global.map[name]);
	e.attr("disabled","disabled");
	var a = e.nextAll("a[edit]");
	a.html(a_hint1);
	// 去掉取消按钮
	var c = a.nextAll("a[cancel]");
	if(c.length) {
		c.remove();
	}
}

/**
 * 修改用户名
 */
function updateUsername() {
	var username = $("input[name='username']").val();
	if(username == "") {
		showAlert("请输入用户名");
		return false;
	} else {
		if(!regUsername.test(username)) {
			showAlert("用户名不符合规则，使用字母、数字、下划线，6-18位且以字母开头");
			return false;
		}
	}
	return true;
}

/**
 * 编辑真实姓名
 */
function updateRealname() {
	return true;
}

/**
 * 修改邮箱
 */
function updateEmail() {
	if(global.userStatus == "WJH") {
		showAlert("此邮箱尚未激活！不允许修改");
		return false;
	}
	showDialog("更改邮箱提示","修改邮箱会让用户状态变为未激活，" +
		"在邮箱验证后才能激活用户，在此之前，" +
		"不能进行投标操作。确定进行邮箱修改？", 
		function() {
			
	});
	return false;
}

/**
 * 修改性别
 */
function updateGender(){
	return true;
}

/**
 * 修改出生日期
 */
function updateDate() {
	return true;
}