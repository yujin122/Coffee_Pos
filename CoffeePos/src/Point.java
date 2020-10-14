

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Point extends JFrame {
	
	public Point() {
		
		super("포인트 조회");
		
		
		JPanel jp1 = new JPanel();
		JLabel searchLable = new JLabel("님의 적립금은", JLabel.CENTER);
		JLabel searchLable2 = new JLabel("점입니다.", JLabel.CENTER);
		jp1.add(searchLable);
		jp1.add(searchLable2);
		
		JPanel jp2 = new JPanel();
		JLabel usingpoint = new JLabel("사용 포인트 : ");
		JTextField searchText = new JTextField(15);
		jp2.add(usingpoint);
		jp2.add(searchText);
		
		JPanel jp3 = new JPanel();
		JButton useButton = new JButton("사용");
		JButton cancelButton = new JButton("닫기");
		jp3.add(useButton);
		jp3.add(cancelButton);
		
		
		setLayout(new BorderLayout());
		add(jp1, BorderLayout.NORTH);
		add(jp2, BorderLayout.CENTER);
		add(jp3, BorderLayout.SOUTH);
		
		setBounds(100, 100, 300, 150);
		
		setResizable(false); 	// 화면크기 고정
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setVisible(true);
		
		
		
		// 이벤트 처리
		// cancelbButton 이벤트 처리
		cancelButton.addActionListener(new ActionListener() {
									
			@Override
			public void actionPerformed(ActionEvent e) {
					System.exit(0);	
										
			}
		});
				
				
	}
		
		
		
}

