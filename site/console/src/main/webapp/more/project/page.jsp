<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page import="com.zgljl2012.common.database.enums.Gender" %>
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

<link rel="stylesheet" type="text/css" href="publics/css/zg-common.css">
<script src="publics/js/jquery.min.js"></script>
<script src="publics/js/plugins/template/jquery.tmpl.min.js"></script>
<script src="publics/js/bootstrap.min.js"></script>
<%
	headerPage="PROJECT";
%>
</head><%@include file="/include/validate.jsp" %>
<body>
	<!--导航栏-->
    <%@include file="/include/header.jsp" %>
    <div class="container">
    <div class="row">
    <div class="panel panel-default">
    	<div class="panel-heading">${data.get("t40").get("F02")}</div>
    	<div class="panel-body">
    <div id="fxsInfo" class="tab-content">
   <div class="row mt20 tc">
		<div class="col-sm-1"></div>
		<div class="col-sm-2 tc">
			<span class="fr">项目名称：</span>
			<span class="red fr lh15">*</span>
			
		</div>
		<div class="col-sm-2 tc">
			<input style="width:100%;" class="m-input-form-control" name="projectName" type="text" value='${ data.get("t40").get("F02") }' readonly>
		</div>
		<div class="col-sm-2 tc">
			<span class="fr">意向价格：</span>
		</div>
		<div class="col-sm-3">
			<input style="width:80%;" class="fl m-input-form-control" name="willPrice" type="text" readonly value='${ data.get("t40").get("F03")}'>
			<span class="fl ml5"><input type="checkbox" id="mianyi" checked >面议</span>
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
			<input style="width:100%;" readonly class="m-input-form-control" name="bidDays" type="text" value='${ data.get("t40").get("F17") }'>
		</div>
		<div class="col-sm-2 tc">
			<span class="fr">完成时间：</span>
		</div>
		<div class="col-sm-3">
			<input style="width:80%;" readonly type="text" name="timeLimit" 
			class="fl m-input-form-control" value='${ data.get("t40").get("F12") }'
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
		    <textarea name="projectDescription" class="mt10"  readonly
		    	class="form-control m-input-form-control" rows="8" cols="80"
		   >${ data.get("t40").get("F13") }</textarea><br>
		</div>
	</div>
	<hr>
	<div class="row tc mt10">
	<form id="form" action="project/realease" method="post">
		<input name="id" value="${ data.get("t40").get("F01") }" class="display_none">
		<input name="type" id="type" value="release" class="display_none">
		<textarea name="reason" id="reason" class="display_none"></textarea>
		<input type="button" class="btn" value="项目审核不通过" id="nopass">
		<input type="submit" class="btn btn-primary"  value="发布项目">
	</form>
	</div>
	
	<div class="modal fade" id="modalAlertDialog" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
         <div class="modal-header">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">
                  &times;
            </button>
            <h4 class="modal-title" id="modalAlertTitle">
               项目审核不通过
            </h4>
         </div>
         <div class="modal-body" id="modalAlertBody">
         	<div class="row tc"><div class="col-sm-10">
            <textarea name="reason" id="text_reason" rows="5" cols="60" placeholder="请输入不通过原因"></textarea>
            </div></div>
         </div>
         <div class="modal-footer tc">
            <button type="button" class="btn btn-default mr20" 
               data-dismiss="modal" id="modalAlertCancel">取消
            </button>
            <button type="button" class="btn btn-primary ml20" data-dismiss="modal" id="modalAlertOk">
               	确定
            </button>
         </div>
      </div><!-- /.modal-content -->
</div></div><!-- /.modal -->
 </div>
 </div></div></div></div>
    <!--底部导航栏-->
   <%@include file="/include/footer.jsp" %>
   <%--对话框 --%>
   <%@include file="/include/dialog.jsp" %>
   <script>
   var data = eval('('+'${data}'+')');
   if(data.t40.F03 == 0.0) {
		$("#mianyi").attr("checked","checked");
   } else {
	   $("#mianyi").removeAttr("checked");
   }
   $("#nopass").click(function(){
	   $("#modalAlertDialog").modal("show");
	   
   });
   $("#modalAlertOk").click(function(){
       var reason = $("#text_reason").val();
       $("#type").val("nopass");
       $("#reason").val(reason);
       document.getElementById("form").submit();
   });
   </script>
</body>
</html>