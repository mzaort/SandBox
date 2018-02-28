package type;

import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

import org.junit.Test;

public class CalendarTest {
	@Test
	public void testBasic() {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTimeZone(TimeZone.getTimeZone("UTC"));
		calendar.set(2009, 10, 21, -9, -13, -22);
		System.out.println(SimpleDateFormat.getInstance().format(new Date(calendar.getTimeInMillis())));
	}

	@Test
	public void testCalendar() {
		System.out.println(null instanceof String);
		System.out.println(TimeZone.getTimeZone(ZoneId.systemDefault()).getRawOffset());
		System.out.println(TimeZone.getTimeZone(ZoneId.of("UTC")).getRawOffset());
		System.out.println(ZoneId.of("UTC"));

		System.out.println(TimeZone.getTimeZone(ZoneId.of("Asia/Shanghai")).getRawOffset() / (1000 * 3600));

		System.out.println(TimeZone.getTimeZone("UTC+08:00").getRawOffset() / (1000 * 3600));

		System.out.println(ZoneId.of("Asia/Tokyo").toString());
		System.out.println(ZoneId.of("Asia/Tokyo").getId());
		System.out.println(TimeZone.getDefault().getID());

		System.out.println(ZoneId.of("UTC+08:00"));
		System.out.println(TimeZone.getTimeZone(ZoneId.of("+08:00")).getRawOffset());
		System.out.println(TimeZone.getTimeZone(ZoneOffset.of("+08:00")).getRawOffset() / (1000 * 3600));
		System.out.println(TimeZone.getTimeZone(ZoneId.of("UTC+08:00")));

		System.out.println(
				TimeZone.getTimeZone(ZoneId.ofOffset("GMT", ZoneOffset.of("+08:00"))).getRawOffset() / (1000 * 3600));
		System.out.println(Locale.JAPANESE.toString());
	}
}
