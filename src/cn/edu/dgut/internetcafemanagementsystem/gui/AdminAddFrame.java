package cn.edu.dgut.internetcafemanagementsystem.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import cn.edu.dgut.internetcafemanagementsystem.operater.AdminMana;

@SuppressWarnings("serial")
public class  AdminAddFrame extends JPanel implements ActionListener{

	int x;
	JPanel centerPanel, username, password, balance, pannel;
	JButton contorl;
	JTextField usernameT, passwordT, balanceT;
	ButtonGroup btnGroup;
	JRadioButton normoluser,superuser;
	Font font = new Font("微软雅黑", Font.PLAIN, 32);
	
	public AdminAddFrame(){
		
		username = new UsernameText();
		usernameT = ((UsernameText) username).text;

		password = new PasswordText();
		passwordT = ((PasswordText) password).text;
		
		normoluser = new JRadioButton("一般管理员");
		normoluser.setFont(font);
		normoluser.setOpaque(false);
		
		superuser = new JRadioButton("超级管理员");
		superuser.setFont(font);
		superuser.setOpaque(false);
	    
	    btnGroup = new ButtonGroup();
        btnGroup.add(normoluser);
        btnGroup.add(superuser);
        
        superuser.addActionListener(new ActionListener() {		
        	
        	public void actionPerformed(ActionEvent e) {
        		x=2;
        	}
        });
        normoluser.addActionListener(new ActionListener(){
        	
        	public void actionPerformed(ActionEvent e) {
        		x=1;
        	}
        });
        
        pannel = new JPanel();
        pannel.add(superuser);
        pannel.add(normoluser);
        pannel.setFont(font);
        pannel.setOpaque(false);
		
		contorl = new JButton("确定添加");
		contorl.setFont(font);
		contorl.setBackground(Color.WHITE);
		contorl.addActionListener(this);;
		
		centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(5, 1));
		centerPanel.add(new JLabel(""));
		centerPanel.add(username);
		centerPanel.add(password);
		centerPanel.add(pannel);
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
				if(usernameT.getText().equals("") || passwordT.getText().equals("")) {
					new MyDialog("文本框请勿留空");
					return;
				}
				if(new AdminMana().add(usernameT.getText(), passwordT.getText(), x)) {
					new MyDialog("添加成功!");
					return;
				}
				new MyDialog("失败:可能此管理员已存在");
			} catch (NumberFormatException e1) {
				e1.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
}

