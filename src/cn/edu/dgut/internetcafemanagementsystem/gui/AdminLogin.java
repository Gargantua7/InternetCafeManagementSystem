package cn.edu.dgut.internetcafemanagementsystem.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


import cn.edu.dgut.internetcafemanagementsystem.operater.AdminMana;

@SuppressWarnings("serial")
public class AdminLogin extends JDialog implements ActionListener{

	JPanel centerPanel, controlPanel, username, password;
	JButton yes, no;
	JTextField usernameT, passwordT;
	JLabel topic, usernameL, passwordL;
	Font font = new Font("微软雅黑", Font.PLAIN, 24);
	
	public void Login() {
		boolean empty = new AdminMana().isAdminsListEmpty();
		
		if(empty)
			topic = new JLabel("请先注册一个超级管理员账号", JLabel.CENTER);
		else
			topic = new JLabel("请登录你的管理员账号", JLabel.CENTER);
		topic.setFont(font);
		
		usernameL = new JLabel("用户 ");
		usernameL.setFont(font);
		usernameT = new JTextField(10);
		usernameT.setFont(font);
		username = new JPanel();
		username.add(usernameL);
		username.setFont(font);
		username.add(usernameT);
		
		passwordL = new JLabel("密码 ");
		passwordL.setFont(font);
		passwordT = new JTextField(10);
		passwordT.setFont(font);
		password = new JPanel();
		password.add(passwordL);
		password.setFont(font);
		password.add(passwordT);
		
		if(empty)
			yes = new JButton("注册并登录");
		else
			yes = new JButton("登录");
		yes.setFont(font);
		yes.setBackground(Color.WHITE);
		yes.addActionListener(this);
		
		no = new JButton("退出");
		no.setFont(font);
		no.setBackground(Color.WHITE);
		no.addActionListener(this);
		
		centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(6, 1));
		centerPanel.add(new JLabel(""));
		centerPanel.add(topic);
		centerPanel.add(new JLabel(""));
		centerPanel.add(username);
		centerPanel.add(password);
		centerPanel.add(new JLabel(""));
		
		controlPanel = new JPanel();
		controlPanel.setLayout(new GridLayout(1, 2));
		controlPanel.add(yes);
		controlPanel.add(no);
		
		
		setTitle("欢迎使用计费管理系统");
		setLayout(new BorderLayout());
		add(centerPanel, BorderLayout.CENTER);
		add(controlPanel, BorderLayout.SOUTH);
		setModal(true);
		setResizable(false);
		setSize(400, 300);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == yes) {
			if(isTextFieldEmpty()) {
				new MyDialog("文本框请勿留空");
				return;
			}
			AdminMana adminMana = new AdminMana();
			String username = usernameT.getText();
			String password = passwordT.getText();
			if(adminMana.isAdminsListEmpty()) {
				try {
					if(adminMana.add(username, password, 2)) {
						new MyDialog("注册成功！");
						dispose();
					}
					else
						new MyDialog("注册失败");
				} catch (SQLException es) {
					es.printStackTrace();
				}	
			} else
				try {
					if(adminMana.verify(username, password)) {
						new MyDialog("登录成功！");
						dispose();
					}
					else
						new MyDialog("登录失败");
				} catch (SQLException es) {
					es.printStackTrace();
				}
		}
		
		if(e.getSource() == no) {
			System.exit(0);
		}
	}

	public int getAdminPower() throws SQLException {
		Login();
		if(isTextFieldEmpty() || !new AdminMana().verify(usernameT.getText(), passwordT.getText()))
			return -1;
		return new AdminMana().getAdminPower(usernameT.getText());
		
	}
	
	public boolean isTextFieldEmpty() {
		if(usernameT.getText().equals("") || passwordT.getText().equals(""))
			return true;
		return false;
	}
}
