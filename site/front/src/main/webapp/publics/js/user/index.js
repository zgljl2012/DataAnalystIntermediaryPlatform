
$(function(){
	//初始化日期控件
	$('#startDate').datetimepicker({  
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
});



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
	var a = e.nextAll("a");
	if(a.html() == a_hint1) {
		e.removeAttr("disabled");
		a.html(a_hint2);
	} else {
		e.attr("disabled","disabled");
		a.html(a_hint1);
		if(callback) {
			callback.apply([],[]);
		}
	}
}

/**
 * 修改用户名
 */
function updateUsername() {
	console.log("修改用户名");
}

/**
 * 编辑真实姓名
 */
function updateRealname() {
	console.log("真实姓名");
}

/**
 * 修改邮箱
 */
function updateEmail() {
	console.log("邮箱");
}

/**
 * 修改性别
 */
function updateGender(){
	console.log("性别");
}

/**
 * 修改出生日期
 */
function updateDate() {
	
}