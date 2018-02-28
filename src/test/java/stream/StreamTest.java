package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.junit.Test;

public class StreamTest {
	@Test
	public void testSimpleStream() {
		String[] s = { "1", "2" };
		Stream<String> stream = Arrays.asList(s).stream();
		s[0] = "3";
		stream.forEach(System.out::println);
		Map<String, String> map = new HashMap<>();
		map.put("s", "s");
		map.keySet().stream().forEach(System.out::println);

		List<Integer> list = new ArrayList<>();
		if (list.stream().allMatch(i -> false)) {
			System.out.println("all match");
		} else {
			System.out.println("not");
		}
	}
}
