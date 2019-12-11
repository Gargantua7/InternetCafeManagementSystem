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
import cn.edu.dgut.internetcafemanagementsystem.operater.SettleMana;

@SuppressWarnings("serial")
public class SettleLogoutFrame extends JPanel implements ActionListener {

	JPanel username, centerPanel;
	JTextField usernameT;
	JButton check;
	Font font = new Font("΢���ź�", Font.PLAIN, 32);

	public SettleLogoutFrame() {

		username = new UsernameText();
		usernameT = ((UsernameText) username).text;

		check = new JButton("�»�ȷ��");
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
		if (e.getSource() == check) {
			try {
				if (usernameT.getText().equals("")) {
					new MyDialog("�ı�����������");
					return;
				}
				if (new SettleMana().logout(usernameT.getText())) {
					new MyDialog("�»��ɹ������Ϊ��" + new CardMana().inquire(usernameT.getText()) + "Ԫ");
					return;
				}
				new MyDialog("ʧ��:��ȷ���û�������˺ſ��ܲ�δ����");
			} catch (NumberFormatException e1) {
				e1.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

}
