
//현금영수증임

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class MoneyCard extends JFrame {

	private ImageIcon icon;
	DefaultTableModel dTable = new DefaultTableModel();
	
	int count;
	public MoneyCard() {}
	
	public MoneyCard(int count) {

		super("카드 영수증"); // 프레임 제목 붙이기

		this.count = count;
		
		icon = new ImageIcon("image/payment.png");
		icon = imageSetSize(icon, 550, 750);

		JPanel background = new JPanel(new BorderLayout()) {
			public void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(), 0, 0, null);

				setOpaque(false);
				super.paintComponent(g);
			}
		};

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int height = screenSize.height;
		int width = screenSize.width;
		
		setSize(558, 780);
		setLocation(width/2-this.getWidth()/2, height/2-this.getHeight()/2);
		
		JPanel Centerpanel = new JPanel(); // 패널 객체화 // 테이블 넣을 공간
		Centerpanel.setOpaque(false);
		JPanel Northpanel = new JPanel(); // 패널 객체화 // 현금 결제 라벨 텍스트 컴포넌트
		Northpanel.setOpaque(false);
		JPanel Southpanel = new JPanel(); // 패널 객체화 // 텍스트 area 컴포넌트
		Southpanel.setOpaque(false);

		// north
		JLabel moneyLable = new JLabel("카드 계산");
		moneyLable.setFont(new Font("굴림체", Font.BOLD, 30));

		/// center 테이블 부분		
		dTable.addColumn("메뉴"); dTable.addColumn("단가");
		dTable.addColumn("수량"); dTable.addColumn("금액");
		
		displayAll();
		JTable table = new JTable(dTable);
		table.setRowHeight(30);
		JScrollPane jsp = new JScrollPane(table);
		
		Centerpanel.add(jsp);
		// 테이블

		// south
		JTextArea moneyText = new JTextArea(10, 40);
		moneyText.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		moneyText.append("총  합  계 : 3000 " + "\n");
		moneyText.append(
				"--------------------------------------------------------------------------------------" + "\n");
		moneyText.append("받 을 금 액 : " + "\n");
		moneyText.append("받 은 금 액 : " + "\n");

		Southpanel.add(moneyText);
		Southpanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 70, 0));
		Northpanel.add(moneyLable);

		background.add(Northpanel, BorderLayout.NORTH); // 메인 프레임에 메인패널을 붙여주는 작업
		background.add(Centerpanel, BorderLayout.CENTER);
		background.add(Southpanel, BorderLayout.SOUTH);

		add(background, BorderLayout.CENTER);

		setVisible(true); // 프레임 보이게 하기

		addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}

		});
	}

	public ImageIcon imageSetSize(ImageIcon icon, int i, int j) {
		Image ximg = icon.getImage();
		Image yimg = ximg.getScaledInstance(i, j, java.awt.Image.SCALE_SMOOTH);
		ImageIcon xyimg = new ImageIcon(yimg);
		return xyimg;
	}

	public void displayAll() {
		dTable.setRowCount(0);
		
		CoffeePosDAO dao = new CoffeePosDAO();
		dao.listAll(dTable, count);
	}
	
	public static void main(String[] args) {
		new MoneyCard();
		
		
	}
}
