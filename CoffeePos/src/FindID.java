import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FindID extends JFrame {
	
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	public FindID() {
		super("ID 찾기");
		setLocation(100, 100);

		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(17, 34, 48, 21);
		getContentPane().add(panel);

		JLabel name = new JLabel("이름 : ");
		name.setFont(new Font("굴림", Font.BOLD, 12));

		panel.add(name);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(21, 68, 89, 21);
		getContentPane().add(panel_1);

		JLabel socialNumber = new JLabel("주민등록번호 : ");
		socialNumber.setFont(new Font("굴림", Font.BOLD, 12));

		panel_1.add(socialNumber);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(114, 29, 183, 31);
		getContentPane().add(panel_2);

		textField = new JTextField();
		panel_2.add(textField);
		textField.setColumns(15);

		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBounds(110, 63, 187, 32);
		getContentPane().add(panel_2_1);

		textField_1 = new JTextField();
		panel_2_1.add(textField_1);
		textField_1.setColumns(6);

		JLabel label = new JLabel("-");
		panel_2_1.add(label);

		JPasswordField nINumber = new JPasswordField(7);
		panel_2_1.add(nINumber);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(40, 116, 61, 31);
		getContentPane().add(panel_3);

		JButton confirm = new JButton("확인");
		confirm.setFont(new Font("굴림", Font.BOLD, 12));

		panel_3.add(confirm);

		JPanel panel_3_1 = new JPanel();
		panel_3_1.setBounds(126, 116, 65, 31);
		getContentPane().add(panel_3_1);

		JButton cancel = new JButton("취소");
		cancel.setFont(new Font("굴림", Font.BOLD, 12));

		panel_3_1.add(cancel);

		JPanel panel_3_1_1 = new JPanel();
		panel_3_1_1.setBounds(211, 116, 64, 40);
		getContentPane().add(panel_3_1_1);

		JButton close = new JButton("닫기");
		close.setFont(new Font("굴림", Font.BOLD, 12));

		panel_3_1_1.add(close);

		setBounds(300, 250, 320, 205);

		setResizable(false);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setVisible(true);

		// 취소버튼
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
		new FindID();

	}

}
