<%@ page language="java" contentType="text/html; charset=utf-8"%>
<script>
require(["jquery-2.1.1.min"], function(){
 	require(["user/user/userList"], function(ProjectList){
 		$("#consoleUser_loading").show();
 		$("#consoleUsernumber").hide();
		var list = new ProjectList("consoleUser", true);
		list.loadData($("#consoleUser_tmplData"), $("#consoleUser_tmplTable"),function(data){
			$("#consoleUser_loading").hide();
			if(data==null||data.data==null||data.data.length == 0) {
				$("#consoleUser_noDataHint").show();
				$("ul[name=consoleUser_paging]").hide()
				$("#consoleUser_tmplTable").hide();
			}else {
				$("#consoleUsernumber").show();
				$("#consoleUsernumber").children("span").html(data.count);
			}
		});
		scConsoleUser = list.operator.scConsoleUser;
	});
}) 
</script>
<div class="container">
	<div class="row tc orange fs08 mt10" id="consoleUsernumber">共<span></span>条记录</div>
	<%-- 暂无数据 --%>
			<div id="consoleUser_noDataHint" class="row tc orange fs15 mt20 display_none">暂无数据</div>
			<div id="consoleUser_loading" class="row tc">
				<img src="publics/images/loadingBig.gif"></img>
			</div>
			<%-- 分页 --%>
			<div class="row col-sm-12 fl">
			<ul class="pagination fs08 ml30 mt10 cp" name="consoleUser_paging">
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
			<table class="table table-hover" id="consoleUser_tmplTable" style="width:60%;">
				<tr>
				<th>管理员组</th>
				<th>用户名</th>
				<th>操作</th>
				</tr>
				<script id="consoleUser_tmplData" type="text/x-jquery-tmpl">
				{{each(i, d) data}}
				{{if d!=null}}
				<tr>
					<td>{{= F02}}</td>
					<td>{{= F03}}</td>
					<td class="cp"><a onclick="scConsoleUser({{= F01}})">删除</a><a class="ml10">查看权限</a></td>
				</tr>
				{{/if}}
				{{/each}}
				</script>
			</table>
			</div>
			<%-- 分页 --%>
			<div class="row col-sm-12 fl">
			<ul class="pagination fs08 ml30 mt10 cp" name="consoleUser_paging">
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