package com.zgljl2012.framework.util;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringHelper
{
    public static boolean isEmpty(String value)
    {
    	if(value == null || (value!=null&&value.trim().length()==0)) {
    		return true;
    	}
    	return false;
    }
    
    /**
     * 使用SHA算法单向散列加密
     * @param pwd
     * @return
     */
    public static String crypt(String pwd) {
    	try {
			return SHAUtil.shaEncode(pwd);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pwd;
    }
    
    /**
     * 校验密码
     * @param input 待校验的输入
     * @param pwd 加密后的密码
     * @return
     */
    public static boolean checkPwd(String input, String pwd) {
    	try {
			return SHAUtil.shaEncode(input).equals(pwd);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return false;
    }
    
    /**
     * 给名字带上星号
     * @param realName
     * @return
     */
    public static String asteriskRealName(String realName) {
    	if(isEmpty(realName)) {
    		return null;
    	}
    	String r = realName;
    	if(r.length() == 1) {
    		r = "***";
    	} else {
    		r = r.charAt(0)+"**";
    	}
    	return r;
    }
    
    /**
     * 给邮箱加上星号
     * @param email
     * @return
     */
    public static String asteriskEmail(String email) {
    	if(isEmpty(email)) {
    		return null;
    	}
    	String r = email;
    	String domain = email.substring(email.indexOf("@"));
    	if(r.length() - domain.length() <= 5) {
    		r = r.charAt(0) + "****"+domain;
    	} else {
    		r = r.substring(0,2)+"******" + 
    				r.substring(r.length()-domain.length()-2, 
    						email.indexOf("@")) + domain;
    	}
    	return r;
    }
    
    /**
	 * 根据键值对填充字符串，如("hello ${name}",{name:"xiaoming"})
	 * 输出：
	 * @param content
	 * @param map
	 * @return
	 */
	public static String renderString(String content, Map<String, String> map){
		Set<Entry<String, String>> sets = map.entrySet();
		for(Entry<String, String> entry : sets) {
			String regex = "\\$\\{" + entry.getKey() + "\\}";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(content);
			content = matcher.replaceAll(entry.getValue());
		}
		return content;
	}
}