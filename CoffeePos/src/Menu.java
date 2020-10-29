import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

  
public class Menu extends JFrame{

	private ImageIcon icon;
	
	public Menu() {
	
		icon = new ImageIcon("image/menu.png");
		icon = imageSetSize(icon, 1000, 800);
		
		JPanel background = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(),0,0,null);
			}
		};		
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int height = screenSize.height;
		int width = screenSize.width;
		
		setPreferredSize(new Dimension(1000, 800));
		setSize(new Dimension(1000, 800));
		setLocation(width/2-this.getWidth()/2, height/2-this.getHeight()/2);
		
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
		
		add(background);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		
		memBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new MemberManage();
				dispose();
			}
		});
		
		stockBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new StockManage();
				dispose();
			}
		});

		salesBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new SalesManage();
				dispose();
			}
		});

		posBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new POS();
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
