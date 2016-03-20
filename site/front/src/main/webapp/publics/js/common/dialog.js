

/**
 * 显示对话框
 * @param title
 * @param content
 * @param okCall
 * @param cancelCall
 */
function showDialog(title, content, okCall, cancelCall) {
	if(typeof content==='function') {
		cancelCall=okCall;
		okCall=content;
		content = title;
		title = "温馨提示";
	}
	$("#modalTitle").html(title);
	$("#modalBody").html(content);
	$("#modalOk").addClass("ml20");
	$("#modalOk").click(function(){
		okCall.apply([],[]);
	});
	$("#modalCancel").show();
	$("#modalCancel").click(cancelCall);
	$("#modalDialog").modal("show");
}

function showAlert(title, content, okCall) {
	if(content == null) {
		content = title;
		title = "温馨提示";
	}
	$("#modalAlertTitle").html(title);
	$("#modalAlertBody").html(content);
	$("#modalAlertOk").removeClass("ml20");
	$("#modalAlertOk").click(okCall);
	$("#modalAlertDialog").modal("show");
	$("#modalAlertCancel").hide();
}
