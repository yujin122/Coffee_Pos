import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class MemberManage extends JFrame {
	
	private String[] search = {"전화번호", "이름"};
	private String[] colName = {"이름", "생년월일", "성별", "전화번호","이메일"};
	String[][] data = null;
	
	private JScrollPane scrollPane;
	private ImageIcon icon;
	
	public MemberManage() {
		
		icon = new ImageIcon("image/payment.png");
		icon = imageSetSize(icon, 623, 600);
		
		JPanel background = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(),0,0,null);
				
				setOpaque(false);
				super.paintComponent(g);
			}
		};	
	
		setTitle("회원 관리");
		
		JPanel btnJp = new JPanel(new GridLayout(1,3,6,0));
		btnJp.setOpaque(false);
		JPanel searchJp = new JPanel();
		searchJp.setOpaque(false);
		JPanel jp = new JPanel(new GridLayout(2,1,10,10));
		jp.setOpaque(false);
		JPanel allJp = new JPanel(new BorderLayout());
		allJp.setOpaque(false);
		
		JButton addBtn = new JButton("추가");
		btnJp.add(addBtn);
		
		JButton updateBtn = new JButton("수정");
		
		btnJp.add(updateBtn);
		
		JButton deleteBtn = new JButton("삭제");
		btnJp.add(deleteBtn);
		
		JComboBox<String> comboBox = new JComboBox<String>(search);
		searchJp.add(comboBox);
		
		JTextField textField = new JTextField(25);
		searchJp.add(textField);
		
		JButton searchBtn = new JButton("찾기");
		searchJp.add(searchBtn);
		
		jp.add(btnJp); jp.add(searchJp);
		
		DefaultTableModel dTable = new DefaultTableModel(data, colName);
		JTable table = new JTable(dTable);
		table.setRowHeight(40);
		table.setBounds(30, 30, 50, 50);
		allJp.add(jp, BorderLayout.NORTH);
		allJp.add(new JScrollPane(table), BorderLayout.CENTER);
		
		background.add(allJp);
		
		scrollPane = new JScrollPane(background);
		setContentPane(scrollPane);
		
		setBounds(100, 100, 640, 640);
		setResizable(false);
		setVisible(true);
		
		
		addBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new MemberAdd();
				dispose();
			}
		});

		updateBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new MemberUpdate();
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
		new MemberManage();
	}
}
