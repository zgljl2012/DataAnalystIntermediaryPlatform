<%@ page language="java" contentType="text/html; charset=utf-8"%>
<script>
require(["jquery-2.1.1.min"], function(){
 	require(["user/user/userList"], function(ProjectList){
 		$("#frontUser_loading").show();
 		$("#number").hide();
		var list = new ProjectList("frontUser");
		sc = list.operator.sc;
		usc= list.operator.usc;
		hmd = list.operator.hmd;
		uhmd = list.operator.uhmd;
		list.loadData($("#frontUser_tmplData"), $("#frontUser_tmplTable"),function(data){
			$("#frontUser_loading").hide();
			if(data==null||data.data==null||data.data.length == 0) {
				$("#frontUser_noDataHint").show();
				$("ul[name=frontUser_paging]").hide()
			}else {
				$("#number").show();
				$("#number").children("span").html(data.count);
			}
		});
	});
}) 
</script>
<div class="container">
	<div class="row tc orange fs08 mt10" id="number">共<span></span>条记录</div>
	<%-- 暂无数据 --%>
			<div id="frontUser_noDataHint" class="row tc orange fs15 mt20 display_none">暂无数据</div>
			<div id="frontUser_loading" class="row tc">
				<img src="publics/images/loadingBig.gif"></img>
			</div>
			<%-- 分页 --%>
			<div class="row col-sm-12 fl">
			<ul class="pagination fs08 ml30 mt10 cp" name="frontUser_paging">
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
			<table class="table table-hover" id="frontUser_tmplTable" style="width:95%;">
				<script id="frontUser_tmplData" type="text/x-jquery-tmpl">
				{{each(i, d) data}}
				{{if d!=null}}
				<tr>
					<td >
						<div class="w80">
							<span class="zg-price">{{= F02 }}</span>
							<span class="zg-title gray">邮箱：{{= F03 }}</a></span>
							<span class="zg-time-before-limit">用户类型：{{= F05 }}</span>
						</div><br>
						<div class="w80">
							<span class="zg-content-abbr">用户状态：{{= F08 }}</span>
							{{if F08=='启用'}}
							<span class="cp ml10"><a onclick="sc({{= F01 }})">删除用户</a></span>
							{{/if}}
							{{if F08=='删除'}}
							<span class="cp ml10"><a onclick="usc({{= F01 }})">恢复用户</a></span>
							{{/if}}
							{{if F08=='黑名单'}}
							<span class="cp ml10"><a onclick="uhmd({{= F01 }})">将用户移出黑名单</a></span>
							{{/if}}
							{{if F08=="启用" }}
							<span class="cp ml10"><a onclick="hmd({{= F01 }})">将用户加入黑名单</a></span>
							{{/if}}
							<span class="zg-time-after-limit">注册时间：{{= F07 }}</span>
						</div>
					</td>
				</tr>
				{{/if}}
				{{/each}}
				</script>
			</table>
			</div>
			<%-- 分页 --%>
			<div class="row col-sm-12 fl">
			<ul class="pagination fs08 ml30 mt10 cp" name="frontUser_paging">
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