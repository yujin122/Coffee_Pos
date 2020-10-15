import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;
import javax.swing.table.*;

public class SalesManage extends JFrame{

	private String[] yearData = { "2018", "2019", "2020" };
	private String[] monthData = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" };

	private JFrame frame = new JFrame();

	MyCalendarModel model = new MyCalendarModel();
	JTable cal = new JTable(model);

	private int year_, month_;
	Object data;

	private ImageIcon icon;
	
	public SalesManage() {
		
		setTitle("매출 관리");
		setResizable(false);
		
		icon = new ImageIcon("image/payment.png");
		icon = imageSetSize(icon, 620, 600);
		
		JPanel background = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(),0,0,null);
			}
		};	
		
		setLocation(100, 100);
		setPreferredSize(new Dimension(630, 640));
		setSize(new Dimension(630, 640));
		
		JPanel selectJp = new JPanel(new GridLayout(1, 2));
		selectJp.setBorder(BorderFactory.createEmptyBorder(50, 30, 0, 200));
		selectJp.setOpaque(false);
		
		JPanel calendarJp = new JPanel();
		calendarJp.setOpaque(false);
		
		JPanel salesJp = new JPanel(new GridLayout(1, 2));
		salesJp.setOpaque(false);
		salesJp.setBorder(BorderFactory.createEmptyBorder(0, 30, 50, 50));
		
		JPanel allJp = new JPanel(new BorderLayout());
		allJp.setOpaque(false);


		JComboBox<String> year = new JComboBox<String>(yearData);
		year.setSize(62, 35);
		year.setSelectedIndex(2);
		selectJp.add(year);
		
		Calendar c = Calendar.getInstance();
		JComboBox<String> month = new JComboBox<String>(monthData);
		month.setSize(62, 35);
		month.setSelectedIndex(c.get(Calendar.MONTH));
		selectJp.add(month);

		JLabel daySales = new JLabel("매출 : " + "50000원");
		daySales.setFont(new Font("굴림", Font.BOLD, 22));
		
		daySales.setSize(50, 50);
		salesJp.add(daySales);

		JLabel totalSales = new JLabel((c.get(Calendar.MONTH) + 1) + "월 총매출 : " + "700000원");
		totalSales.setFont(new Font("굴림", Font.BOLD, 22));
		totalSales.setOpaque(true);
		totalSales.setSize(50, 50);
		salesJp.add(totalSales);

		calendarJp.add(cal);
		//calendarJp.setBackground(Color.WHITE);
		year_ = year.getSelectedIndex() + 2018;
		month_ = month.getSelectedIndex() + 1;

		model.setMonth(year.getSelectedIndex() + 2018, month.getSelectedIndex());

		myCalendar(cal);

		allJp.add(selectJp, BorderLayout.NORTH);
		allJp.add(calendarJp, BorderLayout.CENTER);
		allJp.add(salesJp, BorderLayout.SOUTH);
		
		background.add(allJp);
		
		add(background);
		
		setVisible(true);

		year.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				model.setMonth(year.getSelectedIndex() + 2018, month.getSelectedIndex());
				year_ = year.getSelectedIndex() + 2018;
				cal.repaint();

			}
		});

		month.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				model.setMonth(year.getSelectedIndex() + 2018, month.getSelectedIndex());
				month_ = month.getSelectedIndex() + 1;
				totalSales.setText(month_ + "월 총매출 : " + "700000원");
				cal.repaint();
			}
		});

		cal.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
				int row = cal.getSelectedRow();
				int col = cal.getSelectedColumn();

				data = model.getValueAt(row, col);

				String dayNum = null;

				if (data == null) {
					dayNum = " ";
				} else {
					dayNum = data.toString() + "일 ";
				}
				
				daySales.setText(dayNum + "매출 : " + "50000원");

				System.out.println(year_ + "년 " + month_ + "월 " + data + "일");
			}

			@Override
			public void mouseExited(MouseEvent e) {}

			@Override
			public void mouseEntered(MouseEvent e) {}

			@Override
			public void mouseClicked(MouseEvent e) {}
		});

		addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) { new Menu(); }
			
		});
	}

	// table 모델 class
	class MyCalendarModel extends AbstractTableModel {

		String[] days = { "일", "월", "화", "수", "목", "금", "토" };

		int[] lastDays = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		// 날짜 들어가는 배열
		String[][] calendar = new String[7][7];

		// 초기화
		public MyCalendarModel() {
			// header
			for (int i = 0; i < days.length; ++i) {
				calendar[0][i] = days[i];
			}
			for (int i = 1; i < 7; ++i) {
				for (int j = 0; j < 7; ++j) {
					calendar[i][j] = null;
				}
			}
		}

		@Override
		public int getColumnCount() {
			return 7;
		}

		@Override
		public int getRowCount() {
			return 7;
		}

		@Override
		public Object getValueAt(int row, int column) {
			return calendar[row][column];
		}

		@Override
		public void setValueAt(Object value, int row, int column) {
			calendar[row][column] = (String) value;
		}

		// 달마다 날짜 설정
		public void setMonth(int year, int month) {
			for (int i = 1; i < 7; ++i) {
				for (int j = 0; j < 7; ++j) {
					calendar[i][j] = null;
				}
			}

			GregorianCalendar cal = new GregorianCalendar();
			cal.set(year, month, 1);

			int offset = cal.get(GregorianCalendar.DAY_OF_WEEK) - 1;
			offset += 7;

			// 달 마지막 날짜
			int num = daysInMonth(year, month);
			for (int i = 0; i < num; ++i) {
				calendar[offset / 7][offset % 7] = Integer.toString(i + 1);
				++offset;
			}
		}

		// 윤년
		public boolean isLeapYear(int year) {
			if (year % 4 == 0)
				return true;

			return false;
		}

		public int daysInMonth(int year, int month) {
			int days = lastDays[month];
			if (month == 1 && isLeapYear(year)) {
				++days;
			}

			return days;
		}

	}

	// 캘린더 설정
	public void myCalendar(JTable table) {

		table.setGridColor(Color.DARK_GRAY);
		table.setSize(600, 600);
		table.setRowHeight(60);
		table.setRowHeight(0, 30); // header 높이
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setCellSelectionEnabled(true); // 셀 하나만 선택
		table.setSelectionBackground(Color.gray);

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		for (int i = 0; i < 7; i++) {
			table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		}

	}

	public ImageIcon imageSetSize(ImageIcon icon, int i, int j) {
		Image ximg = icon.getImage();
		Image yimg = ximg.getScaledInstance(i, j, java.awt.Image.SCALE_SMOOTH);
		ImageIcon xyimg = new ImageIcon(yimg);
		return xyimg;
	}
	
	public static void main(String[] args) {
		new SalesManage();
	}

}
