<%@ page language="java" contentType="text/html; charset=utf-8"%>
<div class="container">
<div class="panel panel-default">
    	<div class="panel-heading">数据分析师</div>
    	<div class="panel-body">
	<ul id="myTab" class="nav nav-tabs">
   <li class="active">
      <a href="#baseInfo" data-toggle="tab">
                     个人信息
      </a>
   </li>
   <li><a href="#bidding_project" data-toggle="tab">已投标项目 </a></li>
   <li><a href="#running_project" data-toggle="tab">进行中项目 </a></li>
   <li><a href="#finished_project" data-toggle="tab">已完成项目 </a></li>
</ul>
<div id="fxsInfo" class="tab-content">
   <div class="tab-pane fade in active" id="baseInfo">
      <div class="row mt20">
      	<div class="col-sm-2 tc">
      		<img src="publics/images/noface.gif" width="150" height="150" class="display_block cp border_eee" name="headImg" title='点击更改图像' onclick="changeHeadImage()"/>
      		<div class="form-group">
                <input onclick="changeHeadImage()" type="button" class="btn btn-primary fs05 mt5" value="上传图像">
            </div>
      	</div>
      	<div class="col-sm-10">
      		<div class="row mt20">
      			<div class="col-sm-5">
      				<span>用&nbsp;&nbsp;户&nbsp;&nbsp;名:</span>
      				<input class="m-input-form-control" type="text" name="username" value="<%=ljlSession.getUsername() %>" maxlength="18" disabled/>
      				<a edit onclick="edit('username','编辑','完成', updateUsername)" class="cp">编辑</a>
      			</div>
      			<div class="col-sm-5">
      				<span>真实姓名:</span>
      				<input class="m-input-form-control" type="text" name="realName" value="" maxlength="18" disabled/>
      				<a edit onclick="edit('realName','编辑','完成', updateRealname)" class="cp">编辑</a>
      			</div>
      		</div>
      		<div class="row mt25">
      			<div class="col-sm-5">
      				<span>邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱:</span>
      				<input class="m-input-form-control" type="text" name="email" value="" maxlength="18" disabled/>
      				<a onclick="edit('email','编辑','完成', updateEmail)" class="cp">编辑</a>
      			</div>
      			<div class="col-sm-5">
      				<span>出生日期:</span>
      				<input class="m-input-form-control" date id="bornDate" readonly disabled class="dateTime" type="text" name="bornDate">
      				<a edit onclick="edit('bornDate', '编辑','完成',updateDate)" class="cp">编辑</a>
      			</div>
      		</div>
      		<div class="row mt20">
      			<div class="col-sm-5 fl">
      				<span>性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别:</span>
      				<select class="m-input-form-control" name="gender" disabled>
      					<option value="BM">保密</option>
      					<option value="NAN">男</option>
      					<option value="NV">女</option>
      				</select>
      				<a edit onclick="edit('gender','编辑','完成', updateGender)" class="cp">编辑</a>
      			</div>
      			<div class="col-sm-5 fl">
      				<span>学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;历:</span>
      				<select name="degree" class="m-input-form-control" disabled placeholder="学历">
      					<option value="DZ">大专</option>
      					<option value="BK">本科</option>
      					<option value="SS">硕士</option>
      					<option value="BS">博士</option>
      					<option value="BSH">博士后</option>
      					<option value="QT">其它</option>
      				</select>
      				<a edit onclick="edit('degree','编辑','完成', updateDegree)" class="cp">编辑</a>
      			</div>
      		</div>
      		<div class="row mt20">
      			<div class="col-sm-10">
	      			<span>毕业院校:</span>
	      			<input class="m-input-form-control" type="text" name="school" value="" maxlength="40" style="width:78.9%" disabled/>
	      			<a edit onclick="edit('school','编辑','完成', updateSchool)" class="cp">编辑</a>
      			</div>
      		</div>
      		
      		<div class="row mt20">
      			<div class="col-sm-5 fl">
      				<span>毕业时间:</span>
      				<input class="m-input-form-control" date readonly disabled class="dateTime" type="text" name="employDate">
      				<a edit onclick="edit('employDate', '编辑','完成',updateEmployDate)" class="cp">编辑</a>
      			</div>
      		</div>
      	</div>
      </div>
      <hr>
      <div class="row">
      	<div class="row tc">
      		<span class="fs15 ml10 gray">个人简介</span>
      		<a edit onclick="edit('personalIntroduce', '编辑','完成',updatePersonalIntroduce)" class="cp">编辑</a>
      	</div>
      	<div class="row mt10 tc">
      		<textarea class="m-input-form-control"  disabled name="personalIntroduce" style="width:75%;height:180px;" placeholder="请您对自己作一个简单的介绍，100字左右" maxlength=250></textarea>
      	</div>
      </div>
      <hr>
      <div class="row">
      	<div class="row tc">
      		<span class="fs15 ml10 gray">从业经历</span>
      	</div>
      	<div class="row mt10 tc">
      		<span class="gray">当前公司:</span>
	      	<input class="m-input-form-control"  placeholder="可填写自由职业" type="text" name="commany" value="" maxlength="60" style="width:70.8%;" disabled/>
	      	<a edit onclick="edit('commany','编辑','完成', updateCommany)" class="cp">编辑</a>
      	</div>
      	<div class="row ml50 mt20 tc col-sm-10">
      		<ul id="experience" class="nav nav-tabs">
			  <li class="active"><a data-toggle="tab" href="#manage_experience" onclick="initWorkExperience()">管理工作经历</a></li>
			  <li ><a data-toggle="tab" href="#add_experience">增加工作经历</a></li>
			</ul>
			<div id="experience_content" class="tab-content">
				<div class="row tab-pane fade in active" id="manage_experience">
					<table id="we_table" class="table tc fs08 ml30 mt10">
					    <thead>
					    	<tr class="tl">
					    		<th>序号</th>
					    		<th>公司名称</th>
					    		<th>开始时间</th>
					    		<th>结束时间</th>
					    		<th>职务说明</th>
					    		<th>操作</th>
					    	</tr>
					    </thead>
					    <tbody>
					    	<tr>
					    		<th>序号</th>
					    		<td>公司名称</td>
					    		<td>开始时间</td>
					    		<td>结束时间</td>
					    		<td>职务说明</td>
					    		<td><a  onclick="deleteItem();" class="cp">删除</a></td>
					    	</tr>
					    </tbody>
					  </table>
					  <%--分页 --%>
					  <ul class="pagination fs08 ml30 mt10 cp" id="paging">
					    <li>
					      <a href="#" aria-label="Previous">
					        <span aria-hidden="true">&laquo;</span>
					      </a>
					    </li>
					    <li>
					      <a href="#" aria-label="Next">
					        <span aria-hidden="true">&raquo;</span>
					      </a>
					    </li>
					  </ul>
					  
				</div>
				<div class="tab-pane fade tc" id="add_experience">
					<div class="input-group input-group-md col-md-5 mt20">
						<span class="input-group-addon">
							<span class="red vm">*&nbsp;</span>公司名称：
						</span>
						<input type="text" name="companyName" placeHolder="请输入公司名称(不少于5个字)" class="form-control" maxlength="100">
					</div>
					<div class="input-group input-group-md col-md-5 mt15">
						<span class="input-group-addon">
							<span class="red vm">*&nbsp;</span>开始时间：</span>
						<input date type="text" name="companyStartDate" placeHolder="请输入开始时间" class="form-control">
					</div>
					<div class="input-group input-group-md col-md-5 mt15">
						<span class="input-group-addon">&nbsp;&nbsp;&nbsp;结束时间：</span>
						<input date type="text" name="companyFinishDate" placeHolder="请输入结束时间（如果是当前公司可不填写）" class="form-control">
					</div>
					<div class="input-group input-group-md col-md-8 mt15">
						<span class="input-group-addon">
							<span class="red vm">*&nbsp;</span>职务说明：</span>
						<textarea name="companyRemark" maxlength="150" placeHolder="请输入您在公司的具体职务和工作情况（限10-150字）" class="form-control"></textarea>
					</div>
					<div class="form-group ml20 mt15">
			                <input type="button" class="btn btn-primary mt5" value="确定添加" onclick="submitCompanyAdd('/front/user/workExperience');">
			                <input type="button" class="btn btn-default ml15 mt5" value="重置" onClick="resetCompanyAdd()">
			        </div>
				</div>
			</div>
      	</div>
      </div>
   </div>
   
   
   <div class="tab-pane fade" id="running_project">
      <%@include file="/include/project-list-fxs/jxzProject.jsp" %> 
   </div>
   <div class="tab-pane fade" id="bidding_project">
      <%@include file="/include/project-list-fxs/tbzProject.jsp" %> 
   </div>
   <div class="tab-pane fade" id="finished_project">
      <%@include file="/include/project-list-fxs/yjsProject.jsp" %>
   </div>
