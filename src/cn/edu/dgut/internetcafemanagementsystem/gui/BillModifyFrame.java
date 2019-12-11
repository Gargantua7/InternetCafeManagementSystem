package cn.edu.dgut.internetcafemanagementsystem.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import cn.edu.dgut.internetcafemanagementsystem.operater.BillMana;

@SuppressWarnings("serial")
public class BillModifyFrame  extends JPanel implements ActionListener {
	
	JPanel username,password,centerPanel;
	JTextField usernameT,balanceT,passwordT;
	JLabel usernameL,passwordL;
	JButton delete;
	Font font = new Font("微软雅黑", Font.PLAIN, 32);
	
	public BillModifyFrame () {
		usernameL = new JLabel("       时间 ");
		usernameL.setFont(font);
		usernameT = new JTextField(10);
		usernameT.setFont(font);
		username = new JPanel();
		username.add(usernameL);
		username.setFont(font);
		username.add(usernameT);
		username.setOpaque(false);
		
		passwordL = new JLabel("    新花费 ");
		passwordL.setFont(font);
		passwordT = new JTextField(10);
		passwordT.setFont(font);
		password = new JPanel();
		password.add(passwordL);
		password.setFont(font);
		password.add(passwordT);
		password.setOpaque(false);
		
		delete = new JButton("更新标准");
		delete.setFont(font);
		delete.setBackground(Color.WHITE);
		delete.addActionListener(this);
		
		centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(4, 1));
		centerPanel.add(new JLabel(""));
		centerPanel.add(username);
		centerPanel.add(password);
		centerPanel.add(new JLabel(""));
		centerPanel.setOpaque(false);
		
		setLayout(new BorderLayout());
		add(centerPanel, BorderLayout.CENTER);
		add(delete, BorderLayout.SOUTH);
		setOpaque(false);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == delete) {
			try {
				if(usernameT.getText().equals("") && passwordT.getText().equals("") ) {
					new MyDialog("文本框请勿留空");
					return;
				}
				if(new BillMana().modify(Integer.parseInt(usernameT.getText()), Double.parseDouble(passwordT.getText()))) {
					new MyDialog("修改成功!");
					return;
				}
				new MyDialog("失败:可能无此计费标准");
			} catch (NumberFormatException e1) {
				e1.printStackTrace();
			}
		}
	}
}
