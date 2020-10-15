
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Font;

public class FindPW extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	public FindPW() {
		super("PW 찾기");

		setLocation(100, 100);

		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(7, 67, 58, 21);
		getContentPane().add(panel);

		JLabel lblNewLabel = new JLabel("이름 : ");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 12));
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(14, 99, 88, 21);
		getContentPane().add(panel_1);

		JLabel lblNewLabel_1 = new JLabel("주민등록번호 : ");
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 12));
		panel_1.add(lblNewLabel_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(113, 62, 179, 31);
		getContentPane().add(panel_2);

		textField = new JTextField();
		panel_2.add(textField);
		textField.setColumns(15);

		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBounds(107, 98, 187, 32);
		getContentPane().add(panel_2_1);

		textField_1 = new JTextField();
		panel_2_1.add(textField_1);
		textField_1.setColumns(6);

		JLabel label = new JLabel("-");
		panel_2_1.add(label);

		JPasswordField nINumber = new JPasswordField();
		panel_2_1.add(nINumber);
		nINumber.setColumns(7);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(50, 146, 61, 31);
		getContentPane().add(panel_3);

		JButton btnNewButton = new JButton("확인");
		btnNewButton.setFont(new Font("굴림", Font.BOLD, 12));
		panel_3.add(btnNewButton);

		JPanel panel_3_1 = new JPanel();
		panel_3_1.setBounds(123, 146, 65, 31);
		getContentPane().add(panel_3_1);

		JButton cancel = new JButton("취소");
		cancel.setFont(new Font("굴림", Font.BOLD, 12));
		panel_3_1.add(cancel);

		JPanel panel_3_1_1 = new JPanel();
		panel_3_1_1.setBounds(197, 146, 64, 31);
		getContentPane().add(panel_3_1_1);

		JButton close = new JButton("닫기");
		close.setFont(new Font("굴림", Font.BOLD, 12));
		panel_3_1_1.add(close);

		JPanel panel_4 = new JPanel();
		panel_4.setBounds(6, 32, 73, 21);
		getContentPane().add(panel_4);

		JLabel lblNewLabel_2 = new JLabel("아이디 : ");
		lblNewLabel_2.setFont(new Font("굴림", Font.BOLD, 12));
		panel_4.add(lblNewLabel_2);

		JPanel panel_2_2 = new JPanel();
		panel_2_2.setBounds(113, 28, 179, 31);
		getContentPane().add(panel_2_2);

		textField_2 = new JTextField();
		textField_2.setColumns(15);
		panel_2_2.add(textField_2);

		setBounds(250, 250, 315, 230);

		setResizable(false);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setVisible(true);

		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new FindIDPW();
				dispose();
			}
		});
		// 종료버튼
		close.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}
		});

	}

	public static void main(String[] args) {
		new FindPW();

	}

}
