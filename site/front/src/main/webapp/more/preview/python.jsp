<%@page language="java" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html lang="zh">
  <head>
	<%@include file="/include/meta.jsp" %>
    <title>Python-<%=variableManage.getValue(SystemVariable.SITENAME) %></title>
    <link href="publics/css/bootstrap.min.css" rel="stylesheet">
    <link href="publics/css/zg-common.css" rel="stylesheet"/>
    <link rel="stylesheet" href="publics/css/styles/default.css">
    <script src="publics/js/plugins/require/require.min.js" data-main="publics/js/main.js"></script>
  	
  </head>
  <body>
  	<div class="container">
 	<div class="row">
 		<div class="col-sm-12">
 		<%-- <textarea rows="1" cols="1" id="a" style="position:relative;"></textarea>
 		<pre><code class="html lang-python">
 		import sys
 		print("Hello")
 		</code></pre> --%>
    	<input type="button" value="运行" class="btn  mt10" onclick="run()">
    	<input type="button" value="缓存" class="btn  mt10 ml10" onclick="cache()">
    	<input type="button" value="保存" class="btn  mt10 ml10" onclick="save()">
    	<div class=" gray mt10">请注意，本在线Python解释器版本为3.4，不提供交互式环境，<br>请确保代码里面不出现类似input一类的等待输入的函数</div>
    	</div>
    </div>
    <div class="row">
 		<div class="col-sm-12">
 		<textarea rows="15" style="width:100%;" class="mt10" id="code" name="code"></textarea>
    	</div>
    </div>
    <div class="row">
 		<div class="col-sm-12 mt10">
    	<span class="gray fs08" id="progress"></span>
    	<textarea rows="5"  disabled style="width:100%;" class="" id="console" name="console"></textarea>
    	</div>
    </div>
    </div>
    <script type="text/javascript">
    
    require(["jquery-2.1.1"],function(){
 	   require(["bootstrap.min"], function() {
 		   require(["publics/js/code/highlight.pack.js"], function(){
 			   require(["publics/js/code/code.js"], function(){
 			   })
 		   })
 	   })
    })
    
    </script>
  </body>
</html>
