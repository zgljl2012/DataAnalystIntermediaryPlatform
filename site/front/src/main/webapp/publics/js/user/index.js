
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
	$('input[date]').datetimepicker({  
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
			$("textarea[name='personalIntroduce'").val(data.t20.F05);
			$("input[name='employDate']").val(data.t20.F06);
			$("input[name='commany']").val(data.t20.F08);
			$("select[name='degree']").val(data.t20.F10);
			// 设置头像
			var url = "/front/uploadHeadImage?filePath=" + data.t20.F09;
			if(data.t20.F09 != null) {
				$("img[name='headImg']").attr("src", url);
			}
			// 毕业院校
			$("input[name='school']").val(data.t20.F07);
			// 初始化
			global.map = [];
			global.map["username"] = $("input[name='username']").val()||"";
			global.map["realName"] = $("input[name='realName']").val()||"";
			global.map["bornDate"] = $("input[name='bornDate']").val()||"";
			global.map["gender"] = $("select[name='gender']").val()||"";
			global.map["email"] = $("input[name='email']").val()||"";
			global.map["school"] = $("input[name='school']").val()||"";
			global.map["personalIntroduce"] = $("textarea[name='personalIntroduce'").val()||"";
			global.map["employDate"] = $("input[name='employDate']").val()||"";
			global.map["commany"] = $("input[name='commany']").val()||"";
			global.map["degree"] = $("select[name='degree']").val() ||"";
			// 设置用户状态
			global.userStatus = data.t10.F08; 
		},
		error:function(err) {
			showAlert("网络连接出错！请刷新重试！");
		}
	});
	global.count = 0;
	global.pageSize = 0;
	global.current = 0;
	loadWorkExperience(fxsWorkExperience, 1);
	initPagingInfo();
}

/**
 * 初始化总页数和每页条数
 */
function initPagingInfo() {
	$.ajax({
		type:"GET",
		url:fxsWorkExperienceManage,
		success:function(data) {
			data = eval("("+data+")");
			global.count = data.count;
			global.pageSize = data.pageSize;
			// 进行分页
			paging();
		},
		error:function() {
			showAlert("分页信息获取失败！请刷新重试！");
		}
	});
}

/**********************************************************
 * 获取分页信息
 */
function paging() {
	var pageCount = getPageCount();
	var s = "<li><a onclick=loadWorkExperience('"+fxsWorkExperience+"',1)"+" aria-label=Previous title='首页'>"
		+"<span aria-hidden=true>&laquo;</span></a></li>";
	var left=[];
	var right=[];
	var isMiddle = false;
	for(var i=0; i < pageCount;i++) left.push(i+1);
	if(pageCount>5) {
		var all =getPageCount();
		if(global.current<=3){
			left=[1,2,3];
			right=[all-1, all];
		} else if(global.current>=all-2){
			left=[1,2];
			right=[all-2, all-1, all];
		} else {
			isMiddle = true;
			left=[global.current-1, global.current, global.current+1];
			right = [];
		}
	}
	if(isMiddle) {
		s += "<li><a onclick=prev() title='上一页'>...</a></li>"
	}
	for(var i=0;i<left.length;i++) {
		s += "<li><a onclick=loadWorkExperience('"+fxsWorkExperience+"',"+left[i]
			+") >"+left[i]+"</a></li>";
	}
	if(!isMiddle&&left.length >= 3) {
		s += "<li><a title='下一页' onclick=loadWorkExperience('"+fxsWorkExperience+"',"+
			"4)>...</a></li>"
	} else if(!isMiddle) {
		s += "<li><a title='下一页' onclick=loadWorkExperience('"+fxsWorkExperience+"',"+
		 (getPageCount()-3)+")>...</a></li>"
	}
	for(var i=0;i<right.length;i++) {
		s += "<li><a onclick=loadWorkExperience('"+fxsWorkExperience+"',"+right[i]
			+") >"+right[i]+"</a></li>";
	}
	if(isMiddle) {
		s += "<li><a onclick=next() title='下一页'>...</a></li>"
	}
	s += "<li><a onclick=loadWorkExperience('"+fxsWorkExperience+"',"+getPageCount()+") aria-label=Next title='尾页'>" +
		"<span aria-hidden=true>&raquo;</span></a></li>";
	var e = $("#paging");
	e.html(s);
}

function prev(i) {
	if(i == null) i=1;
	if(global.current > 1) {
		loadWorkExperience(fxsWorkExperience, global.current-i);
	}
}

function next(i) {
	if(i==null) i=1;
	if(global.current < getPageCount()) {
		loadWorkExperience(fxsWorkExperience, global.current+i);
	}
}

function getPageCount() {
	var pageCount = global.count % global.pageSize; 
	if(pageCount > 0) {
		pageCount = (global.count - pageCount)/global.pageSize + 1;
	} else {
		pageCount = (global.count - pageCount)/global.pageSize;
	}
	return pageCount;
}

/******************************************************/

/**
 * 装载工作经历信息
 * @param url
 * @param current
 */
