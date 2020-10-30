import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class StockManage extends JFrame{
	
	private String[] search = {"재고품명"};
	
	DefaultTableModel dTable = new DefaultTableModel();
	JTable table;
	String nameData;
	
	private ImageIcon icon;

	
	public StockManage() {
		
		icon = new ImageIcon("image/payment.png");
		icon = imageSetSize(icon, 628, 615);
		
		JPanel background = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(),0,0,null);
			}
		};

		setTitle("재고 관리");
		setResizable(false);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int height = screenSize.height;
		int width = screenSize.width;
		
		setPreferredSize(new Dimension(640, 640));
		setSize(new Dimension(640, 640));
		setLocation(width/2-this.getWidth()/2, height/2-this.getHeight()/2);

		
		JPanel btnJp = new JPanel(new GridLayout(1,3,6,0));
		btnJp.setOpaque(false);
		
		JPanel searchJp = new JPanel();
		searchJp.setOpaque(false);
		
		JPanel jp = new JPanel(new GridLayout(2,1,10,10));
		jp.setOpaque(false);
		
		JButton addBtn = new JButton("추가");
		addBtn.setForeground(Color.WHITE); 
		addBtn.setFont(new Font("굴림", Font.BOLD, 12));
		addBtn.setBackground(new Color(230,160,0));
		btnJp.add(addBtn);
		
		JPanel allJp = new JPanel(new BorderLayout());
		allJp.setOpaque(false);
		
		JButton updateBtn = new JButton("수정");
		updateBtn.setForeground(Color.WHITE); 
		updateBtn.setFont(new Font("굴림", Font.BOLD, 12));
		updateBtn.setBackground(new Color(230,160,0));
		btnJp.add(updateBtn);
		
		JButton deleteBtn = new JButton("삭제");
		deleteBtn.setForeground(Color.WHITE); 
		deleteBtn.setFont(new Font("굴림", Font.BOLD, 12));
		deleteBtn.setBackground(new Color(230,160,0));
		btnJp.add(deleteBtn);
		
		JComboBox<String> comboBox = new JComboBox<String>(search);
		comboBox.setSize(77, 36);
		searchJp.add(comboBox);
		
		JTextField searchtxt = new JTextField(25);
		searchtxt.setBounds(151, 80, 288, 36);
		searchJp.add(searchtxt);
		
		JButton searchBtn = new JButton("찾기");
		searchJp.add(searchBtn);
		
		JButton searchAllBtn = new JButton("전체 조회");
		searchJp.add(searchAllBtn);
		
		jp.add(btnJp); jp.add(searchJp);
		
		dTable.addColumn("재고품명"); dTable.addColumn("수량");
		displayAll();
		
		table = new JTable(dTable);
		table.setRowHeight(40);
		table.setBounds(30, 30, 50, 50);
		
		allJp.setBorder(BorderFactory.createEmptyBorder(20,0,0,0));
		
		allJp.add(jp, BorderLayout.NORTH);
		allJp.add(new JScrollPane(table), BorderLayout.CENTER);
		
		background.add(allJp);
		
		add(background);
		setVisible(true);
		
		
		table.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {}
			
			@Override
			public void mousePressed(MouseEvent e) {}
			
			@Override
			public void mouseExited(MouseEvent e) {}
			
			@Override
			public void mouseEntered(MouseEvent e) {}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int row = table.getSelectedRow();
				
				nameData = table.getValueAt(row, 0).toString();
				
			}
		});
		
		
		
		
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
				new StockUpdate(nameData);
				dispose();
			}
		});

		deleteBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
			StockManageDAO dao = new StockManageDAO();
			
			int result = dao.stoDelete(nameData);
			
			if(result > 0) {
				JOptionPane.showMessageDialog(background, "삭제 완료");
			}else {
				JOptionPane.showMessageDialog(background, "삭제 실패");
			}
			
			displayAll();

			}
		});
		
		searchBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			StockManageDAO dao = new StockManageDAO();
			
			String txt = searchtxt.getText().toString();
			
			dao.stoSearch(txt, dTable);
				
			}
		});
		
		
		searchAllBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				searchtxt.setText(null);
				displayAll();
			}
		});
		
		
		addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) { new Menu(); }
			
		});
	}
	
	public void displayAll() {
		dTable.setRowCount(0);
		
		StockManageDAO dao = new StockManageDAO();
		dao.tableAll(dTable);
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
