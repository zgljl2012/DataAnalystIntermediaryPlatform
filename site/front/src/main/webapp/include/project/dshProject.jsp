<%@ page language="java" contentType="text/html; charset=utf-8"%>
<script>
$("#dsh_loading").show();
require(["user/project/projectList"], function(doc){
	doc.loadData($("#dsh_tmplData"), $("#dsh_tmplTable"), function(data){
		$("#dsh_loading").hide();
		if(data==null||data.length == 0) {
			$("#dsh_noDataHint").show();
			$("ul[name=dsh_paging]").hide()
		}
	});
});
</script>
<div class="container">
	<%-- 暂无数据 --%>
			<div id="dsh_noDataHint" class="row tc orange fs15 mt10 display_none">暂无数据</div>
			<div id="dsh_loading" class="row tc">
				<img src="publics/images/loadingBig.gif"></img>
			</div>
			<%-- 分页 --%>
			<div class="row col-sm-12 fl">
			<ul class="pagination fs08 ml30 mt10 cp" name="dsh_paging">
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
			<table class="table table-hover col-sm-12" id="dsh_tmplTable">
				<script id="dsh_tmplData" type="text/x-jquery-tmpl">
				{{each(i, d) data}}
				{{if d!=null}}
				<tr class="fl row col-sm-12">
					<td>{{= d }}</td>
				</tr>
				{{/if}}
				{{/each}}
				</script>
			</table>
			<%-- 分页 --%>
			<div class="row col-sm-12 fl">
			<ul class="pagination fs08 ml30 mt10 cp" name="dsh_paging">
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