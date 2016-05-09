define(["common/url","dialog","common/request","plugins/star/star-rating"],
		function(url,dialog,request) {
	var _url = url.project.comment.qy;
	var star = function(url, comment, grade) {
		this.url = url;
		if(this.url==null) {
			this.url = _url;
		}
		this.title = "评论";
		$("#commentModalCancel").click(function(){
			if(!comment) comment="";
			if(!grade) grade = 4;
			$("#commentTextarea").val(comment);
			$("#commentGrade").val(grade);
		});
	};
	star.prototype.setComment = function(comment) {
		$("#commentTextarea").val(comment);
		return this;
	};
	star.prototype.setGrade = function(grade) {
		$("#commentGrade").val(grade);
		return this;
	};
	star.prototype.show = function(ok) {
		$("#commentModalTitle").html(this.title);
		$("#commentModalOk").unbind("click");
		$("#commentModalOk").click(function(){
			if(ok != null) {
				var comment = $("#commentTextarea").val();
				var grade = $("#commentGrade").val();
				ok.apply([],[comment, grade]);
				$("#commentTextarea").val("");
				$("#commentGrade").val(4);
			}
		});
		$("#commentModalDialog").modal("show");
		return this;
	};
	star.prototype.qy2fxs = function(projectId, comment, grade, callback) {
		$.ajax({
			url:this.url,
			type:"post",
			data:{projectId:projectId, comment:comment, grade:grade},
			success:function(data){
				data = eval('('+data+')');
				if(data.status == 'success') {
					dialog.showAlert("评论成功");
				} else {
					dialog.showAlert(data.description);
				}
				if(callback) {
					callback.apply([],[data]);
				}
			},error:function() {
				dialog.showAlert("网络发生错误，请刷新重试");
			}
		});
	};
	star.prototype.getQy2Fxs = function(projectId, call) {
		request.get({
			url:this.url,
			data:{projectId:projectId},
			success:function(data){
				data = request.toJson(data);
				if(call) {
					call(data);
				}
			}
		});
	}
	return star;
})
