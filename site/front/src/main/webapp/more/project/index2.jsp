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
    
<%--筛选条件框 --%>
<link rel="stylesheet" type="text/css" href="publics/css/shaixuan/list.css"/>
<link rel="stylesheet" type="text/css" href="publics/css/shaixuan/manhuaDate.1.0.css"/>

<%--项目列表 --%>
<link rel="stylesheet" type="text/css" href="publics/css/zg-common.css">
 
<script type="text/javascript" src="publics/js/shaixuan/jquery-1.5.1.js"></script>
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
$(function (){
	$("input.mh_date").datejs({					       
		Event : "click",//可选				       
		Left : 0,//弹出时间停靠的左边位置
		Top : -16,//弹出时间停靠的顶部边位置
		fuhao : "-",//日期连接符默认为-
		isTime : false,//是否开启时间值默认为false
		beginY : 2010,//年份的开始默认为1949
		endY :2015//年份的结束默认为2049
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
	headerPage="XMSC";
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
		            <dt>薪酬范围</dt>
		            <dd>
		              <label><a href="javascript:;" values2="" values1="" attrval="不限">不限</a></label>
		              <label>
		                <input name="radio2" type="radio" value="" />
		                <a href="javascript:;" values2="99" values1="1" attrval="1-99">100元以下</a></label>
		              <label>
		                <input name="radio2" type="radio" value="" />
		                <a href="javascript:;" values2="300" values1="100" attrval="100-300">100-1000元 </a></label>
		              <label>
		                <input name="radio2" type="radio" value="" />
		                <a href="javascript:;" values2="600" values1="300" attrval="300-600">1000-5000元</a></label>
		              <div class="custom"><span>自定义</span>&nbsp;
		                <input name="" type="text" id="custext1"/>
		                &nbsp;-&nbsp;
		                <input name="" type="text" id="custext2"/>
		                <input name="" type="button" id="cusbtn"/>
		              </div>
		            </dd>
		          </dl>
		          <dl class=" listIndex" attr="terminal_os_s">
		            <dt>完成期限</dt>
		            <dd>
		              <label><a href="javascript:;" values2="" values1="" attrval="不限">不限</a> </label>
		              <label>
		                <input name="checkbox2" type="checkbox" value="" autocomplete="off"/>
		                <a href="javascript:;" values2="" values1="" attrval="android"> 一天内</a> </label>
		              <label>
		                <input name="checkbox2" type="checkbox" value="" autocomplete="off"/>
		                <a href="javascript:;" values2="" values1="" attrval="symbian">三天内</a></label>
		              <label>
		                <input name="checkbox2" type="checkbox" value="" autocomplete="off"/>
		                <a href="javascript:;" values2="" values1="" attrval="百度易平台">七天内</a></label>
		              <label>
		                <input name="checkbox2" type="checkbox" value="" autocomplete="off"/>
		                <a href="javascript:;" values2="" values1="" attrval="百度易平台">一年内</a></label>
		              <label>
		                <input name="checkbox2" type="checkbox" value="" autocomplete="off"/>
		                <a href="javascript:;" values2="" values1="" attrval="百度易平台">其他</a></label>
		            </dd>
		          </dl>
		          <dl class="listIndex" attr="terminal_brand_s">
		            <dt>项目状态</dt>
		            <dd>
		              <label><a href="javascript:;" values2="" values1="" attrval="不限">不限</a></label>
		              <label>
		                <input name="checkbox2" type="checkbox" value="" autocomplete="off"/>
		                <a href="javascript:;" values2="" values1="" attrval="小米">投标中</a></label>
		              <label>
		                <input name="checkbox2" type="checkbox" value="" autocomplete="off"/>
		                <a href="javascript:;" values2="" values1="" attrval="华为">已完成</a> </label>
		              <label>
		                <input name="checkbox2" type="checkbox" value="" autocomplete="off"/>
		                <a href="javascript:;" values2="" values1="" attrval="lenovo">进行中</a> </label>
		               </dd> 
		          </dl>
		        </div>
      </div>   
    </div>
    </div>
    
    <div class="hasBeenSelected clearfix"><span id="time-num"><font>208</font>个项目</span>
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
    		
			<table class="table table-hover">
				<tr>
					<td>
					<div>
						<span class="zg-price">￥100.00</span>
						<span class="zg-title"><a href="#">标题...</a></span>
						<span class="zg-time-before-limit">3天后截止</span>
					</div>
					<div>
						<span class="zg-content-abbr">内容共设30个字，多余的使用...</span>
						<span class="zg-time-after-limit">完成期限：3天</span>
						<span class="zg-join-people">现有28人参与</span>
					</div>
					</td>
				</tr>
				<tr><td>2</td></tr>
				<tr><td>3</td></tr>
			</table>
		</div>
		</div>
	</div>    
    <!--底部导航栏-->
   <%@include file="/include/footer.jsp" %>
</body>
</html>