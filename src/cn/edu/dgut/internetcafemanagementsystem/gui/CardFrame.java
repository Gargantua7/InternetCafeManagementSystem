package cn.edu.dgut.internetcafemanagementsystem.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class CardFrame extends JPanel implements ActionListener{

	JPanel muenPanel = new JPanel();
	JPanel mainPanel = new JPanel();
	JButton add, inquire, delete;
	CardLayout cardLayout = new CardLayout();
	Font font = new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 32);
	
	public CardFrame(){
		Color color = Color.WHITE; 
		add = new JButton("Ìí¼Ó¿¨");
		add.setFont(font);
		add.setBackground(color);
		add.addActionListener(this);
		
		inquire = new JButton("²éÑ¯¿¨Óà¶î");
		inquire.setFont(font);
		inquire.setBackground(color);
		inquire.addActionListener(this);
		
		delete = new JButton("×¢Ïú¿¨");
		delete.setFont(font);
		delete.setBackground(color);
		delete.addActionListener(this);
		
		muenPanel.setLayout(new GridLayout());
		muenPanel.add(add);
		muenPanel.add(inquire);
		muenPanel.add(delete);
		
		mainPanel.setLayout(cardLayout);
		mainPanel.add("add" , new CardAddFrame());
		mainPanel.add("inquire" , new CardInquireFrame());
		mainPanel.add("delete" , new CardDeleteFrame());
		mainPanel.setOpaque(false);
		
		setLayout(new BorderLayout());
		add(muenPanel, BorderLayout.NORTH);
		add(mainPanel, BorderLayout.CENTER);
		setOpaque(false);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == add)
			cardLayout.show(mainPanel, "add");
		if(e.getSource() == inquire)
			cardLayout.show(mainPanel, "inquire");
		if(e.getSource() == delete)
			cardLayout.show(mainPanel, "delete");
	}
}
