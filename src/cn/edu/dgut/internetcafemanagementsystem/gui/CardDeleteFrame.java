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
public class CardDeleteFrame extends JPanel implements ActionListener{
	
	JPanel username,password,centerPanel;
	JTextField usernameT,balanceT,passwordT;
	JLabel usernameL,passwordL;
	JButton delete;
	Font font = new Font("΢���ź�", Font.PLAIN, 32);
	
	public CardDeleteFrame () {

		username = new UsernameText();
		usernameT = ((UsernameText) username).text;
		
		password = new PasswordText();
		passwordT = ((PasswordText) password).text;
		
		delete = new JButton("ȷ��ɾ��");
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
					new MyDialog("�ı�����������");
					return;
				}
				double balance = new CardMana().inquire(usernameT.getText());
				if(new CardMana().delete(usernameT.getText(), passwordT.getText())) {
					new MyDialog("ɾ���ɹ�!Ӧ�˿�" + balance + "Ԫ");
					return;
				}
				new MyDialog("ʧ��:��ȷ���û���������");
			} catch (NumberFormatException e1) {
				e1.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
		
}
