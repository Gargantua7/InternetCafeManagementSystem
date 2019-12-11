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
public class SettleFrame extends JPanel implements ActionListener{

	JPanel muenPanel = new JPanel();
	JPanel mainPanel = new JPanel();
	JButton add, inquire, delete;
	CardLayout cardLayout = new CardLayout();
	Font font = new Font("微软雅黑", Font.PLAIN, 32);
	
	public SettleFrame(){
		Color color = Color.WHITE; 
		add = new JButton("上机");
		add.setFont(font);
		add.setBackground(color);
		add.addActionListener(this);
		
		inquire = new JButton("下机");
		inquire.setFont(font);
		inquire.setBackground(color);
		inquire.addActionListener(this);
		
		muenPanel.setLayout(new GridLayout());
		muenPanel.add(add);
		muenPanel.add(inquire);
		
		mainPanel.setLayout(cardLayout);
		mainPanel.add("add" , new SettleLoginFrame());
		mainPanel.add("inquire" , new SettleLogoutFrame());
		mainPanel.setOpaque(false);
		
		setLayout(new BorderLayout());
		add(muenPanel, BorderLayout.NORTH);
		add(mainPanel, BorderLayout.CENTER);
		setOpaque(false);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == add)
			cardLayout.show(mainPanel, "add");
		if(e.getSource() == inquire)
			cardLayout.show(mainPanel, "inquire");
		//if(e.getSource() == delete)
			//cardLayout.show(mainPanel, "delete");
	}
}



