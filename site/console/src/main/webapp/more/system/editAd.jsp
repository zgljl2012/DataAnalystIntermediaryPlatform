<%@page language="java" contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html lang="zh">
  <head>
	<%@include file="/include/meta.jsp" %>

    <title>添加广告-<%=variableManage.getValue(SystemVariable.SITENAME) %></title>

    <%@include file="/include/style.jsp" %>
    
    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="publics/js/ie-emulation-modes-warning.js"></script>
    
    
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <link href="publics/css/plugins/fileInput/fileinput.css" rel="stylesheet"/>
    <%
    	headerPage = "USER";
    %>
  </head>
	<%@include file="/include/validate.jsp" %>
  <body>
  	
    <!--导航栏-->
    <%@include file="/include/header.jsp" %>
    <div class="container">
    <div class="panel panel-default">
    	<div class="panel-heading">添加广告</div>
    	<div class="panel-body">
    	<form enctype="multipart/form-data" action="ad/add" method="post">
    	<div class="row">
    		<input type="text" name="type" value="edit" class="display_none"> 
    		<div class="col-sm-5">
    			上传广告图片：
    			<input required id="file_1" name="filePath" type="file" placeholder="上传广告图片">
    		</div>
    	</div>
    	<div class="row mt10">
    		<div class="col-sm-5">
    		广告标题：
    		<input required type="text" name="title" placeholder="广告标题" value="${t.getF03() }">
    		</div>
    	</div>
    	<div class="row mt10">
    		<div class="col-sm-5">
    		广告链接：
    		<input required type="text" name="href" placeholder="广告链接" value="${t.getF04() }">
    		</div>
    	</div>
    	<div class="row mt10">
    		<div class="col-sm-5">
    		<input type="submit" value="添加广告" class="btn btn-primary">
    		</div>
    	</div>
    	</form>
    	</div>
    </div>
    </div>
   <!--底部导航栏-->
   <%@include file="/include/footer.jsp" %>
   <%@include file="/include/dialog.jsp" %>
    <script type="text/javascript">
    require(["jquery-2.1.1"],function(){
 	   require(["bootstrap.min"], function() {
 	   		require(["plugins/fileInput/fileinput"], function(){
 	   		$('#file_1').fileinput({
				language: 'zh',
				showUpload : false,
                showRemove : false,
			    maxFileSize : 10000,
			    allowedFileExtensions : ['png',"jpg","jpeg","bmp"],
			});
 	   		})
 	   })
    })
    
    </script>
  </body>
</html>
