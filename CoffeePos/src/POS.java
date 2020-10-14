
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

public class POS {

	private int cnt = 0;
	
	
	public POS() {
		
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
		JButton[] CoffeeMBtn = new JButton[9];
		
		CoffeeMBtn[0] = new JButton("HOT 아메리카노");
		CoffeeMBtn[1] = new JButton("ICE 아메리카노");
		CoffeeMBtn[2] = new JButton("HOT 카페라떼");
		CoffeeMBtn[3] = new JButton("ICE 카페라떼");
		CoffeeMBtn[4] = new JButton("HOT 카페모카");
		CoffeeMBtn[5] = new JButton("ICE 카페모카");
		CoffeeMBtn[6] = new JButton("HOT 바닐라라떼");
		CoffeeMBtn[7] = new JButton("ICE 바닐라라떼");
		CoffeeMBtn[8] = new JButton("ICE 콜드브루");
		
		for(int i=0;i<9;i++) {
			CoffeeMBtn[i].setFont(new Font(null, Font.BOLD, 20));
			CoffeeMBtn[i].setHorizontalTextPosition(SwingConstants.CENTER);
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
		//JLabel coffeeCount = new JLabel("수량");
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
		
		NonCoffeeMBtn[0] = new JButton("HOT 민트티");
		NonCoffeeMBtn[1] = new JButton("HOT 레몬티");
		NonCoffeeMBtn[2] = new JButton("HOT 블랙티");
		NonCoffeeMBtn[3] = new JButton("HOT 얼그레이");
		NonCoffeeMBtn[4] = new JButton("HOT 그린티");
		NonCoffeeMBtn[5] = new JButton("ICE 망고스무디");
		NonCoffeeMBtn[6] = new JButton("ICE 자몽에이드");
		NonCoffeeMBtn[7] = new JButton("ICE 오렌지에이드");
		
		for(int i=0;i<8;i++) {
			NonCoffeeMBtn[i].setFont(new Font(null, Font.BOLD, 20));
			NonCoffeeMBtn[i].setHorizontalTextPosition(SwingConstants.CENTER);
		}
				
		JPanel noncoffeePlusJp = new JPanel();
		plus[1] = new JButton(">");
		noncoffeePlusJp.add(plus[1]);
		noncoffeePlusJp.setBorder(BorderFactory.createEmptyBorder(53,30,30,30));
		JPanel noncoffeeMinusJp = new JPanel();
		minus[1] = new JButton("<");
		noncoffeeMinusJp.add(minus[1]);
		noncoffeeMinusJp.setBorder(BorderFactory.createEmptyBorder(53,30,30,30));
		//JLabel noncoffeeCount = new JLabel("수량");
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
		
		bakeryMBtn[0] = new JButton("블루베리 베이글");
		bakeryMBtn[1] = new JButton("플레인 베이글");
		bakeryMBtn[2] = new JButton("샌드위치");
		bakeryMBtn[3] = new JButton("티라미슈");
		bakeryMBtn[4] = new JButton("레드벨벳 케익");
		bakeryMBtn[5] = new JButton("치즈 케익");
		bakeryMBtn[6] = new JButton("스콘");
		bakeryMBtn[7] = new JButton("샐러드");
		
		for(int i=0;i<8;i++) {
			bakeryMBtn[i].setFont(new Font(null, Font.BOLD, 20));
			bakeryMBtn[i].setHorizontalTextPosition(SwingConstants.CENTER);
		}
		
		JPanel BakeryPlusJp = new JPanel();
		plus[2] = new JButton(">");
		BakeryPlusJp.add(plus[2]);
		BakeryPlusJp.setBorder(BorderFactory.createEmptyBorder(53,30,30,30));
		JPanel BakeryMinusJp = new JPanel();
		minus[2] = new JButton("<");
		BakeryMinusJp.add(minus[2]);
		BakeryMinusJp.setBorder(BorderFactory.createEmptyBorder(53,30,30,30));
		//JLabel BakeryCount = new JLabel("수량");
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
		
		tab.add("Coffee", menuCoffeeJP);
		tab.add("NonCoffee" , menuNonCoffeeJP);
		tab.add("Bakery", menuBakeryJP);
		
		
		for(int i = 0; i<9;i++) {
			CoffeeMBtn[i].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					cnt = 0;
					count[0].setText(Integer.toString(cnt));
					count[1].setText(Integer.toString(cnt));
					count[2].setText(Integer.toString(cnt));
				}
			});
		}
		
		for(int i = 0; i<8;i++) {
			bakeryMBtn[i].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					cnt = 0;
					count[0].setText(Integer.toString(cnt));
					count[1].setText(Integer.toString(cnt));
					count[2].setText(Integer.toString(cnt));
				}
			});
		}
		
		for(int i = 0; i<8;i++) {
			NonCoffeeMBtn[i].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					cnt = 0;
					count[0].setText(Integer.toString(cnt));
					count[1].setText(Integer.toString(cnt));
					count[2].setText(Integer.toString(cnt));
				}
			});
		}
		
		plus[0].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cnt++;
				if(cnt < 1) {
					cnt = 0;
				}
				count[0].setText(Integer.toString(cnt));
			}
		});

		plus[1].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cnt++;
				if(cnt < 1) {
					cnt = 0;
				}
				count[1].setText(Integer.toString(cnt));
			}
		});

		plus[2].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cnt++;
				if(cnt < 1) {
					cnt = 0;
				}
				count[2].setText(Integer.toString(cnt));
			}
		});
		
		minus[0].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cnt--;
				if(cnt < 1) {
					cnt = 0;
				}
				count[0].setText(Integer.toString(cnt));
			}
		});

		minus[1].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cnt--;
				if(cnt < 1) {
					cnt = 0;
				}
				count[1].setText(Integer.toString(cnt));
			}
		});

		minus[2].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cnt--;
				if(cnt < 1) {
					cnt = 0;
				}
				count[2].setText(Integer.toString(cnt));
			}
		});
		
		tab.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				cnt = 0;
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {}
		});
		
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
		
		for(int i = 0;i<10;i++) {
			
			btn[i].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					JButton jb = (JButton)e.getSource();
					ta.setText(ta.getText() + jb.getText());
					System.out.println(jb);
					
				}
			});
		}
		
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
	
	public static void main(String[] args) {
		new POS();
	}

}
