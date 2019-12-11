package cn.edu.dgut.internetcafemanagementsystem.operater;

import cn.edu.dgut.internetcafemanagementsystem.sql.Bill;

public class BillMana{

	public boolean add(int times, double spend) {
		Bill bill = new Bill();
		if(bill.inquire(times) > -1.0)
			return false;
		return bill.add(times, spend);
	}
	
	public double inquire(int times)
	{
		return new Bill().inquire(times);
	}
	
	public boolean delete(int times)
	{
		Bill bill = new Bill();
		if(bill.inquire(times) == -1.0)
			return false;
		return bill.delete(times);
	}
	
	public boolean modify(int times, double spend) {
		Bill bill = new Bill();
		if(bill.inquire(times) == -1.0)
			return false;
		return bill.modify(times, spend);
	}
	
}
