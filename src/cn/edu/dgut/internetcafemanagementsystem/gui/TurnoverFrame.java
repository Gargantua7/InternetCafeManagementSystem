package cn.edu.dgut.internetcafemanagementsystem.gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class TurnoverFrame extends JPanel implements ActionListener{

	JPanel muenPanel = new JPanel();
	JPanel mainPanel = new JPanel();
	JButton inquire, all, month;
	CardLayout cardLayout = new CardLayout();
	Font font = new Font("微软雅黑", Font.PLAIN, 32);
	
	public TurnoverFrame(){
		
		Color color = Color.WHITE; 
		
		inquire = new JButton("查询记录");
		inquire.setFont(font);
		inquire.setBackground(color);
		inquire.addActionListener(this);
		
		all = new JButton("总营业额");
		all.setFont(font);
		all.setBackground(color);
		all.addActionListener(this);
		
		month = new JButton("月营业额");
		month.setFont(font);
		month.setBackground(color);
		month.addActionListener(this);
		
		muenPanel.setLayout(new GridLayout());
		muenPanel.add(inquire);
		muenPanel.add(all);
		muenPanel.add(month);
		
		mainPanel.setLayout(cardLayout);
		mainPanel.add("inquire" , new TurnoverInquireFrame());
		mainPanel.add("all" , new TurnoverStatisticalAllFrame());
		mainPanel.add("month" , new TurnoverStatistcalMonthFrame());
		mainPanel.setOpaque(false);
		
		setLayout(new BorderLayout());
		add(muenPanel, BorderLayout.NORTH);
		add(mainPanel, BorderLayout.CENTER);
		setOpaque(false);
	}

	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == inquire)
			cardLayout.show(mainPanel, "inquire");
		if(e.getSource() == all)
			cardLayout.show(mainPanel, "all");
		if(e.getSource() == month)
			cardLayout.show(mainPanel, "month");
	}
}
