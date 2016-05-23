define(["common/url","dialog","common/pagging2","jquery.tmpl"], function(url,dialog,pagging){
	var doc = function(status) {
		this.url = url.user.fxs.project.query,
		this.data = {"data":[]},
		this.pg = null,
		this.current = 1;
		this.status = status;
	};
	var filterData= function(data){
		tmp = data["data"];
		for(d in tmp) {
			d = tmp[d];
			if(d.price == "0.0") {
				d.price= "面议";
			}
			if(d.description&&d.description.length > 15) {
				d.description.F02 = d.description.substr(0,13)+"..." 
			}
			if(d.projectName&&d.projectName > 15) {
				d.projectName = d.projectName.substr(0,13)+"..."
			}
		}
		return data;
	}
	doc.prototype.loadData = function(_tmpl, _tmplTarget, func) {
		var tmpl = _tmpl;
		var tmplTarget = _tmplTarget;
		var status = this.status;
		var self = this;
		$.ajax({
			url:this.url,
			data:{"status":status,current:this.current},
			success:function(_data){
				if(_data == null) {
					dialog.showAlert("数据出错，请刷新重试");
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
					func.apply(this, [this.data["data"]])
				}
				if(self.pg == null) {
					var name = status.toLowerCase() + "_" + "paging";
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
			},
			error:function(){
				dialog.showAlert("网络出错，请刷新重试！");
			}
		});
	}
	
	return doc;
})
