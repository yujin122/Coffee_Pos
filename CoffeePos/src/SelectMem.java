import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class SelectMem extends JFrame{

	private ImageIcon icon;

	public SelectMem() {
		
		icon = new ImageIcon("image/payment.png");
		icon = imageSetSize(icon, 540,515);

		JPanel background = new JPanel(new BorderLayout()) {
			public void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(), 0, 0, null);
			}
		};

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int height = screenSize.height;
		int width = screenSize.width;
		
		setSize(550,550);		
		setResizable(false);
		setLocation(width/2-this.getWidth()/2, height/2-this.getHeight()/2);
		
		setTitle("회원선택");
		
		JPanel jp = new JPanel(new GridLayout(1,2,15,0));
		jp.setBorder(BorderFactory.createEmptyBorder(175,50,175,50));
		jp.setOpaque(false);
		
		JButton member = new JButton("회원");
		member.setBackground(new Color(230, 160, 0));
		member.setForeground(Color.WHITE);
		jp.add(member);
		
		/*JButton nonmember = new JButton("비회원");
		nonmember.setBackground(new Color(230, 160, 0));
		nonmember.setForeground(Color.WHITE);
		jp.add(nonmember);*/
		
		JButton addMember = new JButton("회원추가");
		addMember.setBackground(new Color(230, 160, 0));
		addMember.setForeground(Color.WHITE);
		jp.add(addMember);
		
		background.add(jp, BorderLayout.CENTER);
		
		add(background);
		
		setVisible(true);
		
		member.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new MemberSearch();
				dispose();
			}
		});
		
		/*nonmember.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(POS.memi == 1) {
					new Money();
					dispose();
				}else if(POS.memi == 2) {
					new MoneyCard();
					dispose();
				}
			}
		});*/
		
		addMember.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new MemberAdd(true);
				dispose();
			}
		});
	}
	
	public ImageIcon imageSetSize(ImageIcon icon, int i, int j) {
		Image ximg = icon.getImage();
		Image yimg = ximg.getScaledInstance(i, j, java.awt.Image.SCALE_SMOOTH);
		ImageIcon xyimg = new ImageIcon(yimg);
		return xyimg;
	}
}
