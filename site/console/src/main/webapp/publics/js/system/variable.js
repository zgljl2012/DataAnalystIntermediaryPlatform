
define(["common/url","common/request","common/pagging2", 
        "plugins/template/jquery.tmpl.min"], function(url, request, pagging){
	var url = url.system.variable,
		doc = window.document,
		pg = null;
	return {
		list:function(call) {
			request.get({
				url:url,
				data:null,
				success:function(data) {
					data = request.toJson(data);
					if(call != null) {
						call.apply([],[data]);
					}
				}
			})
		},
		tmpl:function(tmplData,tmplate,target) {
			tmplate.tmpl(tmplData).appendTo(target);
		}
		
	}
	
})

