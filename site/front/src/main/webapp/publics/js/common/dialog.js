

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
	$("#modalOk").click(okCall);
	$("#modalCancel").show();
	$("#modalCancel").click(cancelCall);
	$("#modalDialog").modal("show");
}

function showAlert(title, content, okCall) {
	if(content == null) {
		content = title;
		title = "温馨提示";
	}
	$("#modalTitle").html(title);
	$("#modalBody").html(content);
	$("#modalOk").removeClass("ml20");
	$("#modalOk").click(okCall);
	$("#modalDialog").modal("show");
	$("#modalCancel").hide();
}
