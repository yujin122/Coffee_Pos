import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class StockManage extends JFrame{
	
	private String[] search = {"재고품명"};
	private String[] colName = {"재고품명", "수량"};
	String[][] data = null;
	
	private ImageIcon icon;

	
	public StockManage() {
		
		icon = new ImageIcon("image/payment.png");
		icon = imageSetSize(icon, 623, 600);
		
		JPanel background = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(),0,0,null);
			}
		};

		setTitle("재고 관리");
		setResizable(false);
		setLocation(100, 100);
		setPreferredSize(new Dimension(640, 640));
		setSize(new Dimension(640, 640));
		
		JPanel btnJp = new JPanel(new GridLayout(1,3,6,0));
		btnJp.setBackground(new Color(0,0,0,0));
		btnJp.setSize(1000,500);
		
		JPanel searchJp = new JPanel();
		searchJp.setBackground(new Color(0,0,0,0));
		
		JPanel jp = new JPanel(new GridLayout(2,1,10,10));
		jp.setBackground(new Color(0,0,0,0));
		
		JButton addBtn = new JButton("추가");
		addBtn.setSize(136, 43);
		btnJp.add(addBtn);
		
		JPanel allJp = new JPanel(new BorderLayout());
		allJp.setBackground(new Color(0,0,0,0));
		
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
		
		allJp.add(jp, BorderLayout.NORTH);
		allJp.add(new JScrollPane(table), BorderLayout.CENTER);
		
		background.add(allJp);
		
		add(background);
		setVisible(true);
		
	addBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new StockAdd();
				dispose();
			}
		});

		updateBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new StockUpdate();
				dispose();
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
		
		addWindowListener(new WindowListener() {
			
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
	
	public ImageIcon imageSetSize(ImageIcon icon, int i, int j) {
		Image ximg = icon.getImage();
		Image yimg = ximg.getScaledInstance(i, j, java.awt.Image.SCALE_SMOOTH);
		ImageIcon xyimg = new ImageIcon(yimg);
		return xyimg;
	}
	
	
	public static void main(String[] args) {
		new StockManage();
	}
}
