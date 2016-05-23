package com.zgljl2012.modules.front.user.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zgljl2012.common.database.T80;
import com.zgljl2012.common.database.enums.T80_F06;
import com.zgljl2012.framework.controller.Controller;
import com.zgljl2012.framework.database.executor.SelectExecutor;
import com.zgljl2012.framework.service.AbstractService;
import com.zgljl2012.modules.front.user.AdvertisementManage;

/**
 * @author 廖金龙
 * @version 2016年5月23日下午8:53:44
 * 
 */
public class AdvertisementManageImpl extends 
	AbstractService implements AdvertisementManage{

	public AdvertisementManageImpl(Controller controller) {
		super(controller);
	}

	@Override
	public List<T80> getAds() {
		String sql = "SELECT * FROM T80 WHERE F07 = 'F' AND F06 = 'SJ' ";
		final List<T80> list = new ArrayList<>();
		Connection conn = this.getConnection();
		try {
			this.select(conn, sql, new SelectExecutor() {
				@Override
				public void execute(ResultSet rs) {
					try {
						while(rs.next()) {
							T80 t = new T80();
							t.setF01(rs.getInt(1));
							t.setF02(rs.getString(2));
							t.setF03(rs.getString(3));
							t.setF04(rs.getString(4));
							t.setF05(rs.getTimestamp(5));
							t.setF06(T80_F06.parse(rs.getString(6)));
							list.add(t);
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}, new Object[]{});
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn);
		}
		return list;
	}

}
