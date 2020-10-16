
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
	
	

	public POSLogin() {
		super("로그인 화면");
		setLocation(100, 100);
		getContentPane().setFont(new Font("굴림", Font.PLAIN, 12));
		getContentPane().setLayout(null);
		
		// 포스이름
		JPanel loginScreenPanel = new JPanel();
		loginScreenPanel.setBounds(43, 23, 200, 50);
		getContentPane().add(loginScreenPanel);

		JLabel loginScreenLabel = new JLabel("Sist P.O.S");
		loginScreenLabel.setFont(new Font("함초롬바탕", Font.PLAIN, 30));
		loginScreenPanel.add(loginScreenLabel);
		
		// ID
		JPanel idPanel = new JPanel();
		idPanel.setBounds(31, 92, 90, 23);
		getContentPane().add(idPanel);
		
		JLabel idLabel = new JLabel("ID :");
		idLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		idPanel.add(idLabel);
		
		// Password
		JPanel pwPanel = new JPanel();
		pwPanel.setBounds(31, 125, 90, 23);
		getContentPane().add(pwPanel);
		
		JLabel pwLabel = new JLabel("PW :");
		pwLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		pwPanel.add(pwLabel);
		JPanel idPwBPanel = new JPanel();
		idPwBPanel.setBounds(90, 164, 101, 40);
		getContentPane().add(idPwBPanel);
		
		// ID/PW찾기
		JButton findIdPwButton = new JButton("ID/PW찾기");
		findIdPwButton.setFont(new Font("굴림", Font.BOLD, 12));
		idPwBPanel.add(findIdPwButton);
		
		// 로그인버튼
		JPanel JloginBPanel = new JPanel();
		JloginBPanel.setBounds(10, 164, 79, 38);
		getContentPane().add(JloginBPanel);

		JButton JLoginButton = new JButton("로그인");
		JLoginButton.setFont(new Font("굴림", Font.BOLD, 12));
		JloginBPanel.add(JLoginButton);
		
		// 회원가입 버튼
		JPanel joinBpanel = new JPanel();
		joinBpanel.setBounds(190, 164, 90, 40);
		getContentPane().add(joinBpanel);

		JButton joinButton = new JButton("회원가입");
		joinButton.setFont(new Font("굴림", Font.BOLD, 12));
		joinBpanel.add(joinButton);
		
		//IDTextfield
		JPanel idTfPanel = new JPanel();
		idTfPanel.setBounds(117, 87, 130, 34);
		getContentPane().add(idTfPanel);
		
		JTextField idTf = new JTextField(10);
				idTfPanel.add(idTf);
		
		// PWTextField
		JPanel pwTfPanel = new JPanel();
				pwTfPanel.setBounds(118, 123, 129, 31);
				getContentPane().add(pwTfPanel);
		
		// 암호화		
		JPasswordField pwTf = new JPasswordField(10);
				pwTfPanel.add(pwTf);

		setBounds(250, 250, 300, 250);

		setResizable(false);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setVisible(true);
		
		
		//로그인 버튼, ID/PW찾기 버튼 , 회원가입 버튼
		JLoginButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(JLoginButton, "로그인 성공");
				new Menu();
				dispose();
			}
		});

		joinButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				new POSJoin();
				dispose();
			}
		});
		findIdPwButton.addActionListener(new ActionListener() {
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