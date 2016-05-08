define([], function(){
	
	var dialog = {}
	/**
	 * 显示对话框
	 * @param title
	 * @param content
	 * @param okCall
	 * @param cancelCall
	 */
	dialog.showDialog = function(title, content, okCall, cancelCall) {
		if(typeof content==='function') {
			cancelCall=okCall;
			okCall=content;
			content = title;
			title = "温馨提示";
		}
		$("#modalTitle").html(title);
		$("#modalBody").html(content);
		$("#modalOk").addClass("ml20");
		$("#modalOk").unbind("click");
		$("#modalOk").click(function(){
			okCall.apply([],[]);
		});
		$("#modalCancel").show();
		$("#modalCancel").click(cancelCall);
		$("#modalDialog").modal("show");
	}
	
	dialog.showAlert = function(title, content, okCall) {
		if(content == null&&okCall==null) {
			content = title;
			title = "温馨提示";
		} else if(content != null && okCall ==null) {
			okCall = content;
			content = title;
			title = "温馨提示";
		}
		$("#modalAlertTitle").html(title);
		$("#modalAlertBody").html(content);
		$("#modalAlertOk").removeClass("ml20");
		$("#modalAlertOk").unbind("click");
		$("#modalAlertOk").click(okCall);
		$("#modalAlertDialog").modal("show");
		$("#modalAlertCancel").hide();
	}
	return dialog;
})
