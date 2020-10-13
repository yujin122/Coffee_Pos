import java.util.GregorianCalendar;

public class ex {

	public static void main(String[] args) {
		
		
		GregorianCalendar cal = new GregorianCalendar();
		cal.set(2020, 5, 1);
		
		int offset = cal.get(GregorianCalendar.DAY_OF_WEEK)-1;
		System.out.println(offset);
		offset += 7;
		System.out.println(offset);
		
		
		/*int num = daysInMonth(year, month);
		for(int i = 0; i < num; ++i) {
			calendar[offset / 7][offset % 7] = Integer.toString(i+1);
			++offset;
		}
	}*/
	}

}