</div>
	</div></div>
	<%--上传图片对话框 --%>
    <div class="modal fade" id="imgImputDialog" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
         <div class="modal-header">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">
                  &times;
            </button>
            <h4 class="modal-title">
               	上传图片
            </h4>
         </div>
         <form id="fileForm" enctype="multipart/form-data" action="/front/uploadHeadImage" method="post" onSubmit="return fileUpload()">
         <div class="modal-body">
                <input id="file-0a" name="imgHead" class="file" type="file" multiple data-min-file-count="1">
            	<input name="filename" class="display_none" type="text"/>
            	<span class="mt5 gray">建议像素：100 * 100</span>            
         </div>
         <div class="modal-footer tc">
            <button type="button" class="btn btn-default mr20" 
               data-dismiss="modal">取消
            </button>
            <button type="button" class="btn btn-primary ml20" data-dismiss="modal" onclick="$('#fileForm').submit()">
               	确定
            </button>
         </div>
         </form>
      </div><!-- /.modal-content -->
</div></div><!-- /.modal -->
</div>
<script>
$('#file-0a').fileinput({
    language: 'zh',
    allowedFileExtensions : ['jpg', 'png','gif'],
});
$("input[name='filename']").addClass("display_none");
function fileUpload() {
	var elem = $("div[class='file-caption-name']");
	if(elem == null) {
		return false;
	}
	var filename = elem.text();
	if(filename==null|| filename!=null&&$.trim(filename)=="") {
		return false;
	}
	$("input[name='filename']").val(filename);
	$("input[name='filename']").removeClass("display_none");
	return true;
}
</script>