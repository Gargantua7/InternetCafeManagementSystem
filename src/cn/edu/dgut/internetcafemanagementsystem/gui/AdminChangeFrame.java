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

import cn.edu.dgut.internetcafemanagementsystem.operater.AdminMana;

@SuppressWarnings("serial")
public class AdminChangeFrame  extends JPanel implements ActionListener{
	
	JPanel username,password,centerPanel;
	JTextField usernameT,balanceT,passwordT;
	JButton check;
	Font font = new Font("΢���ź�", Font.PLAIN, 32);
	
	public AdminChangeFrame() {

		username = new UsernameText();
		usernameT = ((UsernameText) username).text;
		
		check = new JButton("ȷ���޸�");
		check.setFont(font);
		check.setBackground(Color.WHITE);
		check.addActionListener(this);
		
		centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(3, 1));
		centerPanel.add(new JLabel(""));
		centerPanel.add(username);
		centerPanel.add(new JLabel(""));
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
					new MyDialog("�ı�����������");
					return;
				}
				if(new AdminMana().changePower(usernameT.getText(),new AdminMana().getAdminPower(usernameT.getText()))){
					String power;
					if(new AdminMana().getAdminPower(usernameT.getText()) == 2)
						power = "��������Ա";
					else
						power = "һ�����Ա";
					new MyDialog("����Ȩ��Ϊ��" + power);
					return;
				}
				new MyDialog("����Ȩ��ʧ��");
			} catch (NumberFormatException e1) {
				e1.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
		
}

