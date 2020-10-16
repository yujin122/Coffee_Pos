
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

	public FindPW() {
		super("PW 찾기");

		setLocation(100, 100);

		getContentPane().setLayout(null);
		
		// 이름
		JPanel namePanel = new JPanel();
		namePanel.setBounds(7, 67, 58, 21);
		getContentPane().add(namePanel);

		JLabel nameLabel = new JLabel("이름 : ");
		nameLabel.setFont(new Font("굴림", Font.BOLD, 12));
		namePanel.add(nameLabel);
		// 주민등록번호
		JPanel rNumberPanel = new JPanel();
		rNumberPanel.setBounds(14, 99, 88, 21);
		getContentPane().add(rNumberPanel);

		JLabel rNumberLabel = new JLabel("주민등록번호 : ");
		rNumberLabel.setFont(new Font("굴림", Font.BOLD, 12));
		rNumberPanel.add(rNumberLabel);
		
		// id
		JPanel idPanel = new JPanel();
		idPanel.setBounds(6, 32, 73, 21);
		getContentPane().add(idPanel);

		JLabel idLabel = new JLabel("아이디 : ");
		idLabel.setFont(new Font("굴림", Font.BOLD, 12));
		idPanel.add(idLabel);

		
		// 이름TextField
		JPanel nameTfPanel = new JPanel();
		nameTfPanel.setBounds(113, 62, 179, 31);
		getContentPane().add(nameTfPanel);

		JTextField nameTF = new JTextField(15);
		nameTfPanel.add(nameTF);
	
		// 주민등록번호TextField
		JPanel rNumberTfPanel = new JPanel();
		rNumberTfPanel.setBounds(107, 98, 187, 32);
		getContentPane().add(rNumberTfPanel);

		JTextField rNumberTF1 = new JTextField(6);
		rNumberTfPanel.add(rNumberTF1);

		JLabel label = new JLabel("-");
		rNumberTfPanel.add(label);

		JPasswordField rNumberTF2 = new JPasswordField(7);
		rNumberTfPanel.add(rNumberTF2);
		
		// IDTextField
		JPanel idTfPanel = new JPanel();
		idTfPanel.setBounds(113, 28, 179, 31);
		getContentPane().add(idTfPanel);

		JTextField	idTF = new JTextField(15);
		idTfPanel.add(idTF);
		
		// 확인버튼
		JPanel confirmPanel = new JPanel();
		confirmPanel.setBounds(50, 146, 61, 31);
		getContentPane().add(confirmPanel);

		JButton conFirmButton = new JButton("확인");
		conFirmButton.setFont(new Font("굴림", Font.BOLD, 12));
		confirmPanel.add(conFirmButton);
		
		// 취소버튼
		JPanel cancelPanel = new JPanel();
		cancelPanel.setBounds(123, 146, 65, 31);
		getContentPane().add(cancelPanel);

		JButton cancelButton = new JButton("취소");
		cancelButton.setFont(new Font("굴림", Font.BOLD, 12));
		cancelPanel.add(cancelButton);
		
		// 닫기버튼
		JPanel closePanel = new JPanel();
		closePanel.setBounds(197, 146, 64, 31);
		getContentPane().add(closePanel);

		JButton closeButton = new JButton("닫기");
		closeButton.setFont(new Font("굴림", Font.BOLD, 12));
		closePanel.add(closeButton);


		setBounds(250, 250, 315, 230);

		setResizable(false);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setVisible(true);

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
		new FindPW();

	}

}
