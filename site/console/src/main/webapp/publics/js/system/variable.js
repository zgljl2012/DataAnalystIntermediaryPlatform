
define(["common/url","common/request","common/pagging2", 
        "plugins/template/jquery.tmpl.min"], function(url, request, pagging){
	var url = url.system.variable,
		doc = window.document,
		name = "paging",
		current = 1,
		mTmpl = null,
		mTarget = null,
		pg = null;
	var variable = {
		list:function(call,key) {
			request.post({
				url:url,
				data:{current:current,name:key},
				success:function(data) {
					data = request.toJson(data);
					if(call != null) {
						call.apply([],[data]);
					}
					if(pg == null) {
						pg = new pagging(name, function(cur){
							current = cur;
							variable.list(function(data){
								variable.tmpl(data, mTmpl, mTarget);
							});
						}, data.count, data.pageSize)
						pg.paging();
						document[name] = pg;
					}
				}
			})
		},
		tmpl:function(tmplData,tmplate,target) {
			for(var d in tmplData.data) {
				if(tmplData.data[d].value!=null&&tmplData.data[d].value.length > 20) {
					tmplData.data[d].value = 
						tmplData.data[d].value.substr(0,20)+"...";
				}
			}
			if(!doc.tmplItem||!doc.tmplItem.nodes||doc.tmplItem.nodes.length==0) {
				mTmpl = tmplate;
				mTarget = target;
				tmpl = tmplate.tmpl(tmplData).appendTo(target);
				doc.tmplItem = $.tmplItem(tmpl);
			} else {
				doc.tmplItem.data = tmplData;
				doc.tmplItem.update();
			}
		},
		search:function(name) {
			variable.list(function(data){
				variable.tmpl(data, mTmpl, mTarget);
			}, name);
		}
		
	}
	return variable;
})

