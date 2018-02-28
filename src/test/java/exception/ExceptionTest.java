package exception;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class ExceptionTest {
	@Test
	public void testLambdaException() {
		/*
		 * A lambda expression must catch checked exception.
		 * But,
		 * Outer can catch its unchecked exception
		 */
		List<Integer> list = Arrays.asList(1, 2, 3, 4);
		try {
			list.forEach(e -> {
				// throw new Exception("");
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
