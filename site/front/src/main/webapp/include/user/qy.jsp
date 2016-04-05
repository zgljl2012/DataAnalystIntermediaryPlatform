<%@ page language="java" contentType="text/html; charset=utf-8"%>
<div class="container">
<div class="panel panel-default">
	<div class="panel-heading">企业的个人主页</div>
    <div class="panel-body">
    	<ul id="myTab" class="nav nav-tabs">
		   <li class="active">
		      <a href="#baseInfo" data-toggle="tab">
		                     企业信息
		      </a>
		   </li>
		   <li><a href="#add_project" data-toggle="tab">新增项目 </a></li>
		   <li><a href="#running_project" data-toggle="tab">进行中项目 </a></li>
		   <li><a href="#bidding_project" data-toggle="tab">已发布项目 </a></li>
		   <li><a href="#stayed_project" data-toggle="tab">待处理项目 </a></li>
		   <li><a href="#finished_project" data-toggle="tab">已完成项目 </a></li>
		</ul>
		<div id="qyInfo" class="tab-content">
			<div class="tab-pane fade in active" id="baseInfo">
		    	<div class="container">
		    		<input name="status" class="display_none" value='${data.get("status")}'/>
		    		<div class="row tc mt20 vm">
		    			<div class="col-sm-5 tr vm">
		    				<span class="fs12" style="line-height:1.9999;">&nbsp;用户名&nbsp;：&nbsp;</span>
		    			</div>
		    			<div class="col-sm-5 vm tl">
		    				<input name="username" type="text" disabled placeholder="用户名" class="m-input-form-control" value=${ data.get("username")}>
		    				<a edit onclick="edit('username','编辑','完成', updateUsername)" class="cp">编辑</a>
		    			</div>
		    		</div>
		    		<div class="row tc mt20 vm">
		    			<div class="col-sm-5 tr vm">
		    				<span class="fs12" style="line-height:1.9999;">&nbsp;邮&nbsp;&nbsp;箱&nbsp;：&nbsp;</span>
		    			</div>
		    			<div class="col-sm-5 vm tl">
		    				<input name="email" type="text" placeholder="邮箱" disabled class="m-input-form-control" value='${data.get("email")}'>
		    				<a edit onclick="edit('email','编辑','完成', updateEmail)"   class="cp">编辑</a>
		    			</div>
		    		</div>
		    		<div class="row tc mt20">
		    			<div class="col-sm-5 tr vm">
		    				<span class="fs12" style="line-height:1.9999;">企业名称：</span>
		    			</div>
		    			<div class="col-sm-5 vm tl">
		    				<input name="companyName" type="text" disabled placeholder="企业名称" class="m-input-form-control" value='${data.get("companyName") }'>
		    				<a edit onclick="edit('companyName','编辑','完成', updateCompanyName)" class="cp">编辑</a>
		    			</div>
		    		</div>
		    		<div class="row">
		    			<div class="col-sm-12"><hr></div>
		    		</div>
		    		<div class="row tc mt10">
		    			<div class="col-sm-12">
		    				<span class="fs12">主营业务</span>
		    				<a edit onclick="edit('business','编辑','完成', updateBusiness)" class="cp">编辑</a>
		    				<br>
		    				<textarea disabled name="business" class="mt10" placeholder="请输入您公司的主营业务" 
		    				class="form-control" rows="6" cols="60"
		    				>${data.get("business") }</textarea>
		    			</div>
		    		</div>
		    		<div class="row">
		    			<div class="col-sm-12"><hr></div>
		    		</div>
		    		<div class="row tc mt10">
		    			<div class="col-sm-12">
		    				<span class="fs12">备注说明</span>
		    				<a edit onclick="edit('remark','编辑','完成', updateRemark)" class="cp">编辑</a>
		    				<br>
		    				<textarea disabled name="remark" class="mt10" placeholder="备注说明" 
		    				class="form-control" rows="7" cols="90"
		    				>${data.get("remark") }</textarea>
		    			</div>
		    		</div>
		    	</div>
		    </div>
			<div class="tab-pane fade" id="add_project">
		    	<%@include file="/include/project/newProject.jsp" %>
		    </div>
			<div class="tab-pane fade" id="running_project">
		    	<p>进行中项目</p>
		    </div>
		    <div class="tab-pane fade" id="bidding_project">
		    	<p>投标中项目</p>
		    </div>
		    <div class="tab-pane fade" id="stayed_project">
		    	<p>待处理项目</p>
		    </div>
		    <div class="tab-pane fade" id="finished_project">
		    	<p>已完成项目</p>
		    </div>
		</div>
	</div>
</div>
</div>