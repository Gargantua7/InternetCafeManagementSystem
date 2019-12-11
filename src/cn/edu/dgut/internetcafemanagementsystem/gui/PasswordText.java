package cn.edu.dgut.internetcafemanagementsystem.gui;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class PasswordText extends JPanel{

	JTextField text = new JTextField();
	JLabel label = new JLabel("√‹¬Î ");
	Font font = new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 32);
	
	public PasswordText() {
		
		label.setFont(font);
		text = new JTextField(10);
		text.setFont(font);
		add(label);
		setFont(font);
		add(text);
		setOpaque(false);
	}
}
