import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

  
public class Menu extends JFrame{

	private JScrollPane scrollPane;
	private ImageIcon icon;
	
	public Menu() {
	
		icon = new ImageIcon("image/menu.png");
		icon = imageSetSize(icon, 1000, 800);
		
		JPanel background = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(),0,0,null);
				
				setOpaque(false);
				super.paintComponent(g);
			}
		};		
		
		JPanel jp = new JPanel(new GridLayout(1,2));
		jp.setBackground(new Color(0,0,0,0));
		
		JPanel menuJp = new JPanel(new GridLayout(4,1,30,30));
		menuJp.setBackground(new Color(0,0,0,0));
		menuJp.setBorder(BorderFactory.createEmptyBorder(80, 50, 80, 50));
		
		ImageIcon memImg = new ImageIcon("image/member.png");
		memImg = imageSetSize(memImg, 350, 110);
		JButton memBtn = new JButton(memImg);
		memBtn.setBorderPainted(false);
		memBtn.setFocusPainted(false);
		memBtn.setContentAreaFilled(false);

		menuJp.add(memBtn);
		
		ImageIcon stockImg = new ImageIcon("image/stock.png");
		stockImg = imageSetSize(stockImg, 350, 110);
		JButton stockBtn = new JButton(stockImg);
		stockBtn.setBorderPainted(false);
		stockBtn.setFocusPainted(false);
		stockBtn.setContentAreaFilled(false);
		
		menuJp.add(stockBtn);
		
		ImageIcon salesImg = new ImageIcon("image/sales.png");
		salesImg = imageSetSize(salesImg, 350, 110);
		JButton salesBtn = new JButton(salesImg);
		salesBtn.setBorderPainted(false);
		salesBtn.setFocusPainted(false);
		salesBtn.setContentAreaFilled(false);
		
		menuJp.add(salesBtn);
		
		ImageIcon posImg = new ImageIcon("image/pos.png");
		posImg = imageSetSize(posImg, 350, 110);
		JButton posBtn = new JButton(posImg);
		posBtn.setBorderPainted(false);
		posBtn.setFocusPainted(false);
		posBtn.setContentAreaFilled(false);
		
		menuJp.add(posBtn);
		
		
		JLabel name = new JLabel(" ");
		name.setHorizontalAlignment(SwingConstants.CENTER);
		name.setFont(new Font("함초롬바탕", Font.BOLD, 35));
		
		jp.add(name);
		jp.add(menuJp);
		
		background.add(jp);
		scrollPane = new JScrollPane(background);
		setContentPane(scrollPane);
		
		setBounds(100, 100, 1000, 800);
		setResizable(false);
		setVisible(true);
		
		memBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new MemberManage();
				//frame.dispose();
				dispose();
			}
		});
		
		stockBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new StockManage();
				//frame.dispose();
				dispose();
			}
		});

		salesBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new SalesManage();
				//frame.dispose();
				dispose();
			}
		});

		posBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new POS();
				new Card();
				//frame.dispose();
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
	
	public static void main(String[] args) {
		new Menu();
	}

}
