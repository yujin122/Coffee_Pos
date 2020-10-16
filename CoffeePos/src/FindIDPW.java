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
		
		// ID찾기
		JPanel idPanel = new JPanel();
		idPanel.setBounds(53, 18, 117, 32);
		getContentPane().add(idPanel);
		
		JButton findIdButton = new JButton("ID 찾기");
		findIdButton.setFont(new Font("Dialog", Font.BOLD, 12));
		idPanel.add(findIdButton);
		
		// PW찾기
		JPanel pwPanel = new JPanel();
		pwPanel.setBounds(52, 55, 117, 32); // 길이
		getContentPane().add(pwPanel);

		JButton findPwButton = new JButton("PW 찾기"); // pw버튼
		findPwButton.setFont(new Font("Dialog", Font.BOLD, 12)); // 글꼴수정
		pwPanel.add(findPwButton);

		setBounds(250, 200, 235, 150);

		setResizable(false);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setVisible(true);

		findIdButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				new FindID();
				dispose();
			}
		});

		findPwButton.addActionListener(new ActionListener() {

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
