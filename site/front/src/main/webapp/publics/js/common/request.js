
define(["dialog"], function(dialog, option) {
	var r = function(option) {
		if(!option.type) {
			option.type="get";
		}
		$.ajax({
			url:option.url,
			data:option.data,
			type:option.type,
			success:function(data){
				if(option.success) {
					option.success.apply([],[data]);
				}
			},
			error:function() {
				dialog.showAlert("网络发生错误，请刷新重试");
			}
		});
	}
	return {
		get:function(option) {
			option.type="get";
			r(option);
		},
		post:function(option) {
			option.type="post";
			r(option);
		},
		toJson:function(s) {
			d = eval('('+s+')');
			return d;
		}
	}
})
