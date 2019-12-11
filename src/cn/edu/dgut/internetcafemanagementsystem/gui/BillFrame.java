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
public class BillFrame extends JPanel implements ActionListener{

	JPanel muenPanel = new JPanel();
	JPanel mainPanel = new JPanel();
	JButton add, inquire, delete, modify;
	CardLayout cardLayout = new CardLayout();
	Font font = new Font("微软雅黑", Font.PLAIN, 28);
	
	public BillFrame(){
		Color color = Color.WHITE; 
		add = new JButton("新增标准");
		add.setFont(font);
		add.setBackground(color);
		add.addActionListener(this);
		
		inquire = new JButton("查询标准");
		inquire.setFont(font);
		inquire.setBackground(color);
		inquire.addActionListener(this);
		
		delete = new JButton("删除标准");
		delete.setFont(font);
		delete.setBackground(color);
		delete.addActionListener(this);
		
		modify = new JButton("修改标准");
		modify .setFont(font);
		modify .setBackground(color);
		modify .addActionListener(this);
		
		muenPanel.setLayout(new GridLayout());
		muenPanel.add(add);
		muenPanel.add(inquire);
		muenPanel.add(delete);
		muenPanel.add(modify);
		
		mainPanel.setLayout(cardLayout);
		mainPanel.add("add" , new BillAddFrame());
		mainPanel.add("inquire" , new BillInquireFrame());
		mainPanel.add("delete" , new BillDeleteFrame());
		mainPanel.add("modify" , new BillModifyFrame());
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
		if(e.getSource() == delete)
			cardLayout.show(mainPanel, "delete");
		if(e.getSource() == modify)
			cardLayout.show(mainPanel, "modify");
	}
}


