import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.*;

import javax.swing.table.DefaultTableModel;

public class StockManage {
	
	private String[] search = {"재고품명"};
	private String[] colName = {"재고품명", "수량"};
	String[][] data = null;
	
	public StockManage() {
		
		JFrame frame = new JFrame();
		frame.setBounds(100, 100, 623, 600);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new FlowLayout());
		frame.setResizable(false);
		frame.setTitle("재고 관리");
		
		JPanel btnJp = new JPanel(new GridLayout(1,3,6,0));
		btnJp.setSize(1000,500);
		JPanel searchJp = new JPanel();
		JPanel jp = new JPanel(new GridLayout(2,1,10,10));
		
		
		JButton addBtn = new JButton("추가");
		addBtn.setSize(136, 43);
		btnJp.add(addBtn);
		
		JButton updateBtn = new JButton("수정");
		updateBtn.setSize(136,43);
		//updateBtn.setBounds(231, 25, 136, 43);
		btnJp.add(updateBtn);
		
		JButton deleteBtn = new JButton("삭제");
		deleteBtn.setSize(136,43);
		btnJp.add(deleteBtn);
		
		JComboBox<String> comboBox = new JComboBox<String>(search);
		comboBox.setSize(77, 36);
		//comboBox.setBounds(72, 80, 77, 36);
		searchJp.add(comboBox);
		
		JTextField textField = new JTextField(25);
		textField.setBounds(151, 80, 288, 36);
		searchJp.add(textField);
		
		JButton searchBtn = new JButton("찾기");
		searchBtn.setBounds(442, 80, 93, 36);
		searchJp.add(searchBtn);
		
		jp.add(btnJp); jp.add(searchJp);
		
		DefaultTableModel dTable = new DefaultTableModel(data, colName);
		JTable table = new JTable(dTable);
		table.setRowHeight(40);
		table.setBounds(30, 30, 50, 50);
		frame.add(jp);
		frame.add(new JScrollPane(table));
		frame.setVisible(true);
		
	addBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new StockAdd();
				frame.dispose();
			}
		});

		updateBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new StockUpdate();
				frame.dispose();
			}
		});

		deleteBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});
		
		searchBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		frame.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {}
			@Override
			public void windowIconified(WindowEvent e) {}
			@Override
			public void windowDeiconified(WindowEvent e) {}
			@Override
			public void windowDeactivated(WindowEvent e) {}
			
			@Override
			public void windowClosing(WindowEvent e) { new Menu(); }
			
			@Override
			public void windowClosed(WindowEvent e) {}
			@Override
			public void windowActivated(WindowEvent e) {}
		});
	}
	
	public static void main(String[] args) {
		new StockManage();
	}
}
