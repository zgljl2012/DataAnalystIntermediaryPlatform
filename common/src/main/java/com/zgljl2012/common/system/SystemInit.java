package com.zgljl2012.common.system;

import com.zgljl2012.framework.controller.Controller;
import com.zgljl2012.framework.system.SystemStartupListener;

/**
 * @author 廖金龙
 * @version 2016年3月16日下午7:54:09
 * 系统启动时将进行系统初始化
 */
public class SystemInit implements SystemStartupListener
{

	@Override
	public void startup(Controller controller) {
		controller.getLogger().console("系统初始化...");
	}

}
