import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// 포인트 조회
public class Point extends JFrame {

	private ImageIcon icon;
	CoffeePosDAO dao = new CoffeePosDAO();
	public Point() {}
	
	public Point(String phone) {

		super("포인트 조회");
		
		String[] mem = dao.memSearch(phone);

		icon = new ImageIcon("image/posback.png");
		icon = imageSetSize(icon, 300, 180);

		JPanel background = new JPanel(new BorderLayout()) {
			public void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(), 0, 0, null);
			}
		};

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int height = screenSize.height;
		int width = screenSize.width;

		setSize(300, 210);
		//setResizable(false);
		setLocation(width/2-this.getWidth()/2, height/2-this.getHeight()/2);
		
		JPanel jp1 = new JPanel();
		jp1.setBorder(BorderFactory.createEmptyBorder(20,0,10,0));
		jp1.setOpaque(false);
		
		JLabel searchLable = new JLabel(mem[0] + "님의 적립금은 " + mem[1] + "점입니다.", JLabel.CENTER);
		jp1.add(searchLable);

		JPanel jp4 = new JPanel();
		jp4.setOpaque(false);
		JLabel pointLable = new JLabel("적립될 포인트 :  " + POS.savep + "점", JLabel.CENTER);
		jp4.add(pointLable);
		
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
		
		JButton addButton = new JButton("적립");
		addButton.setBackground(new Color(230, 160, 0));
		addButton.setForeground(Color.WHITE);
		
		JButton cancelButton = new JButton("닫기");
		cancelButton.setBackground(new Color(230, 160, 0));
		cancelButton.setForeground(Color.WHITE);
		
		jp3.add(useButton);
		jp3.add(addButton);
		jp3.add(cancelButton);

		JPanel cenjp = new JPanel(new GridLayout(4,1));
		cenjp.setOpaque(false);
		cenjp.add(jp1); cenjp.add(jp4); cenjp.add(jp2); cenjp.add(jp3);
	
		background.add(cenjp, BorderLayout.CENTER);
		
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
				}else if(POS.usep ==0){
					JOptionPane.showMessageDialog(background, "사용할 포인트를 입력해주세요.");
				}else {
					
					int result = dao.pointUpdate(mem[2]);
					
					if(result > 0) {
						//JOptionPane.showMessageDialog(background, "포인트 사용 성공");
						POS.memcheck = true;
						dispose();
					}else {
						//JOptionPane.showMessageDialog(background, "포인트 사용 실패");
					}
				}
				
			}
		});
		
		addButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int result = dao.pointInsert(mem[2]);
				
				if(result > 0) {
					//JOptionPane.showMessageDialog(background, "저장완료");	
					POS.memcheck = true;
					POS.savep = 0;
					pointLable.setText("적립될 포인트 :  " + POS.savep + "점");
				}else {
					//JOptionPane.showMessageDialog(background, "저장실패");
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
