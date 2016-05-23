
define(["common/url","common/dialog2","common/pagging2","common/request","jquery.tmpl"], 
		function(url,dialog,pagging,request){
	var op_url = url.user.front;
	var op_url2 = url.user.console;
	var op_url3 = url.user.group;
	var doc = function(status, isConsole, isGroup) {
		this.url = url.user.front;
		if(isConsole==true) {
			this.url = url.user.console;
		}
		if(isGroup == true) {
			this.url = url.user.group;
		}
		console.log(this.url)
		this.data = {"data":[]},
		this.pg = null,
		this.current = 1;
		this.status = status;
	};
	var filterData= function(data){
		tmp = data["data"];
		for(d in tmp) {
			d = tmp[d];
		}
		return data;
	}
	doc.prototype.loadData = function(_tmpl, _tmplTarget, func) {
		var tmpl = _tmpl;
		var tmplTarget = _tmplTarget;
		var status = this.status;
		var self = this;
		request.get({
			url:this.url,
			data:{current:this.current},
			success:function(_data){
				if(_data == null) {
					dialog.showAlert("数据出错，请刷新重试");
				}
				if(self.url == url.user.group) {
					console.log(_data)
				}
				this.data = eval("("+_data+")");
				this.data = filterData(this.data);
				if(!self.tmplItem||!self.tmplItem.nodes||self.tmplItem.nodes.length==0) {
					tmpl = tmpl.tmpl(this.data).appendTo(tmplTarget);
					self.tmplItem = $.tmplItem(tmpl);
				} else {
					self.tmplItem.data = this.data;
					self.tmplItem.update();
				}
				if(func != null) {
					func.apply(this, [this.data])
				}
				if(self.pg == null) {
					var name = status + "_" + "paging";
					self.pg = new pagging(name, function(cur){
						self.current = cur;
						self.pg.current = cur;
						self.loadData(tmpl, tmplTarget, func);
					}, this.data.count, this.data.pageSize)
					self.pg.paging();
					document[name] = self.pg;
				} else {
					self.pg.paging();
				}
			}
		});
	}
	
	doc.prototype.operator = {
		sc:function(id) {
			dialog.showDialog("确定删除此用户？",function(){
				operate(op_url, "sc", id);
			});
		},
		usc:function(id) {
			dialog.showDialog("确定恢复此用户？",function(){
				operate(op_url, "usc", id);
			});
		},
		hmd:function(id) {
			dialog.showDialog("确定将此用户拉入黑名单？",function(){
				operate(op_url, "hmd", id);
			});
		},
		uhmd:function(id) {
			dialog.showDialog("确定将拉出黑名单？",function(){
				operate(op_url, "uhmd", id);
			});
		},
		scConsoleUser:function(id) {
			dialog.showDialog("确定删除此管理员？",function(){
				operate(op_url2, "sc", id);
			});
		}
	}
	
	var operate = function(url, type, id) {
		$.ajax({
			url:url,
			type:"post",
			data:{type:type,id:id},
			success:function(data){
				window.location.reload(1);
			},error:function(){
				dialog.showAlert("网络出错，请刷新重试！");
			}
		});
	}
	
	return doc;
})
