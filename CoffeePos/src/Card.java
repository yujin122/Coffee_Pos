


//카드결제창임


import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

public class Card extends JFrame{
	public Card() { 
	    
		
		 super("결제창"); // 프레임 제목 붙이기 
	    
	    
	 
		JPanel Centerpanel = new JPanel(); // 패널 객체화 // 테이블 넣을 공간 
		JPanel Northpanel = new JPanel(); // 패널 객체화 // 현금 결제 라벨 텍스트 컴포넌트 
		JPanel Southpanel = new JPanel(); // 패널 객체화 // 텍스트 area 컴포넌트 
	    
	    
	    
	     
	    // north
	    JLabel cardLable = new JLabel("결제");
	    cardLable.setFont(new Font("굴림체", Font.BOLD, 30));
	    
	    /// center 테이블 부분 
	    String[] colNames = { "메뉴", "단가", "수량", "금액" }; 
	    Object data[][] = { {"아메리카노", new Integer(3000) , "1", "3000"}, {"카페라떼", "3500", "2", "7000"} }; 
	    JTable table = new JTable(data, colNames); 
	    
	    JScrollPane jsp = new JScrollPane(table); 
	    
	    Centerpanel = new JPanel(); 
	    //add(new JScrollPane(table)); 
	    //Centerpanel.add(table); 
	    Centerpanel.add(jsp); 
	    // 테이블 

	  //south
	    JTextArea cardText = new JTextArea(10,40);
	    cardText.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
	    cardText.append("총  합  계 : 10000원" + "\n");
	    cardText.append("--------------------------------------------------------------------------------------" + "\n");
	    cardText.append("받 을 금 액 : 원" + "\n");
	    cardText.append("받 음 금 액 : 원" + "\n");
	    
	    
	    Southpanel.add(cardText);
	    Northpanel.add(cardLable); 
	 
	    add(Northpanel, BorderLayout.NORTH); // 메인 프레임에 메인패널을 붙여주는 작업 
	    add(Centerpanel); 
	    add(Southpanel, BorderLayout.SOUTH);
	    
	    
	    setBounds(200, 200, 600, 700);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임바 우측상단에 X버튼에 대한 
	    // 강제종료 기능 지정 
	    
	    setVisible(true); // 프레임 보이게 하기 
	 } 
	
	
	




public static void main(String[] args) { 
  new Card(); 
} 
 
	
	 
	
}
