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
	
	//��֤�û����Ƿ����
	public boolean verify() throws SQLException {
		String sql = "select * from admins where username = '" + username + "'";
		String getString = new SqlLink(sql).myExecuteQuery("username", "String");
		if(getString != null && getString.equals(username))
			return true;
		return false;
	}
	
	//��֤�����Ƿ���ȷ
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
	
	//��ȡ����ԱȨ�޵ȼ�
	public int getAdminPower() throws SQLException {
		String sql = "select * from admins where username = '" + username + "'";
		int adminPower = Integer.parseInt(new SqlLink(sql).myExecuteQuery("adminPower", "int"));
		return adminPower;
	}
	
	//��ӹ���Ա�˺ţ�adminPower������ԱȨ�޵ȼ�
	public boolean add(int adminPower) {
		String sql = "insert into admins(username,password,adminpower)"
				+ "values('" + username + "','" + password + "', " + adminPower + ")";
		if(new SqlLink(sql).myExecuteUpdata() > 0) {
			return true;
		}
		return false;
	}
	
	//ɾ������Ա�˺�
	public boolean delete() {
		String sql = "delete from admins where username = '" + username + "'" ;
		if(new SqlLink(sql).myExecuteUpdata() > 0)
			return true;
		return false;
	}
	
	//���Ĺ���ԱȨ�޵ȼ�
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
