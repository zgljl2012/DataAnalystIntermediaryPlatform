package com.zgljl2012.framework.util;

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
}