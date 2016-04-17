
define(["plugins/template/jquery.tmpl.min","common/url"], function(url){
	var doc = {},
		tmpl,
		tmplTarget,
		data = {"data":["1","2"]};
	
	doc.loadData = function(_tmpl, _tmplTarget, func) {
		tmpl = _tmpl;
		tmplTarget = _tmplTarget;
		tmpl.tmpl(data).appendTo(tmplTarget);
		if(func != null) {
			func.apply(this, [data["data"]])
		}
	}
	return doc;
})
