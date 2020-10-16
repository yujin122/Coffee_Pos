import java.awt.*;
import java.awt.event.*;


import javax.swing.*;


public class POS extends JFrame{

	private int cnt = 0;
	private ImageIcon icon;
	private int num = 0;
	private int screen_total=0, usepoint =0, savepoint=0, pay=0;
	JTable table; JTextArea screenTa;
	
	MerInfo[] coffeeinfo = new MerInfo[9];
	MerInfo[] noncfeinfo = new MerInfo[8];
	MerInfo[] bakeryinfo = new MerInfo[8];
	
	String[][] menu = new String[20][4];
	
	public POS() {
		
		new Info();
		
		icon = new ImageIcon("image/posback.png");
		icon = imageSetSize(icon, 1567, 890);
		
		JPanel background = new JPanel(new BorderLayout()) {
			public void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(),0,0,null);
			}
		};	

		//1567
		setPreferredSize(new Dimension(1450, 910));
		setSize(new Dimension(1450, 890));
		setResizable(false);
		setTitle("POS");
		
		JPanel paymentJp = new JPanel();		// 결제창
		paymentJp.setOpaque(false);
		paymentJp.setSize(5,50);
		
		JPanel calculatorJP = new Calculator();	// 계산기
		calculatorJP.setOpaque(false);
		
		JPanel screenJp = new JPanel();			// 스크린
		screenJp.setOpaque(false);
		
		JPanel buttonJp = new JPanel();			// 버튼
		buttonJp.setOpaque(false);
		
		// 메뉴창
		JTabbedPane tab = menuButton();
		tab.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

		
		// 스크린
		screenTa= screen();
	
		screenJp.add(screenTa);
		screenJp.setBorder(BorderFactory.createEmptyBorder(20,0,40,10));
		screenJp.setPreferredSize(new Dimension(200, 180));
		screenJp.setSize(new Dimension(200, 180));
		
		// 결제창
		table = payment();
		
		JScrollPane jsp = new JScrollPane(table);

		table.setFillsViewportHeight(true);
		paymentJp.setLayout(new BorderLayout());
		paymentJp.add(jsp, BorderLayout.CENTER);
		paymentJp.setBorder(BorderFactory.createEmptyBorder(40,20,0,20));

		// 버튼창
		buttonJp = btn();
		
		// 계산기, 스크린
		JPanel jp2 = new JPanel(new BorderLayout());
		jp2.setOpaque(false);
		jp2.add(calculatorJP,BorderLayout.CENTER);
		jp2.add(screenJp,BorderLayout.EAST);
		
		// 결제창 계산기 스크린
		JPanel jp3 = new JPanel(new GridLayout(2,1,2,2));
		
		jp3.setOpaque(false);
		jp3.add(paymentJp); jp3.add(jp2);
		
		JPanel jp4 = new JPanel(new BorderLayout());
		jp4.setOpaque(false);
		jp4.add(tab, BorderLayout.CENTER);
		jp4.add(buttonJp, BorderLayout.SOUTH);
		jp4.setBorder(BorderFactory.createEmptyBorder(20,0,20,0));
		
		// 결제창 계산기 스크린 메뉴창
		JPanel jp5 = new JPanel(new GridLayout(1,2,2,2));
		jp5.setOpaque(false);

		background.add(jp3,BorderLayout.CENTER); background.add(jp4, BorderLayout.EAST);
		
		add(background);
		pack();
		setVisible(true);
		
		
		addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) { new Menu(); }
			
		});
	}
	
	// 메뉴창 
	public JTabbedPane menuButton() {
		
		JPanel menuCoffeeJP = new JPanel(new GridLayout(4,3,5,5));		// 메뉴 - 커피
		JPanel menuNonCoffeeJP = new JPanel(new GridLayout(4,3,5,5));	// 메뉴 - 논커피
		JPanel menuBakeryJP = new JPanel(new GridLayout(4,3,5,5));		// 메뉴 - 베이커리
		
		ImageIcon[] coffeeImg = {new ImageIcon("image/cficon/1.png"),new ImageIcon("image/cficon/2.png"),new ImageIcon("image/cficon/3.png"),
				new ImageIcon("image/cficon/4.png"),new ImageIcon("image/cficon/5.png"),new ImageIcon("image/cficon/6.png"),
				new ImageIcon("image/cficon/7.png"),new ImageIcon("image/cficon/8.png"),new ImageIcon("image/cficon/9.png")};
		
		for(int i =0;i<9;i++) {
			coffeeImg[i] = imageSetSize(coffeeImg[i], 210, 160);
		}
		
		
		// 메뉴창 - 커피
		JButton[] CoffeeMBtn = new JButton[9];
		
		for(int i=0;i<9;i++) {
			CoffeeMBtn[i]= new JButton(Integer.toString(i));
			CoffeeMBtn[i].setBackground(Color.WHITE);
			CoffeeMBtn[i].setIcon(coffeeImg[i]);
		}
		
		JPanel coffeePlusJp = new JPanel();
		JButton[] plus = new JButton[3];
		plus[0] = new JButton(">");
		coffeePlusJp.add(plus[0]);
		coffeePlusJp.setBorder(BorderFactory.createEmptyBorder(53,30,30,30));
		JPanel coffeeMinusJp = new JPanel();
		JButton[] minus = new JButton[3];
		minus[0] = new JButton("<");
		coffeeMinusJp.add(minus[0]);
		coffeeMinusJp.setBorder(BorderFactory.createEmptyBorder(53,30,30,30));
		JLabel[] count = new JLabel[3];
		count[0] = new JLabel("수량");
		count[0].setHorizontalAlignment(0);
		
		JPanel countJp = new JPanel(new GridLayout(1,3));
		countJp.add(coffeeMinusJp);
		countJp.add(count[0]);
		countJp.add(coffeePlusJp);
		
		menuCoffeeJP.add(CoffeeMBtn[0]); menuCoffeeJP.add(CoffeeMBtn[1]);
		menuCoffeeJP.add(CoffeeMBtn[4]); menuCoffeeJP.add(CoffeeMBtn[2]); 
		menuCoffeeJP.add(CoffeeMBtn[3]); menuCoffeeJP.add(CoffeeMBtn[5]);
		menuCoffeeJP.add(CoffeeMBtn[6]); menuCoffeeJP.add(CoffeeMBtn[7]);
		menuCoffeeJP.add(CoffeeMBtn[8]); menuCoffeeJP.add(countJp);
		
		// 메뉴창 - 논커피
		JButton[] NonCoffeeMBtn = new JButton[8];
		
		ImageIcon[] nonCoffeeImg = {new ImageIcon("image/ncficon/1.png"),new ImageIcon("image/ncficon/2.png"),new ImageIcon("image/ncficon/3.png"),
				new ImageIcon("image/ncficon/4.png"),new ImageIcon("image/ncficon/5.png"),new ImageIcon("image/ncficon/6.png"),
				new ImageIcon("image/ncficon/7.png"),new ImageIcon("image/ncficon/8.png"),new ImageIcon("image/ncficon/9.png")};
		
		for(int i =0;i<9;i++) {
			nonCoffeeImg[i] = imageSetSize(nonCoffeeImg[i], 210, 160);
		}
		
		for(int i=0;i<8;i++) {
			NonCoffeeMBtn[i]= new JButton(nonCoffeeImg[i]);
			NonCoffeeMBtn[i].setBackground(Color.WHITE);
			NonCoffeeMBtn[i].setText(Integer.toString(i));
		}
				
		JPanel noncoffeePlusJp = new JPanel();
		plus[1] = new JButton(">");
		noncoffeePlusJp.add(plus[1]);
		noncoffeePlusJp.setBorder(BorderFactory.createEmptyBorder(53,30,30,30));
		JPanel noncoffeeMinusJp = new JPanel();
		minus[1] = new JButton("<");
		noncoffeeMinusJp.add(minus[1]);
		noncoffeeMinusJp.setBorder(BorderFactory.createEmptyBorder(53,30,30,30));
		count[1] = new JLabel("수량");
		count[1].setHorizontalAlignment(0);
		
		JLabel em = new JLabel(" ");
				
		JPanel noncountJp = new JPanel(new GridLayout(1,3));
		noncountJp.add(noncoffeeMinusJp);
		noncountJp.add(count[1]);
		noncountJp.add(noncoffeePlusJp);
				
		menuNonCoffeeJP.add(NonCoffeeMBtn[0]); menuNonCoffeeJP.add(NonCoffeeMBtn[1]);
		menuNonCoffeeJP.add(NonCoffeeMBtn[2]); menuNonCoffeeJP.add(NonCoffeeMBtn[3]); 
		menuNonCoffeeJP.add(NonCoffeeMBtn[4]); menuNonCoffeeJP.add(NonCoffeeMBtn[5]);
		menuNonCoffeeJP.add(NonCoffeeMBtn[6]); menuNonCoffeeJP.add(NonCoffeeMBtn[7]);
		menuNonCoffeeJP.add(em); menuNonCoffeeJP.add(noncountJp);
		
		// 메뉴창 - 베이커리
		JButton[] bakeryMBtn = new JButton[8];
		
		ImageIcon[] bakeryImg = {new ImageIcon("image/dessert/1.png"),new ImageIcon("image/dessert/2.png"),new ImageIcon("image/dessert/3.png"),
				new ImageIcon("image/dessert/4.png"),new ImageIcon("image/dessert/5.png"),new ImageIcon("image/dessert/6.png"),
				new ImageIcon("image/dessert/7.png"),new ImageIcon("image/dessert/8.png"),new ImageIcon("image/dessert/9.png")};
		
		for(int i =0;i<9;i++) {
			bakeryImg[i] = imageSetSize(bakeryImg[i], 210, 160);
		}
		
		for(int i=0;i<8;i++) {
			bakeryMBtn[i]= new JButton(bakeryImg[i]);
			bakeryMBtn[i].setBackground(Color.WHITE);
			bakeryMBtn[i].setText(Integer.toString(i));

		}
		
		JPanel BakeryPlusJp = new JPanel();
		plus[2] = new JButton(">");
		BakeryPlusJp.add(plus[2]);
		BakeryPlusJp.setBorder(BorderFactory.createEmptyBorder(53,30,30,30));
		JPanel BakeryMinusJp = new JPanel();
		minus[2] = new JButton("<");
		BakeryMinusJp.add(minus[2]);
		BakeryMinusJp.setBorder(BorderFactory.createEmptyBorder(53,30,30,30));
		count[2] = new JLabel("수량");
		count[2].setHorizontalAlignment(0);
		
		JLabel em2 = new JLabel(" ");
			
		JPanel BakeryJp = new JPanel(new GridLayout(1,3));
		BakeryJp.add(BakeryMinusJp);
		BakeryJp.add(count[2]);
		BakeryJp.add(BakeryPlusJp);
				
		menuBakeryJP.add(bakeryMBtn[0]); menuBakeryJP.add(bakeryMBtn[1]);
		menuBakeryJP.add(bakeryMBtn[2]); menuBakeryJP.add(bakeryMBtn[3]); 
		menuBakeryJP.add(bakeryMBtn[4]); menuBakeryJP.add(bakeryMBtn[5]);
		menuBakeryJP.add(bakeryMBtn[6]); menuBakeryJP.add(bakeryMBtn[7]);
		menuBakeryJP.add(em2); menuBakeryJP.add(BakeryJp);
		
		JTabbedPane tab = new JTabbedPane();
		//800
		tab.setPreferredSize(new Dimension(650, 500));
		tab.setSize(new Dimension(650,500));
		tab.add("Coffee", menuCoffeeJP);
		tab.add("NonCoffee" , menuNonCoffeeJP);
		tab.add("Bakery", menuBakeryJP);
		
		
		for(int i = 0; i<9;++i) {
			CoffeeMBtn[i].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					cnt = 1;
					count[0].setText(Integer.toString(cnt));
					count[1].setText(Integer.toString(cnt));
					count[2].setText(Integer.toString(cnt));
					
					JButton jb = (JButton)e.getSource();
					int index = Integer.parseInt(jb.getText());
					
					String name = coffeeinfo[index].getName();
					int price = coffeeinfo[index].getPrice();
					int tprice = price * cnt;
					
					menu[num][0] = name;
					menu[num][1] = Integer.toString(price); 
					menu[num][2] = Integer.toString(cnt);
					menu[num][3] = Integer.toString(tprice);
					num++;
					
					table.repaint();
					
					screen_total=0;
					for(int i = 0;i<num;i++) {
						screen_total += Integer.parseInt(menu[i][3]);
					}
					
					pay = screen_total-usepoint;
					savepoint = (int)(pay * 0.01f);
					
					screenTa.setText("총 금액 : " + String.format("%,d", screen_total) + "원\n\n적립 포인트 : " + savepoint + 
							"점\n사용 포인트 : " + usepoint + "점"+
							"\n\n\n\n\n\n\n\n\n\n\n\n\n\n---------------------------------------\n"+
							"결제 금액 : " + String.format("%,d", pay) + "원");
				}
			});
		}
		
		for(int i = 0; i<8;i++) {
			NonCoffeeMBtn[i].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					cnt = 1;
					count[0].setText(Integer.toString(cnt));
					count[1].setText(Integer.toString(cnt));
					count[2].setText(Integer.toString(cnt));
					
					JButton jb = (JButton)e.getSource();
					int index = Integer.parseInt(jb.getText());
					
					String name = noncfeinfo[index].getName();
					int price = noncfeinfo[index].getPrice();
					int tprice = price * cnt;
					
					menu[num][0] = name;
					menu[num][1] = Integer.toString(price); 
					menu[num][2] = Integer.toString(cnt);
					menu[num][3] = Integer.toString(tprice);
					num++;
					
					table.repaint();
					
					screen_total=0;
					for(int i = 0;i<num;i++) {
						screen_total += Integer.parseInt(menu[i][3]);
					}
					
					pay = screen_total-usepoint;
					savepoint = (int)(pay * 0.01f);

					screenTa.setText("총 금액 : " + String.format("%,d", screen_total) + "원\n\n적립 포인트 : " + savepoint + 
							"점\n사용 포인트 : " + usepoint + "점"+
							"\n\n\n\n\n\n\n\n\n\n\n\n\n\n---------------------------------------\n"+
							"결제 금액 : " + String.format("%,d", pay) + "원");
				}
			});
		}
		
		for(int i = 0; i<8;i++) {
			bakeryMBtn[i].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					cnt = 1;
					count[0].setText(Integer.toString(cnt));
					count[1].setText(Integer.toString(cnt));
					count[2].setText(Integer.toString(cnt));
					
					JButton jb = (JButton)e.getSource();
					int index = Integer.parseInt(jb.getText());
					
					String name = bakeryinfo[index].getName();
					int price = bakeryinfo[index].getPrice();
					int tprice = price * cnt;
					
					menu[num][0] = name;
					menu[num][1] = Integer.toString(price); 
					menu[num][2] = Integer.toString(cnt);
					menu[num][3] = Integer.toString(tprice);
					num++;
					
					table.repaint();
					
					screen_total=0;
					for(int i = 0;i<num;i++) {
						screen_total += Integer.parseInt(menu[i][3]);
					}
					
					pay = screen_total-usepoint;
					savepoint = (int)(pay * 0.01f);
					
					screenTa.setText("총 금액 : " + String.format("%,d", screen_total) + "원\n\n적립 포인트 : " + savepoint + 
							"점\n사용 포인트 : " + usepoint + "점"+
							"\n\n\n\n\n\n\n\n\n\n\n\n\n\n---------------------------------------\n"+
							"결제 금액 : " + String.format("%,d", pay) + "원");
				}
			});
		}
		
		for(int i =0; i < plus.length; i++) {
			plus[i].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					cnt++;
					if(cnt < 1) {
						cnt = 0;
					}
					
					count[0].setText(Integer.toString(cnt));
					count[1].setText(Integer.toString(cnt));
					count[2].setText(Integer.toString(cnt));
					
					int price = Integer.parseInt(menu[num-1][1]);
					
					menu[num-1][2] = Integer.toString(cnt);
					menu[num-1][3] = Integer.toString(price*cnt);
					table.repaint();
					
					screen_total = 0;
					for(int i = 0;i<num;i++) {
						screen_total += Integer.parseInt(menu[i][3]);
					}
					
					pay = screen_total-usepoint;
					savepoint = (int)(pay * 0.01f);
					
					screenTa.setText("총 금액 : " + String.format("%,d", screen_total) + "원\n\n적립 포인트 : " + savepoint + 
							"점\n사용 포인트 : " + usepoint + "점"+
							"\n\n\n\n\n\n\n\n\n\n\n\n\n\n---------------------------------------\n"+
							"결제 금액 : " + String.format("%,d", pay) + "원");
				}
			});
		}

		for(int i =0; i < minus.length; i++) {
			minus[i].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					cnt--;
					
					if(cnt < 0) {
						cnt = 0;
				
						count[0].setText(Integer.toString(cnt));
						count[1].setText(Integer.toString(cnt));
						count[2].setText(Integer.toString(cnt));
					}else {
						count[0].setText(Integer.toString(cnt));
						count[1].setText(Integer.toString(cnt));
						count[2].setText(Integer.toString(cnt));
						
						int price = Integer.parseInt(menu[num-1][1]);
						
						menu[num-1][2] = Integer.toString(cnt);
						menu[num-1][3] = Integer.toString(price*cnt);
						
						table.repaint();
						
						screen_total -= Integer.parseInt(menu[num-1][1]);
						
						pay = screen_total-usepoint;
						savepoint = (int)(pay * 0.01f);
						
						screenTa.setText("총 금액 : " + String.format("%,d", screen_total) + "원\n\n적립 포인트 : " + savepoint + 
								"점\n사용 포인트 : " + usepoint + "점"+
								"\n\n\n\n\n\n\n\n\n\n\n\n\n\n---------------------------------------\n"+
								"결제 금액 : " + String.format("%,d", pay) + "원");
						
					}
					
				}
			});
		}
		
		return tab;
	}
	
	// 스크린 
	public JTextArea screen() {

		for(int i = 0;i<num;i++) {
			screen_total += Integer.parseInt(menu[i][3]);
		}
		
		pay = screen_total-usepoint;
		
		JTextArea ta = new JTextArea(20,15);
		ta.setText("총 금액 : " + screen_total + "원\n\n적립 포인트 : " + savepoint + 
				"점\n사용 포인트 : " + usepoint + "점"+
				"\n\n\n\n\n\n\n\n\n\n\n\n\n\n---------------------------------------\n"+
				"결제 금액 : " + pay + "원");
		ta.setBorder(BorderFactory.createEmptyBorder(20,10,10,10));
		ta.setFocusable(false);
		ta.setPreferredSize(new Dimension( 50,375));
		ta.setSize(new Dimension(50, 375));
		
		return ta;
	}
	
	// 결제창
	public JTable payment() {
		
		String[] header = {"메뉴", "단가", "수량", "가격"};

		JTable jt = new JTable(menu, header);
		
		jt.setRowHeight(30);
		
		return jt;
	}
	
	// 버튼
	public JPanel btn() {
		
		JPanel panel = new JPanel(new GridLayout(1,4,5,5));
		panel.setOpaque(false);
		panel.setBorder(BorderFactory.createEmptyBorder(0,15,10,15));
		
		ImageIcon[] btnImg = {new ImageIcon("image/btn/clear.png"),new ImageIcon("image/btn/search.png"),
				new ImageIcon("image/btn/pay.png"), new ImageIcon("image/btn/card.png")};
		
		for(int i =0;i<4;i++) {
			btnImg[i] = imageSetSize(btnImg[i],80,100);
		}
		
		JButton clearBtn = new JButton(btnImg[0]);
		clearBtn.setPreferredSize(new Dimension(80,100));
		clearBtn.setPreferredSize(new Dimension(80,100));
		clearBtn.setBackground(Color.WHITE);	
		
		JButton searchBtn = new JButton(btnImg[1]);
		searchBtn.setBackground(Color.WHITE);
		JButton moneyBtn = new JButton(btnImg[2]);
		moneyBtn.setBackground(Color.WHITE);

		JButton cardBtn = new JButton(btnImg[3]);
		cardBtn.setBackground(Color.WHITE);
		
		panel.add(clearBtn); panel.add(searchBtn); panel.add(moneyBtn); panel.add(cardBtn);
		
		clearBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				for(int i = 0;i<num;i++) {
					menu[i][0] = null;
					menu[i][1] = null; 
					menu[i][2] = null;
					menu[i][3] = null;
				}
				
				table.repaint();
				
				num = 0;
				
				screen_total = 0; savepoint = 0; usepoint = 0; pay =0;
				
				screenTa.setText("총 금액 : " + screen_total + "원\n\n적립 포인트 : " + savepoint + 
						"점\n사용 포인트 : " + usepoint + "점"+
						"\n\n\n\n\n\n\n\n\n\n\n\n\n\n---------------------------------------\n"+
						"결제 금액 : " + pay + "원");
			}
		});
		
		searchBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new MemberSearch();
			}
		});
		
		moneyBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Money();
			}
		});
		
		cardBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new MoneyCard();
			}
		});
		
		return panel;
	}
	
	public ImageIcon imageSetSize(ImageIcon icon, int i, int j) {
		Image ximg = icon.getImage();
		Image yimg = ximg.getScaledInstance(i, j, java.awt.Image.SCALE_SMOOTH);
		ImageIcon xyimg = new ImageIcon(yimg);
		return xyimg;
	}
	
	class Info{
		public Info() {
			
			coffeeinfo[0] = new MerInfo("아메리카노(hot)",4500);
			coffeeinfo[1] = new MerInfo("아메리카노(ice)",5000);
			coffeeinfo[2] = new MerInfo("카페라떼(hot)",5000);
			coffeeinfo[3] = new MerInfo("카페라떼(ice)",5500);
			coffeeinfo[4] = new MerInfo("카페모카(hot)",5000);
			coffeeinfo[5] = new MerInfo("카페모카(ice)",5500);
			coffeeinfo[6] = new MerInfo("바닐라라떼(hot)",5500);
			coffeeinfo[7] = new MerInfo("바닐라라떼(ice)",6000);
			coffeeinfo[8] = new MerInfo("콜드브루(ice)",6000);
			
			noncfeinfo[0] = new MerInfo("민트티(hot)",4500);
			noncfeinfo[1] = new MerInfo("민트티(ice)",5000);
			noncfeinfo[2] = new MerInfo("얼그레이티(hot)",5000);
			noncfeinfo[3] = new MerInfo("버블티(ice)",5500);
			noncfeinfo[4] = new MerInfo("레몬에이드(ice)",5000);
			noncfeinfo[5] = new MerInfo("탄산수(ice)",5500);
			noncfeinfo[6] = new MerInfo("망고스무디(ice)",5500);
			noncfeinfo[7] = new MerInfo("우유(ice)",6000);
			
			bakeryinfo[0] = new MerInfo("치즈케이크",4500);
			bakeryinfo[1] = new MerInfo("초코케이크",5000);
			bakeryinfo[2] = new MerInfo("샌드위치",5000);
			bakeryinfo[3] = new MerInfo("쿠키",5500);
			bakeryinfo[4] = new MerInfo("도넛",5000);
			bakeryinfo[5] = new MerInfo("머핀",5500);
			bakeryinfo[6] = new MerInfo("아이스크림",5500);
			bakeryinfo[7] = new MerInfo("샐러드",6000);
		}	
	}
	
	
	public static void main(String[] args) {
		new POS();
	}

}
