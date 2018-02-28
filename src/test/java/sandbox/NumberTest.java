package sandbox;

import java.math.BigDecimal;
import java.time.ZoneId;
import java.util.TimeZone;

import org.junit.Test;

public class NumberTest {

	@Test
	public void testDoublePresentation() {
		double f = .1;
		double d = 1.;
		d++;
		System.out.println(f + d);
		System.out.println(Math.PI);
	}

	@Test
	public void testPositiveNegative() {
		System.out.println((int) -1.2);
		System.out.println((-1.2) - ((int) -1.2));
		Double D = 1.2;
		System.out.println(D.longValue());
		D = -1.2;
		System.out.println(D.longValue());
	}

	@Test
	public void testUnsigned() {
		byte b = -1;
		System.out.printf("%d\t%s\t%s\n", b, Byte.toString(b), Byte.toUnsignedInt(b));
		int i = 255;
		byte c = (byte) i;
		System.out.println(c);
	}

	@Test
	public void testDoubleAccuracy() {
		System.out.println(1.0 / 3);
		System.out.println(1. / 3 * 3);
		System.out.println(0.3333333333333333 * 3);
		System.out.println(0.9999999999999999);
		// Precision to 16 bit after dot
		System.out.println(0.33333333333333339 == 0.33333333333333338);
		System.out.println(0.3333333333333333 == 0.3333333333333332);
		System.out.println(3333333333.333333333333333 == 3333333333.333333333333999);
		System.out.println(3333333333.33333333 == 3333333333.33333339);
		System.out.println(3333333333.33333333);
		System.out.println(3333333333.33333339);
	}

	@Test
	public void testPow() {
		System.out.println(Math.pow(-1, 0.2));
		System.out.println(Math.pow(-1, 0.4));
		System.out.println(Math.pow(-5, 0.2));
		System.out.println(Math.pow(-5, 1.2));
		System.out.println(Math.pow(5, 1.2));
	}

	@Test
	public void testDouble() {
		System.out.println(Double.valueOf(Double.MAX_VALUE).longValue());
		System.out.println(Double.valueOf(Double.NaN).longValue());

		System.out.println(Double.MAX_VALUE + 1);
		System.out.println(Double.MAX_VALUE);
		System.out.println(Double.MAX_VALUE + Double.MAX_VALUE);

		System.out.println(Long.MAX_VALUE + 1);
		System.out.println(Long.MAX_VALUE);
		System.out.println(Long.MAX_VALUE + Long.MAX_VALUE);
		System.out.println(Double.MAX_VALUE + 1 == Double.MAX_VALUE);
	}

	@Test
	public void testDoubleParse() {
		Double d = Double.parseDouble("1e-324");
		System.out.println(d);
		d = Double.parseDouble("NaN");
		System.out.println(d + 1);
		int x = 1000_00;
		System.out.println(x);
		System.out.println(new BigDecimal("1e-324").doubleValue());
		// System.out.println(Double.parseDouble("10_000"));
		// System.out.println(new BigDecimal("10_100").doubleValue());
		System.out.println(TimeZone.getTimeZone("GMT+2"));
		System.out.println(TimeZone.getTimeZone(ZoneId.of("UTC+8")));
	}
}
