

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;

import javax.swing.*;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class POSLogin extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	
	public POSLogin() {
		super("로그인 화면");
		setLocation(100, 100);
		getContentPane().setFont(new Font("굴림", Font.PLAIN, 12));
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(43, 23, 200, 50);
		getContentPane().add(panel);
		
		JLabel login = new JLabel("Sist P.O.S");
		login.setFont(new Font("함초롬바탕", Font.PLAIN, 30));
		panel.add(login);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(27, 92, 90, 23);
		getContentPane().add(panel_1);
		
		JLabel loginId = new JLabel("ID :");
		loginId.setFont(new Font("Dialog", Font.BOLD, 12));
		panel_1.add(loginId);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBounds(27, 125, 90, 23);
		getContentPane().add(panel_1_1);
		
		JLabel loginPw = new JLabel("PW :");
		loginPw.setFont(new Font("Dialog", Font.BOLD, 12));
		panel_1_1.add(loginPw);
		
		JPasswordField pwTf = new JPasswordField(10);
		pwTf.setBounds(128, 125, 116, 21);
		getContentPane().add(pwTf);
		
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(128, 94, 116, 21);
		getContentPane().add(textField_1);
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(90, 164, 101, 40);
		getContentPane().add(panel_2);
		
		JButton findidpw = new JButton("ID/PW찾기");
		findidpw.setFont(new Font("굴림", Font.BOLD, 12));
		panel_2.add(findidpw);
	
		
		JPanel panel_2_2 = new JPanel();
		panel_2_2.setBounds(10, 164, 79, 38);
		getContentPane().add(panel_2_2);
		
		JButton JLogin = new JButton("로그인");
		JLogin.setFont(new Font("굴림", Font.BOLD, 12));
		panel_2_2.add(JLogin);
		
		JPanel panel_2_2_1 = new JPanel();
		panel_2_2_1.setBounds(190, 164, 90, 40);
		getContentPane().add(panel_2_2_1);
		
		JButton join = new JButton("회원가입");
		join.setFont(new Font("굴림", Font.BOLD, 12));
		panel_2_2_1.add(join);
		
		setBounds(250, 250, 300, 250);
		
		setResizable(false);  // 화면 크기 고정
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setVisible(true);
	
		JLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog
					(JLogin,"로그인 성공");
				new Menu();
				dispose();
			}
		});
		
		join.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				new POSJoin();
				dispose();
			}
		});
		findidpw.addActionListener(new ActionListener() {
		@Override
		
		public void actionPerformed(ActionEvent e) {	
			new FindIDPW();
			dispose();
		}
	});
			
	}
	public static void main(String[] args) {
	
		new POSLogin();
	}		
}