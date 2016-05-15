<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page import="com.zgljl2012.common.database.enums.Gender" %>
<%@ page import="com.zgljl2012.modules.project.BidManage" %>
<%@ page import="com.zgljl2012.framework.util.JSON" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html lang="zh">
<head>
<title>站内信-<%=variableManage.getValue(SystemVariable.SITENAME) %></title>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<%@include file="/include/meta.jsp" %>
<!-- Bootstrap core CSS -->
<link href="publics/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="publics/css/plugins/chat/style.css">    
<link rel="stylesheet" type="text/css" href="publics/css/plugins/chat/jquery.mobile.flatui.css" />
</head>
<body>
<div data-role="page">
<div data-role="content" class="container" role="main">
        <ul class="content-reply-box mg10">
            <li class="odd">
                <a class="user" href="#"><img class="img-responsive avatar_" src="images/avatar-1.png" alt=""><span class="user-name">奔波儿灞</span></a>
                <div class="reply-content-box">
                	<span class="reply-time">03-08 15：00</span>
                    <div class="reply-content pr">
                    	<span class="arrow">&nbsp;</span>
                    	为什么小鑫的名字里有三个金呢？
                    </div>
                </div>
            </li>
            <li class="even">
                <a class="user" href="#"><img class="img-responsive avatar_" src="images/avatar-1.png" alt=""><span class="user-name">灞波儿奔</span></a>
                <div class="reply-content-box">
                	<span class="reply-time">03-08 15：10</span>
                    <div class="reply-content pr">
                    	<span class="arrow">&nbsp;</span>
                    	他命里缺金，所以取名叫鑫，有些人命里缺水，就取名叫淼，还有些人命里缺木就叫森。
                    </div>
                </div>
            </li>
            <li class="odd">
                <a class="user" href="#"><img class="img-responsive avatar_" src="images/avatar-1.png" alt=""><span class="user-name">奔波儿灞</span></a>
                <div class="reply-content-box">
                	<span class="reply-time">03-08 15：20</span>
                    <div class="reply-content pr">
                    	<span class="arrow">&nbsp;</span>
                    	那郭晶晶命里缺什么？
                    </div>
                </div>
            </li>
            <li class="even">
                <a class="user" href="#"><img class="img-responsive avatar_" src="images/avatar-1.png" alt=""><span class="user-name">灞波儿奔</span></a>
                <div class="reply-content-box">
                	<span class="reply-time">03-08 15：30</span>
                    <div class="reply-content pr">
                    	<span class="arrow">&nbsp;</span>
                    	此处省略一百字...
                    </div>
                </div>
            </li>
			<li class="even">
                <a class="user" href="#"><img class="img-responsive avatar_" src="images/avatar-1.png" alt=""><span class="user-name">灞波儿奔</span></a>
                <div class="reply-content-box">
                	<span class="reply-time">03-08 15：30</span>
                    <div class="reply-content pr">
                    	<span class="arrow">&nbsp;</span>
                    	此处省略一百字...
                    </div>
                </div>
            </li>
			<li class="even">
                <a class="user" href="#"><img class="img-responsive avatar_" src="images/avatar-1.png" alt=""><span class="user-name">灞波儿奔</span></a>
                <div class="reply-content-box">
                	<span class="reply-time">03-08 15：30</span>
                    <div class="reply-content pr">
                    	<span class="arrow">&nbsp;</span>
                    	此处省略一百字...
                    </div>
                </div>
            </li>
        </ul>
    </div>
</div>
	
	
   <script>
   require(["jquery-2.1.1"], function(){
	   require(["bootstrap.min"], function() {
			require(["plugins/chat/jquery.mobile-1.4.0-rc.1.js"], function(){
				$('.list-group-item,.menu a').click(function(){
					$.mobile.changePage($(this).attr('href'), {
						transition : 'flip', //转场效果
						reverse : true       //默认为false,设置为true时将导致一个反方向的转场
					});	
				});
			})
	   })
   })
   </script>
 </body>
</html>