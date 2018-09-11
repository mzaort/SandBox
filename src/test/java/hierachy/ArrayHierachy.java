package hierachy;

import org.junit.Test;

public class ArrayHierachy {
	@Test
	public void testArrayHierachy() {
		String[] a = { "a", "b" };
		System.out.println(a instanceof String[]);
		System.out.println(a instanceof Object[]);
	}
}
