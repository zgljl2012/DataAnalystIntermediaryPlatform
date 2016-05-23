<%@ page language="java" contentType="text/html; charset=utf-8"%>
<script>
require(["jquery-2.1.1.min"], function(){
 	require(["user/user/userList"], function(ProjectList){
 		$("#consoleGroup_loading").show();
 		$("#consoleGroupnumber").hide();
		var list = new ProjectList("consoleGroup", false, true);
		list.loadData($("#consoleGroup_tmplData"), $("#consoleGroup_tmplTable"),function(data){
			$("#consoleGroup_loading").hide();
			if(data==null||data.data==null||data.data.length == 0) {
				$("#consoleGroup_noDataHint").show();
				$("ul[name=consoleGroup_paging]").hide()
				$("#consoleGroup_tmplTable").hide();
			}else {
				$("#consoleGroupnumber").show();
				$("#consoleGroupnumber").children("span").html(data.count);
			}
		});
		scconsoleGroup = list.operator.scconsoleGroup;
	});
}) 
</script>
<div class="container">
	<div class="row tc orange fs08 mt10" id="consoleGroupnumber">共<span></span>条记录</div>
	<%-- 暂无数据 --%>
			<div id="consoleGroup_noDataHint" class="row tc orange fs15 mt20 display_none">暂无数据</div>
			<div id="consoleGroup_loading" class="row tc">
				<img src="publics/images/loadingBig.gif"></img>
			</div>
			<%-- 分页 --%>
			<div class="row col-sm-12 fl">
			<ul class="pagination fs08 ml30 mt10 cp" name="consoleGroup_paging">
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
			<table class="table table-hover" id="consoleGroup_tmplTable" style="width:40%;">
				<tr>
				<td>名称</td>
				<td>操作</td>
				</tr>
				<script id="consoleGroup_tmplData" type="text/x-jquery-tmpl">
				{{each(i, d) data}}
				{{if d!=null}}
				<tr>
					<td>{{= F02}}</td>
					<td class="cp"><a href="permission?gid={{= F01 }}">查看权限</a>
					<a href="user/addUserGroup" class="ml10">添加用户组</a></td>
				</tr>
				{{/if}}
				{{/each}}
				</script>
			</table>
			</div>
			<%-- 分页 --%>
			<div class="row col-sm-12 fl">
			<ul class="pagination fs08 ml30 mt10 cp" name="consoleGroup_paging">
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