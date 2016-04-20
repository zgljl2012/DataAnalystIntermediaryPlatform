
define(["common/url","dialog","pagging","jquery.tmpl"], function(url,dialog,pagging){
	var doc = window.document,
		tmpl,
		tmplTarget,
		url = url.user.qy.project.list,
		data = {"data":[]};
	doc.pagging = pagging;
	doc.loadData = function(status, _tmpl, _tmplTarget, func) {
		tmpl = _tmpl;
		tmplTarget = _tmplTarget;
		$.ajax({
			url:url,
			data:{"status":status,current:pagging.current},
			success:function(_data){
				if(_data == null) {
					dialog.showAlert("数据出错，请刷新重试");
				}
				data = eval("("+_data+")");
				data = doc.filterData(data);
				if(!doc.tmplItem||!doc.tmplItem.nodes||doc.tmplItem.nodes.length==0) {
					tmpl = tmpl.tmpl(data).appendTo(tmplTarget);
					doc.tmplItem = $.tmplItem(tmpl);
				} else {
					doc.tmplItem.data = data;
					doc.tmplItem.update();
				}
				if(func != null) {
					func.apply(this, [data["data"]])
				}
				console.log(data)
				pagging.name = status.toLowerCase() + "_" + "paging";
				// 开始分页
				pagging.paging(function(cur){
					pagging.current = cur;
					doc.loadData(status, tmpl, tmplTarget, func);
				}, data.count, data.pageSize);
			},
			error:function(){
				dialog.showAlert("网络出错，请刷新重试！");
			}
		});
	}
	doc.filterData= function(data){
		tmp = data["data"];
		for(d in tmp) {
			d = tmp[d]
			if(d.t40.F03 == "0.0") {
				d.t40.F03= "面议";
			}
			if(d.t40.F02.length > 15) {
				d.t40.F02 = d.t40.F02.substr(0,13)+"..." 
			}
			if(d.t40.F13.length > 15) {
				d.t40.F13 = d.t40.F13.substr(0,13)+"..."
			}
		}
		return data;
	}
	return doc;
})
