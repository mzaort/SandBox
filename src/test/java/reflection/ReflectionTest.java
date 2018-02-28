package reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

public class ReflectionTest {

	@Test
	public void testGetDeclaredMethod() throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		Method foo = Foo.class.getDeclaredMethod("Foo");
		foo.invoke(new Foo(), 1, 2, true);
	}

	public static class Foo {
		private void f() {
			System.out.println();
		}
	}
}
