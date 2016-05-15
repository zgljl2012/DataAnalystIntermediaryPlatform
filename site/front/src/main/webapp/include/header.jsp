<%@page language="java" contentType="text/html; charset=utf-8" %>
<%@page language="java" import="com.zgljl2012.modules.letter.manage.service.LetterManage" %>
<%
LetterManage letterManage = 
	controller.getServiceManage().getService(LetterManage.class);
int unreaded = letterManage.countUnReaded(ljlSession.getUserId());

%>
    <%--引入requireJS框架 --%>
    <script src="publics/js/plugins/require/require.min.js" data-main="publics/js/main.js"></script>
    <nav class="navbar navbar-fixed-top navbar-inverse">
      <div class="container">
      <div class="row" >
        <div class="navbar-header">
          <a class="navbar-brand" href="#"><%=variableManage.getValue(SystemVariable.SITENAME) %></a>
        </div>
        <div id="navbar" class="col-md-10">
          <ul class="col-md-8 nav navbar-nav">
            <li <%=headerPage.equals("SY")?"class='active'":""%>><a href="index.jsp">首页</a></li>
            <li <%=headerPage.equals("XMSC")?"class='active'":""%>><a href="more/project/index2.jsp">项目市场</a></li>
            <li <%=headerPage.equals("FXSSC")?"class='active'":""%>><a href="more/analyst/index.jsp">分析师市场</a></li>
          </ul>
          <ul class="fr col-md-3 nav navbar-nav">
          <%if(ljlSession!=null&&ljlSession.isLogined()) {%>
          	<li <%=headerPage.equals("USER_CENTER")?"class='active'":""%>>
          		 <a href="user" title="<%=ljlSession.getUsername() %>" class="dropdown-toggle cp" 
          		 type="button" id="dropdownMenu1"
          		 data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
				    	用户中心
				    <span class="caret"></span>
				  </a>
				  <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
				    <li><a href="user" title="<%=ljlSession.getUsername() %>">基础资料</a></li>
				    <li><a href="user/resetPwd">修改密码</a></li>
				    <li><a href="more/user/letter.jsp">站内信<label class="white bk_red pl5 pr5 ml5 cp" title="<%=unreaded %>条未读"><%=unreaded %></label></a></li>
				  </ul>
				
          	</li>
            <li><a>|</a></li>
            <li><a href="/front/logout">退出</a></li>
          <%} else { %>
          	<li <%=headerPage.equals("LOGIN")?"class='active'":""%>><a href="more/user/login.jsp">登录</a></li>
            <li><a>|</a></li>
            <li <%=headerPage.equals("REGISTER")?"class='active'":""%>><a href="more/user/register.jsp">注册</a></li>
          <%} %>
          </ul>
        </div><!-- /.nav-collapse -->
      </div><!-- /.container -->
      </div>
    </nav><!-- /.navbar -->