function loadWorkExperience(url, current) {
	var data = {};
	data.current = current;
	$.ajax({
		url:url,
		data:data,
		success:function(data) {
			data = eval('('+data+')');
			var e = $("#we_table").find("tbody");
			e.html("");
			var s = "";
			var j=(current-1)*global.pageSize;
			for(var i in data) {
				j++;
				s += "<tr>"
				s += "<th>" + j +"</th>";
				var cn = data[i].F03;
				if(cn.length > 10) cn = data[i].F03.substr(0,7)+"...";
				s += "<th title=" + data[i].F03 +">"+cn+"</th>";
				s += "<th>" + data[i].F04 +"</th>";
				if(!data[i].F05) {
					data[i].F05="至今";
				}
				s += "<th>" + data[i].F05 +"</th>";
				cn = data[i].F06;
				if(cn.length>15) cn = data[i].F06.substr(0,12)+"...";
				s += "<th title=" + data[i].F06 +">"+cn+"</th>";
				s += "<th><a class='cp' onclick=deleteItem('"+data[i].F01 +"')>删除</th>";
				s += "</tr>";
			}
			e.html(s);
			global.current = current;
			paging();
		},
		error:function() {
			showAlert("网络连接出错！请刷新重试！");
		}
	});
}

/**
 * 删除从业经历
 * @param id
 */
function deleteItem(id) {
	console.log(id);
}

/**
 * 改变头像
 */
function changeHeadImage() {
	// 初始化上传图像控件
	$("#imgImputDialog").modal("show");
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
	if(name=="gender"||name=="degree") {
		e = $("select[name="+name+"]")
	}
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
	if(name=="gender"||name=="degree") {
		e = $("select[name="+name+"]")
	}
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
	var date = $("input[name='bornDate']").val();
	var date1 = new Date(date);
	if(date1 >= new Date()) {
		showAlert("您输入的出生日期"+date+"不合法");
		return false;
	}
	return true;
}

/**
 * 毕业院校
 */
function updateSchool() {
	return true;
}

function updateDegree() {
	return true;
}

/**
 * 个人简介
 * @returns {Boolean}
 */
function updatePersonalIntroduce() {
	return true;
}

/**
 * 毕业日期
 */
function updateEmployDate() {
	var date = $("input[name='employDate']").val();
	var date1 = new Date(date);
	if(date1 >= new Date()) {
		showAlert("您输入的毕业日期"+date+"不合法");
		return false;
	}
	return true;
}

/**
 * 当前公司
 * @returns {Boolean}
 */
function updateCommany() {
	return true;
}

/**
 * 从业经历增加
 */
function submitCompanyAdd(url) {
	var companyName = $("input[name='companyName']").val();
	if(companyName == null || companyName!=null&&companyName.trim().length==0) {
		showAlert("请输入公司名称");
		return false;
	}
	if(companyName.trim().length < 5) {
		showAlert("公司名称不少于5个字");
		return false;
	}
	var companyStartDate = $("input[name='companyStartDate']").val();
	if(companyStartDate==null||companyStartDate!=null&&companyStartDate.trim()=="") {
		showAlert("请输入开始日期");
		return false;
	}
	if(!isDate(companyStartDate)) {
		showAlert("请输入格式正确的日期\n\r日期格式：yyyy-mm-dd\n\r例    如：2008-08-08\n\r");
		return false;
	}
	var companyRemark = $("textarea[name='companyRemark']").val();
	if(companyRemark == null || companyRemark!=null&&companyRemark.trim().length==0) {
		showAlert("请输入您在公司的担任的具体职务（10-150字）");
		return false;
	}
	if(companyRemark.length<10||companyRemark.length>200) {
		showAlert("职务说明的字数在10-150字之间");
		return false;
	}
	var companyFinishDate = $("input[name='companyFinishDate']").val();
	if(companyFinishDate!=null&&companyFinishDate.trim().length>0) {
		if(!isDate(companyFinishDate)) {
			showAlert("请输入格式正确的日期\n\r日期格式：yyyy-mm-dd\n\r例    如：2008-08-08\n\r");
			return false;
		}
	}
	var fd = new Date(companyFinishDate);
	var cd = new Date(companyStartDate);
	if(fd < cd) {
		showAlert("您的结束时间早于您的开始时间");
		return false;
	}
	var data = {
		"type":"add",
		"companyName":companyName,
		"companyStartDate":companyStartDate,
		"companyRemark":companyRemark,
		"companyFinishDate":companyFinishDate
	};
	$.ajax({
		type:"post",
		url:url,
		data:data,
		success:function(data) {
			data = eval('('+data+')');
			if(data.success=='true') {
				showAlert("从业经历添加成功！");
				$("input[name='companyName']").val("");
				$("input[name='companyStartDate']").val("");
				$("input[name='companyFinishDate']").val("");
				$("textarea[name='companyRemark']").val("");
			} else {
				showAlert("从业经历添加失败，请核查您填写的信息是否正确！");
			}
		},
		error:function() {
			showAlert("网络连接失败，请稍候重试！");
		}
	})
	return false;
}

/**
 * 重置添加公司
 */
function resetCompanyAdd() {
	showDialog("您是否确定重新填写所有信息？", function(){
		$("input[name='companyName']").val("");
		$("input[name='companyStartDate']").val("");
		$("input[name='companyFinishDate']").val("");
		$("textarea[name='companyRemark']").val("");
	});
}

function isDate(dateString){
    if(dateString.trim()=="")return true;
    var r=dateString.match(/^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/); 
    if(r==null){
      return false;
    }
    var d=new Date(r[1],r[3]-1,r[4]);   
    var num = (d.getFullYear()==r[1]&&(d.getMonth()+1)==r[3]&&d.getDate()==r[4]);
    if(num==0){
      return false;
    }
    return (num!=0);
}
  