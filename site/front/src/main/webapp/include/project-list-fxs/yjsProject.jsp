<%@ page language="java" contentType="text/html; charset=utf-8"%>
<script>
$("#yjs_loading").show();
require(["jquery-2.1.1.min"], function(){
require(["dialog"], function(){
require(["user/project/projectList-fxs", "common/url","common/star"], 
		function(ProjectList, url, Star){
	var list = new ProjectList("YJS");
	list.loadData($("#yjs_tmplData"), $("#yjs_tmplTable"),function(data){
		$("#yjs_loading").hide();
		if(data==null||data.length == 0) {
			$("#yjs_noDataHint").show();
			$("ul[name=yjs_paging]").hide();
		}
	});
	var star = new Star();
	window.document.comment = function(id) {
		star.placeholder("请您根据和企业的合作情况为企业打一个分并做出评论");
		star.show(function(comment, grade){
			star.fxs2qy(id, comment, grade, function(data){
				
			});
		})
	}
});});});
</script>
<%@include file="/include/star.jsp" %>
<div class="container">
	<%-- 暂无数据 --%>
			<div id="yjs_noDataHint" class="row tc orange fs15 mt10 display_none">暂无数据</div>
			<div id="yjs_loading" class="row tc">
				<img src="publics/images/loadingBig.gif"></img>
			</div>
			<%-- 分页 --%>
			<div class="row col-sm-12 fl">
			<ul class="pagination fs08 ml30 mt10 cp" name="yjs_paging">
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
			<table class="table table-hover" id="yjs_tmplTable" style="width:95%;">
				<script id="yjs_tmplData" type="text/x-jquery-tmpl">
				{{each(i, d) data}}
				{{if d!=null}}
				<tr>
					<td >
						<div class="row">
						<div class="col-sm-10">
						<div class="row col-sm-11">
							<span class="zg-price">{{= price }}</span>
							<span class="zg-title cp"><a href="project/page/{{= F01 }}">{{= projectName }}</a></span>
							<span class="zg-time-before-limit">
								雇主评分：{{= grade }}
								{{if fxs.grade!=null }}
								&nbsp;|&nbsp;您的评分：{{= fxs.grade}}
								{{/if}}
							</span>
						</div>
						<div class="row col-sm-11">
							<span class="zg-content-abbr">{{= description }}</span>
							<span class="zg-time-after-limit">投标时间：{{= bidDate }}</span>
						</div>
						</div>
						<div class="col-sm-2 mt40">
							<div class="select-buttons tc">
								<button class="btn-8" onclick='comment({{= F01 }})'>
								{{if fxs.grade!=null }}修改评论{{else}}给企业评分{{/if}}
								</button>
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
			<ul class="pagination fs08 ml30 mt10 cp" name="yjs_paging">
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