
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.*;

public class pos {

	public pos() {
		
		JFrame frame = new JFrame();
		frame.setBounds(100, 100, 1550, 850);
		frame.setTitle("POS");
		frame.setResizable(false);
		
		JPanel paymentJp = new JPanel();		// 결제창
		JPanel calculatorJP = new JPanel();		// 계산기
		JPanel screenJp = new JPanel();			// 스크린
		JPanel buttonJp = new JPanel();			// 버튼
		
		// 메뉴창
		JTabbedPane tab = menuButton();
		tab.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		
		// 계산기
		calculatorJP = calculater();
		
		// 스크린
		JPanel sjp = screen();
		screenJp.add(sjp);
		screenJp.setBorder(BorderFactory.createEmptyBorder(20,0,40,10));
		
		
		// 결제창
		JTable table = payment();
		
		JScrollPane jsp = new JScrollPane(table);
		table.setFillsViewportHeight(true);
		paymentJp.setLayout(new BorderLayout());
		paymentJp.add(jsp, BorderLayout.CENTER);
		paymentJp.setBorder(BorderFactory.createEmptyBorder(40,20,0,20));
		// 버튼창
		buttonJp = btn();
		
		// 계산기, 스크린
		JPanel jp2 = new JPanel(new BorderLayout());
		jp2.add(calculatorJP,BorderLayout.WEST);
		jp2.add(screenJp,BorderLayout.EAST);
		
		// 결제창 계산기 스크린
		JPanel jp3 = new JPanel(new GridLayout(2,1,2,2));
		jp3.add(paymentJp); jp3.add(jp2);
		
		JPanel jp4 = new JPanel(new BorderLayout());
		jp4.add(tab, BorderLayout.CENTER);
		jp4.add(buttonJp, BorderLayout.SOUTH);
		jp4.setBorder(BorderFactory.createEmptyBorder(20,0,20,0));
		
		// 결제창 계산기 스크린 메뉴창
		JPanel jp5 = new JPanel(new GridLayout(1,2,2,2));
		jp5.add(jp3); jp5.add(jp4);
		
		frame.add(jp5);
		frame.setVisible(true);
		
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
	
	// 메뉴창 
	public JTabbedPane menuButton() {
		
		JPanel menuCoffeeJP = new JPanel(new GridLayout(4,3,5,5));		// 메뉴 - 커피
		JPanel menuNonCoffeeJP = new JPanel(new GridLayout(4,3,5,5));	// 메뉴 - 논커피
		JPanel menuBakeryJP = new JPanel(new GridLayout(4,3,5,5));		// 메뉴 - 베이커리
		
		// 메뉴창 - 커피
		JButton americanoHot = new JButton("HOT \n아메리카노");
		americanoHot.setFont(new Font(null, Font.BOLD, 20));
		americanoHot.setHorizontalTextPosition(SwingConstants.CENTER);
		JButton americanoIce = new JButton("ICE \n아메리카노");
		americanoIce.setHorizontalTextPosition(SwingConstants.CENTER);
		americanoIce.setFont(new Font(null, Font.BOLD, 20));
		JButton latteHot = new JButton("HOT \n카페라떼");
		latteHot.setHorizontalTextPosition(SwingConstants.CENTER);
		latteHot.setFont(new Font(null, Font.BOLD, 20));
		JButton latteIce = new JButton("ICE \n카페라떼");
		latteIce.setHorizontalTextPosition(SwingConstants.CENTER);
		latteIce.setFont(new Font(null, Font.BOLD, 20));
		JButton mochaHot = new JButton("HOT \n카페모카");
		mochaHot.setHorizontalTextPosition(SwingConstants.CENTER);
		mochaHot.setFont(new Font(null, Font.BOLD, 20));
		JButton mochaIce = new JButton("ICE \n카페모카");
		mochaIce.setHorizontalTextPosition(SwingConstants.CENTER);
		mochaIce.setFont(new Font(null, Font.BOLD, 20));
		JButton vanillaHot = new JButton("HOT \n바닐라라떼");
		vanillaHot.setHorizontalTextPosition(SwingConstants.CENTER);
		vanillaHot.setFont(new Font(null, Font.BOLD, 20));
		JButton vanillaIce = new JButton("ICE \n바닐라라떼");
		vanillaIce.setHorizontalTextPosition(SwingConstants.CENTER);
		vanillaIce.setFont(new Font(null, Font.BOLD, 20));
		JButton coldbrewIce = new JButton("ICE \n콜드브루");
		coldbrewIce.setHorizontalTextPosition(SwingConstants.CENTER);
		coldbrewIce.setFont(new Font(null, Font.BOLD, 20));
		
		JPanel coffeePlusJp = new JPanel();
		JButton coffeePlus = new JButton(">");
		coffeePlusJp.add(coffeePlus);
		coffeePlusJp.setBorder(BorderFactory.createEmptyBorder(53,30,30,30));
		JPanel coffeeMinusJp = new JPanel();
		JButton coffeeMinus = new JButton("<");
		coffeeMinusJp.add(coffeeMinus);
		coffeeMinusJp.setBorder(BorderFactory.createEmptyBorder(53,30,30,30));
		JLabel coffeeCount = new JLabel("수량");
		coffeeCount.setHorizontalAlignment(0);
		
		JPanel countJp = new JPanel(new GridLayout(1,3));
		countJp.add(coffeeMinusJp);
		countJp.add(coffeeCount);
		countJp.add(coffeePlusJp);
		
		menuCoffeeJP.add(americanoHot); menuCoffeeJP.add(americanoIce);
		menuCoffeeJP.add(mochaHot); menuCoffeeJP.add(latteHot); 
		menuCoffeeJP.add(latteIce); menuCoffeeJP.add(mochaIce);
		menuCoffeeJP.add(vanillaHot); menuCoffeeJP.add(vanillaIce);
		menuCoffeeJP.add(coldbrewIce); menuCoffeeJP.add(countJp);
		
		// 메뉴창 - 논커피
		JButton minteaHot = new JButton("HOT \n민트티");
		minteaHot.setFont(new Font(null, Font.BOLD, 20));
		minteaHot.setHorizontalTextPosition(SwingConstants.CENTER);
		JButton lemonteaHot = new JButton("HOT \n레몬티");
		lemonteaHot.setFont(new Font(null, Font.BOLD, 20));
		lemonteaHot.setHorizontalTextPosition(SwingConstants.CENTER);
		JButton balckteaHot = new JButton("HOT \n블랙티");
		balckteaHot.setFont(new Font(null, Font.BOLD, 20));
		balckteaHot.setHorizontalTextPosition(SwingConstants.CENTER);
		JButton earlgreyteaHot = new JButton("HOT \n얼그레이");
		earlgreyteaHot.setFont(new Font(null, Font.BOLD, 20));
		earlgreyteaHot.setHorizontalTextPosition(SwingConstants.CENTER);
		JButton greenteaHot = new JButton("HOT \n그린티");
		greenteaHot.setFont(new Font(null, Font.BOLD, 20));
		greenteaHot.setHorizontalTextPosition(SwingConstants.CENTER);
		JButton mangoIce = new JButton("ICE \n망고스무디");
		mangoIce.setFont(new Font(null, Font.BOLD, 20));
		mangoIce.setHorizontalTextPosition(SwingConstants.CENTER);
		JButton grapefruitICE = new JButton("ICE \n자몽에이드");
		grapefruitICE.setFont(new Font(null, Font.BOLD, 20));
		grapefruitICE.setHorizontalTextPosition(SwingConstants.CENTER);
		JButton orangeIce = new JButton("ICE \n오렌지 에이드");
		orangeIce.setFont(new Font(null, Font.BOLD, 20));
		orangeIce.setHorizontalTextPosition(SwingConstants.CENTER);
				
		JPanel noncoffeePlusJp = new JPanel();
		JButton noncoffeePlus = new JButton(">");
		noncoffeePlusJp.add(noncoffeePlus);
		noncoffeePlusJp.setBorder(BorderFactory.createEmptyBorder(53,30,30,30));
		JPanel noncoffeeMinusJp = new JPanel();
		JButton noncoffeeMinus = new JButton("<");
		noncoffeeMinusJp.add(noncoffeeMinus);
		noncoffeeMinusJp.setBorder(BorderFactory.createEmptyBorder(53,30,30,30));
		JLabel noncoffeeCount = new JLabel("수량");
		noncoffeeCount.setHorizontalAlignment(0);
		
		JLabel em = new JLabel(" ");
				
		JPanel noncountJp = new JPanel(new GridLayout(1,3));
		noncountJp.add(noncoffeeMinusJp);
		noncountJp.add(noncoffeeCount);
		noncountJp.add(noncoffeePlusJp);
				
		menuNonCoffeeJP.add(minteaHot); menuNonCoffeeJP.add(lemonteaHot);
		menuNonCoffeeJP.add(greenteaHot); menuNonCoffeeJP.add(balckteaHot); 
		menuNonCoffeeJP.add(earlgreyteaHot); menuNonCoffeeJP.add(mangoIce);
		menuNonCoffeeJP.add(grapefruitICE); menuNonCoffeeJP.add(orangeIce);
		menuNonCoffeeJP.add(em); menuNonCoffeeJP.add(noncountJp);
		
		// 메뉴창 - 베이커리
		JButton berryBagel = new JButton("블루베리\n베이글");
		berryBagel.setFont(new Font(null, Font.BOLD, 20));
		berryBagel.setHorizontalTextPosition(SwingConstants.CENTER);
		JButton planeBagel = new JButton("플레인\n베이글");
		planeBagel.setFont(new Font(null, Font.BOLD, 20));
		planeBagel.setHorizontalTextPosition(SwingConstants.CENTER);
		JButton sandwich = new JButton("샌드위치");
		sandwich.setFont(new Font(null, Font.BOLD, 20));
		sandwich.setHorizontalTextPosition(SwingConstants.CENTER);
		JButton tiramisu = new JButton("티라미슈");
		tiramisu.setFont(new Font(null, Font.BOLD, 20));
		tiramisu.setHorizontalTextPosition(SwingConstants.CENTER);
		JButton redvelvet = new JButton("레드벨벳 케익");
		redvelvet.setFont(new Font(null, Font.BOLD, 20));
		earlgreyteaHot.setHorizontalTextPosition(SwingConstants.CENTER);
		JButton cheese = new JButton("치즈 케익");
		cheese.setFont(new Font(null, Font.BOLD, 20));
		cheese.setHorizontalTextPosition(SwingConstants.CENTER);
		JButton scon = new JButton("스콘");
		scon.setFont(new Font(null, Font.BOLD, 20));
		scon.setHorizontalTextPosition(SwingConstants.CENTER);
		JButton salad = new JButton("샐러드");
		salad.setFont(new Font(null, Font.BOLD, 20));
		salad.setHorizontalTextPosition(SwingConstants.CENTER);
		
		JPanel BakeryPlusJp = new JPanel();
		JButton BakeryPlus = new JButton(">");
		BakeryPlusJp.add(BakeryPlus);
		BakeryPlusJp.setBorder(BorderFactory.createEmptyBorder(53,30,30,30));
		JPanel BakeryMinusJp = new JPanel();
		JButton BakeryMinus = new JButton("<");
		BakeryMinusJp.add(BakeryMinus);
		BakeryMinusJp.setBorder(BorderFactory.createEmptyBorder(53,30,30,30));
		JLabel BakeryCount = new JLabel("수량");
		BakeryCount.setHorizontalAlignment(0);
		
		JLabel em2 = new JLabel(" ");
				
		JPanel BakeryJp = new JPanel(new GridLayout(1,3));
		BakeryJp.add(BakeryMinusJp);
		BakeryJp.add(BakeryCount);
		BakeryJp.add(BakeryPlusJp);
				
		menuBakeryJP.add(berryBagel); menuBakeryJP.add(planeBagel);
		menuBakeryJP.add(sandwich); menuBakeryJP.add(tiramisu); 
		menuBakeryJP.add(redvelvet); menuBakeryJP.add(cheese);
		menuBakeryJP.add(scon); menuBakeryJP.add(salad);
		menuBakeryJP.add(em2); menuBakeryJP.add(BakeryJp);
		
		JTabbedPane tab = new JTabbedPane();
		
		tab.add("Coffee", menuCoffeeJP);
		tab.add("NonCoffee" , menuNonCoffeeJP);
		tab.add("Bakery", menuBakeryJP);
		
		return tab;
	}
	
	// 계산기
	public JPanel calculater() {
		
		JPanel panel = new JPanel(new BorderLayout());
		
		JTextArea ta = new JTextArea(6,30);
		ta.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		ta.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		ta.setFont(new Font(null, 0, 20));
		ta.setFocusable(false);
		
		JPanel buttonJp = new JPanel(new GridLayout(4,4,10,10));
		
		JButton btn[] = new JButton[10];
		
		for(int i = 0;i<10;i++) {
			btn[i] = new JButton(Integer.toString(i));
		}
		
		JButton jbce = new JButton("CE");
		JButton jbp = new JButton("+");
		JButton jbm = new JButton("-");
		JButton jbe = new JButton("Enter");
		JButton jbc = new JButton("C");
		JButton jbj = new JButton(".");
		
		buttonJp.add(btn[7]); buttonJp.add(btn[8]); buttonJp.add(btn[9]); buttonJp.add(jbce);
		buttonJp.add(btn[4]); buttonJp.add(btn[5]); buttonJp.add(btn[6]); buttonJp.add(jbp);
		buttonJp.add(btn[1]); buttonJp.add(btn[2]); buttonJp.add(btn[3]); buttonJp.add(jbm);
		buttonJp.add(jbj); buttonJp.add(btn[0]); buttonJp.add(jbc); buttonJp.add(jbe);

		buttonJp.setBorder(BorderFactory.createEmptyBorder(20,0,0,0));
		
		panel.add(ta, BorderLayout.NORTH);
		panel.add(buttonJp, BorderLayout.CENTER);	
		panel.setBorder(BorderFactory.createEmptyBorder(30,25,30,30));
		
		
		return panel;
	}
	
	// 스크린 
	public JPanel screen() {
		
		JPanel panel = new JPanel();
		
		int total, usepoint, savepoint, pay;
		
		total = 50000;
		usepoint = 3000;
		savepoint = 500;
		pay = total-usepoint;
		
		JTextArea ta = new JTextArea(20,15);
		ta.setText("총 금액 : " + total + "원\n\n적립 포인트 : " + savepoint + 
				"점\n사용 포인트 : " + usepoint + "점"+
				"\n\n\n\n\n\n\n\n\n\n\n\n\n\n---------------------------------------\n"+
				"결제 금액 : " + pay + "원");
		ta.setBorder(BorderFactory.createEmptyBorder(20,10,10,10));
		ta.setFocusable(false);
		
		panel.add(ta);
		
		return panel;
	}
	
	// 결제창
	public JTable payment() {
		
		String[] header = {"메뉴", "수량", "가격"};
		String[][] data = {{"아메리카노","5","20000"},
				{"카페라떼","1","4500"}};
		
		
		JTable table = new JTable(data, header);
		
		table.setRowHeight(30);
		
		return table;
	}
	
	// 버튼
	public JPanel btn() {
		
		JPanel panel = new JPanel(new GridLayout(1,3,5,5));
		
		panel.setBorder(BorderFactory.createEmptyBorder(0,15,10,15));
		
		JButton searchBtn = new JButton("회원조회");
		searchBtn.setPreferredSize(new Dimension(40,100));
		JButton moneyBtn = new JButton("현금결제");
		JButton cardBtn = new JButton("카드결제");
		
		panel.add(searchBtn); panel.add(moneyBtn); panel.add(cardBtn);
		
		return panel;
	}
	
	public static void main(String[] args) {
		new pos();
	}

}
