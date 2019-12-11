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

import cn.edu.dgut.internetcafemanagementsystem.operater.TurnoverMana;

@SuppressWarnings("serial")
public class TurnoverInquireFrame extends JPanel implements ActionListener {

	JPanel centerPanel, username, password;
	JTextField usernameT, passwordT;
	JButton contorl;
	Font font = new Font("΢���ź�", Font.PLAIN, 32);

	public TurnoverInquireFrame() {
		
		username = new UsernameText();
		usernameT = ((UsernameText) username).text;

		password = new PasswordText();
		passwordT = ((PasswordText) password).text;
		
		centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(4, 1));
		centerPanel.add(new JLabel(""));
		centerPanel.add(username);
		centerPanel.add(password);
		centerPanel.add(new JLabel(""));
		centerPanel.setOpaque(false);

		contorl = new JButton("��ѯ");
		contorl.setFont(font);
		contorl.setBackground(Color.WHITE);
		contorl.addActionListener(this);;
		
		setLayout(new BorderLayout());
		add(centerPanel, BorderLayout.CENTER);
		add(contorl, BorderLayout.SOUTH);
		setOpaque(false);
	}

	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == contorl) {
			try {
				if(usernameT.equals("") || passwordT.getText().equals("")) {
					new MyDialog("�ı�����������");
					return;
				}
				String[][] arr = new TurnoverMana().inquire(usernameT.getText(), passwordT.getText());
				if(arr != null) {
					String[] obj = new String[] {"ʱ��", "���"};
					new ListDialog(arr, obj);
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
