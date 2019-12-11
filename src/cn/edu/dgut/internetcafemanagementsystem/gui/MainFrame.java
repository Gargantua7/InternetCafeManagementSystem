package cn.edu.dgut.internetcafemanagementsystem.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;

@SuppressWarnings("serial")
public class MainFrame extends JFrame implements ActionListener{

	JPanel muenPanel = new JPanel();
	JPanel mainPanel = new JPanel();
	JPanel bar = new JPanel();
	JButton cardMana, adminMana, balanceMana, billMana, settleMana, turnoverMana;
	CardLayout cardLayout = new CardLayout();
	int adminPower = 2;
	
	public MainFrame() {
		
		try {
			setAdminPower();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		Font font = new Font("΢���ź�", Font.PLAIN, 24);
		Color color = Color.WHITE; 
		cardMana = new JButton("������");
		cardMana.setFont(font);
		cardMana.setBackground(color);
		cardMana.addActionListener(this);
		
		billMana = new JButton("��׼����");
		billMana.setFont(font);
		billMana.setBackground(color);
		billMana.addActionListener(this);
		
		settleMana = new JButton("�Ʒѹ���");
		settleMana.setFont(font);
		settleMana.setBackground(color);
		settleMana.addActionListener(this);
		
		balanceMana = new JButton("���ù���");
		balanceMana.setFont(font);
		balanceMana.setBackground(color);
		balanceMana.addActionListener(this);
		
		turnoverMana = new JButton("��ѯͳ��");
		turnoverMana.setFont(font);
		turnoverMana.setBackground(color);
		turnoverMana.addActionListener(this);
		
		adminMana = new JButton("Ȩ�޹���");
		adminMana.setFont(font);
		adminMana.setBackground(color);
		adminMana.addActionListener(this);
		
		muenPanel.setLayout(new GridLayout());
		muenPanel.add(cardMana);
		muenPanel.add(billMana);
		muenPanel.add(settleMana);
		muenPanel.add(balanceMana);
		muenPanel.add(turnoverMana);
		muenPanel.add(adminMana);
		
		mainPanel.setLayout(cardLayout);
		mainPanel.add("cardMana" ,new CardFrame());
		mainPanel.add("billMana" ,new BillFrame());
		mainPanel.add("settleMana" ,new SettleFrame());
		mainPanel.add("balanceMana" ,new BalanceFrame());
		mainPanel.add("turnoverMana" ,new TurnoverFrame());
		mainPanel.add("adminMana" ,new AdminFrame());
		mainPanel.setOpaque(false);
		
		new Thread(new StatusBar(bar, adminPower)).start();
		
		setLayout(new BorderLayout());
		add(muenPanel, BorderLayout.NORTH);
		add(mainPanel, BorderLayout.CENTER);
		add(bar, BorderLayout.SOUTH);
		
		ImageIcon icon = new ImageIcon(MainFrame.class.getResource("back.jpg"));
		JLabel bgLabel = new JLabel(icon);
		bgLabel.setBounds(0, 0, 1000, 700);
		JPanel imagePanel = (JPanel)getContentPane();
		imagePanel.setOpaque(false);
		
		setTitle("�����Ʒѹ���ϵͳ");
		setSize(1000, 700);
		getLayeredPane().add(bgLabel, new Integer(Integer.MIN_VALUE));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == cardMana)
			cardLayout.show(mainPanel, "cardMana");
		if(e.getSource() == billMana)
			cardLayout.show(mainPanel, "billMana");
		if(e.getSource() == settleMana)
			cardLayout.show(mainPanel, "settleMana");
		if(e.getSource() == balanceMana)
			cardLayout.show(mainPanel, "balanceMana");
		if(e.getSource() == turnoverMana)
			cardLayout.show(mainPanel, "turnoverMana");
		if(e.getSource() == adminMana) {
			if(adminPower == 2) {
				cardLayout.show(mainPanel, "adminMana");
				return;
			}
			new MyDialog("����:��ǰ����ԱȨ�޵ȼ��޷�����");
		}
	}
	
	public void setAdminPower() throws SQLException {
		
		do {
			adminPower = new AdminLogin().getAdminPower();
		} while(adminPower <= 0);
		
	}
	
}
