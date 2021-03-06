package com.zgljl2012.modules.front.user.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import com.zgljl2012.common.database.T10;
import com.zgljl2012.common.database.T11;
import com.zgljl2012.common.database.enums.Bool;
import com.zgljl2012.common.database.enums.T10_F05;
import com.zgljl2012.common.database.enums.T10_F08;
import com.zgljl2012.common.variable.LetterVariable;
import com.zgljl2012.framework.controller.Controller;
import com.zgljl2012.framework.exceptions.PostException;
import com.zgljl2012.framework.service.AbstractService;
import com.zgljl2012.framework.util.MD5Util;
import com.zgljl2012.framework.util.StringHelper;
import com.zgljl2012.framework.variable.VariableManage;
import com.zgljl2012.modules.front.user.UserManage;
import com.zgljl2012.modules.letter.manage.service.LetterManage;

/**
 * @author 廖金龙
 * UserManage的实现类
 */
public class UserManageImpl extends AbstractService implements UserManage{
	
	private LetterManage letterManage; 
	
	private VariableManage variableManage;
	
	public UserManageImpl(Controller controller) {
		super(controller);
	}

	public int login(String username, String password) throws Exception {
		Connection conn = this.getConnection();
		if(StringHelper.isEmpty(username)) {
			throw new Exception("用户名不能为空");
		}
		if(StringHelper.isEmpty(password)) {
			throw new Exception("密码不能为空");
		}
		String sql = "SELECT F01, F08 FROM T10 WHERE (F02 = ? OR F03 = ? ) AND F04 = ? AND F06 = 'F'";
		try(PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, username); // username为用户名
			pstmt.setString(2, username); // username为邮箱
			pstmt.setString(3, password);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				int uid = rs.getInt(1);
				T10_F08 f08 = T10_F08.parse(rs.getString(2));
				rs.close();
				pstmt.close();
				if(T10_F08.HMD.equals(f08)) {
					throw new Exception("抱歉，当前用户已被加入黑名单，不允许登录");
				}
				return uid;
			}
		}
		return -1;
	}

	public int register(String username, String password, String email, String userType) throws Exception {
		Connection conn = this.getConnection();
		letterManage = 
				controller.getServiceManage().getService(LetterManage.class);
		variableManage = controller.getVariableManage();
		String sql = "INSERT INTO T10(F02,F03,F04,F05,F06,F07,F08) VALUES(? ,? ,? ,? ,? ,? ,?)";
		String t20 = "INSERT INTO T20(F01) VALUES(?)"; // 插分析师资料简介
		String t30 = "INSERT INTO T30(F01) VALUES(?)"; // 插企业资料简介
		try(PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			if(username == null||username!=null&&username.trim().length()==0) {
				throw new Exception("用户名不能为空");
			}
			if(email == null||email!=null&&email.trim().length()==0) {
				throw new Exception("邮箱不能为空");
			}
			if(password == null||password!=null&&password.trim().length()==0) {
				throw new Exception("密码不能为空");
			}
			if(userType == null||userType!=null&&userType.trim().length()==0) {
				throw new Exception("用户类型不能为空");
			}
			// 开启事务
			conn.setAutoCommit(false);
			// 不能有相同的用户名
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM T10 WHERE F02 = '"+username+"'");
			if(rs.next()) {
				throw new Exception("用户名已被使用，请重新注册！");
			}
			// 不能有相同的邮箱
			rs = st.executeQuery("SELECT * FROM T10 WHERE F03 = '"+email+"'");
			if(rs.next()) {
				throw new Exception("邮箱已被使用，请重新输入！");
			}
			
			pstmt.setString(1, username); // 用户名
			pstmt.setString(2, email); // 邮箱
			pstmt.setString(3, password); //密码（已加密）
			pstmt.setString(4, userType); // 用户类型
			pstmt.setString(5, Bool.F.name()); // 是否删除
			pstmt.setTimestamp(6, this.getNowTimestamp()); // 时间戳
			pstmt.setString(7, T10_F08.WJH.name()); // 用户状态（未激活）
			
			int row = pstmt.executeUpdate();
			rs = pstmt.getGeneratedKeys();
			if(rs.next()) {
				int key = rs.getInt(row);
				if("FXS".equals(userType)) {
					PreparedStatement stmt = conn.prepareStatement(t20);
					stmt.setInt(1, key);
					stmt.execute();
					stmt.close();
				} else {
					PreparedStatement stmt = conn.prepareStatement(t30);
					stmt.setInt(1, key);
					stmt.execute();
					stmt.close();
				}
				conn.commit();
				rs.close();
				pstmt.close();
				String content = variableManage.getValue(LetterVariable.REGISTER);
				Map<String, String> map = new HashMap<>();
				map.put("name", username);
				content = StringHelper.renderString(content, map);
				StringHelper.renderString(content, map);
				letterManage.sendLetter(0, key, "注册成功", content);
				return key; // 返回自增的ID
			}
			return -1; // 注册失败
		} catch(Exception e) {
			conn.rollback();
			throw e;
		}
	}

	public T11 getRegisterValidate(String email) throws Exception {
		String sql = "SELECT * FROM T11 WHERE F02 = ?";
		try(PreparedStatement pstmt = getConnection().prepareStatement(sql)) {
			pstmt.setString(1, email);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				T11 t = new T11();
				t.F01 = rs.getInt(1); // 用户ID
				t.F02 = rs.getString(2); // 邮箱
				t.F03 = rs.getString(3); // 验证码（4位）
				t.F04 = rs.getTimestamp(4);// 时间戳
				rs.close();
				pstmt.close();
				return t;
			}
		}
		return null;
	}

	public void setRegisterValidate(T11 t) throws Exception {
		Connection conn = this.getConnection();
		String sql = "INSERT INTO T11 VALUES(? ,? ,? ,?)";
		try(PreparedStatement pstmt = conn.prepareStatement(sql)) {
			// 查询是否有此用户
			try(Statement st = conn.createStatement()) {
				ResultSet rs = st.executeQuery("SELECT * FROM T10 WHERE F01 = "+t.F01);
				if(!rs.next()) {
					throw new Exception("没有此用户！");
				}
			}
			// 插入用户邮箱验证码表
			pstmt.setInt(1, t.F01);
			pstmt.setString(2, t.F02);
			pstmt.setString(3, t.F03);
			pstmt.setTimestamp(4, this.getNowTimestamp());
			// 执行
			pstmt.execute();
			pstmt.close();
		}
	}

	public T10 getUserByEmail(String email) throws Exception {
		String sql = "SELECT * FROM T10 WHERE F02 = ? and F06 != 'F'";
		try(PreparedStatement pstmt = getConnection().prepareStatement(sql)) {
			pstmt.setString(1, email);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				T10 t = new T10();
				t.F01 = rs.getInt(1); // 用户ID
				t.F02 = rs.getString(2); // 用户名
				t.F03 = rs.getString(3); // 邮箱
				t.F04 = rs.getString(4); // 密码
				t.F05 = T10_F05.parse(rs.getString(5)); // 用户类型
				t.F06 = Bool.parse(rs.getString(6)); // 删除标识
				t.F07 = rs.getTimestamp(7); // 时间戳
				t.F08 = T10_F08.parse(rs.getString(8)); // 用户状态
				rs.close();
				pstmt.close();
				return t;
			}
			return null;
		}
	}

	public void qyUser(int uid) throws Exception {
		// TODO Auto-generated method stub
		String sql = "UPDATE T10 SET F08 = 'QY' WHERE F01 = ?";
		// 查询有无此用户
		Connection conn = this.getConnection();
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM T10 WHERE F01 = "+uid+"");
		if(!rs.next()) {
			rs.close();
			st.close();
			throw new Exception("没有找到该用户！");
		}
		update(getConnection(), sql, uid);
	}

	@Override
	public boolean isUsernameExists(String username) throws Exception {
		Connection conn = this.getConnection();
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM T10 WHERE F02 = '"+username+"'");
		if(rs.next()) {
			rs.close();
			st.close();
			return true;
		}
		return false;
	}

	@Override
	public boolean isEmailExists(String email) throws Exception {
		Connection conn = this.getConnection();
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM T10 WHERE F03 = '"+email+"'");
		if(rs.next()) {
			rs.close();
			st.close();
			return true;
		}
		return false;
	}

	@Override
	public T10 getT10(int uid) throws Exception{
		// TODO Auto-generated method stub
		if(uid<=0) {
			throw new Exception("没有找到该用户");
		}
		Connection conn = this.getConnection();
		try(Statement stmt = conn.createStatement()) {
			String sql = "SELECT F02, F03, F05, F07, F08 FROM T10 WHERE F06 = 'F' AND F01 = " + uid;
			ResultSet rs = stmt.executeQuery(sql);
			T10 t = new T10();
			if(rs.next()) {
				t.F01 = uid;
				t.F02 = rs.getString(1);
				t.F03 = rs.getString(2);
				t.F05 = T10_F05.parse(rs.getString(3));
				t.F07 = rs.getTimestamp(4);
				t.F08 = T10_F08.parse(rs.getString(5));
				if(T10_F08.HMD.equals(t.F08)) {
					rs.close();
					stmt.close();
					conn.close();
					throw new Exception("此用户已被加入黑名单");
				}
				return t;
			}
		}
		return null;
	}

	@Override
	public void updateUsername(int uid, String username) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		if(StringHelper.isEmpty(username)) {
			throw new Exception("用户名不能为空");
		}
		if(this.isUsernameExists(username)) {
			throw new Exception("用户名已被占用，请重新输入用户名");
		}
		String sql = "UPDATE T10 SET F02 = ? WHERE F01 = ?";
		try(PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, username);
			pstmt.setInt(2, uid);
			int count = pstmt.executeUpdate();
			pstmt.close();
			conn.close();
			if(count == 0) {
				throw new Exception("没有找到该用户！");
			}
		}
	}

	@Override
	public void updatePassword(int uid, String pwd) throws Exception {
		Connection conn = this.getConnection();
		this.update(conn, "UPDATE T10 SET F04 = ? WHERE F01 = ?", null, pwd,uid);
		conn.close();
	}

	@Override
	public int getUidByUsername(String username) throws PostException {
		String sql = "SELECT F01 FROM T10 WHERE F02 = ?";
		Connection conn = this.getConnection();
		ResultSet rs = null;
		try {
			rs = this.select(conn, sql, username);
			if(rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try {
					rs.close();
					rs.getStatement().close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			this.close(conn);
		}
		return 0;
	}

	@Override
	public void confirmEmailBox(String email, String hexCode)
			throws PostException {
		String sql = "SELECT F01,F02,F03,F04 FROM T11 WHERE F02 LIKE ? ORDER BY F04 DESC LIMIT 1";
		Connection conn = this.getConnection();
		ResultSet rs = null;
		try {
			conn.setAutoCommit(false);
			rs = this.select(conn, sql, email);
			if(rs.next()) {
				int uid = rs.getInt(1);
				String hc = rs.getString(3);
				if(StringHelper.isEmpty(hc)||StringHelper.isEmpty(hexCode)) {
					throw new PostException("验证失败");
				}
				if(hexCode.equals(MD5Util.encode2hex(hc))) {
					sql = "UPDATE T10 SET F08='QY' WHERE F01 = ?";
					this.execute(conn, sql, uid);
				} else {
					throw new PostException("验证失败");
				}
			} else {
				throw new PostException("没有找到此邮箱");
			}
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			throw new PostException("验证失败");
		} finally {
			close(rs);
			close(conn);
		}
		
		
	}	
}
