import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ex {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		cal.set(2020, 5, 7);
		int offset = cal.get(Calendar.DAY_OF_WEEK)-1;
		System.out.println(cal.get(Calendar.MONTH) + "  " + offset);
		
		String[] days = { "일", "월", "화", "수", "목", "금", "토" };

		//int[] lastDays = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		
		DefaultTableModel dModel = new DefaultTableModel(days,7);
		
		/*dModel.addColumn("일");
		dModel.addColumn("월");
		dModel.addColumn("화");
		dModel.addColumn("수");
		dModel.addColumn("목");
		dModel.addColumn("금");
		dModel.addColumn("토");*/
		
		dModel.setValueAt("5", 0, 0);
		dModel.setValueAt("5", 0, 1);
		dModel.setValueAt("5", 0, 2);
		dModel.setValueAt("5", 0, 3);
		dModel.setValueAt("5", 0, 4);
		dModel.setValueAt("5", 0, 5);
		dModel.setValueAt("5", 0, 6);

		
		JFrame jf = new JFrame();
		
		JTable jt = new JTable(dModel);
		jf.add(new JScrollPane(jt));
		
		jf.setBounds(100,100,500,500);
		jf.setVisible(true);
	}
	

}
