package cn.edu.dgut.internetcafemanagementsystem.sql;

import java.sql.*;

public class SqlLink {

	Connection con = null;
	Statement sta = null;
	String sql;
	
	public SqlLink(String sql) {
		this.sql = sql;
	}
	
	public boolean myExecute() {
		boolean b = false;
		try {
			con = Connect.getConnection();
			sta = con.createStatement();
			b = sta.execute(sql);
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			Connect.release(sta, con);
		}
		return b;
	}
	
	public int myExecuteUpdata() {
		int num = 0;
		try {
			con = Connect.getConnection();
			sta = con.createStatement();
			num = sta.executeUpdate(sql);
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			Connect.release(sta, con);
		}
		return num;
	}
	
	public String myExecuteQuery(String obj, String type) {
		String data = null;	
		try {
			con = Connect.getConnection();
			sta = con.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			if(rs.next()) {
				switch (type) {
				case "double":
					data = Double.toString(rs.getDouble(obj));
					break;
					
				case "int":
					data = String.valueOf(rs.getInt(obj));
					break;

				default:
					data = rs.getString(obj);
					break;
				}
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			Connect.release(sta, con);
		}
		return data;
	}
}
