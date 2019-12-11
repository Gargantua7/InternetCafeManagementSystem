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
public class TurnoverStatisticalAllFrame extends JPanel implements ActionListener{

	JButton control;
	Font font = new Font("微软雅黑", Font.PLAIN, 32);
	
	public TurnoverStatisticalAllFrame() {
		
		JLabel topic = new JLabel("点击下方查询按钮查询总营业额", JLabel.CENTER);
		topic.setFont(font);
		
		control = new JButton("查询");
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
			new MyDialog("总营业额为" + new TurnoverMana().statisticalAll() + "元");
	}
}
