package cn.edu.dgut.internetcafemanagementsystem.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import cn.edu.dgut.internetcafemanagementsystem.operater.BillMana;

@SuppressWarnings("serial")
public class BillInquireFrame extends JPanel implements ActionListener{
	JPanel time,cost,centerPanel;
	JLabel tip,timeL,costL;
	JTextField timeT,costT;
	JButton contorl;
	Font font = new Font("΢���ź�", Font.PLAIN, 32);
	
	public BillInquireFrame() {
		
		tip = new JLabel("*��������ʱ*", SwingConstants.CENTER);
		tip.setFont(font);
		
		timeT = new JTextField(10);
		timeT.setFont(font);
		timeL = new JLabel(" ʱ");
		timeL.setFont(font);
		time = new JPanel();
		time.add(timeT);
		time.add(timeL);
		time.setOpaque(false);
		
		centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(4, 1));
		centerPanel.add(new JLabel(""));
		centerPanel.add(tip);
		centerPanel.add(time);
		centerPanel.add(new JLabel(""));
		centerPanel.setOpaque(false);
		
		contorl = new JButton("��ѯ��׼");
		contorl.setFont(font);
		contorl.setBackground(Color.WHITE);
		contorl.addActionListener(this);
		
		setLayout(new BorderLayout());
		add(centerPanel, BorderLayout.CENTER);
		add(contorl, BorderLayout.SOUTH);
		setOpaque(false);
	}

	public void actionPerformed(ActionEvent e) {
	
		if(e.getSource() == contorl) {
			try {
				if(timeT.getText().equals("") && costT.getText().equals("")) {
					new MyDialog("�ı�����������");
					return;
				}
				if(new BillMana().inquire(Integer.parseInt(timeT.getText())) > 0) {
					new MyDialog("�ϻ�"+timeT.getText()+"Сʱ����"+new BillMana().inquire(Integer.parseInt(timeT.getText())));
					return;
				}
				new MyDialog("ʧ��:�����޴˼Ʒѱ�׼");
			} catch (NumberFormatException e1) {
				e1.printStackTrace();
			}
		}
		
	}
}

