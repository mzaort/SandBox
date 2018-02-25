package sandbox;

import org.junit.Test;

public class NumberTest {

	@Test
	public void testAccuracy() {
		System.out.println(1.0 / 3);
		System.out.println(1. / 3 * 3);
		System.out.println(0.3333333333333333 * 3);
		System.out.println(0.9999999999999999);
		// System.out.println(0.33333333333333339 == 0.33333333333333338);
		System.out.println(0.3333333333333333 == 0.3333333333333332);
	}

}
