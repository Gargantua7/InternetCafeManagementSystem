package cn.edu.dgut.internetcafemanagementsystem.sql;

import java.sql.*;

public class Admin {

	private String username;
	private String password;
	
	public Admin() {
		
	}
	
	public Admin(String username) {
		this.username = username;
	}
	
	public Admin(String username, String password) {
		this(username);
		this.password = password;
	}
	
	//验证用户名是否存在
	public boolean verify() throws SQLException {
		String sql = "select * from admins where username = '" + username + "'";
		String getString = new SqlLink(sql).myExecuteQuery("username", "String");
		if(getString != null && getString.equals(username))
			return true;
		return false;
	}
	
	//验证密码是否正确
	public boolean verifyPassword() throws SQLException {
		if(!verify())
			return false;
		String sql = "select * from admins where username = '" + username + "'";
		if(new SqlLink(sql).myExecuteQuery("password", "String") == null)
			return false;
		if(new SqlLink(sql).myExecuteQuery("password", "String").equals(password))
			return true;
		return false;
	}
	
	//获取管理员权限等级
	public int getAdminPower() throws SQLException {
		String sql = "select * from admins where username = '" + username + "'";
		int adminPower = Integer.parseInt(new SqlLink(sql).myExecuteQuery("adminPower", "int"));
		return adminPower;
	}
	
	//添加管理员账号；adminPower：管理员权限等级
	public boolean add(int adminPower) {
		String sql = "insert into admins(username,password,adminpower)"
				+ "values('" + username + "','" + password + "', " + adminPower + ")";
		if(new SqlLink(sql).myExecuteUpdata() > 0) {
			return true;
		}
		return false;
	}
	
	//删除管理员账号
	public boolean delete() {
		String sql = "delete from admins where username = '" + username + "'" ;
		if(new SqlLink(sql).myExecuteUpdata() > 0)
			return true;
		return false;
	}
	
	//更改管理员权限等级
	public boolean changePower(int adminpower) {
		String sql = "update admins set adminpower = " + adminpower + " where username = '" + username + "'";
		if(new SqlLink(sql).myExecuteUpdata() > 0)
			return true;
		return false;
	}
	
	public boolean adminsListNotEmpty() {
		int num = 0;
		Connection connection = null;
		Statement statement = null;
		try {
			connection = Connect.getConnection();
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select count(*) as total from admins");
			while(rs.next()) {
				num = rs.getInt("total");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			Connect.release(statement, connection);
		}
		if (num > 0)
			return false;
		return true;
	}
}
