<%@ page language="java" contentType="text/html; charset=utf-8"%>
<div class="container">
<div class="panel panel-default">
    	<div class="panel-heading">数据分析师</div>
    	<div class="panel-body">
	<ul id="myTab" class="nav nav-tabs">
   <li class="active">
      <a href="#baseInfo" data-toggle="tab">
                     基础信息
      </a>
   </li>
   <li><a href="#ios" data-toggle="tab">个人经历</a></li>
   <li class="dropdown">
      <a href="#" id="myTabDrop1" class="dropdown-toggle" 
         data-toggle="dropdown">项目管理 
         <b class="caret"></b>
      </a>
      <ul class="dropdown-menu" role="menu" aria-labelledby="myTabDrop1">
         <li><a href="#jmeter" tabindex="-1" data-toggle="tab">进行中项目</a></li>
         <li><a href="#ejb" tabindex="-1" data-toggle="tab">已投标项目</a></li>
         <li><a href="#ejb" tabindex="-1" data-toggle="tab">已完成项目</a></li>
      </ul>
   </li>
</ul>
<div id="myTabContent" class="tab-content">
   <div class="tab-pane fade in active" id="baseInfo">
      <div class="row mt20">
      	<div class="col-sm-1">
      		<img src="#" title="点击上传图像" width="100" height="100"/>
      	</div>
      	<div class="col-sm-10 ml20">
      		<div class="row mt10">
      			<div class="col-sm-4">
      				<span>用户名:</span>
      				<input type="text" name="username" value="<%=ljlSession.getUsername() %>" maxlength="18" disabled/>
      				<a edit onclick="edit('username','编辑','完成', updateUsername)" class="cp">编辑</a>
      			</div>
      			<div class="col-sm-5">
      				<span>真实姓名:</span>
      				<input type="text" name="realName" value="<%=ljlSession.getUsername() %>" maxlength="18" disabled/>
      				<a edit onclick="edit('realName','编辑','完成', updateRealname)" class="cp">编辑</a>
      			</div>
      		</div>
      		<div class="row mt20">
      			<div class="col-sm-4">
      				<span>邮&nbsp;&nbsp;&nbsp;&nbsp;箱:</span>
      				<input type="text" name="email" value="<%=ljlSession.getUsername() %>" maxlength="18" disabled/>
      				<a onclick="edit('email','编辑','完成', updateEmail)" class="cp">编辑</a>
      			</div>
      			<div class="col-sm-5">
      				<span>出生日期:</span>
      				<input id="bornDate" readonly disabled class="dateTime" type="text" name="bornDate">
      				<a edit onclick="edit('bornDate', '编辑','完成',updateDate)" class="cp">编辑</a>
      			</div>
      			<div class="col-sm-3">
      				<span>性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别:</span>
      				<select name="gender" disabled>
      					<option value="BM">保密</option>
      					<option value="NAN">男</option>
      					<option value="NV">女</option>
      				</select>
      				<a edit onclick="edit('gender','编辑','完成', updateGender)" class="cp">编辑</a>
      			</div>
      			
      		</div>
      	</div>
      </div>
   </div>
   
   
   <div class="tab-pane fade" id="ios">
      <p>iOS 是一个由苹果公司开发和发布的手机操作系统。最初是于 2007 年首次发布 iPhone、iPod Touch 和 Apple 
      TV。iOS 派生自 OS X，它们共享 Darwin 基础。OS X 操作系统是用在苹果电脑上，iOS 是苹果的移动版本。</p>
   </div>
   <div class="tab-pane fade" id="jmeter">
      <p>jMeter 是一款开源的测试软件。它是 100% 纯 Java 应用程序，用于负载和性能测试。</p>
   </div>
   <div class="tab-pane fade" id="ejb">
      <p>Enterprise Java Beans（EJB）是一个创建高度可扩展性和强大企业级应用程序的开发架构，部署在兼容应用程序服务器（比如 JBOSS、Web Logic 等）的 J2EE 上。
      </p>
   </div>
</div>
	</div></div>
</div>