package cn.edu.dgut.internetcafemanagementsystem.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import cn.edu.dgut.internetcafemanagementsystem.operater.Export2File;

@SuppressWarnings("serial")
public class ListDialog extends JDialog implements ActionListener{

	JButton control, export;
	JPanel south;
	Font font = new Font("黑体", Font.PLAIN, 32);
	String[][] data;
	
	public ListDialog(String[][] data, String[] obj) {
		
		this.data = data;
		
		JTable jTable = new JTable(data, obj);
		JScrollPane jScrollPane = new JScrollPane(jTable);
		
		export = new JButton("导出");
		export.setFont(font);
		export.setBackground(Color.WHITE);
		export.addActionListener(this);
		
		control = new JButton("OK");
		control.setFont(font);
		control.setBackground(Color.WHITE);
		control.addActionListener(this);
		
		south = new JPanel();
		south.setLayout(new GridLayout(2, 1));
		south.add(export);
		south.add(control);
		
		setTitle("查询结果");
		setLayout(new BorderLayout());
		add(jScrollPane, BorderLayout.CENTER);
		add(south, BorderLayout.SOUTH);
		setModal(true);
		setResizable(false);
		setSize(400, 400);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == control)
			this.dispose();
		if(e.getSource() == export) {

			Calendar c = Calendar.getInstance();
			int y = c.get(Calendar.YEAR);
			int m = c.get(Calendar.MONTH);
			int d = c.get(Calendar.DAY_OF_MONTH);
			int h = c.get(Calendar.HOUR_OF_DAY);
			int ms = c.get(Calendar.MINUTE);
			int s = c.get(Calendar.SECOND);
			String filename = ""+y+"-"+m+"-"+d+"_"+h+"-"+ms+"-"+s+"_export_data";
			try {
				new Export2File(data, filename);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			new MyDialog("成功:已导出到" + filename);
		}
	}
}
