package cn.edu.dgut.internetcafemanagementsystem.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import cn.edu.dgut.internetcafemanagementsystem.operater.TurnoverMana;

@SuppressWarnings("serial")
public class TurnoverStatistcalMonthFrame extends JPanel implements ActionListener{

	JButton control;
	Font font = new Font("΢���ź�", Font.PLAIN, 32);
	
	public TurnoverStatistcalMonthFrame() {
		
		JLabel topic = new JLabel("����·���ѯ��ť��ѯ��Ӫҵ��", JLabel.CENTER);
		topic.setFont(font);
		
		control = new JButton("��ѯ");
		control.setFont(font);
		control.setBackground(Color.WHITE);
		control.addActionListener(this);
		
		setLayout(new BorderLayout());
		add(topic, BorderLayout.CENTER);
		add(control, BorderLayout.SOUTH);
		setOpaque(false);
	}

	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == control)
			new ListDialog(new TurnoverMana().statistcalMonth(), new String[] {"�·�", "Ӫҵ��"});
	}
}
