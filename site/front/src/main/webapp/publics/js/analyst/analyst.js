
var global = {};
$(function(){
	var data = {};
	data.current = 1;
	$.ajax({
		url:analystServlet,
		success:function(data) {
			data = eval('('+data+')');
			console.log(data);
			$("#number").html(data.count);
			loadTable(data);
		},
		error:function() {
			showAlert("网络连接错误，请刷新重试！");
		}
	});
});

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
	$("#tmplData").tmpl(data).appendTo("#tmplTable");
}

/**
 * 从业经历计算
 * @param date
 */
function workYearCal(date) {
	var tmp = new Date();
	return tmp.getYear() - date.getYear() + 1;
}
