
define(["common/url","common/request","jquery.tmpl"], function(url, request){
	var dataUrl = url.index.data,
		projectUrl = url.index.project,
		data = null;
	return {
		getData:function(call) {
			request.get({
				url:dataUrl,
				success:function(data) {
					data = request.toJson(data);
					console.log(data)
					if(data.project.data) {
						for(i in data.project.data) {
							data.project.data[i].url = projectUrl+data.project.data[i].t40.F01; 
						}
					}
					if(data.fxs.data) {
						for(i in data.fxs.data) {
							data.fxs.data[i].avg = parseFloat(data.fxs.data[i].avg).toFixed(2);
						}
					}
					if(call != null) {
						call.apply([],[data]);
					}
				}
			})
		}
	}
})
