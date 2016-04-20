<%@ page language="java" contentType="text/html; charset=utf-8" %>
<footer class="footer mt10">
    <section class="footer-maps">
        <div class="container">
            <div class="row">
                <div class="col-sm-12">
                    <div class="footer-qr-code">
                        <img src="publics/images/weixin.png" alt="扫描关注微信" title="扫描关注微信"/>
                        <p>扫描关注微信</p>
                    </div>
                    <div class="footer-maps-block">
                        <a href="http://www.shafa.com" target="_blank" onclick="ga('send', 'event', 'footerNav', 'linkClick', 'www');" title="网站名称">
                        	<h2><%=variableManage.getValue(SystemVariable.SITENAME) %></h2>
                        </a>
                        <ul class="list-unstyled footer-maps-list">
                            <li><a href="#" target="_blank" onclick="ga('send', 'event', 'footerNav', 'linkClick', 'www1');" title="联系我们">联系我们</a></li>
                            <li><a href="#" target="_blank" onclick="ga('send', 'event', 'footerNav', 'linkClick', 'www2');" title="新手帮助">新手帮助</a></li>
                            <li><a href="#" target="_blank" onclick="ga('send', 'event', 'footerNav', 'linkClick', 'www3');" title="关于我们">关于我们</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </section>
</footer>
