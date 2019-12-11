package cn.edu.dgut.internetcafemanagementsystem.operater;

import java.sql.SQLException;

import cn.edu.dgut.internetcafemanagementsystem.sql.Card;
import cn.edu.dgut.internetcafemanagementsystem.sql.Settlement;

public class SettleMana {

	public boolean login(String username, String password) throws SQLException {
		if(!new Card(username, password).verifyPassword() || new Settlement().isOnline(username))
			return false;
		return new Settlement().login(username);
	}
	
	public boolean logout(String username) {
		if(!new Settlement().isOnline(username))
			return false;
		return new Settlement().logout(username);
	}
}
