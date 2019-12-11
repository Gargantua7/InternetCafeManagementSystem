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
public class CardAddFrame extends JPanel implements ActionListener{

	JPanel centerPanel, username, password, balance;
	JButton contorl;
	JTextField usernameT, passwordT, balanceT;
	Font font = new Font("微软雅黑", Font.PLAIN, 32);

	public CardAddFrame() {
		username = new UsernameText();
		usernameT = ((UsernameText) username).text;
		username.setOpaque(false);

		password = new PasswordText();
		passwordT = ((PasswordText) password).text;
		password.setOpaque(false);

		balance = new BalanceText();
		balanceT = ((BalanceText) balance).text;
		balance.setOpaque(false);

		contorl = new JButton("确定添加");
		contorl.setFont(font);
		contorl.setBackground(Color.WHITE);
		contorl.addActionListener(this);
		
		centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(5, 1));
		centerPanel.add(new JLabel(""));
		centerPanel.add(username);
		centerPanel.add(password);
		centerPanel.add(balance);
		centerPanel.add(new JLabel(""));
		centerPanel.setOpaque(false);
		
		setLayout(new BorderLayout());
		add(centerPanel, BorderLayout.CENTER);
		add(contorl, BorderLayout.SOUTH);
		setOpaque(false);
		
	}

	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == contorl) {
			try {
				if(usernameT.equals("") || passwordT.getText().equals("") || balanceT.getText().equals("")) {
					new MyDialog("文本框请勿留空");
					return;
				}
				if(new CardMana().add(usernameT.getText(), passwordT.getText(), Double.parseDouble(balanceT.getText()))) {
					new MyDialog("添加成功!");
					return;
				}
				new MyDialog("失败:可能此卡号已存在");
			} catch (NumberFormatException e1) {
				e1.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
}
