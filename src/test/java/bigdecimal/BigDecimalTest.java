package bigdecimal;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.Test;

public class BigDecimalTest {

	@Test 
	public void testBigDecimal() {
		double x = -1e308;
		BigDecimal num = new BigDecimal(x);
		BigDecimal d = num.multiply(num);
		System.out.println(d.doubleValue());
		// when creating a BigDecimal, using a string, not a double. Because double can not be stored precisely
		System.out.println(BigDecimal.valueOf(1.2));
		System.out.println(new BigDecimal(1.2));
		
		x = 1.2;
		System.out.println(x);

		num = BigDecimal.valueOf(1);
		System.out.println(num.scale());
		System.out.println(num.signum());

	}
	
	@Test
	public void testScale() {
		System.out.println(BigDecimal.valueOf(-4.1).scale());
		System.out.println(BigDecimal.valueOf(-4.33).scale());
		System.out.println(BigDecimal.valueOf(-4.56).scale());
		System.out.println(BigDecimal.valueOf(-4.90).scale());
		System.out.println(BigDecimal.valueOf(-0.0).scale());
		System.out.println(BigDecimal.valueOf(0.00).scale());
		System.out.println(BigDecimal.valueOf(1.2).scale());
		System.out.println(BigDecimal.valueOf(1312).scale());
		System.out.println(BigDecimal.valueOf(-314).scale());
		System.out.println(BigDecimal.valueOf(4.90).scale());
	}
	
	@Test
	public void testCompareAndReminder() {
		System.out.println(BigDecimal.valueOf(0.0).compareTo(
				BigDecimal.valueOf(-0.0)));
		System.out.println(BigDecimal.valueOf(-34.1).remainder(BigDecimal.ONE));
		System.out
				.println(new BigDecimal("1.e2000").doubleValue() == Double.POSITIVE_INFINITY);
		//throw Exception if NaN or Infinite
		//System.out.println(new BigDecimal(Double.POSITIVE_INFINITY));
		System.out.println(Double.isNaN(Math.pow(-1, 0.5)));

		System.out.println(new BigDecimal(-1.25)
				.setScale(1, BigDecimal.ROUND_HALF_UP).stripTrailingZeros()
				.toPlainString());
		System.out.println(new BigDecimal("-0").signum());
		System.out.println(new BigDecimal("+0").signum());

		System.out.println(Math.pow(Math.E, 100000));
	}
	
	@Test
	public void testScaleAndPrecision() {
		BigDecimal bd = new BigDecimal("1.2345643243124242343244234234E+100");
		BigDecimal bd2 = new BigDecimal("1.2345643243124242343244234234E-100");
		BigDecimal bd3 = new BigDecimal("1.23456432E-100");
		System.out.println(bd.precision());
		System.out.println(bd.scale());
		// set precision scale - precision + precisionToSet
		System.out.println(bd.setScale(bd.scale() - (bd.precision() - 15), RoundingMode.DOWN).doubleValue());
		System.out.println(bd2.setScale(bd2.scale() - (bd2.precision() - 15), RoundingMode.DOWN).doubleValue());
		System.out.println(bd3.setScale(bd3.scale() - (bd3.precision() - 15), RoundingMode.DOWN).doubleValue());
		System.out.println(bd.setScale(9));
		
		BigDecimal bd4 = new BigDecimal("1.0E+15");
		BigDecimal bd5 = new BigDecimal("9.9");
		System.out.println(bd4.scale());
		System.out.println(bd4.unscaledValue());
		System.out.println(bd4.divide(bd5, RoundingMode.CEILING));
		// must set scale when using BigDecimal
		System.out.println(bd4.divide(bd5, Math.max(bd4.scale(), bd5.scale()), RoundingMode.CEILING));
		
		BigDecimal bd6 = new BigDecimal("242342131");
		// throw exception -- must using round
		// System.out.println(bd6.setScale(-5)); 
	}
	
	@Test
	public void testScientificNotation() {
		/*
		 * The toString method for a BigDecimal behaves differently based on the scale and precision. (Thanks to @RudyVelthuis for pointing this out.)
		 * If scale == 0, the integer is just printed out, as-is.
		 * If scale < 0, E-Notation is always used (e.g. 5 scale -1 produces "5E+1")
		 * If scale >= 0 and precision - scale -1 >= -6 a plain decimal number is produced (e.g. 10000000 scale 1 produces "1000000.0")
		 * Otherwise, E-notation is used, e.g. 10 scale 8 produces "1.0E-7" since precision - scale -1 equals  is less than -6.
		 */
		BigDecimal bd = null;
		bd = new BigDecimal("111e-3");
		System.out.println(bd.toString());
	}
	
	@Test
	public void testRange() {
		BigDecimal bd = new BigDecimal("1.2E1000");
		System.out.println(bd.intValue() + 1);
		System.out.println(bd.intValue() == Integer.MAX_VALUE);
	}
}
