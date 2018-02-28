package format;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import org.junit.Test;

public class SimpleDateFormatSample {
	
	@Test
	public void testSimpleDateFormat() throws ParseException {
		String[] dates = { "13:12" };
		String[] format = { "h:mm" };
		Date date = null;
		DateFormat standard = new SimpleDateFormat("yyyy-MMMM-dd hh:mm");
		standard.setTimeZone(TimeZone.getTimeZone(ZoneId.of("UTC")));
		for (int i = 0; i < format.length; i++) {
			DateFormat d = new SimpleDateFormat(format[i]);
			d.setTimeZone(TimeZone.getTimeZone(ZoneId.of("UTC")));
			for (int j = 0; j < dates.length; j++) {
				try {
					date = d.parse(dates[i]);
					System.out.println(standard.format(date));
					System.out
							.println(standard.format(new Date(date.getTime())));
					System.out.println(standard.format(new Date(0)));
					System.out.println(date.getTime());
					System.out.println(date.getTime() > 24 * 3600 * 1000);
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
		}

		SimpleDateFormat sdf2 = new SimpleDateFormat(format[0]);
		System.out.println(sdf2.parse(dates[0]).getTime());
		System.out.println(24 * 3600 * 1000);

		SimpleDateFormat sdf = new SimpleDateFormat(format[0]);
		sdf.setTimeZone(TimeZone.getTimeZone("UTC+8"));
		System.out.println(sdf.parse(dates[0]).getTime());
		System.out.println((sdf.parse(dates[0]).getTime() - sdf2
				.parse(dates[0]).getTime()) / (1000 * 3600));

		SimpleDateFormat sdf3 = new SimpleDateFormat("h:m");
		System.out.println(sdf.format(sdf3.parse("12:10")));

		GregorianCalendar calendar = new GregorianCalendar(
				TimeZone.getTimeZone(ZoneId.of("UTC")));
		int year = calendar.get(Calendar.YEAR);
		System.out.println(year);

		SimpleDateFormat sdf4 = new SimpleDateFormat("MMM");
		SimpleDateFormat sdf5 = new SimpleDateFormat("M");
		for (int i = 1; i <= 12; i++) {
			System.out.print("\""
					+ sdf4.format(sdf5.parse(i + "")).toUpperCase() + "\",");
		}

		System.out.println("年".equals("年"));
	}
	
	@Test
	public void testSample2() {
		String[] dates = { "2012-10-12 fsdfs" };
		String[] format = { "y-M-d" };
		Date date = null;
		DateFormat standard = new SimpleDateFormat("yyyy-MMMM-dd HH:mm");
		for (int i = 0; i < format.length; i++) {
			DateFormat d = new SimpleDateFormat(format[i]);
			d.setLenient(false);
			for (int j = 0; j < dates.length; j++) {
				try {
					date = d.parse(dates[i]);
					System.out.println(standard.format(date));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	@Test
	public void testSample3() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("y-M-d h:m");
		sdf.setTimeZone(TimeZone.getTimeZone(ZoneId.of("UTC")));

		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-d HH:mm");
		sdf2.setTimeZone(TimeZone.getTimeZone(ZoneId.of("UTC")));

		System.out.println(sdf2.format(sdf
				.parse("2001-10-1 2000000000000000000:-1")));
	}
	
	@Test
	public void testCalender() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd G");
		Calendar c = new GregorianCalendar(TimeZone.getTimeZone(ZoneId
				.of("UTC")));
		// c.set(0, 0, 0);
		System.out.println(sdf.format(c.getTime()));
		c.set(1, 1, 1);
		System.out.println(sdf.format(c.getTime()));

		c.set(2, 1, 1);
		System.out.println(sdf.format(c.getTime()));

		c.set(1990, 1, 1);
		c.set(Calendar.ERA, GregorianCalendar.AD);
		System.out.println(sdf.format(c.getTime()));

		System.out.println("_________________________________________________");
		c = new GregorianCalendar(TimeZone.getTimeZone(ZoneId.of("UTC")));
		c.set(2000, 1, 2);
		for (int i = 0; i < 12; i++) {
			c.set(Calendar.MONTH, i);
			System.out.println(i + "-" + c.getActualMinimum((Calendar.DATE))
					+ "-" + c.getActualMaximum((Calendar.DATE)));
		}
	}

	// https://en.wikipedia.org/wiki/Date_format_by_country
	String[] FORMATS_COMMON = { "yyyy-MM-dd", "yyyy MM dd", "MM/dd/yyyy",
			"MMM dd, yyyy", "MMMM dd, yyyy", "yyyy年M月d日", "yyyy年MM月dd日" };

	String[] FORMATS_NO_YEAR = { "MM-dd", "MM/dd", "MM dd", "MMM dd", "MMMM dd" };
}
