<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page import="com.zgljl2012.common.database.enums.Gender" %>
<%@ page import="com.zgljl2012.modules.project.BidManage" %>
<%@ page import="com.zgljl2012.framework.util.JSON" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html lang="zh">
<head>
<title>项目主页-<%=variableManage.getValue(SystemVariable.SITENAME) %></title>
<%@include file="/include/meta.jsp" %>
<!-- Bootstrap core CSS -->
<link href="publics/css/bootstrap.min.css" rel="stylesheet">

<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<link href="publics/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <!-- Custom styles for this template -->
<link href="publics/css/offcanvas.css" rel="stylesheet">
    
<link href="publics/css/app.css" rel="stylesheet"/>
    
<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
<!--[if lt IE 9]><script src="js/ie8-responsive-file-warning.js"></script><![endif]-->
<!-- <script src="publics/js/ie-emulation-modes-warning.js"></script> -->
<link href="publics/css/plugins/date/bootstrap-datetimepicker.min.css" rel="stylesheet"/>

<link rel="stylesheet" type="text/css" href="publics/css/zg-common.css">
<link rel="stylesheet" type="text/css" href="publics/css/plugins/star/star-rating.min.css">
<link href="publics/css/plugins/fileInput/fileinput.css" rel="stylesheet"/>
<%
	headerPage="USER_CENTER";
%>
</head>
<body>
	<!--导航栏-->
	<%@include file="/include/validate.jsp" %>
    <%@include file="/include/header.jsp" %>
    <div class="container">
    <div class="row">
    <div class="panel panel-default">
    	<div class="panel-heading">编辑项目</div>
    	<div class="panel-body">
    	<div id="toubiao"></div>
    <div class="container">
	<form action="" method="post" onsubmit="return doc.onNewProject(this, true)">
	<input name="projectId" class="display_none" value='${data.get("t40").get("F01") }'>
	<div class="row mt20 tc">
		<div class="col-sm-1"></div>
		<div class="col-sm-2 tc">
			<span class="fr">项目名称：</span>
			<span class="red fr lh15">*</span>
			
		</div>
		<div class="col-sm-2 tc">
			<input style="width:100%;" value='${data.get("t40").get("F02") }' class="m-input-form-control" name="projectName" type="text" placeholder="字数大于4少于20" maxlength=20 onblur="doc.checkProjectName(this)">
			<span error class="display_none red fl"></span>
		</div>
		<div class="col-sm-2 tc">
			<span class="fr">意向价格：</span>
		</div>
		<div class="col-sm-3">
			<input style="width:80%;"  value='${data.get("t40").get("F03") }' class="fl m-input-form-control" name="willPrice" type="text" placeholder="可选面议" maxlength=10 onblur="doc.checkWillPrice(this);">
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
			<input style="width:100%;" value="${data.get("t40").get("F17") }" class="m-input-form-control" name="bidDays" type="text" placeholder="请输入招标天数" maxlength=10 onblur="doc.checkBidDays(this)">
			<span error class="display_none red fl"></span>
		</div>
		<div class="col-sm-2 tc">
			<span class="fr">希望完成时间：</span>
			<span class="red fr lh15">*</span>
		</div>
		<div class="col-sm-3">
			<input style="width:80%;" value='${data.get("t40").get("F12") }' readonly date type="text" name="timeLimit" 
			class="fl m-input-form-control" placeholder="请输入希望完成日期" 
			maxlength=10 onblur="doc.checkTimeLimit(this, true)"
			onchange="doc.checkTimeLimit(this, true)"
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
		   >${data.get("t40").get("F13") }</textarea><br>
		   <span error class="display_none red"></span>
		</div>
	</div>
	<div class="row tc mt10">
		<input type="submit" class="btn btn-primary"  value="提交">
	</div>
	</form>
	<hr>
	<div class="row tc mt10">
		<span>附件上传（可以上传一份包含样例数据的Excel文档）</span>
		<br>
		<div class="mt10">
		<c:if test="${data.get(\"filename\")!=null }">
			<a href='download/attachment?filename=${data.get("filename") }' >已上传附件，下载查看</a>
		</c:if>
		</div>
		<div class="mt10">
		<input type="button" onclick="show()" class="btn btn-primary" value="上传文件">
		</div>
	</div>
</div>
    </div></div></div></div>
    
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
               	上传文件
            </h4>
         </div>
         <form id="fileForm" enctype="multipart/form-data" action="project/attachment" method="post" onSubmit="return fileUpload()">
         <div class="modal-body">
                <input id="file_1" name="filePath" type="file" >
            	<input name="filename" class="display_none" type="text"/>
            	<input name="pid" class="display_none" type="text" value='${data.get("t40").get("F01") }'>
            	<span id="filename_hint" class="mt10 gray">可以上传一份不超过10M的文档</span>            
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
    
    <!--底部导航栏-->
   <%@include file="/include/footer.jsp" %>
   <%--对话框 --%>
   <%@include file="/include/dialog.jsp" %>
  	<%@include file="/include/star.jsp" %>
   <script>
   function goToTopXX(obj){
	    var _targetTop = $('#'+obj).offset().top;//获取位置
	    jQuery("html,body").animate({scrollTop:_targetTop},300);//跳转
	}
   var doc = {};
   require(["jquery-2.1.1"], function() {
	   require(["bootstrap"], function() {
		   require(["publics/js/plugins/date/bootstrap-datetimepicker.min.js",
		            "publics/js/plugins/fileInput/fileinput.js"],function(){
			   require(["publics/js/plugins/date/bootstrap-datetimepicker.zh-CN.js",
			            "publics/js/plugins/fileInput/fileinput_locale_zh.js"], 
					   function(){
				   require(["user/project/newProject","dialog"], function(_doc, dialog){
					   var data = eval('('+'${data}'+')');
					   doc = _doc;
					   console.log(data);
					   if(data.t40.F03 == 0.0) {
							$("#mianyi").html("面议"); 
					   }
				   });
				})
				$('#file_1').fileinput({
					language: 'zh',
					showUpload : false,
	                showRemove : false,
				    maxFileSize : 10000,
				    allowedFileExtensions : ['xlsx',"xls"],
				});
				$("input[name='filename']").addClass("display_none");
				fileUpload = function() {
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
				show = function() {
					$("#imgImputDialog").modal("show");
				}
				download = function(){
					
				}
		   })
	   });
   });
   </script>
</body>
</html>