import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

public class MemberAdd extends JFrame{

	private ImageIcon icon;
	private int check = 0;
	
	public MemberAdd() {	
		  
		// 배경화면
		icon = new ImageIcon("image/payment.png");
		icon = imageSetSize(icon, 415, 420);
		
		JPanel background = new JPanel(new BorderLayout()) {
			public void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(),0,0,null);
				
				setOpaque(false);
				super.paintComponent(g);
			}
		};	
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int height = screenSize.height;
		int width = screenSize.width;
		
		setSize(430, 460);
		setLocation(width/2-this.getWidth()/2, height/2-this.getHeight()/2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("회원 추가");
		
		// 제목
		JPanel titleJp = new JPanel();
		titleJp.setOpaque(false);
		titleJp.setBorder(BorderFactory.createEmptyBorder(20, 0, 10, 0));
		
		JLabel jl = new JLabel("회원 추가");
		jl.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		titleJp.add(jl);
		
		// 이름, 생년월일, 성별, 핸드폰번호, 이메일 panel
		JPanel insertJp1 = new JPanel(new GridLayout(5,2,0,10));
		insertJp1.setOpaque(false);

		// 이름
		JPanel nameJp1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		nameJp1.setOpaque(false);
		JLabel nameJl = new JLabel("이름 : ",JLabel.CENTER);
		nameJp1.add(nameJl);
		insertJp1.add(nameJp1);
		
		JPanel nameJp2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		nameJp2.setOpaque(false);
		JTextField name = new JTextField(10);
		nameJp2.add(name);
		insertJp1.add(nameJp2);
		
		// 생년월일
		JPanel birJp1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		birJp1.setOpaque(false);
		JLabel birJl = new JLabel("생년월일 : ",JLabel.CENTER);
		birJp1.add(birJl);
		insertJp1.add(birJp1);
		
		JPanel birJp2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		birJp2.setOpaque(false);
		JTextField bir = new JTextField(10);
		bir.setText("ex) 20201026"); 
		bir.setForeground(Color.GRAY);
		birJp2.add(bir);
		insertJp1.add(birJp2);
		
		bir.addFocusListener(new FocusAdapter() {
			
			@Override
			 public void focusGained(FocusEvent e) {
		        JTextField text = (JTextField)e.getComponent();
		        text.setText("");
		        text.setForeground(Color.BLACK);
		        text.removeFocusListener(this);
		    }
		});
		
		// 성별
		JPanel genderJp1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		genderJp1.setOpaque(false);
		JLabel genderJl = new JLabel("성별 : ",JLabel.CENTER);
		genderJp1.add(genderJl);
		insertJp1.add(genderJp1);
		
		JPanel genderJp2 = new JPanel(new FlowLayout());
		genderJp2.setOpaque(false);
		
		JRadioButton female = new JRadioButton("여");
		female.setOpaque(false);
		genderJp2.add(female);
		
		JRadioButton male = new JRadioButton("남");
		male.setOpaque(false);
		genderJp2.add(male);
		
		insertJp1.add(genderJp2);
		
		ButtonGroup bg = new ButtonGroup();
		
		bg.add(male); bg.add(female);
		
		// 핸드폰번호
		JPanel phoneJp1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		phoneJp1.setOpaque(false);
		JLabel phoneJl = new JLabel("전화번호 : ",JLabel.CENTER);
		phoneJp1.add(phoneJl);
		insertJp1.add(phoneJp1);
		
		JPanel phoneJp2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		phoneJp2.setOpaque(false);
		JTextField phone = new JTextField(10);
		phone.setText("ex) 000-0000-0000"); 
		phone.setForeground(Color.GRAY);
		phoneJp2.add(phone);
		insertJp1.add(phoneJp2);
		
		phone.addFocusListener(new FocusAdapter() {
			
			@Override
			 public void focusGained(FocusEvent e) {
		        JTextField text = (JTextField)e.getComponent();
		        text.setText("");
		        text.setForeground(Color.BLACK);
		        text.removeFocusListener(this);
		    }
		});
		
		// 중복버튼
		JPanel bJp = new JPanel(new FlowLayout(FlowLayout.LEFT));
		bJp.setOpaque(false);
		bJp.setBorder(BorderFactory.createEmptyBorder(130, 0, 0, 0));
		
		JButton btn = new JButton("중복확인");
		btn.setForeground(Color.WHITE); 
		btn.setFont(new Font("굴림", Font.BOLD, 12));
		btn.setBackground(new Color(230,160,0));
		bJp.add(btn);
		
		// 메일
		JPanel emailJp1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		emailJp1.setOpaque(false);
		JLabel emailJl = new JLabel("이메일 : ",JLabel.CENTER);
		emailJp1.add(emailJl);
		insertJp1.add(emailJp1);
		
		JPanel emailJp2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		emailJp2.setOpaque(false);
		JTextField email = new JTextField(10);
		emailJp2.add(email);
		insertJp1.add(emailJp2);
		
		// 중복버튼까지 추가 panel
		JPanel insertJp2 = new JPanel(new GridLayout(1,2,5,5));
		insertJp2.setOpaque(false);
		insertJp2.setBorder(BorderFactory.createEmptyBorder(5, 170, 0, 0));
		insertJp2.add(insertJp1); insertJp2.add(bJp);
				
		// 버튼 panel
		JPanel buttonJp = new JPanel(new GridLayout(1,3,5,5));
		buttonJp.setOpaque(false);
		buttonJp.setBorder(BorderFactory.createEmptyBorder(20, 60, 50, 50));
		
		JButton okbtn = new JButton("확인");
		okbtn.setForeground(Color.WHITE); 
		okbtn.setFont(new Font("굴림", Font.BOLD, 12));
		okbtn.setBackground(new Color(230,160,0));
		buttonJp.add(okbtn);
		
		JButton canclebtn= new JButton("취소");
		canclebtn.setForeground(Color.WHITE); 
		canclebtn.setFont(new Font("굴림", Font.BOLD, 12));
		canclebtn.setBackground(new Color(230,160,0));
		buttonJp.add(canclebtn);
		
		JButton exitbtn = new JButton("닫기");
		exitbtn.setForeground(Color.WHITE); 
		exitbtn.setFont(new Font("굴림", Font.BOLD, 12));
		exitbtn.setBackground(new Color(230,160,0));
		buttonJp.add(exitbtn);
		
		JPanel centerJp = new JPanel();
		centerJp.setOpaque(false);
		
		centerJp.add(insertJp2);
		centerJp.add(buttonJp);
		
		background.add(titleJp,BorderLayout.NORTH);
		background.add(centerJp,BorderLayout.CENTER);
		
		add(background);
		setVisible(true);
		
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CoffeePosDAO dao = new CoffeePosDAO();
				
				String phoneExist = phone.getText().toString();
				
				boolean ft = dao.isExist(phoneExist);
				
				if(ft) {
					JOptionPane.showMessageDialog(background, "해당 전화번호가 이미 존재합니다.");
				}else {
					JOptionPane.showMessageDialog(background, "해당 전화번호는 사용 가능합니다.");
					check = 1;
				}
			}
		});

		okbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(check == 0) {
					JOptionPane.showMessageDialog(background, "전화번호 중복 확인을 해주세요.");
				}else {
					CoffeePosDAO dao = new CoffeePosDAO();
					
					String phoneData = phone.getText().toString();
					String nameData = name.getText().toString();
					String birthData = bir.getText().toString();
					String genderData = "남";
					if(female.isSelected()) {
						genderData = "여";
					}
					String emailData = email.getText().toString();
					
					int result = dao.memAdd(phoneData, nameData, birthData, genderData, emailData);
					
					if(result > 0) {
						JOptionPane.showMessageDialog(background, "전화번호 : "+ phoneData + 
								"\n이름 : " + nameData + "\n생년월일 : " + birthData +
								"\n성별 : " + genderData + "\n이메일 : " + emailData);
						
						dispose();
						new MemberManage();
					}else {
						JOptionPane.showMessageDialog(background, "회원 추가 실패");
					}
				}
			}
		});
		
		canclebtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				bg.clearSelection();
				phone.setText(null); name.setText(null);
				bir.setText(null); email.setText(null);

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
		new MemberAdd();
	}

}
