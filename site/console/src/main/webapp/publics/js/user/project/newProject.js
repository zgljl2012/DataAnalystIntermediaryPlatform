
define(["common/url"], function(url){
	
	var doc = document,
		submitUrl = url.user.qy.project.add;
	
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

	/**
	 * 检查项目名称
	 * @param pn
	 * @returns {Boolean}
	 */
	doc.checkProjectName = function(pn) {
		var value = pn.value;
		var a = $(pn).nextAll('span[error]');
		if(value==null||value=="") {
			a.html("请输入项目名称");
			a.show();
			return false;
		}
		if(value.length < 5 || value.length >= 20) {
			a.html("名称长度大于4小于20");
			a.show();
			return false;
		}
		a.hide();
		return true;
	}

	/**
	 * 检查意向价格
	 * @param wp
	 * @returns {Boolean}
	 */
	doc.checkWillPrice = function(wp) {
		var value = wp.value;
		var a = $(wp).nextAll('span[error]');
		if(value==null||value=="") {
			//wp.value=-1; // 面议为-1
			return true;
		}
		var reg = /(^[1-9]\d*(\.\d{1,2})?$)|(^0(\.\d{1,2})?$)/;
		if(!reg.test(value)) {
			a.html("价格输入有误，请您重新输入");
			a.show();
			return false;
		}
		a.hide();
		return true;
	}

	/**
	 * 检查招标天数
	 * @param bd
	 */
	doc.checkBidDays = function(bd) {
		var value = bd.value;
		console.log(value)
		var a = $(bd).nextAll('span[error]');
		if(value==null||value=="") {
			a.html("请输入招标天数");
			a.show();
			return false;
		}
		var reg = /^[1-9]\d*$/;
		if(!reg.test(value)) {
			a.html("招标天数应为纯数字");
			a.show();
			return false;
		}
		a.hide();
		return true;
	}

	/**
	 * 检查完成时间
	 * @param tl
	 */
	doc.checkTimeLimit = function(tl) {
		var value = tl.value;
		var a = $(tl).nextAll('span[error]');
		if(value==null||value=="") {
			if(value == null || value =="") {
				a.html("请输入完成时间");
				a.show();
				return false;
			}
		}
		var now = new Date();
		var target = new Date(value);
		if(now > target) {
			a.html("完成时间不能小于当前时间");
			return false;
		}
		a.hide();
		return true;
	}

	/**
	 * 检查项目描述
	 * @param pd
	 */
	doc.checkProjectDescription = function(pd) {
		var value = pd.value;
		var a = $(pd).nextAll('span[error]');
		if(value ==null || value == "") {
			a.html("请输入项目描述");
			a.show();
			return false;
		}
		if(value.length<10||value.length>500) {
			a.html("项目描述字数在10到500字之间");
			a.show();
			return false;
		}
		a.hide();
		return true;
	}
	
	/**
	 * 新建项目提交检查函数
	 * @param form
	 * @returns {Boolean}
	 */
	doc.onNewProject = function(form) {
		console.log(form)
		if(doc.checkProjectName(form.projectName)&&doc.checkWillPrice(form.willPrice)
				&&doc.checkBidDays(form.bidDays)&&doc.checkTimeLimit(form.timeLimit)
				&&doc.checkProjectDescription(form.projectDescription)) {
			$(form).attr("action",submitUrl);
			return true;
		}
		return false;
	}
	
	return doc;
})

