<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html lang="zh">
<head>
<title>分析师市场-<%=variableManage.getValue(SystemVariable.SITENAME) %></title>
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
<%
	headerPage="FXSSC";
%>
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
    		<div class="pl20">
		      <div>
		        <div id="selectList" class="screenBox">
		          <dl>
		            <dt>学历要求</dt>
		            <dd>
		              <label><a hint href="javascript:;">不限</a></label>
		              <label>
		                <input name="degree" type="radio" value="BK" />
		                <a hint href="javascript:;">本科</a></label>
		              <label>
		                <input name="degree" type="radio" value="SS" />
		                <a hint href="javascript:;" >硕士 </a></label>
		              <label>
		                <input name="degree" type="radio" value="BS" />
		                <a hint href="javascript:;" >博士</a></label>
		            </dd>
		          </dl>
		          <dl>
		            <dt>从业年限</dt>
		            <dd>
		              <label><a hint href="javascript:;">不限</a> </label>
		              <label>
		                <input name="workTime" type="radio" value="1" autocomplete="off"/>
		                <a hint href="javascript:;"> 一年以上</a> </label>
		              <label>
		                <input name="workTime" type="radio" value="2" autocomplete="off"/>
		                <a hint href="javascript:;">三年以上</a></label>
		              <label>
		                <input name="workTime" type="radio" value="5" autocomplete="off"/>
		                <a hint href="javascript:;">五年以上</a></label>
		              <label>
		                <input name="workTime" type="radio" value="10" autocomplete="off"/>
		            	<a hint href="javascript:;">十年以上</a></label>
		            </dd>
		          </dl>
		          <dl>
		            <dt>分数要求</dt>
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
    
    <div class="hasBeenSelected clearfix"><span style="position:absolute;left:10px;top:10px;">共<font id="number" style="color:#fa7003;">208</font>名分析师</span>
          <div style="float:right;" class="eliminateCriteria" id="clearAll">【清空】 </div>
          <dl>
            <dt>已选条件：</dt>
            <dd id="hasSelected" class="selectedInfor"></dd>
          </dl>
     </div>
     
     </div></div></div></div>
    
    <%--企业分析师列表 --%>
	<div class="container">
    	<div class="panel panel-default">
    	<div class="panel-heading">所有分析师</div>
    	<div class="panel-body">
    		<a name="one"></a>
    		<%-- 暂无数据 --%>
			<div id="noDataHint" class="row tc orange fs15 mt10">暂无数据</div>
			<div id="loading" class="row tc">
				<img src="publics/images/loadingBig.gif"></img>
			</div>
    		<%-- 分页 --%>
			<div class="row col-sm-12 fl">
			<ul class="pagination fs08 ml30 mt10 cp" name="paging">
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
			<%-- 分页结束 --%>
			<table class="table table-hover col-sm-12" id="tmplTable">
				<script id="tmplData" type="text/x-jquery-tmpl">
				{{each(i, d) data}}
				{{if d.t20.F02!=null&&d.t20.F06!=null }}
				<tr class="fl row col-sm-12">
					<td class="col-sm-1">
						<a href='{{= d.t10.F01 }}' ><span><img src="{{= d.t20.F09 }}" alt="图像" width=110 height=105></span></a>
					</td>
					<td class="col-sm-10 fl">
						<a href='{{= d.t10.F01 }}' class="col-sm-10 fl">
						<div class="row mt10 col-sm-10 fl">
							<span class="fs15 orange col-sm-3">{{= d.t20.F02 }}</span>
							<span class="fs08 lightblue col-sm-8 mt10">{{= d.t20.F06 }}年从业经历</span>
						</div>
						<div class="row mt20 col-sm-10">
							<span title='{{= d.t20.F05 }}' class="gray col-sm-9 fl">{{= d.t20._F05 }}</span>
							<span class="col-sm-3">学历：{{= d.t20.F10 }}</span>
						</div>
						</a>
					</td>
					<td>
						<span><label class="orange">{{= d.avg}}</label></span>
					</td>
				</tr>
				{{/if}}
				{{/each}}
				</script>
			</table>
			<%-- 分页 --%>
			<div class="row col-sm-12 fl">
			<ul class="pagination fs08 ml30 mt10 cp" name="paging">
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
   <%--对话框 --%>
   <%@include file="/include/dialog.jsp" %>
   <script>
   var analystServlet = "analyst";
   </script>
   <script src="publics/js/analyst/analyst.js"></script>
   <script src="publics/js/common/filter.js"></script>
</body>
</html>