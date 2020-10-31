import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// 아이디 찾기
public class FindID extends JFrame {

	private ImageIcon icon;
	
	public FindID() {	
		// 배경화면
		icon = new ImageIcon("image/payment.png");
		icon = imageSetSize(icon, 390, 290);
		
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
		
		setSize(400, 330);
		setLocation(width/2-this.getWidth()/2, height/2-this.getHeight()/2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("ID찾기");
		
		// 제목
		JPanel titleJp = new JPanel();
		titleJp.setOpaque(false);
		titleJp.setBorder(BorderFactory.createEmptyBorder(20, 0, 10, 0));
		
		JLabel jl = new JLabel("ID찾기");
		jl.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		titleJp.add(jl);
		
		JPanel insertJp1 = new JPanel(new GridLayout(2,2,0,10));
		insertJp1.setBorder(BorderFactory.createEmptyBorder(10,0,10,80));
		insertJp1.setOpaque(false);

		// 이름
		JPanel nameJp = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		nameJp.setOpaque(false);
		JLabel nameJl = new JLabel("이름 : ",JLabel.CENTER);
		nameJp.add(nameJl);
		insertJp1.add(nameJp);
		
		JPanel nametfJp = new JPanel(new FlowLayout(FlowLayout.LEFT));
		nametfJp.setOpaque(false);
		JTextField nametf = new JTextField(13);
		nametfJp.add(nametf);
		insertJp1.add(nametfJp);
		
		// 주민등록번호
		JPanel rNumJp1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		rNumJp1.setOpaque(false);
		JLabel rNumJl1 = new JLabel("주민등록번호 : ",JLabel.CENTER);
		rNumJp1.add(rNumJl1);
		insertJp1.add(rNumJp1);
	
		
		JPanel rNumtfJp1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		rNumtfJp1.setOpaque(false);
		JTextField rNumtf1 = new JTextField(7);
		JLabel n = new JLabel("-");
		JPasswordField rNumtf2 = new JPasswordField(7);
		
		rNumtfJp1.add(rNumtf1);
		rNumtfJp1.add(n);
		rNumtfJp1.add(rNumtf2);
		
		insertJp1.add(rNumtfJp1);
		
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
		
		centerJp.add(insertJp1);
		centerJp.add(buttonJp);
		
		background.add(titleJp,BorderLayout.NORTH);
		background.add(centerJp,BorderLayout.CENTER);
		
		add(background);
		setVisible(true);
		
		okbtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = nametf.getText().toString();
				String rnum = rNumtf1.getText().toString() + "-" + rNumtf2.getText().toString();
				
				CoffeePosDAO dao = new CoffeePosDAO();
				
				String result = dao.fId(name,rnum);
				
				if(result != null) {					
					JOptionPane.showMessageDialog(background, "아이디는 " + result + " 입니다" );
					new POSLogin();
					dispose();
				}else {
				
					
					JOptionPane.showMessageDialog(background, " 이름 또는 주민등록번호가 맞지 않습니다.");
					
				}
			
			}
		
		});

		canclebtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				nametf.setText(null); rNumtf1.setText(null);
				rNumtf2.setText(null);

			}
		});


		exitbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new FindIDPW();
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
