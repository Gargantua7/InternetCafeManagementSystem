package cn.edu.dgut.internetcafemanagementsystem.sql;

public class Settlement {

	//�ϻ�
	public boolean login(String username) {
		Time time = new Time();
		String sql = "insert into onlines(username, hours, minutes)"
				+ "values('" + username + "'," + time.getHours() + "," + time.getMinutes() + ");";
		if(new SqlLink(sql).myExecuteUpdata() > 0)
			return true;
		return false;
	}
	
	//�»��������ϻ�ʱ����ͨ��Bill.billing����۷ѽ��
	public boolean logout(String username) {
		Time time = new Time();
		String sql = "select * from onlines where username = '" + username + "'";
		SqlLink sqlLink = new SqlLink(sql);
		int hours = -1, minutes = -1;
		hours = Integer.parseInt(sqlLink.myExecuteQuery("hours", "int"));
		minutes = Integer.parseInt(sqlLink.myExecuteQuery("minutes", "int"));
		if( hours == -1 || minutes == -1)
			return false;
		int usetime = time.getHours() - hours;
		if(minutes < time.getMinutes())
			usetime++;
		new SqlLink("delete from onlines where username = '" + username + "'").myExecuteUpdata();
		return new Bill().billing(usetime, username);
	}
	
	public boolean isOnline(String username) {
		String sql = "select * from onlines where username = '" + username + "'";
		if(new SqlLink(sql).myExecuteQuery("username", "String") == null)
			return false;
		return true;
	}
}
