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
   <li><a href="#jmeter" data-toggle="tab">进行中项目 </a></li>
   <li><a href="#ejb" data-toggle="tab">已投标项目 </a></li>
   <li><a href="#ejb" data-toggle="tab">已完成项目 </a></li>
</ul>
<div id="myTabContent" class="tab-content">
   <div class="tab-pane fade in active" id="baseInfo">
      <div class="row mt20">
      	<div class="col-sm-1 tc">
      		<img src="publics/images/noface.gif" width="100" height="100" class="display_block" name="headImg"/>
      		<div class="form-group tc ml10">
                <input onclick="changeHeadImage()" type="button" class="btn btn-primary fs05 mt5" value="上传图像">
            </div>
      	</div>
      	<div class="col-sm-10 ml20">
      		<div class="row mt20">
      			<div class="col-sm-4" style="width:35%">
      				<span>用&nbsp;&nbsp;户&nbsp;&nbsp;名:</span>
      				<input type="text" name="username" value="<%=ljlSession.getUsername() %>" maxlength="18" disabled/>
      				<a edit onclick="edit('username','编辑','完成', updateUsername)" class="cp">编辑</a>
      			</div>
      			<div class="col-sm-5">
      				<span>真实姓名:</span>
      				<input type="text" name="realName" value="" maxlength="18" disabled/>
      				<a edit onclick="edit('realName','编辑','完成', updateRealname)" class="cp">编辑</a>
      			</div>
      		</div>
      		<div class="row mt25">
      			<div class="col-sm-4" style="width:35%">
      				<span>邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱:</span>
      				<input type="text" name="email" value="" maxlength="18" disabled/>
      				<a onclick="edit('email','编辑','完成', updateEmail)" class="cp">编辑</a>
      			</div>
      			<div class="col-sm-5" style="width:40%">
      				<span>出生日期:</span>
      				<input date id="bornDate" readonly disabled class="dateTime" type="text" name="bornDate">
      				<a edit onclick="edit('bornDate', '编辑','完成',updateDate)" class="cp">编辑</a>
      			</div>
      			<div class="col-sm-3">
      				<span>性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别:</span>
      				<select name="gender" disabled>
      					<option value="BM">保密</option>
      					<option value="NAN">男</option>
      					<option value="NV">女</option>
      				</select>
      				<a edit onclick="edit('gender','编辑','完成', updateGender)" class="cp">编辑</a>
      			</div>
      		</div>
      		<div class="row mt20">
      			<div class="col-sm-9">
	      			<span>毕业院校:</span>
	      			<input type="text" name="school" value="" maxlength="40" style="width:70.8%;" disabled/>
	      			<a edit onclick="edit('school','编辑','完成', updateSchool)" class="cp">编辑</a>
      			</div>
      			<div class="col-sm-3">
      				<span>毕业时间:</span>
      				<input date readonly disabled class="dateTime" type="text" name="employDate" style="width:37%;">
      				<a edit onclick="edit('employDate', '编辑','完成',updateEmployDate)" class="cp">编辑</a>
      			</div>
      		</div>
      	</div>
      </div>
      <hr>
      <div class="row">
      	<div class="row ml20">
      		<span class="fs15 ml10 gray">个人简介</span>
      		<a edit onclick="edit('personalIntroduce', '编辑','完成',updatePersonalIntroduce)" class="cp">编辑</a>
      	</div>
      	<div class="row ml30 mt10">
      		<textarea disabled name="personalIntroduce" style="width:50%;height:150px;" placeholder="请您对自己作一个简单的介绍，100字左右" maxlength=250></textarea>
      	</div>
      </div>
      <hr>
      <div class="row">
      	<div class="row ml20">
      		<span class="fs15 ml10 gray">从业经历</span>
      	</div>
      	<div class="row ml30 mt10">
      		<span class="gray">当前公司:</span>
	      	<input placeholder="可填写自由职业" type="text" name="commany" value="" maxlength="60" style="width:70.8%;" disabled/>
	      	<a edit onclick="edit('commany','编辑','完成', updateCommany)" class="cp">编辑</a>
      	</div>
      </div>
   </div>
   
   
   <div class="tab-pane fade" id="ios">
      <p>iOS 是一个由苹果公司开发和发布的手机操作系统。最初是于 2007 年首次发布 iPhone、iPod Touch 和 Apple 
      TV。iOS 派生自 OS X，它们共享 Darwin 基础。OS X 操作系统是用在苹果电脑上，iOS 是苹果的移动版本。</p>
   </div>
   <div class="tab-pane fade" id="jmeter">
      <p>jMeter 是一款开源的测试软件。它是 100% 纯 Java 应用程序，用于负载和性能测试。</p>
   </div>
   <div class="tab-pane fade" id="ejb">
      <p>Enterprise Java Beans（EJB）是一个创建高度可扩展性和强大企业级应用程序的开发架构，部署在兼容应用程序服务器（比如 JBOSS、Web Logic 等）的 J2EE 上。
      </p>
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