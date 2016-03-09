package com.zgljl2012.front.user;

import java.util.Date;

import com.zgljl2012.common.database.T10;
import com.zgljl2012.common.database.T11;
import com.zgljl2012.framework.controller.Controller;
import com.zgljl2012.framework.email.SendEmail;
import com.zgljl2012.framework.service.AbstractService;
import com.zgljl2012.framework.util.MD5Util;
import com.zgljl2012.modules.front.user.UserManage;

public class RegisterValidate extends AbstractService{
	
	public RegisterValidate(Controller controller) {
		super(controller);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 通过此接口将拼接URL的权力交给调用者
	 */
	public interface RegisterUrl {
		public String url(String email, String hexCode);
	}
	
	/**
	 * 处理注册，将激活码发送至注册者邮箱（将激活码、对应用户存入数据库）
	 * @param email
	 * @throws Exception 
	 */
	public void processRegister(int uid, String email, RegisterUrl registerUrl) throws Exception {
		/**
		 * 1. 随机生成一个四位的激活码，将激活码存入t
		 * 2. 使用MD5将激活码加密
		 * 3. 将密文与验证的url拼接成一个url
		 * 4. 发送一封邮件给用户
		 * 5. 将T11存储到数据库中
		 */
		T11 t = new T11();
		t.F01 = uid;
		t.F02 = email;
		int tmp = (int) (Math.random()*9000+1000);
		String code = Integer.toString(tmp);
		t.F03 = code;
		String hexCode = MD5Util.encode2hex(code);
		String url = registerUrl.url(t.F02, hexCode);
		///邮件的内容
        StringBuffer sb=new StringBuffer("点击下面链接激活账号，24小时生效，否则重新注册账号，链接只能使用一次，请尽快激活！</br>");
        sb.append("<a href=\"");
        sb.append(url); 
        sb.append("\">"); 
        sb.append(url);
        sb.append("</a>");
        
        SendEmail.send(t.F02, sb.toString());
        
        UserManage userManage = controller.getServiceManage().getService(UserManage.class);
        userManage.setRegisterValidate(t);
	}
	
	/**
	 * 根据邮箱地址和激活码判断用户是否激活
	 * @param email
	 * @param hexCode 已经MD5加密后的激活码
	 * @throws Exception 
	 */
	public void processActivate(String email, String hexCode) throws Exception {
		/**
		 * 1. 从数据库中取出T10，T11
		 * 2. 进行用户是否已经是QY状态
		 * 2. 进行时间是否超过规定时间的判断
		 * 3. 判断激活码是否正确
		 * 4. 在T10中更新用户状态
		 */
		UserManage userManage = controller.getServiceManage().getService(UserManage.class);
		T11 t11 = userManage.getRegisterValidate(email);
		T10 t10 = userManage.getUserByEmail(email);
		if(t11 == null || t10 == null) {
			if(t10.F08.equals(t10.F08.WJH)) {
				Date date = new Date();
				long gap = date.getTime() - t11.F04.getTime();
				// 当前时间与数据库存储时间在1天之内
				if(gap >= 0 && gap <= 24*60*60*1000) {
					// 验证激活码
					if(MD5Util.validate(t11.F03, hexCode)) {
						userManage.qyUser(t10.F01);
					} else {
						throw new Exception("激活码不正确");
					}
				} else {
					throw new Exception("激活码已超时，请重新注册！");
				}
			} else {
				throw new Exception("邮箱已验证，请登录！");
			}
		} else {
			throw new Exception("邮箱尚未注册，邮箱地址不存在！");
		}
	}
}
