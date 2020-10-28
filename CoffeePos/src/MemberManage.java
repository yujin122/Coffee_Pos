import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class MemberManage extends JFrame {
	
	private String[] search = {"전화번호"};

	DefaultTableModel dTable = new DefaultTableModel();
	JTable table;
	String phoneData, nameData;
	JComboBox<String> comboBox;
	
	private ImageIcon icon;
	
	public MemberManage() {
		
		icon = new ImageIcon("image/payment.png");
		icon = imageSetSize(icon, 623, 665);
		
		JPanel background = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(),0,0,null);
				
				setOpaque(false);
				super.paintComponent(g);
			}
		};	
	
		setTitle("회원 관리");
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int height = screenSize.height;
		int width = screenSize.width;
		
		setSize(640, 695);
		setResizable(false);
		setLocation(width/2-this.getWidth()/2, height/2-this.getHeight()/2);
		
		JPanel btnJp = new JPanel(new GridLayout(1,3,10,5));
		btnJp.setOpaque(false);
		btnJp.setBorder(BorderFactory.createEmptyBorder(5,20,5,20));
		
		JPanel searchJp = new JPanel();
		searchJp.setOpaque(false);
		JPanel jp = new JPanel(new GridLayout(2,1,10,10));
		jp.setOpaque(false);
		
		JPanel allJp = new JPanel(new BorderLayout());
		allJp.setBorder(BorderFactory.createEmptyBorder(20,0,0,0));
		allJp.setOpaque(false);
		
		
		JButton addBtn = new JButton("추가");
		addBtn.setPreferredSize(new Dimension(50, 50));
		addBtn.setSize(new Dimension(50, 50));
		addBtn.setForeground(Color.WHITE); 
		addBtn.setFont(new Font("굴림", Font.BOLD, 12));
		addBtn.setBackground(new Color(230,160,0));
		btnJp.add(addBtn);
		
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
		
		comboBox = new JComboBox<String>(search);
		searchJp.add(comboBox);
		
		JTextField searchtxt = new JTextField(25);
		searchJp.add(searchtxt);
		
		JButton searchBtn = new JButton("조회");
		searchJp.add(searchBtn);
		
		JButton searchAllBtn = new JButton("전체 조회");
		searchJp.add(searchAllBtn);
		
		jp.add(btnJp); jp.add(searchJp);
		
		dTable.addColumn("이름"); dTable.addColumn("생년월일"); dTable.addColumn("성별");
		dTable.addColumn("전화번호"); dTable.addColumn("이메일"); dTable.addColumn("포인트");
		
		displayAll();
		
		table = new JTable(dTable);
		table.getColumnModel().getColumn(2).setPreferredWidth(5);
		table.getColumnModel().getColumn(5).setPreferredWidth(5);
		table.setRowHeight(40);
		table.setPreferredSize(new Dimension(500, 400));
		table.setSize(new Dimension(500, 400));
		allJp.add(jp, BorderLayout.NORTH);
		
		JScrollPane jsp = new JScrollPane(table);
		jsp.setPreferredSize(new Dimension(600, 425));
		jsp.setSize(new Dimension(600, 380));
		allJp.add(jsp, BorderLayout.CENTER);
		
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
				
				phoneData = table.getValueAt(row, 3).toString();
				nameData = table.getValueAt(row, 0).toString();
			}
		});
		
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
				new MemberUpdate(phoneData);
				dispose();
			}
		});

		deleteBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CoffeePosDAO dao = new CoffeePosDAO();
				
				int result = dao.memDelete(phoneData);
				
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
				CoffeePosDAO dao = new CoffeePosDAO();
				
				String txt = searchtxt.getText().toString();
				
				dao.memSearch(txt,dTable);
			}
		});
		
		searchAllBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				searchtxt.setText(null);
				displayAll();
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
	
	public void displayAll() {
		dTable.setRowCount(0);
		
		CoffeePosDAO dao = new CoffeePosDAO();
		dao.tableAll(dTable);
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
