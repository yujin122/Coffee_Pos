import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

public class Card extends JFrame {

	private ImageIcon icon;

	public Card() {

		super("결제창"); // 프레임 제목 붙이기

		icon = new ImageIcon("image/payment.png");
		icon = imageSetSize(icon, 550, 750);

		JPanel background = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(), 0, 0, null);
			}
		};

		setLocation(100, 100);
		setPreferredSize(new Dimension(560, 780));
		setSize(new Dimension(560, 780));

		JPanel Centerpanel = new JPanel(); // 패널 객체화 // 테이블 넣을 공간
		Centerpanel.setBackground(new Color(0,0,0,0));
		JPanel Northpanel = new JPanel(); // 패널 객체화 // 현금 결제 라벨 텍스트 컴포넌트
		Northpanel.setBackground(new Color(0,0,0,0));
		JPanel Southpanel = new JPanel(); // 패널 객체화 // 텍스트 area 컴포넌트
		Southpanel.setBackground(new Color(0,0,0,0));
		
		// north
		JLabel cardLable = new JLabel("결제");
		cardLable.setFont(new Font("굴림체", Font.BOLD, 30));

		/// center 테이블 부분
		String[] colNames = { "메뉴", "단가", "수량", "금액" };
		Object data[][] = { { "아메리카노", new Integer(3000), "1", "3000" }, { "카페라떼", "3500", "2", "7000" } };
		JTable table = new JTable(data, colNames);
		
		JScrollPane jsp = new JScrollPane(table);

		Centerpanel = new JPanel();
		// add(new JScrollPane(table));
		// Centerpanel.add(table);
		Centerpanel.add(jsp);
		// 테이블

		// south
		JTextArea cardText = new JTextArea(10, 40);
		cardText.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		cardText.append("총  합  계 : 10000원" + "\n");
		cardText.append(
				"--------------------------------------------------------------------------------------" + "\n");
		cardText.append("받 을 금 액 : 원" + "\n");
		cardText.append("받 음 금 액 : 원" + "\n");

		Southpanel.add(cardText);
		Northpanel.add(cardLable);

		JPanel allJp = new JPanel(new BorderLayout());
		allJp.setBackground(new Color(0,0,0,0));
		
		allJp.add(Northpanel, BorderLayout.NORTH);
		allJp.add(Centerpanel, BorderLayout.CENTER);
		allJp.add(Southpanel, BorderLayout.SOUTH);

		background.add(allJp);
		
		add(background);

		// setBounds(200, 200, 600, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임바 우측상단에 X버튼에 대한
		// 강제종료 기능 지정

		setVisible(true); // 프레임 보이게 하기
	}

	public ImageIcon imageSetSize(ImageIcon icon, int i, int j) {
		Image ximg = icon.getImage();
		Image yimg = ximg.getScaledInstance(i, j, java.awt.Image.SCALE_SMOOTH);
		ImageIcon xyimg = new ImageIcon(yimg);
		return xyimg;
	}

	public static void main(String[] args) {
		new Card();
	}

}
