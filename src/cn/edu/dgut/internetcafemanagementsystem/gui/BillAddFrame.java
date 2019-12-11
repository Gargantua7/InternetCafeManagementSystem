package cn.edu.dgut.internetcafemanagementsystem.gui;

import java.awt.event.ActionListener;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import cn.edu.dgut.internetcafemanagementsystem.operater.BillMana;
//Int转换
@SuppressWarnings("serial")
public class BillAddFrame extends JPanel implements ActionListener{
	
	JPanel time,cost,centerPanel;
	JLabel tip,timeL,costL;
	JTextField timeT,costT;
	JButton contorl;
	Font font = new Font("微软雅黑", Font.PLAIN, 32);
	
	public BillAddFrame() {
		
		tip = new JLabel("*请输入整时和整元*", SwingConstants.CENTER);
		tip.setFont(font);
		
		timeT = new JTextField(10);
		timeT.setFont(font);
		timeL = new JLabel(" 时");
		timeL.setFont(font);
		time = new JPanel();
		time.add(timeT);
		time.add(timeL);
		time.setOpaque(false);
		
		costT = new JTextField(10);
		costT.setFont(font);
		costL = new JLabel(" 元");
		costL.setFont(font);
		cost = new JPanel();
		cost.add(costT);
		cost.add(costL);
		cost.setOpaque(false);
		
		centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(5, 1));
		centerPanel.add(new JLabel(""));
		centerPanel.add(tip);
		centerPanel.add(time);
		centerPanel.add(cost);
		centerPanel.add(new JLabel(""));
		centerPanel.setOpaque(false);
		
		contorl = new JButton("增加标准");
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
					new MyDialog("文本框请勿留空");
					return;
				}
				if(new BillMana().add(Integer.parseInt(timeT.getText()), Double.parseDouble(costT.getText()))) {
					new MyDialog("添加成功!");
					return;
				}
				new MyDialog("失败:可能此计费标准已存在");
			} catch (NumberFormatException e1) {
				e1.printStackTrace();
			}
		}
		
	}
}
