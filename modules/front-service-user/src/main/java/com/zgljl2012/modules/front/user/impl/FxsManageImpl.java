package com.zgljl2012.modules.front.user.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.zgljl2012.common.database.T20;
import com.zgljl2012.common.database.enums.Gender;
import com.zgljl2012.framework.controller.Controller;
import com.zgljl2012.framework.service.AbstractService;
import com.zgljl2012.framework.util.StringHelper;
import com.zgljl2012.modules.front.user.FxsManage;
import com.zgljl2012.modules.front.user.query.FxsWorkExperienceQuery;
import com.zgljl2012.modules.front.user.query.T20Query;

/**
 * @author 廖金龙
 * @version 2016年2月29日上午10:07:59
 * 分析师管理实现类
 */
public class FxsManageImpl extends AbstractService implements FxsManage{

	public FxsManageImpl(Controller controller) {
		super(controller);
		// TODO Auto-generated constructor stub
	}

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
				int i = 1;
				if(query.getRealName() != null) {
					pstmt.setString(i++, query.getRealName());
				}
				if(query.getGender() != null) {
					pstmt.setString(i++, query.getGender().name());
				}
				if(query.getBornDate() != null) {
					pstmt.setDate(i++, new java.sql.Date(query.getBornDate().getTime()));
				}
				if(query.getPersonalIntroduce() != null) {
					pstmt.setString(i++, query.getPersonalIntroduce());
				}
				if(query.getEmployDate() != null) {
					pstmt.setDate(i++, new java.sql.Date(query.getEmployDate().getTime()));
				}
				if(query.getSchool() != null) {
					pstmt.setString(i++, query.getSchool());
				}
				if(query.getCompany() != null) {
					pstmt.setString(i++, query.getCompany());
				}
				if(query.getHeadImgLink() != null) {
					pstmt.setString(i++, query.getHeadImgLink());
				}
			}
			pstmt.execute();
			conn.commit();
		} catch(Exception e) {
			conn.rollback();
			throw e;
		}
	}

	@Override
	public T20 getT20(int uid) throws Exception {
		Connection conn = getConnection();
		String sql = "SELECT F02,F03,F04,F05,F06,F07,F08,F09 FROM T20 WHERE F01 = "+uid;
		try(Statement stmt = conn.createStatement()) {
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()) {
				T20 t = new T20();
				t.setF01(uid);
				t.setF02(rs.getString(1));
				t.setF03(Gender.parse(rs.getString(2)));
				t.setF04(rs.getDate(3));
				t.setF05(rs.getString(4));
				t.setF06(rs.getDate(5));
				t.setF07(rs.getString(6));
				t.setF08(rs.getString(7));
				t.setF09(rs.getString(8));
				return t;
			} else {
				throw new Exception("没有找到该用户！");
			}
		}
	}
	
	@Override
	public void updateHeadImage(int uid, String fileName) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		if(StringHelper.isEmpty(fileName)) {
			throw new Exception("头像链接为空！");
		}
		String sql = "UPDATE T20 SET F09 = ? WHERE F01 = ?";
		try(PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, fileName);
			pstmt.setInt(2, uid);
			pstmt.execute();
		}
	}

	@Override
	public int insertWorkExperience(int uid, FxsWorkExperienceQuery query) {
		Connection conn = getConnection();
		String sql = "INSERT INTO T21(F02, F03, F04, F05, F06) VALUES(?,?,?,?,?)";
		int r = -1;
		try {
			r = this.insert(conn, sql, 
					uid,
					query.getCompanyName(),
					query.getStartDate(),
					query.getFinishedDate(),
					query.getRemark());
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return r;
	}
}
