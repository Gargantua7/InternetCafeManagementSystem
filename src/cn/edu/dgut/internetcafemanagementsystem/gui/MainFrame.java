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
		
		Font font = new Font("微软雅黑", Font.PLAIN, 24);
		Color color = Color.WHITE; 
		cardMana = new JButton("卡管理");
		cardMana.setFont(font);
		cardMana.setBackground(color);
		cardMana.addActionListener(this);
		
		billMana = new JButton("标准管理");
		billMana.setFont(font);
		billMana.setBackground(color);
		billMana.addActionListener(this);
		
		settleMana = new JButton("计费管理");
		settleMana.setFont(font);
		settleMana.setBackground(color);
		settleMana.addActionListener(this);
		
		balanceMana = new JButton("费用管理");
		balanceMana.setFont(font);
		balanceMana.setBackground(color);
		balanceMana.addActionListener(this);
		
		turnoverMana = new JButton("查询统计");
		turnoverMana.setFont(font);
		turnoverMana.setBackground(color);
		turnoverMana.addActionListener(this);
		
		adminMana = new JButton("权限管理");
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
		
		setTitle("机房计费管理系统");
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
			new MyDialog("警告:当前管理员权限等级无法访问");
		}
	}
	
	public void setAdminPower() throws SQLException {
		
		do {
			adminPower = new AdminLogin().getAdminPower();
		} while(adminPower <= 0);
		
	}
	
}
