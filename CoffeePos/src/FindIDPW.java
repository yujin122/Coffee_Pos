import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// 아이디 비밀번호 찾기
public class FindIDPW extends JFrame{

	private ImageIcon icon;

	public FindIDPW() {

		// 배경화면
		icon = new ImageIcon("image/payment.png");
		icon = imageSetSize(icon, 490, 520);

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

		setSize(350, 300);
		setLocation(width / 2 - this.getWidth() / 2, height / 2 - this.getHeight() / 2);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("ID/PW 찾기");

		// 제목
		JPanel titleJp = new JPanel();
		titleJp.setOpaque(false);
		titleJp.setBorder(BorderFactory.createEmptyBorder(20, 0, 10, 0));

		JLabel jl = new JLabel("ID/PW찾기");
		jl.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		titleJp.add(jl);

		// 버튼 panel
		JPanel buttonJp = new JPanel(new GridLayout(1, 2,10,10));
		buttonJp.setOpaque(false);
		buttonJp.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));

		JButton idbtn = new JButton("ID 찾기");
		idbtn.setForeground(Color.WHITE);
		idbtn.setFont(new Font("굴림", Font.BOLD, 12));
		idbtn.setBackground(new Color(230, 160, 0));
		buttonJp.add(idbtn);

		JButton pwbtn = new JButton("PW 찾기");
		pwbtn.setForeground(Color.WHITE);
		pwbtn.setFont(new Font("굴림", Font.BOLD, 12));
		pwbtn.setBackground(new Color(230, 160, 0));
		buttonJp.add(pwbtn);

		background.add(titleJp, BorderLayout.NORTH);
		background.add(buttonJp, BorderLayout.CENTER);

		add(background);
		setVisible(true);

		idbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				new FindID();
				dispose();
			}
		});

		pwbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				new FindPW();
				dispose();
			}
		});
		
		addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) { new POSLogin(); }
			
		});

	}

	public ImageIcon imageSetSize(ImageIcon icon, int i, int j) {
		Image ximg = icon.getImage();
		Image yimg = ximg.getScaledInstance(i, j, java.awt.Image.SCALE_SMOOTH);
		ImageIcon xyimg = new ImageIcon(yimg);
		return xyimg;
	}

}