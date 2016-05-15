
define(["common/request","common/url","common/pagging2", "jquery.tmpl"], 
		function(request, url, pagging) {
	var urlList = url.user.letter.list,
		name ="paging",
		readed = null,
		mTmpl = null,
		mTmplTarget = null,
		mFunc = null,
		isSelectAll = false;
	var letter = {
		current:1,
		load:function(_tmpl, _tmplTarget, _func) {
			mTmpl = _tmpl,
			mTmplTarget = _tmplTarget,
			mFunc = _func,
			tmpl = _tmpl;
			tmplTarget = _tmplTarget;
			func = _func;
			self = letter;
			request.get({
				url:urlList,
				data:{current:self.current,readed:readed},
				success:function(data) {
					data = request.toJson(data);
					if(!self.tmplItem||!self.tmplItem.nodes||self.tmplItem.nodes.length==0) {
						tmpl = tmpl.tmpl(data).appendTo(tmplTarget);
						self.tmplItem = $.tmplItem(tmpl);
					} else {
						self.tmplItem.data = data;
						self.tmplItem.update();
					}
					if(func != null) {
						func.apply(this, [data])
					}
					if(self.pg == null) {
						self.pg = new pagging(name, function(cur){
							self.current = cur;
							self.pg.current = cur;
							self.load(tmpl, tmplTarget, func);
						}, data.count, data.pageSize)
						self.pg.paging();
						document[name] = self.pg;
					}
					self.pg.paging();
					if(isSelectAll) {
						$("input[name=lid]").prop("checked", true);
					}
				}
			})
		},
		show:function(item, id, readed) {
			var elem = $(item);
			var next = elem.next("div");
			if(!next.is(":hidden")) {
				next.hide();
			} else {
				next.show();
			}
			if (readed == 'false') {
				letter.read(id);
			}
		},
		read:function(id) {
			request.post({
				url:urlList,
				data:{id:id,type:"read"},
				success:function(data) {
					//letter.load(mTmpl, mTmplTarget, mFunc);
				}
			})
		},
		del:function() {
			var data = {"lid":[]};
			var delAll = isSelectAll?"delAll":"del";
			$("input[name=lid]:checked").each(function(){
				data["lid"].push($(this).val());
			});
			data.type = delAll;
			console.log(data)
			request.post({
				url:urlList,
				data:data,
				traditional :true,
				success:function(data){
					letter.load(mTmpl, mTmplTarget, mFunc);
				}
			})
		},
		selectAll: function(s) {
			if(s == null) return;
			isSelectAll = !isSelectAll;
			if($(s).prop("checked")) {
				$("input[name=lid]").prop("checked", true);
			} else {
				$("input[name=lid]").prop("checked", false);
			}
		},
		changeReaded:function(s) {
			readed = $(s).val();
			letter.load(mTmpl, mTmplTarget, mFunc);
		}
	} 
	return letter;
})
