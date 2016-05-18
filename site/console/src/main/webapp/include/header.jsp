    <%@page language="java" contentType="text/html; charset=utf-8" %>
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
            <li <%=headerPage.equals("USER")?"class='active'":""%>><a href="more/user.jsp">用户管理</a></li>
            <li <%=headerPage.equals("PROJECT")?"class='active'":""%>><a href="more/project.jsp">项目管理</a></li>
            <li <%=headerPage.equals("COMPAIGN")?"class='active'":""%>><a href="more/compaign.jsp">宣传管理</a></li>
            <li <%=headerPage.equals("SYSTEM")?"class='active'":""%>><a href="more/system.jsp">系统管理</a></li>
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
				    <li><a href="user/resetPwd">修改密码</a></li>
				  </ul>
				
          	</li>
            <li><a>|</a></li>
            <li><a href="/front/logout">退出</a></li>
          <%} else { %>
          	<li <%=headerPage.equals("LOGIN")?"class='active'":""%>><a href="more/login.jsp">登录</a></li>
          <%} %>
          </ul>
        </div><!-- /.nav-collapse -->
      </div><!-- /.container -->
      </div>
    </nav><!-- /.navbar -->
