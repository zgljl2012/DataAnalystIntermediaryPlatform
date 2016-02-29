package com.zgljl2012.modules.front.user.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.zgljl2012.framework.service.AbstractService;
import com.zgljl2012.modules.front.user.FxsManage;
import com.zgljl2012.modules.front.user.query.T20Query;

/**
 * @author 廖金龙
 * @version 2016年2月29日上午10:07:59
 * 分析师管理实现类
 */
public class FxsManageImpl extends AbstractService implements FxsManage{

	@Override
	public void update(int uid, T20Query query) throws Exception{
		// TODO Auto-generated method stub
		Connection conn = this.getConnection();
		StringBuilder sql = new StringBuilder("UPDATE T20 SET F01=F01 ");
		if(query != null) {
			if(query.getRealName() != null) {
				sql.append(", F02=?");
			}
			if(query.getGender() != null) {
				sql.append(", F03=?");
			}
			if(query.getBornDate() != null) {
				sql.append(", F04=?");
			}
			if(query.getPersonalIntroduce() != null) {
				sql.append(", F05=?");
			}
			if(query.getEmployDate() != null) {
				sql.append(", F06=?");
			}
			if(query.getSchool() != null) {
				sql.append(", F07=?");
			}
			if(query.getCompany() != null) {
				sql.append(", F08=?");
			}
			if(query.getHeadImgLink() != null) {
				sql.append(", F09=?");
			}
		}
		sql.append(" WHERE F01 = "+uid);
		try(PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {
			conn.setAutoCommit(false);
			if(query!=null) {
				if(query.getRealName() != null) {
					pstmt.setString(1, query.getRealName());
				}
				if(query.getGender() != null) {
					pstmt.setString(2, query.getGender().name());
				}
				if(query.getBornDate() != null) {
					pstmt.setDate(3, new java.sql.Date(query.getBornDate().getTime()));
				}
				if(query.getPersonalIntroduce() != null) {
					pstmt.setString(4, query.getPersonalIntroduce());
				}
				if(query.getEmployDate() != null) {
					pstmt.setDate(5, new java.sql.Date(query.getEmployDate().getTime()));
				}
				if(query.getSchool() != null) {
					pstmt.setString(6, query.getSchool());
				}
				if(query.getCompany() != null) {
					pstmt.setString(7, query.getCompany());
				}
				if(query.getHeadImgLink() != null) {
					pstmt.setString(8, query.getHeadImgLink());
				}
			}
			pstmt.execute();
		} catch(Exception e) {
			conn.rollback();
			throw e;
		}
	}
	
	
}
