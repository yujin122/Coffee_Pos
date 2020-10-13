import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MemberAdd {
	
	private String genderData = null;
	
	public MemberAdd() {	
		
		JFrame frame = new JFrame();
		frame.setBounds(100, 100, 447, 493);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("회원 추가");
		
		JPanel jp = new JPanel();
		jp.setLayout(null);
	
		JLabel jl = new JLabel("회원 추가");
		jl.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		jl.setBounds(150, 25, 429, 53); 
		jp.add(jl);
		
		JLabel label = new JLabel("전화번호 : ");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(50, 91, 106, 18);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("이름 : ");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(94, 136, 62, 18);
		frame.getContentPane().add(label_1);
		
		JLabel lblNewLabel = new JLabel("생년월일 : ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(72, 182, 84, 18);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("성별 : ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(94, 227, 62, 18);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("이메일 : ");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(94, 282, 62, 18);
		frame.getContentPane().add(lblNewLabel_2);
		
		JTextField phone = new JTextField(10);
		phone.setBounds(164, 88, 116, 24);
		jp.add(phone);
		
		JTextField name = new JTextField(10);
		name.setBounds(164, 133, 116, 24);
		jp.add(name);
		
		JTextField bir = new JTextField(10);
		bir.setBounds(164, 179, 116, 24);
		jp.add(bir);
		
		JRadioButton female = new JRadioButton("여");
		female.setBounds(166, 223, 62, 27);
		jp.add(female);
		
		JRadioButton male = new JRadioButton("남");
		male.setBounds(234, 223, 48, 27);
		jp.add(male);
		
		ButtonGroup gender = new ButtonGroup();
		gender.add(male); gender.add(female);
		
		JTextField email = new JTextField(10);
		email.setBounds(164, 279, 116, 24);
		jp.add(email);
		
		JButton btn = new JButton("중복확인");
		btn.setBounds(286, 87, 89, 27);
		jp.add(btn);
		
		JButton okbtn = new JButton("확인");
		okbtn.setBounds(72, 361, 84, 27);
		jp.add(okbtn);
		
		JButton canclebtn= new JButton("취소");
		canclebtn.setBounds(170, 361, 84, 27);
		jp.add(canclebtn);
		
		JButton exitbtn = new JButton("닫기");
		exitbtn.setBounds(268, 361, 84, 27);
		jp.add(exitbtn);
		
		frame.add(jp);
		frame.setVisible(true);
		
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});

		okbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(female.isSelected()) {
					genderData = "여";
				}else if(male.isSelected()) {
					genderData = "남";
				}
				JOptionPane.showMessageDialog(frame, "전화번호 : "+ phone.getText() + 
						"\n이름 : " + name.getText() + "\n생년월일 : " + bir.getText() +
						"\n성별 : " + genderData + "\n이메일 : " + email.getText());
				frame.dispose();
				new MemberManage();
			}
		});
		
		canclebtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				gender.clearSelection();
				phone.setText(null); name.setText(null);
				bir.setText(null); email.setText(null);

			}
		});
		
		exitbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new MemberManage();

			}
		});
	}

	public static void main(String[] args) {
		new MemberAdd();
	}

}
