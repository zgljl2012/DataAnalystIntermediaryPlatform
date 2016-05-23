<%@ page language="java" contentType="text/html; charset=utf-8"%>
<script>
require(["jquery-2.1.1.min"], function(){
 	require(["system/ad"], function(AdList){
 		$("#ad_loading").show();
 		$("#ad_number").hide();
		var list = new AdList("ad");
		sc = list.operator.sc;
		xj= list.operator.xj;
		sj = list.operator.sj;
		list.loadData($("#ad_tmplData"), $("#ad_tmplTable"),function(data){
			$("#ad_loading").hide();
			if(data==null||data.data==null||data.data.length == 0) {
				$("#ad_noDataHint").show();
				$("ul[name=ad_paging]").hide()
			}else {
				$("#ad_number").show();
				$("#ad_number").children("span").html(data.count);
			}
		});
	});
}) 
</script>
<div class="container">
	<div class="row">
	<input class="btn btn-primary mt10 ml10" type="button" value="添加广告" onclick="window.location.href='ad/add'">
	</div>
	<div class="row tc orange fs08 mt10" id="ad_number">共<span></span>条记录</div>
	<%-- 暂无数据 --%>
			<div id="ad_noDataHint" class="row tc orange fs15 mt20 display_none">暂无数据</div>
			<div id="ad_loading" class="row tc">
				<img src="publics/images/loadingBig.gif"></img>
			</div>
			<%-- 分页 --%>
			<div class="row col-sm-12 fl">
			<ul class="pagination fs08 ml30 mt10 cp" name="ad_paging">
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
			<table class="table table-hover" id="ad_tmplTable" style="width:95%;">
				<tr>
					<th>图片</th>
					<th>广告标题</th>
					<th>链接</th>
					<th>状态</th>
					<th>时间</th>
					<th>操作</th>
				</tr>
				<script id="ad_tmplData" type="text/x-jquery-tmpl">
				{{each(i, d) data}}
				{{if d!=null}}
				<tr>
					<td><img src="ad/show?filePath={{= F02 }}" width=80 height=80></td>
					<td>{{= F03 }}</td>
					<td>{{= F04 }}</td>
					<td>
						{{if F06=='SJ'}}
						已发布
						{{/if}}
						{{if F06=='XJ'}}
						已下架
						{{/if}}
					</td>
					<td>{{= F05}}</td>
					<td><a class="ml10 cp" onclick="sc({{= F01}})">删除</a>
						{{if F06=='SJ'}}
						<a class="ml10 cp" onclick="xj({{= F01}})">下架</a>
						{{/if}}
						{{if F06=='XJ'}}
						<a class="ml10 cp" onclick="sj({{= F01}})">上架</a>
						{{/if}}
					</td>
				</tr>
				{{/if}}
				{{/each}}
				</script>
			</table>
			</div>
			<%-- 分页 --%>
			<div class="row col-sm-12 fl">
			<ul class="pagination fs08 ml30 mt10 cp" name="ad_paging">
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