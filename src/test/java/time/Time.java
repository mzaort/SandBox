package time;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Time {
	public static void main(String[] args) {
		System.out.println(System.currentTimeMillis());
		Arrays.asList(12, 3, 4).stream().forEach(System.out::println);
		System.out.println(new GregorianCalendar(1899, 11, 30, 12, 0, 0));
		System.out.println(new GregorianCalendar(1899, 11, 30, 12, 0, 0).toZonedDateTime());

		System.out.println(new Date());
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d = new Date();
		Calendar c = new GregorianCalendar();
		System.out.println(df.format(d));
		System.out.printf("%d/%d/%d %d:%d:%d\n", c.get(Calendar.YEAR), c.get(Calendar.MONTH) + 1,
				c.get(Calendar.DAY_OF_MONTH), c.get(Calendar.HOUR_OF_DAY), c.get(Calendar.MINUTE),
				c.get(Calendar.SECOND));
		System.out.println(c.get(Calendar.DST_OFFSET));
		System.out.println(c.get(Calendar.ZONE_OFFSET));
	}

}
