

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class StockUpdate extends JFrame {

	private ImageIcon icon;
	
	public StockUpdate() {}

	public StockUpdate(String nameData) {

		// 배경화면
		icon = new ImageIcon("image/payment.png");
		icon = imageSetSize(icon, 400, 260);

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

		setSize(415, 300);
		setLocation(width / 2 - this.getWidth() / 2, height / 2 - this.getHeight() / 2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("재고 수정");
		
		
		StockManageDAO dao = new StockManageDAO();
		
		String data[] = new String[2];
		data = dao.stoUpdateForm(nameData);

		JPanel jp = new JPanel();

		JPanel titleJp = new JPanel();
		titleJp.setBorder(BorderFactory.createEmptyBorder(10, 0, 5, 0));
		titleJp.setOpaque(false);
		JLabel titleJl = new JLabel("재고 수정");
		titleJl.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		titleJp.add(titleJl);

		JPanel nameJp1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		nameJp1.setOpaque(false);
		JLabel label = new JLabel("재고품명 : ", JLabel.CENTER);
		nameJp1.add(label);

		JPanel nameJp2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		nameJp2.setOpaque(false);
		JTextField stockName = new JTextField(10);
		stockName.setText(data[0]);
		nameJp2.add(stockName);

		JPanel countJp1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		countJp1.setOpaque(false);
		JLabel countJl = new JLabel("수량 : ", JLabel.CENTER);
		countJp1.add(countJl);

		JPanel countJp2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		countJp2.setOpaque(false);
		JTextField stockCount = new JTextField(10);
		stockCount.setText(data[1]);
		countJp2.add(stockCount);
		
		

		JPanel insertJp = new JPanel(new GridLayout(2, 2, 0, 10));
		insertJp.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 60));
		insertJp.setOpaque(false);
		insertJp.add(nameJp1);
		insertJp.add(nameJp2);
		insertJp.add(countJp1);
		insertJp.add(countJp2);

		JPanel btnJp = new JPanel(new GridLayout(1, 3, 5, 5));
		btnJp.setBorder(BorderFactory.createEmptyBorder(15, 15, 0, 0));
		btnJp.setOpaque(false);

		JButton okBtn = new JButton("확인");
		okBtn.setForeground(Color.WHITE);
		okBtn.setFont(new Font("굴림", Font.BOLD, 12));
		okBtn.setBackground(new Color(230, 160, 0));
		btnJp.add(okBtn);

		JButton cancleBtn = new JButton("취소");
		cancleBtn.setForeground(Color.WHITE);
		cancleBtn.setFont(new Font("굴림", Font.BOLD, 12));
		cancleBtn.setBackground(new Color(230, 160, 0));
		btnJp.add(cancleBtn);

		JButton exitBtn = new JButton("닫기");
		exitBtn.setForeground(Color.WHITE);
		exitBtn.setFont(new Font("굴림", Font.BOLD, 12));
		exitBtn.setBackground(new Color(230, 160, 0));
		btnJp.add(exitBtn);

		JPanel centerJp = new JPanel();
		centerJp.setOpaque(false);
		centerJp.add(insertJp);
		centerJp.add(btnJp);

		background.add(titleJp, BorderLayout.NORTH);
		background.add(centerJp, BorderLayout.CENTER);

		add(background);
		setVisible(true);

		okBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
			String nameData = stockName.getText().toString();
			String countData = stockCount.getText().toString();
			
			int result = dao.stoUpdate(nameData, countData, nameData);
			
			if(result > 0) {
				JOptionPane.showMessageDialog(background, "수정 완료");
			}else {
				JOptionPane.showMessageDialog(background, "수정 실패");
			}
			dispose();
			new StockManage();
			}
		});

		cancleBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			 stockCount.setText(null);
			}
		});
		
		exitBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new StockManage();

			}
		});
		
	}
	
	public ImageIcon imageSetSize(ImageIcon icon, int i, int j) {
		Image ximg = icon.getImage();
		Image yimg = ximg.getScaledInstance(i, j, java.awt.Image.SCALE_SMOOTH);
		ImageIcon xyimg = new ImageIcon(yimg);
		return xyimg;
	}
	
	
	public static void main(String[] args) {
		new StockUpdate();
	}

}
