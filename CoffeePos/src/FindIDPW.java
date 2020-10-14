

import javax.swing.JFrame;
import javax.swing.JPanel;



import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class FindIDPW extends JFrame {
	public FindIDPW() {
		super("ID/PW찾기");
		setLocation(100, 100);

		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(53, 18, 117, 32);
		getContentPane().add(panel);
		//id찾기
		JButton findId = new JButton("ID 찾기");
		findId.setFont(new Font("Dialog", Font.BOLD, 12));
		findId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(findId);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(52, 55, 117, 32); //길이
		getContentPane().add(panel_1);
		
		JButton findPw = new JButton("PW 찾기"); 	//pw버튼
		 findPw.setFont(new Font("Dialog", Font.BOLD, 12)); //글꼴수정
		panel_1.add(findPw);
		
	
		
		
		
		setBounds(250, 200,235, 150);
		
		setResizable(false);  
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setVisible(true);
		
		findId.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				new FindID();
				dispose();
			}
		});
		
		findPw.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				new FindPW();
				dispose();
				}
		});
			
	}
			

	public static void main(String[] args) {
		new FindIDPW();

	}

}
