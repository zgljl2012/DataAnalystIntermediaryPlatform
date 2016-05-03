<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html lang="zh">
<head>
<title>项目市场-<%=variableManage.getValue(SystemVariable.SITENAME) %></title>
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
<script src="publics/js/ie-emulation-modes-warning.js"></script>
<%--项目列表 --%>
<link rel="stylesheet" type="text/css" href="publics/css/zg-common.css">
<%headerPage="XMSC";%>
</head>
<body>
	<!--导航栏-->
    <%@include file="/include/header.jsp" %>
    <%--搜索条件框--%>
    <div class="container">
    <div class="panel panel-default">
    	<div class="panel-heading">筛选条件</div>
    	<div class="panel-body">
  		<div class="row">
    		<div style="padding:0px 30px 10px 10px;">
		    <div class="screen-term">
		      <div class="selectNumberScreen">
		        <div id="selectList" class="screenBox screenBackground">
		          <dl>
		            <dt>项目进度</dt>
		            <dd>
		              <label><a hint href="javascript:;">不限</a></label>
		              <label>
		                <input name="status" type="radio" value="TBZ" />
		                <a hint href="javascript:;">可投标</a></label>
		              <label>
		                <input name="status" type="radio" value="JXZ" />
		                <a hint href="javascript:;" >工作中</a></label>
		              <label>
		                <input name="status" type="radio" value="YJS" />
		                <a hint href="javascript:;" >已完成</a></label>
		            </dd>
		          </dl>
		          <dl>
		            <dt>薪酬范围</dt>
		            <dd>
		              <label><a hint href="javascript:;">不限</a></label>
		              <label>
		                <input name="salaryRange" type="radio" value="1000" autocomplete="off"/>
		                <a hint href="javascript:;">一千以下</a> </label>
		              <label>
		                <input name="salaryRange" type="radio" value="5000" autocomplete="off"/>
		                <a hint href="javascript:;">五千以下</a></label>
		              <label>
		                <input name="salaryRange" type="radio" value="9999" autocomplete="off"/>
		                <a hint href="javascript:;">一万以下</a></label>
		              <label>
		                <input name="salaryRange" type="radio" value="10000" autocomplete="off"/>
		            	<a hint href="javascript:;">一万以上</a></label>
		            </dd>
		          </dl>
		          <dl>
		            <dt>企业评分</dt>
		            <dd>
		              <label><a hint href="javascript:;" >不限</a></label>
		              <label>
		                <input name="grade" type="radio" value="1" autocomplete="off"/>
		                <a hint href="javascript:;" >1分</a></label>
		              <label>
		                <input name="grade" type="radio" value="2" autocomplete="off"/>
		                <a hint href="javascript:;" >2分</a> </label>
		              <label>
		                <input name="grade" type="radio" value="3" autocomplete="off"/>
		                <a hint href="javascript:;" >3分</a> </label>
		              <label>
		                <input name="grade" type="radio" value="4" autocomplete="off"/>
		                <a hint href="javascript:;" >4分</a> </label>
		              <label>
		                <input name="grade" type="radio" value="5" autocomplete="off"/>
		                <a hint href="javascript:;" >5分</a> </label>
		               </dd> 
		          </dl>
		        </div>
      </div>   
    </div>
    </div>
    <div class="hasBeenSelected clearfix"><span style="position:absolute;left:10px;top:10px;" id="time-num">共<font id="number" style="color:#fa7003;"></font>个项目</span>
          <div style="float:right;" class="eliminateCriteria" id="clearAll">【清空】 </div>
          <dl>
            <dt>已选条件：</dt>
            <dd id="hasSelected" class="selectedInfor"></dd>
          </dl>
     </div>
     </div></div></div></div>
    
    <%--企业项目列表 --%>
	<div class="container">
    	<div class="panel panel-default">
    	<div class="panel-heading">所有项目</div>
    	<div class="panel-body">
    		<div id="project_noDataHint" class="row tc orange fs15 mt10 display_none">暂无数据</div>
			<div id="project_loading" class="row tc">
				<img src="publics/images/loadingBig.gif"></img>
			</div>
			<%-- 分页 --%>
			<div class="row col-sm-12 fl">
			<ul class="pagination fs08 ml30 mt10 cp" name="project_paging">
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
			<table class="table table-hover" id="project_tmplTable" >
				<script id="project_tmplData" type="text/x-jquery-tmpl">
				{{each(i, d) data}}
				{{if d!=null}}
				<tr>
					<td >
						<div>
							<span class="zg-price">{{= t40.F03 }}</span>
							<span class="zg-title cp"><a href="project/page/{{= t40.F01 }}">{{= t40.F02 }}</a></span>
							<span class="zg-time-before-limit">{{= t40.F17 }}天后截止</span>
						</div><br>
						<div>
							<span class="zg-content-abbr">{{= t40.F13 }}</span>
							<span class="zg-time-after-limit">发布时间：{{= t40.F06 }}</span>
							{{if d.t40.F05 == 'TBZ'}}
							<span class="zg-time-after-limit">期望完成时间：{{= t40.F12 }}</span>
							{{/if}}
							<span class="zg-join-people">现有28人参与</span>
						</div>
					</td>
				</tr>
				{{/if}}
				{{/each}}
				</script>
			</table>
			<%-- 分页 --%>
			<div class="row col-sm-12 fl">
			<ul class="pagination fs08 ml30 mt10 cp" name="project_paging">
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
		</div>
		</div>
	</div>
    <!--底部导航栏-->
   <%@include file="/include/footer.jsp" %>
   <%@include file="/include/dialog.jsp" %>
   <script>
   var refresh = function(data,count){
		$("#project_loading").hide();
		var size = data&&data.length;
		console.log(count)
		$("#number").html(count)
		if(data==null||data.length == 0) {
			$("#project_noDataHint").show();
			$("ul[name=project_paging]").hide()
		} else {
			$("#project_noDataHint").hide();
			$("ul[name=project_paging]").show()
		}
	}
   require(["jquery-2.1.1","bootstrap.min","project/project", "common/filter2"], function(bootstrap, jq, doc, filter){
	   $("ul[name=project_paging]").hide();
	   doc.loadData($("#project_tmplData"), $("#project_tmplTable"), refresh);
	   filter.init($("#selectList"), $("#hasSelected"), function(data){
	   	doc.params = data;
		   doc.loadData($("#project_tmplData"), $("#project_tmplTable"), refresh);
		})
		$("#clearAll").click(function(){
			filter.clear()
		})
   })
   </script>
</body>
</html>