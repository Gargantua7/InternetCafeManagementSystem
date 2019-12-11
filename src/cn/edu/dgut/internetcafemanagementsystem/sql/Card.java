package cn.edu.dgut.internetcafemanagementsystem.sql;

import java.sql.SQLException;

public class Card {

	private String username;
	private String password;
	
	public Card(String username) {
		this.username = username;
	}
	
	public Card(String username, String password) {
		this(username);
		this.password = password;
	}
	
	//验证账号是否存在
	public boolean verify() throws SQLException {
		String sql = "select * from users where username = '" + username + "'";
		if(new SqlLink(sql).myExecuteQuery("username", "String") == null)
			return false;
		if(new SqlLink(sql).myExecuteQuery("username", "String").equals(username))
			return true;
		return false;
	}
	
	//验证密码是否正确
	public boolean verifyPassword() throws SQLException {
		if(!verify())
			return false;
		String sql = "select * from users where username = '" + username + "'";
		if(new SqlLink(sql).myExecuteQuery("password", "String").equals(password))
			return true;
		return false;
	}
	
	//添加新的用户卡；balance:开卡金额
	public boolean add(double balance) {
		String sql = "insert into users(username,password,balance)"
				+ "values('" + username + "','" + password + "'," + balance + ")";
		if(new SqlLink(sql).myExecuteUpdata() > 0)
			return true;
		return false;
	}
	
	//查询余额
	public double inquire() {
		String sql = "select * from users where username = '" + username + "'";
		String str = new SqlLink(sql).myExecuteQuery("balance", "double");
		if(str == null)
			return -1.0;
		return Double.parseDouble(str);
	}
	
	//删除用户卡
	public boolean delete() {
		String sql = "delete from users where username = '" + username + "'" ;
		if(new SqlLink(sql).myExecuteUpdata() > 0)
			return true;
		return false;
	}
	
	//充值&扣费；balance:充值&扣费金额
	public boolean rechange(double balance) {
		String sql = "update users set balance = balance + " + balance + " where username = '" + username + "'";
		if(new SqlLink(sql).myExecuteUpdata() > 0) {
			new Turnover().recording(username, balance);
			return true;
		}
		return false;
	}
	
}
