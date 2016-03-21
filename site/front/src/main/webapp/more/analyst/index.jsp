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

<%--筛选条件框 --%>
<link rel="stylesheet" type="text/css" href="publics/css/shaixuan/list.css"/>
<link rel="stylesheet" type="text/css" href="publics/css/shaixuan/manhuaDate.1.0.css"/>

<%--列表 --%>
<link rel="stylesheet" type="text/css" href="publics/css/zg-common.css">
 
<script type="text/javascript" src="publics/js/shaixuan/jquery-1.5.1.js"></script>
<script src="publics/js/plugins/template/jquery.tmpl.min.js"></script>
<script type="text/javascript" src="publics/js/shaixuan/ui.tab.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	var tab = new $.fn.tab({
		tabList:"#demo1 .ui-tab-container .ui-tab-list li",
		contentList:"#demo1 .ui-tab-container .ui-tab-content"
	});
	var tab = new $.fn.tab({
		tabList:"#demo1 .ui-tab-container .ui-tab-list2 li",
		contentList:"#demo1 .ui-tab-container .ui-tab-content2"
	});		
});	
</script>
<script type="text/javascript">
$(document).ready(function(e) {
    $("#selectList").find(".more").toggle(function(){
	$(this).addClass("more_bg");
	$(".more-none").show()
    },function(){
	$(this).removeClass("more_bg");
	$(".more-none").hide()
	});
});
$(document).ready(function(){
	var taboy_box=$(".lefttable-list");
	taboy_box.children("tbody").find("tr:gt(2)").hide(); 
	$(".leftbox-morea").toggle(function(){
	$(this).parent().prev().find("tr").show();
	$(this).addClass("more-i")
	},function(){
	$(this).removeClass("more-i");
	$(this).parent().prev().children("tbody").find("tr:gt(2)").hide(); 
	}
	);
});
</script>
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
    		<div style="padding:0px 30px 10px 10px;">
		    <div class="screen-term">
		      <div class="selectNumberScreen">
		        <div id="selectList" class="screenBox screenBackground">
		          <dl class="listIndex" attr="薪酬范围">
		            <dt>学历要求</dt>
		            <dd>
		              <label><a href="javascript:;" values2="" values1="" attrval="不限">不限</a></label>
		              <label>
		                <input name="radio2" type="radio" value="" />
		                <a href="javascript:;" values2="99" values1="1" attrval="1-99">本科以上</a></label>
		              <label>
		                <input name="radio2" type="radio" value="" />
		                <a href="javascript:;" values2="300" values1="100" attrval="100-300">硕士以上 </a></label>
		              <label>
		                <input name="radio2" type="radio" value="" />
		                <a href="javascript:;" values2="600" values1="300" attrval="300-600">博士以上</a></label>
		            </dd>
		          </dl>
		          <dl class=" listIndex" attr="terminal_os_s">
		            <dt>从业年限</dt>
		            <dd>
		              <label><a href="javascript:;" values2="" values1="" attrval="不限">不限</a> </label>
		              <label>
		                <input name="checkbox2" type="checkbox" value="" autocomplete="off"/>
		                <a href="javascript:;" values2="" values1="" attrval="android"> 一年以上</a> </label>
		              <label>
		                <input name="checkbox2" type="checkbox" value="" autocomplete="off"/>
		                <a href="javascript:;" values2="" values1="" attrval="symbian">三年以上</a></label>
		              <label>
		                <input name="checkbox2" type="checkbox" value="" autocomplete="off"/>
		                <a href="javascript:;" values2="" values1="" attrval="百度易平台">五年以上</a></label>
		              <label>
		                <input name="checkbox2" type="checkbox" value="" autocomplete="off"/>
		                <a href="javascript:;" values2="" values1="" attrval="百度易平台">十年以上</a></label>
		            </dd>
		          </dl>
		          <dl class="listIndex" attr="terminal_brand_s">
		            <dt>分数要求</dt>
		            <dd>
		              <label><a href="javascript:;" values2="" values1="" attrval="不限">不限</a></label>
		              <label>
		                <input name="checkbox2" type="checkbox" value="" autocomplete="off"/>
		                <a href="javascript:;" values2="" values1="" attrval="小米">1分以上</a></label>
		              <label>
		                <input name="checkbox2" type="checkbox" value="" autocomplete="off"/>
		                <a href="javascript:;" values2="" values1="" attrval="华为">3分以上</a> </label>
		              <label>
		                <input name="checkbox2" type="checkbox" value="" autocomplete="off"/>
		                <a href="javascript:;" values2="" values1="" attrval="lenovo">4分以上</a> </label>
		               </dd> 
		          </dl>
		        </div>
      </div>   
    </div>
    </div>
    
    <div class="hasBeenSelected clearfix"><span id="time-num">共<font id="number">208</font>名分析师</span>
          <div style="float:right;" class="eliminateCriteria">【清空】 </div>
          <dl>
            <dt>已选条件：</dt>
            <dd style="DISPLAY: none" class=clearDd>
              <div class=clearList></div>
          </dl>
     </div>
     <script type="text/javascript" src="publics/js/shaixuan/shaixuan.js"></script> 
  	 </div></div></div></div>
    
    <%--企业项目列表 --%>
	<div class="container">
    	<div class="panel panel-default">
    	<div class="panel-heading">所有项目</div>
    	<div class="panel-body">
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
					<td class="col-sm-2">
						<span><a><img src="{{= d.t20.F09 }}" alt="图像" width=100 height=100></a></span>
					</td>
					<td class="col-sm-10">
						<div class="row mt10">
							<span class="fs15 orange col-sm-3">{{= d.t20.F02 }}</span>
							<span class="fs08 lightblue col-sm-8 mt10">{{= d.t20.F06 }}年从业经历</span>
						</div>
						<div class="row mt20">
							<span title='{{= d.t20.F05 }}' class="gray col-sm-8 fl">{{= d.t20._F05 }}</span>
							<span class="col-sm-4">学历：{{= d.t20.F10 }}</span>
						</div>
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
			<%-- 分页结束 --%>
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
</body>
</html>