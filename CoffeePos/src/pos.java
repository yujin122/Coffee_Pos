
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.*;


public class pos {

	public pos() {
		
		JFrame frame = new JFrame();
		frame.setBounds(100, 100, 800, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("POS");
		
		JPanel paymentJp = new JPanel();		// 결제창
		JPanel calculatorJP = new JPanel();		// 계산기
		JPanel screenJp = new JPanel();			// 스크린
		JPanel buttonJp = new JPanel();			// 버튼
		
		/*JPanel menuCoffeeJP = new JPanel(new GridLayout(4,3,5,5));		// 메뉴 - 커피
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
		coffeePlusJp.setBorder(BorderFactory.createEmptyBorder(75,30,30,30));
		JPanel coffeeMinusJp = new JPanel();
		JButton coffeeMinus = new JButton("<");
		coffeeMinusJp.add(coffeeMinus);
		coffeeMinusJp.setBorder(BorderFactory.createEmptyBorder(75,30,30,30));
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
		noncoffeePlusJp.setBorder(BorderFactory.createEmptyBorder(75,30,30,30));
		JPanel noncoffeeMinusJp = new JPanel();
		JButton noncoffeeMinus = new JButton("<");
		noncoffeeMinusJp.add(noncoffeeMinus);
		noncoffeeMinusJp.setBorder(BorderFactory.createEmptyBorder(75,30,30,30));
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
		BakeryPlusJp.setBorder(BorderFactory.createEmptyBorder(75,30,30,30));
		JPanel BakeryMinusJp = new JPanel();
		JButton BakeryMinus = new JButton("<");
		BakeryMinusJp.add(BakeryMinus);
		BakeryMinusJp.setBorder(BorderFactory.createEmptyBorder(75,30,30,30));
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
		*/
		
		JTabbedPane tab = menuButton();
		frame.add(tab);
		frame.setVisible(true);
		
		
		

	}
	
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
		coffeePlusJp.setBorder(BorderFactory.createEmptyBorder(75,30,30,30));
		JPanel coffeeMinusJp = new JPanel();
		JButton coffeeMinus = new JButton("<");
		coffeeMinusJp.add(coffeeMinus);
		coffeeMinusJp.setBorder(BorderFactory.createEmptyBorder(75,30,30,30));
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
		noncoffeePlusJp.setBorder(BorderFactory.createEmptyBorder(75,30,30,30));
		JPanel noncoffeeMinusJp = new JPanel();
		JButton noncoffeeMinus = new JButton("<");
		noncoffeeMinusJp.add(noncoffeeMinus);
		noncoffeeMinusJp.setBorder(BorderFactory.createEmptyBorder(75,30,30,30));
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
		BakeryPlusJp.setBorder(BorderFactory.createEmptyBorder(75,30,30,30));
		JPanel BakeryMinusJp = new JPanel();
		JButton BakeryMinus = new JButton("<");
		BakeryMinusJp.add(BakeryMinus);
		BakeryMinusJp.setBorder(BorderFactory.createEmptyBorder(75,30,30,30));
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
	
	public static void main(String[] args) {
		new pos();
	}

}
