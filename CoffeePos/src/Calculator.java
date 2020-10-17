import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;


public class Calculator extends JPanel{

	private JTextField numText;
	private JTextField resultText;
	
	public Calculator() {
		
		setOpaque(false);
		
		JPanel panel = new JPanel(new BorderLayout());
		panel.setOpaque(false);
		
		JPanel textPan = new JPanel(new GridLayout(2,1));
		textPan.setOpaque(false);
		
		numText = new JTextField(30);
		numText.setBackground(new Color(252, 252, 252));
		numText.setHorizontalAlignment(SwingConstants.RIGHT);
		numText.setFont(new Font(null, 0, 20));
		numText.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
		
		resultText = new JTextField(30);
		resultText.setBackground(new Color(252, 252, 252));
		resultText.setHorizontalAlignment(SwingConstants.RIGHT);
		resultText.setFont(new Font(null, 0, 20));
		resultText.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
		
		textPan.add(numText); textPan.add(resultText);
		numText.setFocusable(false); resultText.setFocusable(false);
		
		JPanel buttonJp = new JPanel(new GridLayout(4,4,10,10));
		buttonJp.setOpaque(false);
		
		JButton btn[] = new JButton[16];
		
		for(int i = 0;i<10;i++) {
			btn[i] = new JButton(Integer.toString(i));
			btn[i].setPreferredSize(new Dimension( 50, 50));
			btn[i].setSize(new Dimension(50, 50));
			btn[i].setBackground(new Color(250, 250, 250));
		}
		
		btn[10] = new JButton("+");
		btn[11] = new JButton("-");
		btn[12] = new JButton(".");
		btn[13] = new JButton("Enter");
		btn[14] = new JButton("<");
		btn[15] = new JButton("C");
		
		for(int i = 10;i<16;i++) {
			btn[i].setBackground(new Color(227, 225, 225));
		}
		
		buttonJp.add(btn[7]); buttonJp.add(btn[8]); buttonJp.add(btn[9]); buttonJp.add(btn[15]);
		buttonJp.add(btn[4]); buttonJp.add(btn[5]); buttonJp.add(btn[6]); buttonJp.add(btn[10]);
		buttonJp.add(btn[1]); buttonJp.add(btn[2]); buttonJp.add(btn[3]); buttonJp.add(btn[11]);
		buttonJp.add(btn[12]); buttonJp.add(btn[0]); buttonJp.add(btn[14]); buttonJp.add(btn[13]);

		buttonJp.setBorder(BorderFactory.createEmptyBorder(20,0,0,0));
		
		panel.add(textPan, BorderLayout.NORTH);
		panel.add(buttonJp, BorderLayout.CENTER);	
		panel.setBorder(BorderFactory.createEmptyBorder(30,25,30,30));
		
		add(panel);

		setLocation(100, 100);
		setVisible(true);
		
		for(int i = 0;i<16;i++) {
			
			if(i < 13) {
				
				// 숫자
				btn[i].addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						JButton jb = (JButton)e.getSource();
						String oldTxt = numText.getText();
						String txt = jb.getText();
						String newTxt = oldTxt + txt;
						
						int n = newTxt.length();
						
						if(n <= 30) {
							numText.setText(newTxt);
						}else if(n>30) {
							numText.setText("입력 범위를 초과하였습니다.");
						}						
					}
				});
			} else if(i>=13) {
				
				// enter
				if(i == 13) {
					btn[13].addActionListener(new Enter());
				}
				
				// c
				if(i == 14) {
					btn[14].addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							int n = ((numText.getText()).length());
							
							if(n>0) {
								numText.setText(numText.getText().substring(0, n-1));
							}else if(n==0) {
								numText.setText("");
							}
						}
					});
				}
				
				// ce
				if(i == 15) {
					btn[15].addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							numText.setText(null);
							resultText.setText(null);
						}
					});
				}
			}
			
		}
		
		
	}
	
	private class Enter implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			String txt = numText.getText();
			double result = Calculator(txt);
			
			if(result < 0) {
				resultText.setText(Double.toString(result));
			}else {
				resultText.setText(Double.toString(result));
			}
		}

		private double Calculator(String txt) {
			double result;
			
			ArrayList<Double> val = new ArrayList<>();
			ArrayList<String> op = new ArrayList<>();
			
			op.add(null);
			
			String str = new String("");
			
			for (int i = 0; i< txt.length();i++) {
				Character c = txt.charAt(i);
				String s = Character.toString(c);
				
				// 숫자인경우
				if(Character.isDigit(c)) {
					str += Character.toString(c);
					if(i == txt.length()-1) {
						val.add(Double.parseDouble(str));
					}
				}else if(s.equals(".")) {
					str += s;
				}else {
					val.add(Double.parseDouble(str));
					op.add(Character.toString(c));
					str = "";
				}
			}
			
			for (int i = 1; i < val.size(); i++) {
				String s = op.get(i);
				double tmp;

				if (s.equals("+")) {
					tmp = val.get(i - 1) + val.get(i);
					op.remove(i);
					val.remove(i);
					val.remove(i - 1);
					val.add(i - 1, tmp);
					i--;
				} else if (s.equals("-")) {
					tmp = val.get(i - 1) - val.get(i);
					op.remove(i);
					val.remove(i);
					val.remove(i - 1);
					val.add(i - 1, tmp);
					i--;
				}
			}

			result = val.get(0);

			return result;
		}
		
	}
}
