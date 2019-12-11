package cn.edu.dgut.internetcafemanagementsystem.gui;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class UsernameText extends JPanel{

	JTextField text = new JTextField();
	JLabel label = new JLabel("”√ªß ");
	Font font = new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 32);
	
	public UsernameText() {
		label.setFont(font);
		text = new JTextField(10);
		text.setFont(font);
		add(label);
		setFont(font);
		add(text);
		setOpaque(false);
		
	}
	
}
