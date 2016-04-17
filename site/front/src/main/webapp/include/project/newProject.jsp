<%@ page language="java" contentType="text/html; charset=utf-8"%>
<script>
var doc = {}
require(["user/project/newProject"], function(_doc){
	doc = _doc
});
</script>
<div class="container">
	<form action="" method="post" onsubmit="return doc.onNewProject(this)">
	<div class="row mt20 tc">
		<div class="col-sm-1"></div>
		<div class="col-sm-2 tc">
			<span class="fr">项目名称：</span>
			<span class="red fr lh15">*</span>
			
		</div>
		<div class="col-sm-2 tc">
			<input style="width:100%;" class="m-input-form-control" name="projectName" type="text" placeholder="字数大于4少于20" maxlength=20 onblur="doc.checkProjectName(this)">
			<span error class="display_none red fl"></span>
		</div>
		<div class="col-sm-2 tc">
			<span class="fr">意向价格：</span>
		</div>
		<div class="col-sm-3">
			<input style="width:80%;" class="fl m-input-form-control" name="willPrice" type="text" placeholder="可选面议" maxlength=10 onblur="doc.checkWillPrice(this);">
			<span class="fl ml5"><input type="checkbox" checked >面议</span>
			<span error class="display_none red fl"></span>
		</div>
		<div class="col-sm-2"></div>
	</div>
	<div class="row mt20 tc">
		<div class="col-sm-1"></div>
		<div class="col-sm-2 tc">
			<span class="fr">招标天数：</span>
			<span class="red fr lh15">*</span>
		</div>
		<div class="col-sm-2 tc">
			<input style="width:100%;" class="m-input-form-control" name="bidDays" type="text" placeholder="请输入招标天数" maxlength=10 onblur="doc.checkBidDays(this)">
			<span error class="display_none red fl"></span>
		</div>
		<div class="col-sm-2 tc">
			<span class="fr">完成时间：</span>
			<span class="red fr lh15">*</span>
		</div>
		<div class="col-sm-3">
			<input style="width:80%;" readonly date type="text" name="timeLimit" 
			class="fl m-input-form-control" placeholder="请输入希望完成日期" 
			maxlength=10 onblur="doc.checkTimeLimit(this)"
			onchange="doc.checkTimeLimit(this)"
			>
			<span error class="display_none red fl"></span>
		</div>
		<div class="col-sm-2"></div>
	</div>
	<hr>
	<div class="row tc mt10">
		<div class="col-sm-12 tc">
			<span class="red lh15">*</span>
			<span class="fs12">项目描述</span><br>
		    <textarea name="projectDescription" class="mt10" placeholder="请输入项目描述（不少于10字，少于500字）" 
		    	class="form-control m-input-form-control" rows="8" cols="80"
		    	onblur="doc.checkProjectDescription(this)"
		   ></textarea><br>
		   <span error class="display_none red"></span>
		</div>
	</div>
	<hr>
	<div class="row tc mt10">
		<input type="submit" class="btn btn-primary"  value="提交">
	</div>
	</form>
</div>
