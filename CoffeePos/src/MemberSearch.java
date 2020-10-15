
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.*;

//회원조회
public class MemberSearch extends JFrame {

	public MemberSearch() {

		super("회원 조회");

		JPanel jp1 = new JPanel();
		JLabel searchLable = new JLabel("전화번호를 입력하세요.", JLabel.CENTER);
		jp1.add(searchLable);

		JPanel jp2 = new JPanel();
		JTextField searchText = new JTextField(15);
		jp2.add(searchText);

		JPanel jp3 = new JPanel();
		JButton searchbButton = new JButton("조회");
		JButton clearButton = new JButton("초기화");
		JButton cancelbButton = new JButton("종료");
		jp3.add(searchbButton);
		jp3.add(clearButton);
		jp3.add(cancelbButton);

		setLayout(new BorderLayout());
		add(jp1, BorderLayout.NORTH);
		add(jp2, BorderLayout.CENTER);
		add(jp3, BorderLayout.SOUTH);

		setBounds(100, 100, 300, 150);

		setResizable(false); // 화면크기 고정

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setVisible(true);

		// 이벤트처리
		// clearButton 이벤트 처리
		clearButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// 컴포넌트 초기화 작업
				searchText.setText(null);

			}
		});

		// cancelbButton 이벤트 처리
		cancelbButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();

			}
		});
	}

}
