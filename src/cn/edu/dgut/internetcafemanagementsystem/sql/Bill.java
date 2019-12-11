package cn.edu.dgut.internetcafemanagementsystem.sql;

public class Bill {

	//添加新的计费标准；times：上机时间，spend：消费金额（下同）
	public boolean add(int times, double spend) {
		String sql = "insert into bills(times,money)"
				+ "values(" + times + "," + spend + ")";
		if(new SqlLink(sql).myExecuteUpdata() > 0) {
			return true;
		}
		return false;
	}
	
	//删除已有的计费标准
	public boolean delete(int times) {
		String sql = "delete from bills where times = " + times;
		if(new SqlLink(sql).myExecuteUpdata() > 0)
			return true;
		return false;
	}
	
	//按时间查询计费标准
	public double inquire(int times) {
		String sql = "select * from bills where times = " + times;
		String str = new SqlLink(sql).myExecuteQuery("money", "double");
		if(str == null)
			return -1.0;
		return Double.parseDouble(str);
	}
	
	//修改计费标准
	public boolean modify(int times, double spend) {
		String sql = "update bills set money = " + spend + " where times = " + times;
		if(new SqlLink(sql).myExecuteUpdata() > 0)
			return true;
		return false;
	}
	
	//计算扣费金额，与Settlement.logouts配合食用，再通过Card.rechange进行扣费
	public boolean billing(int usetimes, String username) {
		double bills = 0;
		for(int times = usetimes; times > 0; times--) {
			double money = inquire(times);
			if(money > 0) {
				bills = money * usetimes / times;
				usetimes %= times;
			}
		}
		return new Card(username).rechange(-bills);
	}
}
