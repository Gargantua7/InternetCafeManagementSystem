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

import cn.edu.dgut.internetcafemanagementsystem.operater.BalanceMana;

@SuppressWarnings("serial")
public class BalanceRefundFrame  extends JPanel implements ActionListener{

	JPanel centerPanel, username, password, balance;
	JButton contorl;
	JTextField usernameT, passwordT, balanceT;
	JLabel usernameL, passwordL, balanceL;
	Font font = new Font("微软雅黑", Font.PLAIN, 32);
	
	public BalanceRefundFrame(){
		
		username = new UsernameText();
		usernameT = ((UsernameText) username).text;
		
		password = new PasswordText();
		passwordT = ((PasswordText) password).text;
		
		balance = new BalanceText();
		balanceT = ((BalanceText) balance).text;
		
		contorl = new JButton("退款确认");
		contorl.setFont(font);
		contorl.setBackground(Color.WHITE);
		contorl.addActionListener(this);;
		
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
				if(usernameT.getText().equals("") || balanceT.getText().equals("")) {
					new MyDialog("文本框请勿留空");
					return;
				}
				if(new BalanceMana().refund(usernameT.getText(), passwordT.getText(), Double.parseDouble(balanceT.getText()))) {
					new MyDialog("退款成功!");
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
