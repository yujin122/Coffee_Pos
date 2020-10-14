import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
  
public class Menu {

	public Menu() {
		
		JFrame frame = new JFrame();
		frame.setBounds(100, 100, 890, 680);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel jp = new JPanel(new GridLayout(1,2));
		JPanel menuJp = new JPanel(new GridLayout(4,1,30,30));
		menuJp.setBorder(BorderFactory.createEmptyBorder(80, 50, 80, 50));
		
		JButton memBtn = new JButton("회원 관리");
		menuJp.add(memBtn);
		
		JButton stockBtn = new JButton("재고 관리");
		menuJp.add(stockBtn);
		
		JButton salesBtn = new JButton("매출 관리");
		menuJp.add(salesBtn);
		
		JButton posBtn = new JButton("POS");
		menuJp.add(posBtn);
		
		
		JLabel name = new JLabel("카페이름");
		name.setHorizontalAlignment(SwingConstants.CENTER);
		name.setFont(new Font("함초롬바탕", Font.BOLD, 35));
		
		jp.add(name);
		jp.add(menuJp);
		
		frame.add(jp);
		frame.setVisible(true);
		
		memBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new MemberManage();
				frame.dispose();
			}
		});
		
		stockBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new StockManage();
				frame.dispose();
			}
		});

		salesBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new SalesManage();
				frame.dispose();
			}
		});

		posBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new POS();
				new Card();
				frame.dispose();
			}
		});
	}

	public static void main(String[] args) {
		new Menu();
	}

}
