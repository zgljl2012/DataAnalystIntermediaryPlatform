
define(["common/url", "dialog","pagging", 
        "jquery.tmpl"],
		function(urlUtil, dialog, pagging){
	var url = urlUtil.project.bid,
		delUrl = urlUtil.project.del,
		selectUrl = urlUtil.project.select,
		updateUrl = urlUtil.project.bidUpdate,
		doc = {},
		meta={
			current:0,
			projectId:null,
			callback:null,
			count:0,
			pageSize:0
		};
	document.pagging = pagging;
	pagging.name = "bid_paging";
	var r =  {
		list:function(projectId, callback) {
			if(callback==null) {
				callback = projectId;
				projectId = meta.projectId;
			} else {
				meta.projectId = projectId;
				meta.callback = callback;
			}
			$.ajax({
				url:url,
				data:{projectId:projectId, current:meta.current},
				type:"get",
				success:function(data) {
					data = eval("("+data+")");
					meta.count = parseInt(data.count);
					meta.pageSize = parseInt(data.pageSize);
					if(callback != null) {
						callback.apply([], [data]);
					}
				},error:function() {
					dialog.showAlert("网络错误，请刷新重试")
				}
			});
		},
		pullData:function(cur) {
			meta.current = cur;
			pagging.current = cur;
			r.list(meta.projectId, meta.callback);
		},
		/**
		 * data:待显示的数据
		 * tmpl:模板
		 * target:模板经渲染后的数据存储目标
		 * paggingElem: 分页控件所在
		 */
		showbids:function(data, tmpl, target) {
			var tmp = data["data"];
			if(tmp != null){
				var l = tmp.length;
				for(var i=0; i < l; i++) {
					if(tmp[i].comment) {
						tmp[i]._comment = "\n"+tmp[i].comment;
					}
				}
				if(!doc.tmplItem||!doc.tmplItem.nodes||doc.tmplItem.nodes.length==0) {
					tmpl = tmpl.tmpl(data).appendTo(target);
					doc.tmplItem = $.tmplItem(tmpl);
				} else {
					doc.tmplItem.data = data;
					doc.tmplItem.update();
				}
			}
			pagging.paging(this.pullData, meta.count, meta.pageSize);
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
		},
		del:function(id) {
			dialog.showDialog("删除确认","确定删除这个投标？",function(){
				$.ajax({
					type:"post",
					url:delUrl,
					data:{bidId:id},
					success:function(data) {
						data = eval("("+data+")");
						console.log(data)
						if(data.status == "success") {
							r.list(meta.projectId, meta.callback);
						} else {
							dialog.showAlert(data.description);
						}
					},error:function() {
						dialog.showAlert("网络错误，请刷新重试")
					}
				})
			})
		},
		select:function(id) {
			dialog.showDialog("中标确认","确定选中此分析师？一经选中不得更改",function(){
				$.ajax({
					type:"post",
					url:selectUrl,
					data:{bidId:id},
					success:function(data) {
						data = eval("("+data+")");
						if(data.status == "success") {
							window.location.reload(true);
						} else {
							dialog.showAlert(data.description);
						}
					},error:function() {
						dialog.showAlert("网络错误，请刷新重试")
					}
				})
			})
		},
		update:function(id, price, comment) {
			console.log(price);
			console.log(comment);
			console.log(id);
			$.ajax({
				type:"post",
				url:updateUrl,
				data:{bid:id, price:price, comment:comment},
				success:function(data) {
					data = eval("("+data+")");
					if(data.status == "success") {
						window.location.reload(true);
					} else {
						dialog.showAlert(data.description);
					}
				},error:function() {
					dialog.showAlert("网络错误，请刷新重试")
				}
			})
		}
	}
	return r;
});
