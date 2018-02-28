package sandbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

public class CollectionTest {
	@Test
	public void testFilterStream() {
		List<String> sl = new ArrayList<>();
		sl.add("23");
		sl.add("fsdfsd");
		sl.add("1");
		System.out.println(sl);
		System.out.println(sl.stream().filter(e -> e.length() > 1).collect(Collectors.toList()));
		System.out.println(sl.remove(null));
	}

	@Test(expected = UnsupportedOperationException.class)
	public void testUnchangedList() {
		List<String> asList = Arrays.asList("1");
		System.out.println(asList);
		asList.add("fsdfs");
		System.out.println(asList);
	}

	@Test(expected = IllegalStateException.class)
	public void testReuseStream() {
		List<String> list = new ArrayList<>(Arrays.asList("a", "b", "ab", "bc"));
		Stream<String> stream = list.stream();
		System.out.println(stream.filter(e -> e.startsWith("a")).toArray(String[]::new));
		System.out.println(stream.filter(e -> e.startsWith("b")).toArray());
	}

	@Test
	public void testNullKey() {
		Map<String, String> map = new HashMap<>();
		map.put(null, "hello");
		System.out.println(map.get(null));
	}
}
