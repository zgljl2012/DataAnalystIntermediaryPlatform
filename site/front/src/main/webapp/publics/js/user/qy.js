var global = {};

$(function() {
	global.map={};
	// 初始化数据
	initItem("username");
	initItem("email");
	initItem("companyName");
	initItem("business");
	initItem("remark");
	initItem("status");
});

function initItem(name) {
	var value = $("input[name="+name+"]").val();
	global.map[name] = value;
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
	var a = e.nextAll("a[edit]");
	if(name=="personalIntroduce") {
		e = $("textarea[name="+name+"]");
		a = e.parent().prev().children("a[edit]");
	}
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
					url:qyUpdateInfoUrl,
					data:{name:name, value:e.val()},
					success:function(data) {
						data = eval('('+data+')');
						showAlert(data.msg);
						if(data.success == "true") {
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
 * 企业取消按钮
 * @param name
 * @param a_hint1
 */
function cancel(name, a_hint1) {
	var e = $("input[name="+name+"]");
	var a = e.nextAll("a[edit]");
	if(name=="personalIntroduce") {
		e = $("textarea[name="+name+"]");
		a = e.parent().prev().children("a[edit]");
	}
	if(global.map != null) {
		if(global.map[name] != null) {
			e.val(global.map[name]);
		}
	}
	e.attr("disabled","disabled");
	a.html(a_hint1);
	// 去掉取消按钮
	var c = a.nextAll("a[cancel]");
	if(c.length) {
		c.remove();
	}
}

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

function updateEmail() {
	if(global.map.status == "WJH") {
		showAlert("当前邮箱处于未激活状态，不允许修改，请您尽快激活邮箱");
		return false;
	}
	return true;
}

function updateCompanyName() {
	return false;
}

