package cn.edu.dgut.internetcafemanagementsystem.operater;

import java.sql.SQLException;

import cn.edu.dgut.internetcafemanagementsystem.sql.Card;

public class BalanceMana {

	public boolean rechange(String username, double balance) throws SQLException {
		Card card = new Card(username);
		if(balance <= 0 || !card.verify())
			return false;
		return card.rechange(balance);
	}
	
	public boolean refund(String username, String password, double balance) throws SQLException {
		Card card = new Card(username,password);
		if(balance <= 0 || !card.verifyPassword())
			return false;
		return card.rechange(-1 * balance);
	}
}
