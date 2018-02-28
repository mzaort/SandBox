package format;

import org.junit.Test;

public class FullWidthCharacters {
	@Test
	public void testCodePoint() {
		String s = "ｶﾞ";
		for (int i = 0; i < s.length(); i++) {
			System.out.println("charat " + i + ": " + s.charAt(i));
		}

		System.out.println(new String(Character
				.toChars(Character.MIN_SUPPLEMENTARY_CODE_POINT + 19)));
	}
}
