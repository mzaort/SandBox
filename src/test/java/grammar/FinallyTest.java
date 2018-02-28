package grammar;

public class FinallyTest {

	public static String T = null;

	public static void main(String[] args) {
		String x = null;
		try {
			x = tryCatch();
		} catch (Throwable t) {

		}
		System.out.println(T);
		System.out.println(x);
	}

	public static String tryCatch() {
		try {
			int x = 6 / 2;
			System.out.println(x / 0);
			return "gogo";
		} finally {
			T = "ddd";
		}
	}
}
