package cn.edu.dgut.internetcafemanagementsystem.gui;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class BalanceText extends JPanel{

	JTextField text = new JTextField();
	JLabel label = new JLabel("½ð¶î ");
	Font font = new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 32);
	
	public BalanceText() {
		label.setFont(font);
		text = new JTextField(10);
		text.setFont(font);
		add(label);
		setFont(font);
		add(text);
		setOpaque(false);
	}
}
