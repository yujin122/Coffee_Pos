

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class POSJoin extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	public POSJoin() {
		super("관리자 회원가입");
		setLocation(100, 100);

		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 66, 65, 22);
		getContentPane().add(panel);
		
		JLabel name = new JLabel("이름 : ");
		name.setFont(new Font("Dialog", Font.BOLD, 12));
		panel.add(name);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(116, 60, 194, 31);
		getContentPane().add(panel_1);
		
		textField = new JTextField();
		panel_1.add(textField);
		textField.setColumns(15);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(19, 101, 96, 22);
		getContentPane().add(panel_2);
		
		JLabel lblNewLabel_1 = new JLabel("주민등록번호 : ");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 12));
		panel_2.add(lblNewLabel_1);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBounds(15, 136, 55, 22);
		getContentPane().add(panel_2_1);
		
		JLabel lblNewLabel_2 = new JLabel("성별 : ");
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 12));
		panel_2_1.add(lblNewLabel_2);
		
		JPanel panel_2_1_1 = new JPanel();
		panel_2_1_1.setBounds(17, 170, 61, 22);
		getContentPane().add(panel_2_1_1);
		
		JLabel ID = new JLabel("아이디 : ");
		ID.setFont(new Font("Dialog", Font.BOLD, 12));
		panel_2_1_1.add(ID);
		
		JPanel panel_2_1_2 = new JPanel();
		panel_2_1_2.setBounds(14, 202, 80, 22);
		getContentPane().add(panel_2_1_2);
		
		JLabel password = new JLabel("비밀번호 : ");
		password.setFont(new Font("Dialog", Font.BOLD, 12));
		panel_2_1_2.add(password);
		
		JPanel panel_2_1_3 = new JPanel();
		panel_2_1_3.setBounds(13, 234, 82, 22);
		getContentPane().add(panel_2_1_3);
		
		JLabel label_1 = new JLabel("전화번호 : ");
		label_1.setFont(new Font("Dialog", Font.BOLD, 12));
		panel_2_1_3.add(label_1);
		
		JPanel panel_2_1_4 = new JPanel();
		panel_2_1_4.setBounds(13, 263, 70, 22);
		getContentPane().add(panel_2_1_4);
		
		JLabel label_2 = new JLabel("이메일 : ");
		label_2.setFont(new Font("Dialog", Font.BOLD, 12));
		panel_2_1_4.add(label_2);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBounds(119, 95, 186, 31);
		getContentPane().add(panel_1_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(6);
		panel_1_1.add(textField_1);
		
		JLabel label = new JLabel("-");
		panel_1_1.add(label);
		
		JPasswordField nINumber = new JPasswordField();
		panel_1_1.add(nINumber);
		nINumber.setColumns(7);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBounds(108, 132, 200, 31);
		getContentPane().add(panel_1_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(14);
		panel_1_2.add(textField_2);
		
		JPanel panel_1_3 = new JPanel();
		panel_1_3.setBounds(121, 165, 162, 31);
		getContentPane().add(panel_1_3);
		
		textField_3 = new JTextField();
		textField_3.setColumns(13);
		panel_1_3.add(textField_3);
		
		JPanel panel_1_4 = new JPanel();
		panel_1_4.setBounds(106, 197, 202, 31);
		getContentPane().add(panel_1_4);
		
		textField_4 = new JTextField();
		textField_4.setColumns(14);
		panel_1_4.add(textField_4);
		
		JPanel panel_1_5 = new JPanel();
		panel_1_5.setBounds(106, 229, 202, 31);
		getContentPane().add(panel_1_5);
		
		textField_5 = new JTextField();
		textField_5.setColumns(14);
		panel_1_5.add(textField_5);
		
		JPanel panel_1_6 = new JPanel();
		panel_1_6.setBounds(106, 261, 203, 31);
		getContentPane().add(panel_1_6);
		
		textField_6 = new JTextField();
		textField_6.setColumns(14);
		panel_1_6.add(textField_6);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(289, 162, 91, 31);
		getContentPane().add(panel_3);
		
		JButton btnNewButton = new JButton("중복확인");
		btnNewButton.setFont(new Font("나눔고딕", Font.BOLD, 12));
		panel_3.add(btnNewButton);
		
		
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setBounds(73, 332, 70, 33);
		getContentPane().add(panel_3_1);
		
		JButton btnNewButton_1 = new JButton("확인");
		panel_3_1.add(btnNewButton_1);
		btnNewButton_1.setFont(new Font("나눔고딕", Font.BOLD, 12));
		
		JPanel panel_3_1_1 = new JPanel();
		panel_3_1_1.setBounds(161, 332, 70, 33);
		getContentPane().add(panel_3_1_1);
		
		JButton cancel = new JButton("취소");
		cancel.setFont(new Font("나눔고딕", Font.BOLD, 12));
		panel_3_1_1.add(cancel);
		
		JPanel panel_3_1_2 = new JPanel();
		panel_3_1_2.setBounds(247, 332, 70, 33);
		getContentPane().add(panel_3_1_2);
		
		JButton close2 = new JButton("닫기\r\n");
		close2.setFont(new Font("나눔고딕", Font.BOLD, 12));
		panel_3_1_2.add(close2);
	
	
	
	
	
	setBounds(600, 700, 400, 450);
	
	setResizable(false);  // 화면 크기 고정
	
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	setVisible(true);
	
	cancel.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			new POSLogin();
			dispose();
			
		}
	} );
	
	
	close2.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
			
		}
	});
	
	}
	
	public static void main(String[] args) {
		
	new POSJoin();
	}
}
