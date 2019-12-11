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
public class AdminFrame extends JPanel implements ActionListener{


	JPanel muenPanel = new JPanel();
	JPanel mainPanel = new JPanel();
	JButton add, change, delete;
	CardLayout cardLayout = new CardLayout();
	Font font = new Font("微软雅黑", Font.PLAIN, 32);
	
	public  AdminFrame(){
		Color color = Color.WHITE; 
		add = new JButton("添加管理员");
		add.setFont(font);
		add.setBackground(color);
		add.addActionListener(this);
		
		delete = new JButton("注销权限");
		delete.setFont(font);
		delete.setBackground(color);
		delete.addActionListener(this);
		
		change = new JButton("配置管理员");
		change.setFont(font);
		change.setBackground(color);
		change.addActionListener(this);
		
		muenPanel.setLayout(new GridLayout());
		muenPanel.add(add);
		muenPanel.add(change);
		muenPanel.add(delete);
		
		mainPanel.setLayout(cardLayout);
		mainPanel.add("add" , new AdminAddFrame());
		mainPanel.add("change" , new AdminChangeFrame());
		mainPanel.add("delete" , new AdminDeleteFrame());
		mainPanel.setOpaque(false);
		
		setLayout(new BorderLayout());
		add(muenPanel, BorderLayout.NORTH);
		add(mainPanel, BorderLayout.CENTER);
		setOpaque(false);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == add)
			cardLayout.show(mainPanel, "add");
		if(e.getSource() == change)
			cardLayout.show(mainPanel, "change");
		if(e.getSource() == delete)
			cardLayout.show(mainPanel, "delete");
	}
}

