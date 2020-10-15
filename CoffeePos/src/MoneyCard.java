
//현금영수증임

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.*;

public class MoneyCard extends JFrame {

	public MoneyCard() {

		super("카드 영수증"); // 프레임 제목 붙이기

		JPanel Centerpanel = new JPanel(); // 패널 객체화 // 테이블 넣을 공간
		JPanel Northpanel = new JPanel(); // 패널 객체화 // 현금 결제 라벨 텍스트 컴포넌트
		JPanel Southpanel = new JPanel(); // 패널 객체화 // 텍스트 area 컴포넌트

		// north
		JLabel moneyLable = new JLabel("카드 계산");
		moneyLable.setFont(new Font("굴림체", Font.BOLD, 30));

		/// center 테이블 부분
		String[] colNames = { "메뉴", "단가", "수량", "금액" };
		Object data[][] = { { "아메리카노", "3000", "1", "3000" }, { "카페라떼", "3500", "2", "7000" } };
		JTable table = new JTable(data, colNames);

		JScrollPane jsp = new JScrollPane(table);

		Centerpanel = new JPanel();
		// add(new JScrollPane(table));
		// Centerpanel.add(table);
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
		Northpanel.add(moneyLable);

		add(Northpanel, BorderLayout.NORTH); // 메인 프레임에 메인패널을 붙여주는 작업
		add(Centerpanel);
		add(Southpanel, BorderLayout.SOUTH);

		setBounds(200, 200, 600, 700);
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임바 우측상단에 X버튼에 대한
		// 강제종료 기능 지정

		setVisible(true); // 프레임 보이게 하기

		addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) { dispose(); }
			
		});

	}

}
