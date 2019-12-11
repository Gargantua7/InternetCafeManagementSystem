package cn.edu.dgut.internetcafemanagementsystem.sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Map;
import java.util.TreeMap;

public class Turnover {

	//添加到营业记录中
	public boolean recording(String username, double bills) {
		String sql = "INSERT INTO turnover ( times,username,bills) " + 
				"VALUES(NOW(), '" + username + "', " + bills + ")";
		if(new SqlLink(sql).myExecuteUpdata() > 0) {
			return true;
		}
		return false;
	}
	
	//查询某用户的全部消费记录
	public Map<String, Double> inquire(String username) {
		Map<String, Double> map = new TreeMap<>();
		Connection connect = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connect = Connect.getConnection();
			statement = connect.createStatement();
			String sql = "select * from turnover where username = '" + username + "'";
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				map.put(resultSet.getString("times"), resultSet.getDouble("bills"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			Connect.release(resultSet, statement, connect);
		}
		return map;
	}
	
	//查询总营业额
	public double statisticalAll() {
		return Double.parseDouble(new SqlLink("select sum(bills) as allBills from turnover").myExecuteQuery("allBills", "double"));
	}
	
	//查询全年营业额
	public Map<Integer, Double> statistcalMonth()
	{
		Map<Integer, Double> map = new TreeMap<>();
		Connection connect = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connect = Connect.getConnection();
			statement = connect.createStatement();
			String sql = "select month(times) as month,sum(bills) as bill from turnover"
					+ " where year(times) = year(now()) group by month(times) order by month(times)";
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				map.put(Integer.valueOf(resultSet.getString("month")), resultSet.getDouble("bill"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			Connect.release(resultSet, statement, connect);
		}
		return map;
	}
}
