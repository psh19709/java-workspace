package day21.date;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalendarApp2 {
	
	public static void main(String[] args) {
		Calendar now = Calendar.getInstance();
		Calendar birth = new GregorianCalendar(1997, 9, 9);
		
		long nowUnixTime = now.getTimeInMillis();
		long birthUnoxTime = birth.getTimeInMillis();
		
		long lifeUnixTime = nowUnixTime - birthUnoxTime;
		int days = (int) (lifeUnixTime/(60*60*24*1000));
		System.out.println("내가 몇일이나 살았을까?" + days);
	}

}
