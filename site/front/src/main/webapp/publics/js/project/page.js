
define(["common/url", "common/dialog2","common/pagging", 
        "plugins/template/jquery.tmpl.min"],
		function(urlUtil, dialog, pagging){
	var url = urlUtil.project.bid,
		doc = {};
	return {
		list:function(projectId, callback) {
			$.ajax({
				url:url,
				data:{projectId:projectId},
				type:"get",
				success:function(data) {
					data = eval("("+data+")");
					if(callback != null) {
						callback.apply([], [data]);
					}
				},error:function() {
					dialog.showAlert("网络错误，请刷新重试")
				}
			});
		},
		showbids:function(data, tmpl, target) {
			var tmp = data["data"];
			var l = tmp.length;
			for(var i=0; i < l; i++) {
				if(tmp[i].comment) {
					tmp[i].comment = "\n"+tmp[i].comment;
				}
			}
			if(!doc.tmplItem||!doc.tmplItem.nodes||doc.tmplItem.nodes.length==0) {
				tmpl = tmpl.tmpl(data).appendTo(target);
				doc.tmplItem = $.tmplItem(tmpl);
			} else {
				doc.tmplItem.data = data;
				doc.tmplItem.update();
			}
		},
		bid:function(projectId, price, comment) {
			$.ajax({
				url:url,
				data:{projectId:projectId, price:price, comment:comment},
				type:"post",
				success:function(data) {
					data = eval("("+data+")");
					if(data.status == "success") {
						dialog.showAlert("投标成功", function(){
							window.location.reload();
						});
					} else {
						dialog.showAlert(data.description);
					}
				},error:function() {
					dialog.showAlert("网络错误，请刷新重试")
				}
			});
		},
		checkComment:function(elem){
			var comment = elem.val();
			if(comment==null||comment.length < 10) {
				dialog.showAlert("投标评论不可少于10个字");
				return false;
			}
			return true;
		},
		checkPrice:function(elem) {
			var reg = /(^[1-9]\d*(\.\d{1,2})?$)|(^0(\.\d{1,2})?$)/;
			var val = elem.val();
			if(val == null || val.length == 0) {
				dialog.showAlert("请输入价格");
				return false;
			}
			if(!reg.test(val)) {
				dialog.showAlert("价格输入有误，请检查后再提交");
				return false;
			}
			return true;
		}
	}
});
