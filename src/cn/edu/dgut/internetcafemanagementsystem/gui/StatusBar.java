package cn.edu.dgut.internetcafemanagementsystem.gui;

import java.awt.Font;
import java.awt.GridLayout;
import java.util.Calendar;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class StatusBar implements Runnable{

	JLabel time, power;
	JPanel bar;
	int adminpower;
	Font font = new Font("黑体", Font.PLAIN, 16);
	
	public StatusBar(JPanel bar, int adminpower) {
		this.bar = bar;
		this.adminpower = adminpower;
	}
	
	public void run() {
		bar.setLayout(new GridLayout(1,3));
		time = new JLabel("", JLabel.CENTER);
		power = new JLabel("", JLabel.LEFT);
		time.setFont(font);
		power.setFont(font);
		if(adminpower == 2)
			power.setText("权限等级：超级管理员权限");
		else
			power.setText("权限等级：标准管理员权限");
		bar.add(power);
		bar.add(time);
		bar.add(new JLabel(""));
		while(true) {
			Calendar c = Calendar.getInstance();
			int y = c.get(Calendar.YEAR);
			int m = c.get(Calendar.MONTH);
			int d = c.get(Calendar.DAY_OF_MONTH);
			int h = c.get(Calendar.HOUR_OF_DAY);
			int ms = c.get(Calendar.MINUTE);
			int s = c.get(Calendar.SECOND);
			time.setText(""+y+"/"+m+"/"+d+" "+h+":"+ms+":"+s);
			try {
				Thread.sleep(100);
			}catch(Exception e){}
			
		}
	}
}
