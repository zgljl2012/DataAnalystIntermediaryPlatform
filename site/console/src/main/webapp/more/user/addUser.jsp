<%@page language="java" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh">
  <head>
	<%@include file="/include/meta.jsp" %>

    <title>添加管理员-<%=variableManage.getValue(SystemVariable.SITENAME) %></title>

    <%@include file="/include/style.jsp" %>
    
    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="publics/js/ie-emulation-modes-warning.js"></script>
    
    
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <%
    	headerPage = "USER";
    %>
  </head>
	<%-- <%@include file="/include/validate.jsp" %> --%>
  <body>
  	
    <!--导航栏-->
    <%@include file="/include/header.jsp" %>
    <div class="container">
    <div class="panel panel-default">
    	<div class="panel-heading">添加管理员</div>
    	<div class="panel-body">
    	<div id="container">
    		<form action="user/addUser" method="post">
				<div class="row">
					<div class="col-sm-9">
						<span><input type="text" name="name" placeholder="请输入用户名" required></span>
					</div>
				</div>
				<div class="row mt10">
					<div class="col-sm-9">
						<span><input type="password" name="pwd" placeholder="请输入密码" required></span>
					</div>
				</div>
				<div class="row mt10">
					<div class="col-sm-9">
						<span><select name="gid" >
						<c:if test="${group !=null }">
								<c:forEach var="d" items="${group }">
									<option value="${d.getF01() }">${d.getF02() }</option>
								</c:forEach>
						</c:if>
						</select></span>
					</div>
				</div>
				<div class="row mt10 mt10">
					<div class="col-sm-3">
						<span><input type="submit" value="提交"></span>
					</div>
				</div>
    		</form>
    	</div>
    </div>
    </div>
    </div>
   <!--底部导航栏-->
   <%@include file="/include/footer.jsp" %>
   <%@include file="/include/dialog.jsp" %>
    <script type="text/javascript">
    require(["jquery-2.1.1"],function(){
 	   require(["bootstrap.min"], function() {
 	   		
 	   })
    })
    
    </script>
  </body>
</html>
