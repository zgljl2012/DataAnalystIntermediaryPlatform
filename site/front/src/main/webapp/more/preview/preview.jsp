<%@page language="java" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html lang="zh">
  <head>
	<%@include file="/include/meta.jsp" %>
    <title>预览-<%=variableManage.getValue(SystemVariable.SITENAME) %></title>
    <link href="publics/css/bootstrap.min.css" rel="stylesheet">
    <link href="publics/css/zg-common.css" rel="stylesheet"/>
    <script src="publics/js/plugins/require/require.min.js" data-main="publics/js/main.js"></script>
  </head>
  <body>
  	<div class="container">
  	<div class="row">
  		<div class="col-sm-12 gray mt10">文件名称：${filename}</div>
  	</div>
    <table class="table table-hover cp mytable mt10">
  	<c:if test="${table != null&&table.size()>0 }">
  		<c:if test="${table.get(0).size()>0}">
  			<tr>
  			<c:forEach var="s" items="${table.get(0)}">
  				<th class="pagingBk">${s}</th>
  			</c:forEach>
  			</tr>
  		</c:if>
  		<c:if test="${table.size()>1}">
  			<c:forEach begin="1" end="${table.size()-1}" step="1" var="i">
  			<tr>
  			<c:forEach var="s" items="${table.get(i)}">
  				<td>${s}</td>
  			</c:forEach>
  			</tr>
  			</c:forEach>
  		</c:if>
  	</c:if>
  	</table>
  	</div>
    <script type="text/javascript">
    require(["jquery-2.1.1"],function(){
 	   require(["bootstrap.min"], function() {
 			   
 	   })
    })
    
    </script>
  </body>
</html>
