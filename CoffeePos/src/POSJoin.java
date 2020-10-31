import java.awt.*;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.*;

//회원가입
public class POSJoin extends JFrame{

	private ImageIcon icon;
	private int check = 0;
	
	public POSJoin() {

		// 배경화면
		icon = new ImageIcon("image/payment.png");
		icon = imageSetSize(icon, 480, 520);

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

		setSize(490, 550);
		setLocation(width / 2 - this.getWidth() / 2, height / 2 - this.getHeight() / 2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("회원 가입");

		// 제목
		JPanel titleJp = new JPanel();
		titleJp.setOpaque(false);
		titleJp.setBorder(BorderFactory.createEmptyBorder(20, 0, 10, 0));

		JLabel jl = new JLabel("회원 가입");
		jl.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		titleJp.add(jl);

		JPanel insertJp1 = new JPanel(new GridLayout(7, 2, 0, 10));
		insertJp1.setOpaque(false);

		// 이름
		JPanel nameJp = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		nameJp.setOpaque(false);
		JLabel nameJl = new JLabel("이름 : ", JLabel.CENTER);
		nameJp.add(nameJl);
		insertJp1.add(nameJp);

		JPanel nametfJp = new JPanel(new FlowLayout(FlowLayout.LEFT));
		nametfJp.setOpaque(false);
		JTextField nametf = new JTextField(14);
		nametfJp.add(nametf);
		insertJp1.add(nametfJp);

		// 주민등록번호
		JPanel rNumJp1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		rNumJp1.setOpaque(false);
		JLabel rNumJl1 = new JLabel("주민등록번호 : ", JLabel.CENTER);
		rNumJp1.add(rNumJl1);
		insertJp1.add(rNumJp1);

		JPanel rNumtfJp1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		rNumtfJp1.setOpaque(false);
		JTextField rNumtf1 = new JTextField(6);
		JLabel n = new JLabel("-");
		JPasswordField rNumtf2 = new JPasswordField(7);
		rNumtfJp1.add(rNumtf1);
		insertJp1.add(rNumtfJp1);
		rNumtfJp1.add(n);
		rNumtfJp1.add(rNumtf2);

		// 성별
		JPanel genderJp1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		genderJp1.setOpaque(false);
		JLabel genderJl = new JLabel("성별 : ", JLabel.CENTER);
		genderJp1.add(genderJl);
		insertJp1.add(genderJp1);

		JPanel genderRbJp = new JPanel(new FlowLayout());
		genderRbJp.setOpaque(false);

		JRadioButton female = new JRadioButton("여");
		female.setOpaque(false);
		genderRbJp.add(female);

		JRadioButton male = new JRadioButton("남");
		male.setOpaque(false);
		genderRbJp.add(male);

		insertJp1.add(genderRbJp);

		ButtonGroup bg = new ButtonGroup();

		bg.add(male);
		bg.add(female);

		// id
		JPanel idJp = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		idJp.setOpaque(false);
		JLabel idJl = new JLabel("아이디 : ", JLabel.CENTER);
		idJp.add(idJl);
		insertJp1.add(idJp);

		JPanel idtfJp = new JPanel(new FlowLayout(FlowLayout.LEFT));
		idtfJp.setOpaque(false);
		JTextField idtf = new JTextField(13);
		idtfJp.add(idtf);
		insertJp1.add(idtfJp);

		// 중복버튼
		JPanel bJp = new JPanel(new FlowLayout(FlowLayout.LEFT));
		bJp.setOpaque(false);
		bJp.setBorder(BorderFactory.createEmptyBorder(130, 0, 0, 0));

		JButton btn = new JButton("중복확인");
		btn.setForeground(Color.WHITE);
		btn.setFont(new Font("굴림", Font.BOLD, 12));
		btn.setBackground(new Color(230, 160, 0));
		bJp.add(btn);

		// pw
		JPanel pwJp = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		pwJp.setOpaque(false);
		JLabel pwJl = new JLabel("비밀번호 : ", JLabel.CENTER);
		pwJp.add(pwJl);
		insertJp1.add(pwJp);

		JPanel pwtfJp = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pwtfJp.setOpaque(false);
		JPasswordField pwtf = new JPasswordField(13);
		pwtfJp.add(pwtf);
		insertJp1.add(pwtfJp);

		// 핸드폰번호
		JPanel phoneJp = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		phoneJp.setOpaque(false);
		JLabel phoneJl = new JLabel("전화번호 : ", JLabel.CENTER);
		phoneJp.add(phoneJl);
		insertJp1.add(phoneJp);

		JPanel phonetfJp = new JPanel(new FlowLayout(FlowLayout.LEFT));
		phonetfJp.setOpaque(false);
		JTextField phonetf = new JTextField(13);
		phonetf.setText("ex) 000-0000-0000");
		phonetf.setForeground(Color.GRAY);
		phonetfJp.add(phonetf);
		insertJp1.add(phonetfJp);

		phonetf.addFocusListener(new FocusAdapter() {

			@Override
			public void focusGained(FocusEvent e) {
				JTextField text = (JTextField) e.getComponent();
				text.setText("");
				text.setForeground(Color.BLACK);
				text.removeFocusListener(this);
			}
		});

		// 메일
		JPanel emailJp1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		emailJp1.setOpaque(false);
		JLabel emailJl = new JLabel("이메일 : ", JLabel.CENTER);
		emailJp1.add(emailJl);
		insertJp1.add(emailJp1);

		JPanel emailJp2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		emailJp2.setOpaque(false);
		JTextField emailtf = new JTextField(13);
		emailJp2.add(emailtf);
		insertJp1.add(emailJp2);

		// 중복버튼까지 추가 panel
		JPanel insertJp2 = new JPanel(new GridLayout(1, 2, 5, 5));
		insertJp2.setOpaque(false);
		insertJp2.setBorder(BorderFactory.createEmptyBorder(5, 250, 0, 0));
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

		canclebtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				nametf.setText(null); rNumtf1.setText(null); rNumtf2.setText(null);
				bg.clearSelection();  idtf.setText(null); pwtf.setText(null); emailtf.setText(null);
				phonetf.setText(null);

			}
		});

		exitbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new POSLogin();
				dispose();

			}
		});

		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CoffeePosDAO dao = new CoffeePosDAO();

				String DCheck = idtf.getText().toString();

				boolean iddc = dao.dcheck(DCheck);

				if (iddc) {
					JOptionPane.showMessageDialog(background, "해당 아이디는 사용 중 입니다.");
				} else {
					JOptionPane.showMessageDialog(background, "해당 아이디는 사용이 가능합니다.");
				}
				check = 1;
			}
		});

		okbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (check == 0) {
					JOptionPane.showMessageDialog(background, "아이디 중복 확인을 해주세요.");
				} else {
					CoffeePosDAO dao = new CoffeePosDAO();

					String nameData = nametf.getText().toString();
					String rNumberData = rNumtf1.getText().toString() + "-" + rNumtf2.getText().toString();
					String genderData = "남";
					if (female.isSelected()) {
						genderData = "여";
					}

					String idData = idtf.getText().toString();
					String pwData = pwtf.getText().toString();
					String numberData = phonetf.getText().toString();
					String eMailData = emailtf.getText().toString();

					int result = dao.mJoin(nameData, rNumberData, genderData, idData, pwData, numberData, eMailData);

					if (result > 0) {
						JOptionPane.showMessageDialog(background, "가입이 완료되었습니다.");
						dispose();
						new POSLogin();
					} else {
						JOptionPane.showMessageDialog(background, "아이디 중복 확인을 해주세요.");
						;
					}
					check = 1;
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