import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
  
public class Menu {

	//private Image menuImg = new ImageIcon(Menu.class.getResource("image/menu.png")).getImage();
	//ImageIcon icon;
//	BufferedImage img = null;
	
	public Menu() {
		
		JFrame frame = new JFrame();
		frame.setBounds(100, 100, 900, 700);
		frame.setResizable(false);
		
		/*JLayeredPane back = new JLayeredPane();
		back.setSize(900, 700);
		back.setLayout(null);
		*/
		//img = ImageIO.read(new File("C:\\Users\\yyj01\\OneDrive\\문서\\GitHub\\JavaProject\\JavaProject\\CoffeePos\\image\\menu.png");)
		
	/*	JPanel background = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(),0,0,null);
				
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		*/
	/*	JLayeredPane back = new JLayeredPane();
		back.setSize(900, 700);
		back.setLayout(null);
		
		myPanel panel = new myPanel();
		panel.setSize(900,700);		
		
		back.add(panel);
		
		frame.add(back);*/
		
		
		JPanel jp = new JPanel(new GridLayout(1,2));
		JPanel menuJp = new JPanel(new GridLayout(4,1,30,30));
		menuJp.setBorder(BorderFactory.createEmptyBorder(80, 50, 80, 50));
		
		ImageIcon memImg = new ImageIcon("image/member.png");
		memImg = imageSetSize(memImg, 350, 110);
		JButton memBtn = new JButton(memImg);
		menuJp.add(memBtn);
		
		ImageIcon stockImg = new ImageIcon("image/stock.png");
		stockImg = imageSetSize(stockImg, 350, 110);
		JButton stockBtn = new JButton(stockImg);
		menuJp.add(stockBtn);
		
		ImageIcon salesImg = new ImageIcon("image/sales.png");
		salesImg = imageSetSize(salesImg, 350, 110);
		JButton salesBtn = new JButton(salesImg);
		menuJp.add(salesBtn);
		
		ImageIcon posImg = new ImageIcon("image/pos.png");
		posImg = imageSetSize(posImg, 350, 110);
		JButton posBtn = new JButton(posImg);
		menuJp.add(posBtn);
		
		
		JLabel name = new JLabel(" ");
		name.setHorizontalAlignment(SwingConstants.CENTER);
		name.setFont(new Font("함초롬바탕", Font.BOLD, 35));
		
		jp.add(name);
		jp.add(menuJp);
		
		frame.add(jp);
		frame.setVisible(true);
		
		memBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton b = (JButton)e.getSource();
				System.out.println(b);
				new MemberManage();
				frame.dispose();
			}
		});
		
		stockBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new StockManage();
				frame.dispose();
			}
		});

		salesBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new SalesManage();
				frame.dispose();
			}
		});

		posBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new POS();
				new Card();
				frame.dispose();
			}
		});
	}
	
	ImageIcon imageSetSize(ImageIcon icon, int i, int j) {
		Image ximg = icon.getImage();
		Image yimg = ximg.getScaledInstance(i, j, java.awt.Image.SCALE_SMOOTH);
		ImageIcon xyimg = new ImageIcon(yimg);
		return xyimg;
	}
	
	
	/*class myPanel extends JPanel{
		public void pain(Graphics g) {
			g.drawImage(menuImg, 0, 0, null);
		}
	}
	*/
	
	public static void main(String[] args) {
		new Menu();
	}

}
