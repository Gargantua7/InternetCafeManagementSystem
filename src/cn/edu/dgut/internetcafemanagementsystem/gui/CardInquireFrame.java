package cn.edu.dgut.internetcafemanagementsystem.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import cn.edu.dgut.internetcafemanagementsystem.operater.CardMana;

@SuppressWarnings("serial")
public class CardInquireFrame extends JPanel implements ActionListener{
	JPanel username,password,centerPanel;
	JTextField usernameT,balanceT,passwordT;
	JLabel usernameL,passwordL;
	JButton check;
	Font font = new Font("微软雅黑", Font.PLAIN, 32);
	
	public CardInquireFrame() {
		
		username = new UsernameText();
		usernameT = ((UsernameText) username).text;
		
		check = new JButton("查询余额");
		check.setFont(font);
		check.setBackground(Color.WHITE);
		check.addActionListener(this);
		
		centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(3, 1));
		centerPanel.add(new JLabel(""));
		centerPanel.add(username);
		centerPanel.add(new JLabel(""));
		centerPanel.setOpaque(false);
		centerPanel.setOpaque(false);
		
		setLayout(new BorderLayout());
		add(centerPanel, BorderLayout.CENTER);
		add(check, BorderLayout.SOUTH);
		setOpaque(false);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == check) {
			try {
				if(usernameT.getText().equals("")) {
					new MyDialog("文本框请勿留空");
					return;
				}
				if(new CardMana().inquire(usernameT.getText())>0) {
					new MyDialog("余额为：" + new CardMana().inquire(usernameT.getText()) + "元");
					return;
				}
				new MyDialog("失败:请确定用户名和密码");
			} catch (NumberFormatException e1) {
				e1.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
	
}
