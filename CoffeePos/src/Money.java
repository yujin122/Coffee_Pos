import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

// 현금영수증
public class Money extends JFrame {

	private ImageIcon icon;
	DefaultTableModel dTable = new DefaultTableModel();

	
	public Money() {}
	
	public Money(int pay) {

		super("현금 영수증"); // 프레임 제목 붙이기

		int point = POS.usep;
		
		icon = new ImageIcon("image/payment.png");
		icon = imageSetSize(icon, 550, 810);

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
		
		setSize(558, 830);
		setLocation(width/2-this.getWidth()/2, height/2-this.getHeight()/2);
		setResizable(false);
		
		JPanel Centerpanel = new JPanel(); // 패널 객체화 // 테이블 넣을 공간
		Centerpanel.setOpaque(false);
		JPanel Northpanel = new JPanel(); // 패널 객체화 // 현금 결제 라벨 텍스트 컴포넌트
		Northpanel.setBorder(BorderFactory.createEmptyBorder(15, 0, 5, 0));
		Northpanel.setOpaque(false);
		JPanel Southpanel = new JPanel(); // 패널 객체화 // 텍스트 area 컴포넌트
		Southpanel.setOpaque(false);

		// north
		JLabel moneyLable = new JLabel("현금 계산");
		moneyLable.setFont(new Font("굴림체", Font.BOLD, 30));

		/// center 테이블 부분
		
		dTable.addColumn("메뉴"); dTable.addColumn("단가");
		dTable.addColumn("수량"); dTable.addColumn("금액");
		
		displayAll(POS.preNum);
		
		JTable table = new JTable(dTable);
		table.setRowHeight(30);
		JScrollPane jsp = new JScrollPane(table);
		//table.setRowHeight(10);

		int tot = totalPrice(POS.preNum);
		insertSales(tot);
		
		Centerpanel.add(jsp);
		// 테이블

		// south
		JTextArea moneyText = new JTextArea(10, 40);
		moneyText.setBorder(BorderFactory.createEmptyBorder(20,20,5,20));
		moneyText.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		moneyText.append("총  합  계 : " + String.format("%,d", tot) +"\n");
		moneyText.append(
				"--------------------------------------------------------------------------------------------------------------" + "\n");
		moneyText.append("\n\n");
		moneyText.append("받 은 금 액 : " + String.format("%,d",pay) + " 원\n\n");
		moneyText.append("사 용 포 인 트 : " + point + " 점\n\n");
		moneyText.append("결 제 금 액 : " + String.format("%,d", tot-point) +" 원\n\n");
		moneyText.append("거 스 름 돈 : " +  String.format("%,d",(pay - tot+point)) +" 원\n");

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
				POS.usep = 0;
				dispose();
			}

		});
	}
	
	public void displayAll(int num) {
		dTable.setRowCount(0);
		
		CoffeePosDAO dao = new CoffeePosDAO();
		dao.listAll(dTable, num);
	}
	
	public int totalPrice(int num) {
		CoffeePosDAO dao = new CoffeePosDAO();
		int sum = dao.sumPrice(num);
		
		return sum;
	}

	public void insertSales(int sum) {
		CoffeePosDAO dao = new CoffeePosDAO();
		
		int result = dao.addSales(sum);
		
		if(result >0) {
			JOptionPane.showMessageDialog(this, "매출 저장 완료");
		}else {
			JOptionPane.showMessageDialog(this, "매출 저장 실패");
		}
		
	}
	
	public ImageIcon imageSetSize(ImageIcon icon, int i, int j) {
		Image ximg = icon.getImage();
		Image yimg = ximg.getScaledInstance(i, j, java.awt.Image.SCALE_SMOOTH);
		ImageIcon xyimg = new ImageIcon(yimg);
		return xyimg;
	}
}
