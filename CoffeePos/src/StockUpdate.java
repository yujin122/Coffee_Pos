import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class StockUpdate {

	public StockUpdate() {
		
		JFrame frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("재고 수정");
		
		JPanel jp = new JPanel();
		jp.setLayout(null);
		
		JLabel label = new JLabel("재고품명 : ");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(85, 83, 94, 18);
		jp.add(label);
		
		JLabel lblNewLabel = new JLabel("수량 : ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(117, 125, 62, 18);
		jp.add(lblNewLabel);
		
		JTextField stockName = new JTextField(10);
		stockName.setBounds(179, 80, 116, 24);
		jp.add(stockName);
		
		JTextField stockCount = new JTextField(10);
		stockCount.setBounds(179, 122, 116, 24);
		jp.add(stockCount);
		
		JButton okBtn = new JButton("확인");
		okBtn.setBounds(75, 176, 76, 27);
		jp.add(okBtn);
		
		JButton cancleBtn = new JButton("취소");
		cancleBtn.setBounds(174, 176, 76, 27);
		jp.add(cancleBtn);
		
		JButton exitBtn = new JButton("닫기");
		exitBtn.setBounds(278, 176, 76, 27);
		jp.add(exitBtn);
		
		JLabel lblNewLabel_1 = new JLabel("재고 수정");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		lblNewLabel_1.setBounds(0, 12, 432, 44);
		jp.add(lblNewLabel_1);
		
		frame.add(jp);
		frame.setVisible(true);
		
		okBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			
				JOptionPane.showMessageDialog(frame, "재고품명 : "+ stockName.getText() + 
						"\n수량 : " + stockCount.getText());
				frame.dispose();
				new StockManage();
			}
		});
		
		cancleBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				stockName.setText(null); stockCount.setText(null);
			}
		});
		
		exitBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new StockManage();

			}
		});
		
	}
	public static void main(String[] args) {
		new StockUpdate();
	}

}
