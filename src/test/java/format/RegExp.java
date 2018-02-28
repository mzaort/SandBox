package format;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp {
	public static void main(String[] args) {
		System.out.println("hoo".matches("\\w+"));
		System.out.println("hoo".matches("\\w+ "));
		System.out.println("hoo ".matches("\\w+"));

		System.out.println("fdsfds%1231%fsdfs".replace("%1231%", "ok"));

		String s = "hef, f12efje_wlf fewfjf ewfewfwef, fewfw";
		Pattern p = Pattern.compile("\\b\\w+\\b");
		Matcher matcher = p.matcher(s);
		while (matcher.find()) {
			System.out
					.println(String.format("%10d %10d %s", matcher.start(),
							matcher.end(),
							s.substring(matcher.start(), matcher.end())));
		}

		s = "12kay, ok, i wnat 321fs t32432krer2, time is googfs2fs2f";
		p = Pattern.compile("(\\d+)\\w+");
		matcher = p.matcher(s);
		while (matcher.find()) {
			System.out.println(String.format("%10d %10d %s %10s",
					matcher.start(), matcher.end(),
					s.substring(matcher.start(), matcher.end()),
					matcher.group(1)));
		}
		System.out.println(p.matcher(s).lookingAt());

		s = "Hello, this is. not good";
		p = Pattern.compile("[^\\w-_]+", Pattern.MULTILINE
				| Pattern.CASE_INSENSITIVE);
		String[] ss = p.split(s);
		Arrays.asList(ss).forEach(System.out::println);

		System.out.println();
		s = "Hello, this is. n---ot good";
		Arrays.asList(s.split("[^\\w-_]+")).forEach(System.out::println);
	}

	public boolean isPrime(int n) {
		if (n < 2) return false;
		int i = 2, L = (int) Math.sqrt(n);
		for (; i <= L && n % i != 0; i++);
		return i > L;
	}
}
