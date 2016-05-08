define(["common/url","dialog","plugins/star/star-rating"],function(url,dialog) {
	var url = url.project.comment.qy;
	var star = function() {
		this.title = "评论";
		$("#commentModalCancel").click(function(){
			$("#commentTextarea").val("");
			$("#commentGrade").val(4);
		});
	}
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
	}
	star.prototype.qy2fxs = function(projectId, comment, grade) {
		$.ajax({
			url:url,
			type:"post",
			data:{projectId:projectId, comment:comment, grade:grade},
			success:function(data){
				data = eval('('+data+')');
				if(data.status == 'success') {
					dialog.showAlert("评论成功");
				} else {
					dialog.showAlert(data.description);
				}
			},error:function() {
				dialog.showAlert("网络发生错误，请刷新重试");
			}
		});
	}
	return new star();
})
