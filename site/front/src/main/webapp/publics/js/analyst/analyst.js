
var global = {};
$(function(){
	var data = {};
	data.current = 1;
	$.ajax({
		url:analystServlet,
		success:function(data) {
			data = eval('('+data+')');
			loadTable(data.data);
		},
		error:function() {
			showAlert("网络连接错误，请刷新重试！");
		}
	});
});

function loadTable(data) {
	$("#tmplData").tmpl(data).appendTo("#tmplTable");
}

