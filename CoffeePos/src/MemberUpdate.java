import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MemberUpdate extends JFrame {

	private int check = 0;
	private ImageIcon icon;

	public MemberUpdate() {}

	public MemberUpdate(String phoneData) {
		String data[] = new String[5];
		
		CoffeePosDAO dao = new CoffeePosDAO();
		data = dao.memUpdateForm(phoneData);
		
		// 배경화면
		icon = new ImageIcon("image/payment.png");
		icon = imageSetSize(icon, 415, 420);

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

		setSize(430, 460);
		setLocation(width / 2 - this.getWidth() / 2, height / 2 - this.getHeight() / 2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("회원 수정");
		
		// 제목
		JPanel titleJp = new JPanel();
		titleJp.setOpaque(false);
		titleJp.setBorder(BorderFactory.createEmptyBorder(20, 0, 10, 0));

		JLabel jl = new JLabel("회원 수정");
		jl.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		titleJp.add(jl);

		// 이름, 생년월일, 성별, 핸드폰번호, 이메일 panel
		JPanel insertJp1 = new JPanel(new GridLayout(5, 2, 0, 10));
		insertJp1.setOpaque(false);

		// 이름
		JPanel nameJp1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		nameJp1.setOpaque(false);
		JLabel nameJl = new JLabel("이름 : ", JLabel.CENTER);
		nameJp1.add(nameJl);
		insertJp1.add(nameJp1);

		JPanel nameJp2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		nameJp2.setOpaque(false);
		JTextField name = new JTextField(10);
		name.setText(data[0]);
		nameJp2.add(name);
		insertJp1.add(nameJp2);

		// 생년월일
		JPanel birJp1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		birJp1.setOpaque(false);
		JLabel birJl = new JLabel("생년월일 : ", JLabel.CENTER);
		birJp1.add(birJl);
		insertJp1.add(birJp1);

		JPanel birJp2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		birJp2.setOpaque(false);
		JTextField bir = new JTextField(10);
		bir.setText(data[1]);
		bir.setEnabled(false);
		birJp2.add(bir);
		insertJp1.add(birJp2);

		// 성별
		JPanel genderJp1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		genderJp1.setOpaque(false);
		JLabel genderJl = new JLabel("성별 : ", JLabel.CENTER);
		genderJp1.add(genderJl);
		insertJp1.add(genderJp1);

		JPanel genderJp2 = new JPanel(new FlowLayout());
		genderJp2.setOpaque(false);

		JRadioButton female = new JRadioButton("여");
		female.setEnabled(false);
		female.setOpaque(false);
		genderJp2.add(female);

		JRadioButton male = new JRadioButton("남");
		male.setEnabled(false);
		male.setOpaque(false);
		genderJp2.add(male);

		insertJp1.add(genderJp2);

		if(data[2].equals("여")) {
			female.setSelected(true);
		}else {
			male.setSelected(true);
		}
		
		ButtonGroup bg = new ButtonGroup();

		bg.add(male);
		bg.add(female);

		// 핸드폰번호
		JPanel phoneJp1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		phoneJp1.setOpaque(false);
		JLabel phoneJl = new JLabel("전화번호 : ", JLabel.CENTER);
		phoneJp1.add(phoneJl);
		insertJp1.add(phoneJp1);

		JPanel phoneJp2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		phoneJp2.setOpaque(false);
		JTextField phone = new JTextField(10);
		phone.setText(data[3]);
		phoneJp2.add(phone);
		insertJp1.add(phoneJp2);

		// 중복버튼
		JPanel bJp = new JPanel(new FlowLayout(FlowLayout.LEFT));
		bJp.setOpaque(false);
		bJp.setBorder(BorderFactory.createEmptyBorder(130, 0, 0, 0));

		JButton btn = new JButton("중복확인");
		btn.setForeground(Color.WHITE);
		btn.setFont(new Font("굴림", Font.BOLD, 12));
		btn.setBackground(new Color(230, 160, 0));
		bJp.add(btn);

		// 메일
		JPanel emailJp1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		emailJp1.setOpaque(false);
		JLabel emailJl = new JLabel("이메일 : ", JLabel.CENTER);
		emailJp1.add(emailJl);
		insertJp1.add(emailJp1);

		JPanel emailJp2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		emailJp2.setOpaque(false);
		JTextField email = new JTextField(10);
		email.setText(data[4]);
		emailJp2.add(email);
		insertJp1.add(emailJp2);

		// 중복버튼까지 추가 panel
		JPanel insertJp2 = new JPanel(new GridLayout(1, 2, 5, 5));
		insertJp2.setOpaque(false);
		insertJp2.setBorder(BorderFactory.createEmptyBorder(5, 170, 0, 0));
		insertJp2.add(insertJp1);
		insertJp2.add(bJp);

		// 버튼 panel
		JPanel buttonJp = new JPanel(new GridLayout(1, 3, 5, 5));
		buttonJp.setOpaque(false);
		buttonJp.setBorder(BorderFactory.createEmptyBorder(20, 60, 50, 50));

		JButton okbtn = new JButton("확인");
		okbtn.setForeground(Color.WHITE);
		okbtn.setFont(new Font("굴림", Font.BOLD, 12));
		okbtn.setBackground(new Color(230, 160, 0));
		buttonJp.add(okbtn);

		JButton canclebtn = new JButton("취소");
		canclebtn.setForeground(Color.WHITE);
		canclebtn.setFont(new Font("굴림", Font.BOLD, 12));
		canclebtn.setBackground(new Color(230, 160, 0));
		buttonJp.add(canclebtn);

		JButton exitbtn = new JButton("닫기");
		exitbtn.setForeground(Color.WHITE);
		exitbtn.setFont(new Font("굴림", Font.BOLD, 12));
		exitbtn.setBackground(new Color(230, 160, 0));
		buttonJp.add(exitbtn);

		JPanel centerJp = new JPanel();
		centerJp.setOpaque(false);

		centerJp.add(insertJp2);
		centerJp.add(buttonJp);

		background.add(titleJp, BorderLayout.NORTH);
		background.add(centerJp, BorderLayout.CENTER);

		add(background);
		setVisible(true);

		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(phoneData.equals(phone.getText().toString())) {
					JOptionPane.showMessageDialog(background, "해당 전화번호는 사용 가능합니다.");
					check = 1;
				}else {
					String phoneExist = phone.getText().toString();

					boolean ft = dao.isExist(phoneExist);

					if (ft) {
						JOptionPane.showMessageDialog(background, "해당 전화번호가 이미 존재합니다.");
					} else {
						JOptionPane.showMessageDialog(background, "해당 전화번호는 사용 가능합니다.");
						check = 1;
					}
				}

			}
		});
		
		okbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(check == 0) {
					JOptionPane.showMessageDialog(background, "전화번호 중복 확인을 해주세요.");
				}else {
					String nameData = name.getText().toString();
					String phoneData_ = phone.getText().toString();
					String emailData = email.getText().toString();
					
					int result = dao.memUpdate(nameData, phoneData_, emailData, phoneData);
					
					if(result > 0) {
						JOptionPane.showMessageDialog(background, "수정 완료");
						dispose();
						new MemberManage();
					}else {
						JOptionPane.showMessageDialog(background, "수정 실패");
					}	
				}
			}
		});

		canclebtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				phone.setText(null);
				email.setText(null);

			}
		});

		exitbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new MemberManage();

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
		new MemberUpdate();
	}

}
