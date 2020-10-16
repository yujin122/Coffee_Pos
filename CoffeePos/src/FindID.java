import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FindID extends JFrame {

	public FindID() {
		super("ID 찾기");
		setLocation(100, 100);

		getContentPane().setLayout(null);
		
		// 이름
		JPanel namePanel = new JPanel();
		namePanel.setBounds(17, 34, 48, 21);
		getContentPane().add(namePanel);

		JLabel nameLabel = new JLabel("이름 : ");
		nameLabel.setFont(new Font("굴림", Font.BOLD, 12));

		namePanel.add(nameLabel);
		
		// 주민등록번호
		JPanel rNumberPanel = new JPanel();
		rNumberPanel.setBounds(21, 68, 89, 21);
		getContentPane().add(rNumberPanel);

		JLabel rNumberLabel = new JLabel("주민등록번호 : ");
		rNumberLabel.setFont(new Font("굴림", Font.BOLD, 12));

		rNumberPanel.add(rNumberLabel);
		
		// 이름TextField
		JPanel nameTfPanel = new JPanel();
		nameTfPanel.setBounds(114, 29, 183, 31);
		getContentPane().add(nameTfPanel);

		JTextField NameTf = new JTextField(15);
		nameTfPanel.add(NameTf);
		
		// 주민등록번호TextField
		JPanel rNumberTfPanel = new JPanel();
		rNumberTfPanel.setBounds(110, 63, 187, 32);
		getContentPane().add(rNumberTfPanel);

		JTextField rNumberTf1 = new JTextField(6);
		rNumberTfPanel.add(rNumberTf1);

		JLabel label = new JLabel("-");
		rNumberTfPanel.add(label);
		
		// 뒷자리 암호화
		JPasswordField rNumberTf2 = new JPasswordField(7);
		rNumberTfPanel.add(rNumberTf2);
		
		// 확인버튼
		JPanel confirmButtonPanel = new JPanel();
		confirmButtonPanel.setBounds(40, 116, 61, 31);
		getContentPane().add(confirmButtonPanel);

		JButton confirmButton = new JButton("확인");
		confirmButton.setFont(new Font("굴림", Font.BOLD, 12));

		confirmButtonPanel.add(confirmButton);
		
		
		// 취소버튼
		JPanel cancelButtonPanel = new JPanel();
		cancelButtonPanel.setBounds(126, 116, 65, 31);
		getContentPane().add(cancelButtonPanel);
		
		JButton cancelButton = new JButton("취소");
		cancelButton.setFont(new Font("굴림", Font.BOLD, 12));

		cancelButtonPanel.add(cancelButton);
		
		// 닫기버튼
		JPanel closeButtonPanel = new JPanel();
		closeButtonPanel.setBounds(211, 116, 64, 40);
		getContentPane().add(closeButtonPanel);

		JButton closeButton = new JButton("닫기");
		closeButton.setFont(new Font("굴림", Font.BOLD, 12));

		closeButtonPanel.add(closeButton);

		setBounds(300, 250, 320, 205);

		setResizable(false);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setVisible(true);

		// 취소버튼
		cancelButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new FindIDPW();
				dispose();
			}
		});
		// 종료버튼
		closeButton.addActionListener(new ActionListener() {

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
