package cn.edu.dgut.internetcafemanagementsystem.operater;

import java.sql.SQLException;

import cn.edu.dgut.internetcafemanagementsystem.sql.Admin;

public class AdminMana {

	public boolean add(String username, String password, int adminPower) throws SQLException {
		Admin admin = new Admin(username, password);
		if(admin.verify())
			return false;
		return admin.add(adminPower);
	}
	
	public boolean delete(String username) throws SQLException {
		Admin admin = new Admin(username);
		if(!admin.verify())
			return false;
		return admin.delete();
	}
	
	public boolean changePower(String username, int adminPower) throws SQLException {
		Admin admin = new Admin(username);
		if(adminPower == 1)
			adminPower = 2;
		else
			adminPower = 1;
		if(!admin.verify())
			return false;
		return admin.changePower(adminPower);
	}
	
	public boolean verify(String username, String password) throws SQLException{
		return new Admin(username, password).verifyPassword();
	}
	
	public int getAdminPower(String username) throws SQLException {
		Admin admin = new Admin(username);
		if(!admin.verify())
			return -1;
		return admin.getAdminPower();
	}
	
	public boolean isAdminsListEmpty() {
		return new Admin().adminsListNotEmpty();
	}
}
