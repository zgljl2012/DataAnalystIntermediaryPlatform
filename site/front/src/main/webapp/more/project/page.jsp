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

<link rel="stylesheet" type="text/css" href="publics/css/zg-common.css">
<link rel="stylesheet" type="text/css" href="publics/css/plugins/star/star-rating.min.css">
<%
	headerPage="XMSC";
	BidManage bidManage = controller.getServiceManage().getService(BidManage.class);
	boolean isMatch = false;
	boolean isSelected = false;
	int projectId = Integer.parseInt(
			(String)(((JSON)((JSON)request.getAttribute("data")).get("t40")).get("F01")));
	isSelected = bidManage.isSelected(projectId);
	if(ljlSession.isLogined()) {
		isMatch = bidManage.isMatch(projectId,
			ljlSession.getUserId());
	}
	int userId = controller.getSession(session).getUserId();
	request.setAttribute("isMatch", isMatch);
	request.setAttribute("isSelected", isSelected);
	int selectId = -1; 
	if(isMatch) {
		selectId = bidManage.getSelectedUserId(projectId);
		request.setAttribute("selectedId", selectId);
	}
%>
</head>
<body>
	<!--导航栏-->
    <%@include file="/include/header.jsp" %>
    <div class="container">
    <div class="row">
    <div class="panel panel-default">
    	<div class="panel-heading">${data.get("t40").get("F02")}</div>
    	<div class="panel-body">
    	<div class="row">
    	<div id="toubiao"></div>
	    	<div class="col-sm-6 fs20 ml15 mt10 orange">
	    		${data.get("t40").get("F02")}
		    	<div class="fs06 mt20 red">
		    		预算：<label id="mianyi">￥${ data.get("t40").get("F03")}元</label>
		    	</div>
		    	<div class="fs06 mt20 wh400 gray">项目描述：</div>
		    	<div class="fs06 mt5 wh400 gray">
		    	${ data.get("t40").get("F13") }
		    	</div>
	    	</div>
	    	<div class="col-sm-4 fs12 mt10">
	    	<div>期望完成时间：<span class="red">${ data.get("t40").get("F12") }</span></div>
	    		<c:choose>
	    		<c:when test='${data.get("t40").get("F05").equals("TBZ")}'>
	    			<div class="mt10">投标剩余天数：${data.get("t40").get("F17") }</div>
	    		</c:when>
	    		</c:choose>
	    	</div>
    	</div>
    	<hr>
    	<c:if test="${!isSelected}">
    	<div class="row">
    		<div class="col-sm-12 fs12 mt5">
    			<div class="ml15">我要投标：</div>
    			<form action="" method="post">
    			<div class="ml15 mt5">
    				<textarea name="solution" cols="80" rows="6" placeholder="请输入项目需求提出您的解决方案，解决方案只有雇主可见（登录后可提交）"></textarea>
    			</div>
    			<div class="mt5 col-sm-4">
    				<input type="text" name="quote_price" class="m-input-form-control" placeholder="请输入您的报价">
    				<input type="button" id="release" value="发布" class="btn btn-primary" <%if(!ljlSession.isLogined()) out.println("disabled"); %>>
    			</div>
    			</form>
    		</div>
    	</div>
    	</c:if>
    	<c:if test="${isSelected}">
    	<div class="row">
    		<c:if test='${data.get("t40").get("F05").equals("JXZ")}'>
	    		<div class="col-sm-12 tc fs15 red">
	    			<span>企业已选择分析师，分析师工作中...</span>
	    		</div>
    			<c:if test="${isMatch}">
		    		<div class="col-sm-12 tc">
		    			<button class="btn-8 mt10" name="fxsFinish">分析师已完成工作</button>
		    		</div>
		    	</c:if>
    		</c:if>
    		<c:if test='${data.get("t40").get("F05").equals("YJS")}'>
	    		<div class="col-sm-12 tc fs15 red">
	    			<span>当前项目已圆满结束</span>
	    		</div>
	    		<c:if test="${isMatch}">
		    		<div class="col-sm-12 tc mt20">
		    			<div>
		    			<span>评分：<label name="qy2fxs_grade"></label></span><br>
		    			<textarea rows="8" cols="80" name="qy2fxs_comment" readonly></textarea>
		    			</div>
		    			<button class="btn-8 mt10" name="commentUpdate">修改评论</button>
		    		</div>
		    	</c:if>
    		</c:if>
    	</div>
    	</c:if>
    	<hr>
    	<%-- 分页 --%>
			<div class="row col-sm-12 fl">
			<ul class="pagination fs08 ml30 mt10 cp" name="bid_paging">
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
    	<div class="row">
    		<table class="table table-hover" id="project-bid-table">
    		<script type="text/x-jquery-tmpl" id="project-bid-item-tmpl">
    		{{each(i, d) data}}
				{{if d!=null}}
				<tr>
					<td class="opacity-black-position">
						<div class="col-sm-12">
							<span class="lightblue fs12 col-sm-4">{{= d.username }}</span>
							<span class="col-sm-4 fr">投标时间：<label>{{= d.F05 }}</label></span>
							<span class="col-sm-3">报价：<label>{{= d.F04 }}</label>元</span>
						</div>
						<div class="col-sm-12">
							<span class="col-sm-12 fs08 gray">投标：<span>
							<div class="row">
							<pre class="col-sm-12 fs10 gray pre-comment">
								{{= d._comment }}
							</pre>
							</div>
						</div>
						<div class="visibility_hidden select-buttons fr">
   	 						<button class="btn-8 <%=isSelected?"display_none":""%>" onclick="select({{= d.F01}})">中标</button>
   	 						{{if d.F03!=<%=selectId%> }}
							<button class="btn-8" onclick="del({{= d.F01}})">删除</button>
   	 						{{/if}}
							<button class="btn-8">私信</button>
   						</div>
						{{if d.F03 == <%=userId%> }}
						<div class="display_none" name="{{= d.F01}}_div">{{= d.comment}}</div>
						<div class="select-buttons fr">
							<button class="btn-8 <%=isSelected?"display_none":""%>" onclick='update({{= d.F01}}, {{= d.F04}}, $("div[name={{= d.F01}}_div]").html())'>编辑</button>
						</div>
						{{/if}}
					</td>
				</tr>
			{{/if}}
			{{/each}}
    		</script>
    		</table>
    	</div>
    	<%-- 分页 --%>
			<div class="row col-sm-12 fl">
			<ul class="pagination fs08 ml30 mt10 cp" name="bid_paging">
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
 </div></div></div></div>
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
   require(["jquery-2.1.1"], function() {
	   require(["bootstrap"], function() {
		   require(["project/page","common/star", "dialog"], function(page, Star, dialog){
			   var projectId = "${data.get('t40').get('F01')}";
			   var data = eval('('+'${data}'+')');
			   if(data.t40.F03 == 0.0) {
					$("#mianyi").html("面议"); 
			   }
			   star = new Star();
			   $("ul[name=bid_paging]").hide();
			   page.list(projectId, function(data) {
				   if(data&&data.data.length>0) {
					   $("ul[name=bid_paging]").show();
				   }
				   page.showbids(data, $("#project-bid-item-tmpl"), $("#project-bid-table"));
				   $(".opacity-black-position").mouseover(function(){
				   	   if("${isMatch}"=="true") {
				   	   	   $(this).find(".select-buttons").removeClass("visibility_hidden");
				   		   $(this).find(".select-buttons").addClass("visibility_visible");
				   	   }
				   });
				   $(".opacity-black-position").mouseout(function(){
				   	   if("${isMatch}"=="true") {
				   	       $(this).find(".select-buttons").removeClass("visibility_visible");
				   		   $(this).find(".select-buttons").addClass("visibility_hidden");
				   	   }
				   });
			   });
			   $("#release").click(function(){
				  var e1 = $("textarea[name=solution]");
				  var e2 = $("input[name=quote_price]");
				  if(page.checkComment(e1)&&page.checkPrice(e2)) {
					  page.bid("${data.get('t40').get('F01')}",e2.val(), e1.val());
				  }
			   });
			   document.del = page.del;
			   document.select = page.select;
			   document.update = function(bid, price, comment){
				   $("textarea[name=solution]").val(comment);
				   $("input[name=quote_price]").val(price);
				   $("#release").unbind("click");
				   $("#release").click(function(){
					   page.update(bid, $("input[name=quote_price]").val(), $("textarea[name=solution]").val());
				   })
				   goToTopXX("toubiao");
			   }
			   $("button[name=fxsFinish]").unbind("click");
			   $("button[name=fxsFinish]").click(function() {
				  dialog.showDialog("确定您选择的分析师已经圆满完成了您的项目？（点击确定后将" +
						   "需要对分析师工作进行评价与评分）", function(){
					   star.show(function(comment, grade){
							star.qy2fxs("${data.get('t40').get('F01')}", comment, grade);
					   });
				   })
			   });
			   $("button[name=commentUpdate]").unbind("click");
			   $("button[name=commentUpdate]").click(function() {
				   star.show(function(comment, grade){
							star.qy2fxs("${data.get('t40').get('F01')}", comment, grade, function(data){
								star.getQy2Fxs("${data.get('t40').get('F01')}", function(data){
									   $("label[name=qy2fxs_grade]").html(data.grade);
								   		$("textarea[name=qy2fxs_comment]").html(data.comment);
								   });
							});
				   });
			   });
			   star.getQy2Fxs("${data.get('t40').get('F01')}", function(data){
				   $("label[name=qy2fxs_grade]").html(data.grade);
			   		$("textarea[name=qy2fxs_comment]").html(data.comment);
			   });
		   });
	   });
   });
   </script>
</body>
</html>