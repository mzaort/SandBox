package format;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Date;

import org.junit.Test;

public class DateFormatTest {
	
	@Test
	public void testDataFormat() {
		SimpleDateFormat odf = new SimpleDateFormat("y");
		SimpleDateFormat df = new SimpleDateFormat();
		System.out.println(df.toPattern());
		System.out.println(odf.format(new Date()));
	}
	
	@Test
	public void testParseException() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yy-M-d");
		Date d = sdf.parse("112-9-2");
		System.out.println(d);
		System.out.println(ZoneId.getAvailableZoneIds().contains(null));
	}
	
	@Test
	public void testDateFormatWithSpace() throws ParseException {
		String format = "yyyy-MM-dd H:m";
		SimpleDateFormat dateF = new SimpleDateFormat(format);
		System.out.println(dateF.parse("2012-10-21 10:21"));
		System.out.println(dateF.parse("2012-10-21     10:21"));
		System.out.println(dateF.parse("2012-10-21    10:21"));
		System.out.println(dateF.parse("2012-10-21          10:21"));

		System.out.println(dateF.parse("2012-10-21   10:21"));
		System.out.println(dateF.parse("2012-10-21   10:21"));
	}
}
