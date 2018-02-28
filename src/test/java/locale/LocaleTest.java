package locale;

import java.util.Locale;

import org.junit.Test;

public class LocaleTest {
	@Test
	public void testForLocale() {
		Locale l = Locale.forLanguageTag("ja");
		System.out.println(l.getLanguage() + l.getCountry());
	}
}
