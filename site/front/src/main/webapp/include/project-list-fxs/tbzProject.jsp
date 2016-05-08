<%@ page language="java" contentType="text/html; charset=utf-8"%>
<script>
$("#tbz_loading").show();
require(["user/project/projectList-fxs"], function(ProjectList){
	var list = new ProjectList("TBZ");
	list.loadData($("#tbz_tmplData"), $("#tbz_tmplTable"), function(data){
		$("#tbz_loading").hide();
		if(data==null||data.length == 0) {
			$("#tbz_noDataHint").show();
			$("ul[name=tbz_paging]").hide();
		}
	});
});
</script>
<div class="container">
	<%-- 暂无数据 --%>
			<div id="tbz_noDataHint" class="row tc orange fs15 mt10 display_none">暂无数据</div>
			<div id="tbz_loading" class="row tc">
				<img src="publics/images/loadingBig.gif"></img>
			</div>
			<%-- 分页 --%>
			<div class="row col-sm-12 fl">
			<ul class="pagination fs08 ml30 mt10 cp" name="tbz_paging">
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
			<table class="table table-hover" id="tbz_tmplTable" style="width:95%;">
				<script id="tbz_tmplData" type="text/x-jquery-tmpl">
				{{each(i, d) data}}
				{{if d!=null}}
				<tr>
					<td >
						<div class="w80">
							<span class="zg-price">{{= price }}</span>
							<span class="zg-title cp"><a href="project/page/{{= F02 }}">{{= projectName }}</a></span>
							<span class="zg-time-before-limit">{{= days }}天后截止</span>
						</div><br>
						<div class="w80">
							<span class="zg-content-abbr">{{= description }}</span>
							<span class="zg-time-after-limit">投标时间：{{= F05 }}</span>
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
			<ul class="pagination fs08 ml30 mt10 cp" name="tbz_paging">
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