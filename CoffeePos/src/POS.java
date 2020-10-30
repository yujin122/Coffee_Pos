import java.awt.*;
import java.awt.event.*;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class POS extends JFrame {

	int[][] menuIndex = new int[25][2];
	
	JTable table;
	JTextField totJt = new JTextField(15);
	JTextField pointJt = new JTextField(15);
	JTextField inputJt = new JTextField(15);
	
	DefaultTableModel dTable;
	
	CoffeePosDAO dao = new CoffeePosDAO();
	
	private ImageIcon icon;
	
	private int cnt = 0;
	private int num = 0;
	private int screen_total = 0, savepoint = 0;
	private int index;

	static int savep = 0, usep = 0;
	static int preNum = 0;
	
	public POS() {

		//new Info(merInfo);

		icon = new ImageIcon("image/posback.png");
		icon = imageSetSize(icon, 1567, 890);

		JPanel background = new JPanel(new BorderLayout()) {
			public void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(), 0, 0, null);
			}
		};

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int height = screenSize.height;
		int width = screenSize.width;
		
		setPreferredSize(new Dimension(1450, 910));
		setSize(new Dimension(1450, 890));		
		setResizable(false);
		setLocation(width/2-this.getWidth()/2, height/2-this.getHeight()/2);
		
		setTitle("POS");

		JPanel paymentJp = new JPanel(); // 결제창
		paymentJp.setOpaque(false);
		paymentJp.setSize(5, 50);

		JPanel calculatorJP = new Calculator(); // 계산기
		calculatorJP.setOpaque(false);

		JPanel screenJp = new JPanel(); // 스크린
		screenJp.setOpaque(false);

		JPanel buttonJp = new JPanel(); // 버튼
		buttonJp.setOpaque(false);

		// 메뉴창
		JTabbedPane tab = menuButton();
		tab.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

		// 스크린
		screenJp = screen();

		screenJp.setBorder(BorderFactory.createEmptyBorder(20, 0, 40, 10));
		screenJp.setPreferredSize(new Dimension(200, 180));
		screenJp.setSize(new Dimension(200, 180));

		// 결제창
		table = payment();

		JScrollPane jsp = new JScrollPane(table);

		table.setFillsViewportHeight(true);
		paymentJp.setLayout(new BorderLayout());
		paymentJp.add(jsp, BorderLayout.CENTER);
		paymentJp.setBorder(BorderFactory.createEmptyBorder(40, 20, 0, 20));

		// 버튼창
		buttonJp = btn();

		// 계산기, 스크린
		JPanel jp2 = new JPanel(new BorderLayout());
		jp2.setOpaque(false);
		jp2.add(calculatorJP, BorderLayout.CENTER);
		jp2.add(screenJp, BorderLayout.EAST);

		// 결제창 계산기 스크린
		JPanel jp3 = new JPanel(new GridLayout(2, 1, 2, 2));

		jp3.setOpaque(false);
		jp3.add(paymentJp);
		jp3.add(jp2);

		JPanel jp4 = new JPanel(new BorderLayout());
		jp4.setOpaque(false);
		jp4.add(tab, BorderLayout.CENTER);
		jp4.add(buttonJp, BorderLayout.SOUTH);
		jp4.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));

		// 결제창 계산기 스크린 메뉴창
		JPanel jp5 = new JPanel(new GridLayout(1, 2, 2, 2));
		jp5.setOpaque(false);

		background.add(jp3, BorderLayout.CENTER);
		background.add(jp4, BorderLayout.EAST);

		add(background);
		pack();
		setVisible(true);

		addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				new Menu();
			}

		});
	}

	// 메뉴창
	public JTabbedPane menuButton() {

		JPanel menuCoffeeJP = new JPanel(new GridLayout(4, 3, 5, 5)); // 메뉴 - 커피
		JPanel menuNonCoffeeJP = new JPanel(new GridLayout(4, 3, 5, 5)); // 메뉴 - 논커피
		JPanel menuBakeryJP = new JPanel(new GridLayout(4, 3, 5, 5)); // 메뉴 - 베이커리

		ImageIcon[] mImg = { new ImageIcon("image/cficon/1.png"), new ImageIcon("image/cficon/2.png"),
				new ImageIcon("image/cficon/3.png"), new ImageIcon("image/cficon/4.png"),
				new ImageIcon("image/cficon/5.png"), new ImageIcon("image/cficon/6.png"),
				new ImageIcon("image/cficon/7.png"), new ImageIcon("image/cficon/8.png"),
				new ImageIcon("image/cficon/9.png"), new ImageIcon("image/ncficon/1.png"),
				new ImageIcon("image/ncficon/2.png"), new ImageIcon("image/ncficon/3.png"),
				new ImageIcon("image/ncficon/4.png"), new ImageIcon("image/ncficon/5.png"),
				new ImageIcon("image/ncficon/6.png"), new ImageIcon("image/ncficon/7.png"),
				new ImageIcon("image/ncficon/8.png"), new ImageIcon("image/dessert/1.png"),
				new ImageIcon("image/dessert/2.png"), new ImageIcon("image/dessert/3.png"),
				new ImageIcon("image/dessert/4.png"), new ImageIcon("image/dessert/5.png"),
				new ImageIcon("image/dessert/6.png"), new ImageIcon("image/dessert/7.png"),
				new ImageIcon("image/dessert/8.png") };

		for (int i = 0; i < mImg.length; i++) {
			mImg[i] = imageSetSize(mImg[i], 210, 160);
		}

		// 메뉴 버튼
		JButton[] mBtn = new JButton[25];

		for (int i = 0; i < mBtn.length; i++) {
			mBtn[i] = new JButton(Integer.toString(i));
			mBtn[i].setBackground(Color.WHITE);
			mBtn[i].setIcon(mImg[i]);
		}

		// 커피
		JPanel coffeePlusJp = new JPanel();
		JButton[] plus = new JButton[3];
		plus[0] = new JButton(">");
		coffeePlusJp.add(plus[0]);
		coffeePlusJp.setBorder(BorderFactory.createEmptyBorder(53, 30, 30, 30));
		JPanel coffeeMinusJp = new JPanel();
		JButton[] minus = new JButton[3];
		minus[0] = new JButton("<");
		coffeeMinusJp.add(minus[0]);
		coffeeMinusJp.setBorder(BorderFactory.createEmptyBorder(53, 30, 30, 30));
		JLabel[] count = new JLabel[3];
		count[0] = new JLabel("수량");
		count[0].setHorizontalAlignment(0);

		JPanel countJp = new JPanel(new GridLayout(1, 3));
		countJp.add(coffeeMinusJp);
		countJp.add(count[0]);
		countJp.add(coffeePlusJp);

		menuCoffeeJP.add(mBtn[0]); menuCoffeeJP.add(mBtn[1]); menuCoffeeJP.add(mBtn[4]);
		menuCoffeeJP.add(mBtn[2]); menuCoffeeJP.add(mBtn[3]); menuCoffeeJP.add(mBtn[5]);
		menuCoffeeJP.add(mBtn[6]); menuCoffeeJP.add(mBtn[7]); menuCoffeeJP.add(mBtn[8]);
		menuCoffeeJP.add(countJp);

		// 논커피
		JPanel noncoffeePlusJp = new JPanel();
		plus[1] = new JButton(">");
		noncoffeePlusJp.add(plus[1]);
		noncoffeePlusJp.setBorder(BorderFactory.createEmptyBorder(53, 30, 30, 30));
		JPanel noncoffeeMinusJp = new JPanel();
		minus[1] = new JButton("<");
		noncoffeeMinusJp.add(minus[1]);
		noncoffeeMinusJp.setBorder(BorderFactory.createEmptyBorder(53, 30, 30, 30));
		count[1] = new JLabel("수량");
		count[1].setHorizontalAlignment(0);

		JLabel em = new JLabel(" ");

		JPanel noncountJp = new JPanel(new GridLayout(1, 3));
		noncountJp.add(noncoffeeMinusJp);
		noncountJp.add(count[1]);
		noncountJp.add(noncoffeePlusJp);

		menuNonCoffeeJP.add(mBtn[9]); menuNonCoffeeJP.add(mBtn[10]); menuNonCoffeeJP.add(mBtn[11]);
		menuNonCoffeeJP.add(mBtn[12]); menuNonCoffeeJP.add(mBtn[13]); menuNonCoffeeJP.add(mBtn[14]);
		menuNonCoffeeJP.add(mBtn[15]); menuNonCoffeeJP.add(mBtn[16]); menuNonCoffeeJP.add(em);
		menuNonCoffeeJP.add(noncountJp);

		// 베이커리
		JPanel BakeryPlusJp = new JPanel();
		plus[2] = new JButton(">");
		BakeryPlusJp.add(plus[2]);
		BakeryPlusJp.setBorder(BorderFactory.createEmptyBorder(53, 30, 30, 30));
		JPanel BakeryMinusJp = new JPanel();
		minus[2] = new JButton("<");
		BakeryMinusJp.add(minus[2]);
		BakeryMinusJp.setBorder(BorderFactory.createEmptyBorder(53, 30, 30, 30));
		count[2] = new JLabel("수량");
		count[2].setHorizontalAlignment(0);

		JLabel em2 = new JLabel(" ");

		JPanel BakeryJp = new JPanel(new GridLayout(1, 3));
		BakeryJp.add(BakeryMinusJp);
		BakeryJp.add(count[2]);
		BakeryJp.add(BakeryPlusJp);

		menuBakeryJP.add(mBtn[17]); menuBakeryJP.add(mBtn[18]); menuBakeryJP.add(mBtn[19]);
		menuBakeryJP.add(mBtn[20]); menuBakeryJP.add(mBtn[21]); menuBakeryJP.add(mBtn[22]);
		menuBakeryJP.add(mBtn[23]); menuBakeryJP.add(mBtn[24]); menuBakeryJP.add(em2);
		menuBakeryJP.add(BakeryJp);

		JTabbedPane tab = new JTabbedPane();
		tab.setPreferredSize(new Dimension(650, 500));
		tab.setSize(new Dimension(650, 500));
		tab.add("Coffee", menuCoffeeJP);
		tab.add("NonCoffee", menuNonCoffeeJP);
		tab.add("Bakery", menuBakeryJP);

		// 메뉴 선택
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
					
					String[] item = dao.menuInfo(index);
					
					String name = item[0];
					int price = Integer.parseInt(item[1]);
					int tprice = price * cnt;
					
					int numi = num;
					int check = 0;
					
					table.setRowSelectionAllowed(true);
					
					for(int i =0; i <= numi; i++) {
						if(index+1 == menuIndex[i][0] && menuIndex[i][1] == 1) {
							cnt = Integer.parseInt(dTable.getValueAt(i, 2).toString());
							cnt++;
							tprice = price * cnt;
							
							count[0].setText(Integer.toString(cnt));
							count[1].setText(Integer.toString(cnt));
							count[2].setText(Integer.toString(cnt));
		
							Object menu_[]= {name, price, cnt, tprice};
							dTable.removeRow(i);
							dTable.insertRow(i, menu_);
							
							break;
						}else if(menuIndex[i][1] == 0) {

							Object menu_[]= {name, price, cnt, tprice};
							
							dTable.addRow(menu_);
							
							check = 1;
							menuIndex[num][0] = index+1;
							menuIndex[num][1] = check;
							
							num++;
						}
					}
					
					screen_total=0;
					
					for(int i = 0;i<num;i++) {
						screen_total += Integer.parseInt(dTable.getValueAt(i, 3).toString());
					}

					savepoint = (int)(screen_total * 0.01f);
					
					totJt.setText(String.valueOf(screen_total));
					pointJt.setText(String.valueOf(savepoint));
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
					
					String name;
					int price, tprice;
					int numi = num;
					
					for(int i =0; i <= numi; i++) {
						if(index+1 == menuIndex[i][0] && menuIndex[i][1] == 1) {	// 눌렀던 메뉴
							
							name = dTable.getValueAt(i, 0).toString();
							price = Integer.parseInt(dTable.getValueAt(i, 1).toString());
							tprice = price * cnt;
							
							Object menu_[]= {name, price, cnt, tprice};
							dTable.removeRow(i);
							dTable.insertRow(i, menu_);
							
							screen_total = 0;
							
							for(int j = 0;j<num;j++) {
								screen_total += Integer.parseInt(dTable.getValueAt(j, 3).toString());
							}

							savepoint = (int)(screen_total * 0.01f);
							
							totJt.setText(String.valueOf(screen_total));
							pointJt.setText(String.valueOf(savepoint));
							
							break;
							
						}else if(menuIndex[i][1] == 0) {		// 처음 누른 메뉴
							
							try {
								name = dTable.getValueAt(num-1, 0).toString();
								price = Integer.parseInt(dTable.getValueAt(num-1, 1).toString());
								tprice = price * cnt;

								Object menu_[]= {name, price, cnt, tprice};
								dTable.removeRow(num-1);
								dTable.insertRow(num-1, menu_);
							}catch(ArrayIndexOutOfBoundsException ex) {
								
							}
						}
						
						screen_total = 0;
						
						for(int j = 0;j<num;j++) {
							screen_total += Integer.parseInt(dTable.getValueAt(j, 3).toString());
						}

						savepoint = (int)(screen_total * 0.01f);
						
						totJt.setText(String.valueOf(screen_total));
						pointJt.setText(String.valueOf(savepoint));
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
						
						String name;
						int price,tprice;
						int numi = num;
						
						for (int i = 0; i <= numi; i++) {
							if (index + 1 == menuIndex[i][0] && menuIndex[i][1] == 1) { // 눌렀던 메뉴
								
								name = dTable.getValueAt(i, 0).toString();
								price = Integer.parseInt(dTable.getValueAt(i, 1).toString());
								tprice = price * cnt;

								Object menu_[]= {name, price, cnt, tprice};
								dTable.removeRow(i);
								dTable.insertRow(i, menu_);
								
								screen_total = 0;

								for (int j = 0; j < num; j++) {
									screen_total += Integer.parseInt(dTable.getValueAt(j, 3).toString());
								}

								savepoint = (int) (screen_total * 0.01f);

								totJt.setText(String.valueOf(screen_total));
								pointJt.setText(String.valueOf(savepoint));
								
								if (cnt == 0) {
									num--;
									
									for(int j = i; j < num; j++) {
										menuIndex[j][0] = menuIndex[j+1][0];
										menuIndex[j][1] = 1;
									}
							
									menuIndex[num][0] = 0;
									menuIndex[num][1] = 0;
									dTable.removeRow(i);
									
									screen_total =0;
									for (int j = 0; j < num; j++) {
										screen_total += Integer.parseInt(dTable.getValueAt(j, 3).toString());
									}

									savepoint = (int)(screen_total * 0.01f);
									
									totJt.setText(String.valueOf(screen_total));
									pointJt.setText(String.valueOf(savepoint));
									}
								
								count[0].setText(Integer.toString(cnt));
								count[1].setText(Integer.toString(cnt));
								count[2].setText(Integer.toString(cnt));
								
								break;

							} else if (menuIndex[i][1] == 0) { // 처음 누른 메뉴

								try {
									name = dTable.getValueAt(i, 0).toString();
									price = Integer.parseInt(dTable.getValueAt(num - 1, 1).toString());
									tprice = price * cnt;

									Object menu_[] = { name, price, cnt, tprice };
									dTable.removeRow(num - 1);
									dTable.insertRow(num - 1, menu_);

									screen_total = 0;

									for (int j = 0; j < num; j++) {
										screen_total += Integer.parseInt(dTable.getValueAt(j, 3).toString());
									}

									savepoint = (int) (screen_total * 0.01f);

									totJt.setText(String.valueOf(screen_total));
									pointJt.setText(String.valueOf(savepoint));
								} catch (ArrayIndexOutOfBoundsException ee) {

								}
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
	public JPanel screen() {

		for (int i = 0; i < num; i++) {
			screen_total += Integer.parseInt(dTable.getValueAt(i, 3).toString());
		}

		JPanel jp1 = new JPanel(new GridLayout(6,1));
		jp1.setOpaque(false);
		JLabel totJl = new JLabel("총 금 액");

		totJt.setText(String.valueOf(screen_total));
		totJt.setFocusable(false);
		
		JLabel pointJl = new JLabel("적 립 포 인 트");
		
		pointJt.setText(String.valueOf(savepoint));
		pointJt.setFocusable(false);
		
		JLabel inputJl = new JLabel("받 은 금 액");
		
		jp1.add(totJl); jp1.add(totJt);
		jp1.add(pointJl); jp1.add(pointJt);
		jp1.add(inputJl); jp1.add(inputJt);
		
		JPanel alljp = new JPanel(new GridLayout(2,1));
		alljp.setOpaque(false);	
		 
		ImageIcon icons = new ImageIcon("image/logo.png");
		icons = imageSetSize(icons, 150, 150);
		
		JLabel img = new JLabel();
		img.setVerticalAlignment(JLabel.CENTER);
		img.setHorizontalAlignment(JLabel.CENTER);
		img.setIcon(icons);
		
		alljp.add(img); alljp.add(jp1);
		
		return alljp;
	}

	// 결제창
	public JTable payment() {
		dTable = new DefaultTableModel();
		
		dTable.addColumn("메뉴"); dTable.addColumn("단가");
		dTable.addColumn("수량"); dTable.addColumn("가격");
		
		
		JTable jt = new JTable(dTable);

		jt.setRowHeight(30);

		return jt;
	}

	// 버튼
	public JPanel btn() {

		JPanel panel = new JPanel(new GridLayout(1, 4, 5, 5));
		panel.setOpaque(false);
		panel.setBorder(BorderFactory.createEmptyBorder(0, 15, 10, 15));

		JButton clearBtn = new JButton("초기화");
		clearBtn.setPreferredSize(new Dimension(80, 100));
		clearBtn.setPreferredSize(new Dimension(80, 100));
		clearBtn.setBackground(new Color(230, 160, 0));
		clearBtn.setForeground(Color.WHITE);

		JButton searchBtn = new JButton("회원 찾기");
		searchBtn.setBackground(new Color(230,160,0));
		searchBtn.setForeground(Color.WHITE); 
		
		JButton moneyBtn = new JButton("현금 결제");
		moneyBtn.setBackground(new Color(230, 160, 0));
		moneyBtn.setForeground(Color.WHITE);

		JButton cardBtn = new JButton("카드 결제");
		cardBtn.setBackground(new Color(230, 160, 0));
		cardBtn.setForeground(Color.WHITE);

		panel.add(clearBtn); panel.add(searchBtn);
		panel.add(moneyBtn); panel.add(cardBtn);

		clearBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				listClear();
			}
		});

		searchBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				savep = savepoint;
				new SelectMem();
			}
		});
		
		moneyBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				int pay = Integer.parseInt(inputJt.getText());
				
				if(pay == 0) {
					JOptionPane.showMessageDialog(panel, "받은 금액을 입력하세요.");
				}else {
					// cafeorder에 있는 데이터 수
					int listCount = dao.listCount();
					preNum = listCount;
					
					// 현재 테이블 행 수
					int no = dTable.getRowCount();
					
					int list[][] = new int[no][3];
					
					for(int i = 0; i < no; i++) {
						list[i][0] = menuIndex[i][0]-1;		// 메뉴 번호
						list[i][1] = Integer.parseInt(dTable.getValueAt(i, 2).toString());	// 수량
						list[i][2] = Integer.parseInt(dTable.getValueAt(i, 3).toString());	// 가격
					}
					
					int result = dao.addList(list);
					
					if(result < 0) {
						JOptionPane.showMessageDialog(panel, "주문 목록 추가 실패");
					}else {
						JOptionPane.showMessageDialog(panel, "주문 목록 추가 성공");
						listClear();
						new Money(pay);
					}
				}
			}
		});

		cardBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				// cafeorder에 있는 데이터 수
				int listCount = dao.listCount();
				preNum = listCount;
				
				// 현재 테이블 행 수
				int no = dTable.getRowCount();
				
				int list[][] = new int[no][3];
				
				for(int i = 0; i < no; i++) {
					list[i][0] = menuIndex[i][0]-1;		// 메뉴 번호
					list[i][1] = Integer.parseInt(dTable.getValueAt(i, 2).toString());	// 수량
					list[i][2] = Integer.parseInt(dTable.getValueAt(i, 3).toString());	// 가격
				}
				
				int result = dao.addList(list);
				
				if(result < 0) {
					JOptionPane.showMessageDialog(panel, "주문 목록 추가 실패");
				}else {
					JOptionPane.showMessageDialog(panel, "주문 목록 추가 성공");
					listClear();
					new MoneyCard();
				}
			}
		});

		return panel;
	}
	
	// 주문목록 초기화
	public void listClear() {
		
		int count = dTable.getRowCount();
		
		for(int i = 0; i < count;i++) {
			dTable.removeRow(0);
			
			menuIndex[i][0] = 0;
			menuIndex[i][1] = 0;
		}
		
		table.setRowSelectionAllowed(false);
		
		num = 0;

		screen_total = 0;
		savepoint = 0;

		totJt.setText(String.valueOf(screen_total));
		pointJt.setText(String.valueOf(savepoint));
		inputJt.setText(String.valueOf(0));
	}

	public ImageIcon imageSetSize(ImageIcon icon, int i, int j) {
		Image ximg = icon.getImage();
		Image yimg = ximg.getScaledInstance(i, j, java.awt.Image.SCALE_SMOOTH);
		ImageIcon xyimg = new ImageIcon(yimg);
		return xyimg;
	}
}
