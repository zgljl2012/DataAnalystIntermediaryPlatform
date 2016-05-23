<%@page language="java" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh">
  <head>
	<%@include file="/include/meta.jsp" %>

    <title>权限管理-<%=variableManage.getValue(SystemVariable.SITENAME) %></title>

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
    	<div class="panel-heading">权限管理</div>
    	<div class="panel-body">
    	<div id="container">
    		<div class="row">
    		<form action="permission" method="post">
    		<div class="ml10 mt10">
    		<c:if test='${p.get("gname")!=null}'>
    		<label>${p.get("gname")}的权限</label>
    		</c:if>
    		<input class="display_none" name="gid" value='${p.get("gid")}'>
    		</div>
    		<div>
    		<c:if test="${p != null&&p.get(\"permission\")!=null }">
    			<c:forEach var="permission" items='${p.get("permission") }'>
    				<span class="ml10 mt10 cp">
    				<input class="cp" type="checkbox" value='${permission.get("pid")}' name="permission" id="p${permission.get("pid")}">
    				<label class="cp" onclick="change(this)">${permission.get("pname")}</label>
    				</span>
    			</c:forEach>
    		</c:if>
    		</div>
    		<div class="mt10 ml10">
    		<input class="btn btn-primary" type="submit" value="确定">
    		</div>
    		</form>
    		</div>
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
 	   		$(function(){
 	   			var list = ${p.get("list")};
 	   			for(var i in list) {
 	   				$("#p"+list[i].pid).attr("checked", "checked");
 	   			}
 	   		});
 	   		change = function(self) {
 	   			var prev = $(self).prev();
 	   			prev.prop("checked", !prev.prop("checked"));
 	   		}
 	   })
    })
    
    </script>
  </body>
</html>
