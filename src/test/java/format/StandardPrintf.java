package format;

import java.awt.Color;

import org.junit.Test;

public class StandardPrintf {
	@Test
	public void testPrintf() {
		System.out.printf("%% %10.4f%n", 12.3313123);
		System.out.printf("%d, %+d, %n%-+,6.2f, %1$d, %2$H\n", 12, 13, 16000.2);
		System.out.printf("%5.4s%n", "hello");
		
		System.out.printf("%d %s", 10, "Good Test");
		Color sourceColor = new Color(255, 255, 255);
		System.out.println(String.format("#%02x%02x%02x", sourceColor.getRed(), sourceColor.getGreen(), sourceColor.getBlue()));
	}
}
