package cn.edu.dgut.internetcafemanagementsystem.operater;

import java.sql.SQLException;
import cn.edu.dgut.internetcafemanagementsystem.sql.Card;

public class CardMana {

	public boolean add(String username, String password, double balance) throws SQLException {
		Card card = new Card(username, password);
		if(card.verify())
			return false;
		return card.add(balance);
	}
	
	public double inquire(String username) throws SQLException {
		Card card = new Card(username);
		if(!card.verify())
			return -1.0;
		return card.inquire();
	}
	
	public boolean delete(String username, String password) throws SQLException{
		Card card = new Card(username, password);
		if(!card.verifyPassword())
			return false;
		return card.delete();
	}
}
