package cn.edu.dgut.internetcafemanagementsystem.sql;

import java.util.Calendar;

public class Time {

	private Calendar calendar;
	
	public Time() {
		calendar = Calendar.getInstance();
	}
	
	public int getHours() {
		return calendar.get(Calendar.HOUR_OF_DAY);
	}
	
	public int getMinutes() {
		return calendar.get(Calendar.MINUTE);
	}
}
