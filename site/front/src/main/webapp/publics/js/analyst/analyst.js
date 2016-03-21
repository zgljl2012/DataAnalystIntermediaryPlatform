
var global = {};
$(function(){
	global.current = 1;
	pullData(analystServlet, global.current);
});

/**
 * 获取分析师数据
 * @param url
 * @param current
 */
function pullData(url, current) {
	var data = {};
	data.current = current;
	$.ajax({
		url:url,
		data:data,
		type:"post",
		success:function(data) {
			data = eval('('+data+')');
			console.log(data);
			$("#number").html(data.count);
			global.current = current;
			global.count = data.count;
			global.pageSize = data.pageSize;
			loadTable(data);
			paging();
		},
		error:function() {
			showAlert("网络连接错误，请刷新重试！");
		}
	});
}

/**
 * 用数据渲染模板
 * @param data
 */
function loadTable(data) {
	for(var i in data.data) {
		// 图像链接
		if(data.data[i].t20) {
			if(data.data[i].t20.F09){
				data.data[i].t20.F09 = "/front/uploadHeadImage?filePath="+data.data[i].t20.F09;
			} else {
				data.data[i].t20.F09 = 'publics/images/noface.gif';
			}
		}
		// 从业年限
		if(data.data[i].t20) {
			if(data.data[i].t20.F06) {
				data.data[i].t20.F06 = workYearCal(new Date(data.data[i].t20.F06));
			}
		}
		// 个人简介
		if(data.data[i].t20) {
			if(data.data[i].t20.F05) {
				if(data.data[i].t20.F05.length > 20) {
					data.data[i].t20._F05 = data.data[i].t20.F05.substr(0,18)+"……";
				}
			}
		}
	}
	if(!global.tmplItem) {
		var tmpl = $("#tmplData").tmpl(data).appendTo("#tmplTable");
		global.tmplItem = $.tmplItem(tmpl);
	} else {
		global.tmplItem.data = data;
		global.tmplItem.update();
	}
}

/**
 * 从业经历计算
 * @param date
 */
function workYearCal(date) {
	var tmp = new Date();
	return tmp.getYear() - date.getYear() + 1;
}

/**********************************************************
 * 获取分页信息
 */

function paging() {
	var pageCount = getPageCount();
	var e = $("ul[name='paging']");
	if(pageCount ==0) {
		e.hide();
	} else {
		e.show();
	}
	
	var s = "<li><a onclick=pullData('"+analystServlet+"',1)"+" aria-label=Previous title='首页'>"
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
		s += "<li><a onclick=pullData('"+analystServlet+"',"+left[i]
			+") >"+left[i]+"</a></li>";
	}
	if(!isMiddle&&left.length >= 3&&pageCount>5) {
		s += "<li><a title='下一页' onclick=pullData('"+analystServlet+"',"+
			"4)>...</a></li>"
	} else if(!isMiddle&&left.length >= 2&&pageCount>5) {
		s += "<li><a title='下一页' onclick=pullData('"+analystServlet+"',"+
		 (getPageCount()-3)+")>...</a></li>"
	}
	for(var i=0;i<right.length;i++) {
		s += "<li><a onclick=pullData('"+analystServlet+"',"+right[i]
			+") >"+right[i]+"</a></li>";
	}
	if(isMiddle) {
		s += "<li><a onclick=next() title='下一页'>...</a></li>"
	}
	s += "<li><a onclick=pullData('"+analystServlet+"',"+getPageCount()+") aria-label=Next title='尾页'>" +
		"<span aria-hidden=true>&raquo;</span></a></li>";
	e.html(s);
}

function prev(i) {
	if(i == null) i=1;
	if(global.current > 1) {
		pullData(analystServlet, global.current-i);
	}
}

function next(i) {
	if(i==null) i=1;
	if(global.current < getPageCount()) {
		pullData(analystServlet, global.current+i);
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
