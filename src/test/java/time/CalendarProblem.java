package time;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class CalendarProblem {
	public static void main(String[] args) {
		GregorianCalendar c = new GregorianCalendar(-3212008, 1243234, 30);
		Arrays.asList(c.get(Calendar.YEAR), c.get(Calendar.MONTH) + 1,
				c.get(Calendar.DAY_OF_MONTH)).stream()
				.forEach(System.out::println);
		System.out
				.println(TimeUnit.MILLISECONDS.toDays(new GregorianCalendar(1970, 0, 1)
						.getTimeInMillis()
						- new GregorianCalendar(1900, 0, 1).getTimeInMillis()));
		System.out.println((System.currentTimeMillis() - 
				new GregorianCalendar(1900, 0, 1).getTimeInMillis()) / (24d * 3600 * 1000));
		System.out.println(0.86396471065 * 24);
		
		//1453381319272 -2209107600000
		System.out.println((new Date().getTime() - new GregorianCalendar(1899, 11, 31).getTimeInMillis()) / 86400000.0);
		System.out.println(new Date().getTime() + "  " + new GregorianCalendar(1899, 11, 31).getTimeInMillis());
		System.out.println((new Date().getTime() - (-2209107600000L)) / 86400000.0);
		System.out.println(-2209104000000d / 86400000);
		System.out.println(new Date());
		System.out.println(System.currentTimeMillis());
		Date d = new Date();
		System.out.println(TimeUnit.MILLISECONDS.toMinutes(System.currentTimeMillis() - 1453430287580L));
		System.out.println(TimeUnit.MILLISECONDS.toMinutes(1453431897547L - 1453460640000L));
		System.out.println(new Date(0));
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		System.out.println(sdf.format(d));
		
		c = new GregorianCalendar(2016, 0, 22, 11, 38, 0);
		System.out.println(TimeUnit.MILLISECONDS.toMinutes(System.currentTimeMillis() - c.getTimeInMillis()));
		System.out.println(c.get(Calendar.HOUR_OF_DAY));
		System.out.println(c.getTimeZone());
		System.out.println(System.currentTimeMillis());
	}
}
