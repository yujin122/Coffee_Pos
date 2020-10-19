import java.awt.*;
import java.awt.event.*;


import javax.swing.*;


public class POS extends JFrame{

	private int cnt = 0;
	private ImageIcon icon;
	private int num = 0;
	private int screen_total=0, usepoint =0, savepoint=0, pay=0;
	private int index;
	JTable table; JTextArea screenTa;
	
	MerInfo[] merInfo = new MerInfo[25];
	
	String[][] menu = new String[25][4];
	int[][] menuIndex = new int[25][2];
	
	public POS() {
		
		new Info(merInfo);
		
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
		
		ImageIcon[] mImg = {new ImageIcon("image/cficon/1.png"),new ImageIcon("image/cficon/2.png"),new ImageIcon("image/cficon/3.png"),
				new ImageIcon("image/cficon/4.png"),new ImageIcon("image/cficon/5.png"),new ImageIcon("image/cficon/6.png"),
				new ImageIcon("image/cficon/7.png"),new ImageIcon("image/cficon/8.png"),new ImageIcon("image/cficon/9.png"),
				new ImageIcon("image/ncficon/1.png"),new ImageIcon("image/ncficon/2.png"),new ImageIcon("image/ncficon/3.png"),
				new ImageIcon("image/ncficon/4.png"),new ImageIcon("image/ncficon/5.png"),new ImageIcon("image/ncficon/6.png"),
				new ImageIcon("image/ncficon/7.png"),new ImageIcon("image/ncficon/8.png"),new ImageIcon("image/dessert/1.png"),
				new ImageIcon("image/dessert/2.png"),new ImageIcon("image/dessert/3.png"),new ImageIcon("image/dessert/4.png"),
				new ImageIcon("image/dessert/5.png"),new ImageIcon("image/dessert/6.png"),new ImageIcon("image/dessert/7.png"),
				new ImageIcon("image/dessert/8.png")};
	
		for(int i =0;i<mImg.length;i++) {
			mImg[i] = imageSetSize(mImg[i], 210, 160);
		}

		// 메뉴 버튼
		JButton[] mBtn = new JButton[25];
		
		for(int i=0;i<mBtn.length;i++) {
			mBtn[i]= new JButton(Integer.toString(i));
			mBtn[i].setBackground(Color.WHITE);
			mBtn[i].setIcon(mImg[i]);
		}
		
		// 커피
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
		
		menuCoffeeJP.add(mBtn[0]); menuCoffeeJP.add(mBtn[1]);
		menuCoffeeJP.add(mBtn[4]); menuCoffeeJP.add(mBtn[2]); 
		menuCoffeeJP.add(mBtn[3]); menuCoffeeJP.add(mBtn[5]);
		menuCoffeeJP.add(mBtn[6]); menuCoffeeJP.add(mBtn[7]);
		menuCoffeeJP.add(mBtn[8]); menuCoffeeJP.add(countJp);
		
		// 논커피
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
				
		menuNonCoffeeJP.add(mBtn[9]); menuNonCoffeeJP.add(mBtn[10]);
		menuNonCoffeeJP.add(mBtn[11]); menuNonCoffeeJP.add(mBtn[12]); 
		menuNonCoffeeJP.add(mBtn[13]); menuNonCoffeeJP.add(mBtn[14]);
		menuNonCoffeeJP.add(mBtn[15]); menuNonCoffeeJP.add(mBtn[16]);
		menuNonCoffeeJP.add(em); menuNonCoffeeJP.add(noncountJp);
		
		// 베이커리
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
				
		menuBakeryJP.add(mBtn[17]); menuBakeryJP.add(mBtn[18]);
		menuBakeryJP.add(mBtn[19]); menuBakeryJP.add(mBtn[20]); 
		menuBakeryJP.add(mBtn[21]); menuBakeryJP.add(mBtn[22]);
		menuBakeryJP.add(mBtn[23]); menuBakeryJP.add(mBtn[24]);
		menuBakeryJP.add(em2); menuBakeryJP.add(BakeryJp);
		
		JTabbedPane tab = new JTabbedPane();
		tab.setPreferredSize(new Dimension(650, 500));
		tab.setSize(new Dimension(650,500));
		tab.add("Coffee", menuCoffeeJP);
		tab.add("NonCoffee" , menuNonCoffeeJP);
		tab.add("Bakery", menuBakeryJP);
		
		
		for(int i = 0; i<mBtn.length;++i) {
			mBtn[i].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					cnt = 1;
					
					count[0].setText(Integer.toString(cnt));
					count[1].setText(Integer.toString(cnt));
					count[2].setText(Integer.toString(cnt));
					
					JButton jb = (JButton)e.getSource();
					index = Integer.parseInt(jb.getText());
					
					String name = merInfo[index].getName();
					int price = merInfo[index].getPrice();
					int tprice = price * cnt;
					
					int numi = num;
					int check = 0;
					
					table.setRowSelectionAllowed(true);
					
					for(int i =0; i <= numi; i++) {
						if(index+1 == menuIndex[i][0] && menuIndex[i][1] == 1) {
							cnt = Integer.parseInt(menu[i][2]);
							cnt++;
							tprice = price * cnt;
							
							count[0].setText(Integer.toString(cnt));
							count[1].setText(Integer.toString(cnt));
							count[2].setText(Integer.toString(cnt));
		
							menu[i][2] = Integer.toString(cnt);
							menu[i][3] = Integer.toString(tprice);
							
							table.setRowSelectionInterval(i, i);
							
							break;
						}else if(menuIndex[i][1] == 0) {

							menu[num][0] = name;
							menu[num][1] = Integer.toString(price); 
							menu[num][2] = Integer.toString(cnt);
							menu[num][3] = Integer.toString(tprice);
							
							check = 1;
							menuIndex[num][0] = index+1;
							menuIndex[num][1] = check;
							
							table.setRowSelectionInterval(num, num);
							
							num++;
						}
					}
		
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
					
					count[0].setText(Integer.toString(cnt));
					count[1].setText(Integer.toString(cnt));
					count[2].setText(Integer.toString(cnt));
					
					int price;
					int numi = num;
					
					for(int i =0; i <= numi; i++) {
						if(index+1 == menuIndex[i][0] && menuIndex[i][1] == 1) {	// 눌렀던 메뉴
							
							price = Integer.parseInt(menu[i][1]);
							
							menu[i][2] = Integer.toString(cnt);
							menu[i][3] = Integer.toString(price*cnt);
							
						}else if(menuIndex[i][1] == 0) {		// 처음 누른 메뉴

							price = Integer.parseInt(menu[num-1][1]);
							
							menu[num-1][2] = Integer.toString(cnt);
							menu[num-1][3] = Integer.toString(price*cnt);
						}
						
						table.repaint();
						
						screen_total = 0;
						
						for(int j = 0;j<num;j++) {
							screen_total += Integer.parseInt(menu[j][3]);
						}
						
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

		for(int i = 0; i < minus.length; i++) {
			minus[i].addActionListener(new ActionListener() {
		
				@Override
				public void actionPerformed(ActionEvent e) {
					cnt--;

					if (cnt < 0) {
						cnt = 0;

					} else {
						
						int price;
						int numi = num;
						
						for (int i = 0; i <= numi; i++) {
							if (index + 1 == menuIndex[i][0] && menuIndex[i][1] == 1) { // 눌렀던 메뉴
								
								price = Integer.parseInt(menu[i][1]);

								menu[i][2] = Integer.toString(cnt);
								menu[i][3] = Integer.toString(price * cnt);
								
								table.repaint();

								screen_total = 0;

								for (int j = 0; j < num; j++) {
									screen_total += Integer.parseInt(menu[j][3]);
								}

								pay = screen_total - usepoint;
								savepoint = (int) (pay * 0.01f);

								screenTa.setText("총 금액 : " + String.format("%,d", screen_total) + "원\n\n적립 포인트 : "
										+ savepoint + "점\n사용 포인트 : " + usepoint + "점"
										+ "\n\n\n\n\n\n\n\n\n\n\n\n\n\n---------------------------------------\n"
										+ "결제 금액 : " + String.format("%,d", pay) + "원");
								
								if (cnt == 0) {
									num--;
									
									for(int j = i; j < num; j++) {
										menu[j][0] = menu[j+1][0];
										menu[j][1] = menu[j+1][1];
										menu[j][2] = menu[j+1][2];
										menu[j][3] = menu[j+1][3];
										
										menuIndex[j][0] = menuIndex[j+1][0];
										menuIndex[j][1] = 1;
									}
									
									menu[num][0] = "";
									menu[num][1] = "";
									menu[num][2] = "";
									menu[num][3] = "";
									
									menuIndex[num][0] = 0;
									menuIndex[num][1] = 0;
									
									table.repaint();
									
									screen_total =0;
									for (int j = 0; j < num; j++) {
										screen_total += Integer.parseInt(menu[j][3]);
									}

									pay = screen_total-usepoint;
									savepoint = (int)(pay * 0.01f);
									
									screenTa.setText("총 금액 : " + String.format("%,d", screen_total) + "원\n\n적립 포인트 : " + savepoint + 
											"점\n사용 포인트 : " + usepoint + "점"+
											"\n\n\n\n\n\n\n\n\n\n\n\n\n\n---------------------------------------\n"+
											"결제 금액 : " + String.format("%,d", pay) + "원");
								}
								
								count[0].setText(Integer.toString(cnt));
								count[1].setText(Integer.toString(cnt));
								count[2].setText(Integer.toString(cnt));
								
								break;

							} else if (menuIndex[i][1] == 0) { // 처음 누른 메뉴

								price = Integer.parseInt(menu[num - 1][1]);

								menu[num - 1][2] = Integer.toString(cnt);
								menu[num - 1][3] = Integer.toString(price * cnt);
								table.repaint();

								screen_total = 0;

								for (int j = 0; j < num; j++) {
									screen_total += Integer.parseInt(menu[j][3]);
								}

								pay = screen_total - usepoint;
								savepoint = (int) (pay * 0.01f);

								screenTa.setText("총 금액 : " + String.format("%,d", screen_total) + "원\n\n적립 포인트 : "
										+ savepoint + "점\n사용 포인트 : " + usepoint + "점"
										+ "\n\n\n\n\n\n\n\n\n\n\n\n\n\n---------------------------------------\n"
										+ "결제 금액 : " + String.format("%,d", pay) + "원");
							}
							
							count[0].setText(Integer.toString(cnt));
							count[1].setText(Integer.toString(cnt));
							count[2].setText(Integer.toString(cnt));
						}
					}

				}
			});
		}

		return tab;
	}

	// 스크린
	public JTextArea screen() {

		for (int i = 0; i < num; i++) {
			screen_total += Integer.parseInt(menu[i][3]);
		}

		pay = screen_total - usepoint;

		JTextArea ta = new JTextArea(20, 15);
		ta.setText("총 금액 : " + screen_total + "원\n\n적립 포인트 : " + savepoint + "점\n사용 포인트 : " + usepoint + "점"
				+ "\n\n\n\n\n\n\n\n\n\n\n\n\n\n---------------------------------------\n" + "결제 금액 : " + pay + "원");
		ta.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 10));
		ta.setFocusable(false);
		ta.setPreferredSize(new Dimension(50, 375));
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
		
		JButton clearBtn = new JButton("초기화");
		clearBtn.setPreferredSize(new Dimension(80,100));
		clearBtn.setPreferredSize(new Dimension(80,100));
		clearBtn.setBackground(new Color(230,160,0));	
		clearBtn.setForeground(Color.WHITE); 
	
		JButton searchBtn = new JButton("회원 찾기");
		searchBtn.setBackground(new Color(230,160,0));
		searchBtn.setForeground(Color.WHITE); 
		JButton moneyBtn = new JButton("현금 결제");
		moneyBtn.setBackground(new Color(230,160,0));
		moneyBtn.setForeground(Color.WHITE); 
		
		JButton cardBtn = new JButton("카드 결제");
		cardBtn.setBackground(new Color(230,160,0));
		cardBtn.setForeground(Color.WHITE); 
		
		panel.add(clearBtn); panel.add(searchBtn); panel.add(moneyBtn); panel.add(cardBtn);
		
		clearBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				for(int i = 0;i<num;i++) {
					menu[i][0] = null;
					menu[i][1] = null; 
					menu[i][2] = null;
					menu[i][3] = null;
					
					menuIndex[i][0] = 0;
					menuIndex[i][1] = 0;
				}
				
				table.setRowSelectionAllowed(false);
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

	public static void main(String[] args) {
		new POS();
	}

}
