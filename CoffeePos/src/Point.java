
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Point extends JFrame {

	private ImageIcon icon;
	CoffeePosDAO dao = new CoffeePosDAO();
	public Point() {}
	
	public Point(String phone) {

		super("포인트 조회");
		
		String[] mem = dao.memSearch(phone);

		icon = new ImageIcon("image/posback.png");
		icon = imageSetSize(icon, 300, 150);

		JPanel background = new JPanel(new BorderLayout()) {
			public void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(), 0, 0, null);
			}
		};

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int height = screenSize.height;
		int width = screenSize.width;

		setSize(300, 180);
		setResizable(false);
		setLocation(width/2-this.getWidth()/2, height/2-this.getHeight()/2);
		
		JPanel jp1 = new JPanel();
		jp1.setBorder(BorderFactory.createEmptyBorder(20,0,10,0));
		jp1.setOpaque(false);
		
		JLabel searchLable = new JLabel(mem[0] + "님의 적립금은", JLabel.CENTER);
		JLabel searchLable2 = new JLabel(mem[1] + "점입니다.", JLabel.CENTER);
		jp1.add(searchLable);
		jp1.add(searchLable2);

		JPanel jp2 = new JPanel();
		jp2.setOpaque(false);
		
		JLabel usingpoint = new JLabel("사용 포인트 : ");
		JTextField useingText = new JTextField(8);
		useingText.setText("0");
		jp2.add(usingpoint);
		jp2.add(useingText);

		JPanel jp3 = new JPanel();
		jp3.setOpaque(false);
		
		JButton useButton = new JButton("사용");
		useButton.setBackground(new Color(230, 160, 0));
		useButton.setForeground(Color.WHITE);
		
		JButton cancelButton = new JButton("닫기");
		cancelButton.setBackground(new Color(230, 160, 0));
		cancelButton.setForeground(Color.WHITE);
		
		jp3.add(useButton);
		jp3.add(cancelButton);

		background.add(jp1, BorderLayout.NORTH);
		background.add(jp2, BorderLayout.CENTER);
		background.add(jp3, BorderLayout.SOUTH);

		
		add(background);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setVisible(true);

		// 이벤트 처리
		// cancelbButton 이벤트 처리
		cancelButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();

			}
		});
		
		useButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				POS.usep = Integer.parseInt(useingText.getText());
				
				if(POS.usep > Integer.parseInt(mem[1])) {
					JOptionPane.showMessageDialog(background, "현재 포인트를 초과하여 입력하였습니다.");
				}else {
					
					int totPoint = Integer.parseInt(mem[1]) - POS.usep + POS.savep;

					int result = dao.pointUpdate(totPoint, phone);
					
					if(result > 0) {
						JOptionPane.showMessageDialog(background, "포인트 저장 성공");
						dispose();
					}else {
						JOptionPane.showMessageDialog(background, "포인트 저장 실패");
					}
					//dispose();
				}
				
			}
		});

	}
	
	public ImageIcon imageSetSize(ImageIcon icon, int i, int j) {
		Image ximg = icon.getImage();
		Image yimg = ximg.getScaledInstance(i, j, java.awt.Image.SCALE_SMOOTH);
		ImageIcon xyimg = new ImageIcon(yimg);
		return xyimg;
	}
	
}
