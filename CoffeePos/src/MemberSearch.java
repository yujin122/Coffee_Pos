
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// POS 회원조회
public class MemberSearch extends JFrame {

	private ImageIcon icon;

	public MemberSearch() {

		super("회원 조회");

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

		JLabel searchLable = new JLabel("전화번호를 입력하세요.", JLabel.CENTER);
		jp1.add(searchLable);

		JPanel jp2 = new JPanel();
		jp2.setOpaque(false);

		JTextField searchText = new JTextField(15);		
		jp2.add(searchText);

		JPanel jp3 = new JPanel();
		jp3.setOpaque(false);

		JButton searchbButton = new JButton("조회");
		searchbButton.setBackground(new Color(230, 160, 0));
		searchbButton.setForeground(Color.WHITE);
		JButton clearButton = new JButton("초기화");
		clearButton.setBackground(new Color(230, 160, 0));
		clearButton.setForeground(Color.WHITE);
		JButton cancelbButton = new JButton("종료");
		cancelbButton.setBackground(new Color(230, 160, 0));
		cancelbButton.setForeground(Color.WHITE);
		
		jp3.add(searchbButton);
		jp3.add(clearButton);
		jp3.add(cancelbButton);

		background.add(jp1, BorderLayout.NORTH);
		background.add(jp2, BorderLayout.CENTER);
		background.add(jp3, BorderLayout.SOUTH);

		add(background);
		
		setResizable(false); // 화면크기 고정

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setVisible(true);

		// 이벤트처리
		searchbButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String phone = searchText.getText().toString();
				CoffeePosDAO dao = new CoffeePosDAO();
				
				String[] mem = dao.memSearch(phone);
				
				if(Integer.parseInt(mem[1]) < 0) {
					JOptionPane.showMessageDialog(background, "회원이 존재하지 않습니다.");
				}else {
					new Point(phone);
					dispose();
				}
			}
		});
		
		// clearButton 이벤트 처리
		clearButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// 컴포넌트 초기화 작업
				searchText.setText(null);

			}
		});

		// cancelbButton 이벤트 처리
		cancelbButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new SelectMem();
				dispose();

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
