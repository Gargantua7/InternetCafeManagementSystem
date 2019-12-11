package cn.edu.dgut.internetcafemanagementsystem.sql;

public class Bill {

	//����µļƷѱ�׼��times���ϻ�ʱ�䣬spend�����ѽ���ͬ��
	public boolean add(int times, double spend) {
		String sql = "insert into bills(times,money)"
				+ "values(" + times + "," + spend + ")";
		if(new SqlLink(sql).myExecuteUpdata() > 0) {
			return true;
		}
		return false;
	}
	
	//ɾ�����еļƷѱ�׼
	public boolean delete(int times) {
		String sql = "delete from bills where times = " + times;
		if(new SqlLink(sql).myExecuteUpdata() > 0)
			return true;
		return false;
	}
	
	//��ʱ���ѯ�Ʒѱ�׼
	public double inquire(int times) {
		String sql = "select * from bills where times = " + times;
		String str = new SqlLink(sql).myExecuteQuery("money", "double");
		if(str == null)
			return -1.0;
		return Double.parseDouble(str);
	}
	
	//�޸ļƷѱ�׼
	public boolean modify(int times, double spend) {
		String sql = "update bills set money = " + spend + " where times = " + times;
		if(new SqlLink(sql).myExecuteUpdata() > 0)
			return true;
		return false;
	}
	
	//����۷ѽ���Settlement.logouts���ʳ�ã���ͨ��Card.rechange���п۷�
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
