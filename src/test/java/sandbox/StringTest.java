package sandbox;

import java.util.Arrays;
import java.util.Objects;

import org.junit.Test;

public class StringTest {

	@Test
	public void testJoin() {
		String[] str = { "1", "2", "3" };
		System.out.println(String.join("-|", str));
		int[] arr = { 1, 2, 5, 3 };
		System.out.println(Arrays.toString(arr));
	}

	@Test
	public void testReplace() {
		System.out.println("abc".replaceAll("", "eee"));
		System.out.println("abc".substring(2, 2));
		System.out.println(replace("abc", "", "eee"));

		System.out.println("aabca".replace("A", "b"));
		System.out.println("fsdfs".replace("", "ddd"));
		System.out.println("fsdfs".replace("".subSequence(0, 0), "ddd".subSequence(0, 3)));
		System.out.println("fsfs".indexOf("fdsfsd", 1000));
		System.out.println("fdsfs".indexOf("", 2));

		System.out.println("fsdfs".replaceAll("", "ddd"));
	}

	@Test
	public void testSplit() {
		System.out.println(Arrays.asList(",a,,b,".split(",")));
	}

	public static final String replace(String source, String x, String y) {
		Objects.requireNonNull(x);
		Objects.requireNonNull(y);

		if (source == null) return null;

		StringBuilder sb = new StringBuilder();
		if (x.length() == 0) {
			sb.append(y);
			for (int i = 0; i < source.length(); i++) {
				sb.append(source.charAt(i)).append(y);
			}
		} else {
			for (int i = 0; i < source.length();) {
				int j = source.indexOf(x, i);
				if (j >= 0) {
					sb.append(source.substring(i, j)).append(y);
					i = j;
				} else {
					sb.append(source.substring(i));
					break;
				}
			}
		}

		return sb.toString();
	}

	@Test
	public void testCompare() {
		System.out.println("A".compareTo("我"));
		System.out.println("a".compareTo("ab"));
		System.out.println("".compareTo("a"));
	}

	@Test
	public void testCodepoint() {
		String s = "𠮷";
		int cp = s.codePointAt(0);

		System.out.println(Character.isSurrogate(s.charAt(0)));
		System.out.println(Character.isSupplementaryCodePoint(cp));

		for (int i = 0; i < s.length();) {
			cp = s.codePointAt(i);
			System.out.print(Character.toChars(cp));
			i += Character.charCount(cp);
			System.out.println(Character.charCount(cp));
		}

		System.out.println(Character.toChars(Character.MIN_SUPPLEMENTARY_CODE_POINT + 19).length);

		System.out.println(Character.isHighSurrogate((char) 0xff9e));
		System.out.println(Character.isLowSurrogate((char) 0xff9e));
		// System.out.println(new String(Character.toChars((0xff9e << 16)
		// + (codePoint - 0x30ac) / 2 + 0xff76)));
	}
}
