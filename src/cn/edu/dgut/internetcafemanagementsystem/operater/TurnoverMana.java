package cn.edu.dgut.internetcafemanagementsystem.operater;

import java.sql.SQLException;
import java.util.Map;
import java.util.Map.Entry;

import cn.edu.dgut.internetcafemanagementsystem.sql.Card;
import cn.edu.dgut.internetcafemanagementsystem.sql.Turnover;;

public class TurnoverMana {

	public String[][] inquire(String username, String password) throws SQLException {
		if(!new Card(username, password).verifyPassword())
			return null;
		Map<String, Double> map =  new Turnover().inquire(username);
		String[][] arr = new String[map.size()][2];
		int i = 0;
		for (String data : map.keySet()) {
			arr[i][0] = data;
			arr[i][1] = Double.toString(map.get(data));
			i++;
		}
		return arr;
	}
	
	public double statisticalAll() {
		
		return new Turnover().statisticalAll();
	}
	
	public String[][] statistcalMonth(){
		
		Map<Integer, Double> map = new Turnover().statistcalMonth();
		String[][] arr = new String[map.size()][2];
		int i = 0;
		for (Entry<Integer, Double> entry : map.entrySet()) {
			arr[i][0] = Integer.toString(entry.getKey());
			arr[i][1] = Double.toString(entry.getValue());
			i++;
		}
		return arr;
	}
}
