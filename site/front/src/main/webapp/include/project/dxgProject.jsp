<%@ page language="java" contentType="text/html; charset=utf-8"%>
<script>
require(["jquery-2.1.1.min"], function(){
	 	require(["user/project/projectList"], function(ProjectList){
	 		$("#dxg_loading").show();
			var list = new ProjectList("DXG");
			list.loadData($("#dxg_tmplData"), $("#dxg_tmplTable"),function(data){
				$("#dxg_loading").hide();
				if(data==null||data.length == 0) {
					$("#dxg_noDataHint").show();
					$("ul[name=dxg_paging]").hide()
				}
			});
		});
}) 
</script>
<div class="container">
	<%-- 暂无数据 --%>
			<div id="dxg_noDataHint" class="row tc orange fs15 mt10 display_none">暂无数据</div>
			<div id="dxg_loading" class="row tc">
				<img src="publics/images/loadingBig.gif"></img>
			</div>
			<%-- 分页 --%>
			<div class="row col-sm-12 fl">
			<ul class="pagination fs08 ml30 mt10 cp" name="dxg_paging">
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
			<table class="table table-hover" id="dxg_tmplTable" style="width:95%;">
				<script id="dxg_tmplData" type="text/x-jquery-tmpl">
				{{each(i, d) data}}
				{{if d!=null}}
				<tr>
					<td >
						<div class="row">
						<div class="col-sm-10">
						<div class="row col-sm-11">
							<span class="zg-price">{{= t40.F03 }}</span>
							<span class="zg-title cp"><a href="project/page/{{= t40.F01 }}">{{= t40.F02 }}</a></span>
							<span class="zg-time-before-limit">{{= t40.F17 }}天后截止</span>
						</div>
						<div class="row col-sm-11">
							<span class="zg-content-abbr">{{= t40.F13 }}</span>
							<span class="zg-time-after-limit">完成时间：{{= t40.F12 }}</span>
						</div></div>
						<div class="col-sm-2 mt40">
						<div class="select-buttons fr">
							<button class="btn-8" onclick='window.location.href="project/edit/{{= t40.F01}}"'>编辑</button>
						</div>
						</div>
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
			<ul class="pagination fs08 ml30 mt10 cp" name="dxg_paging">
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