package com.zgljl2012.modules.front.user;

import java.util.List;

import com.zgljl2012.common.database.T80;
import com.zgljl2012.framework.service.Service;

/**
 * @author 廖金龙
 * @version 2016年5月23日下午8:51:55
 * 广告管理
 */
public interface AdvertisementManage extends Service{
	
	List<T80> getAds();
	
}
