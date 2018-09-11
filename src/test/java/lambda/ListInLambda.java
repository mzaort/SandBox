package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

import org.junit.Test;

import com.google.common.base.Predicate;

public class ListInLambda {

	@Test
	public void testList() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "2");

		Arrays.asList(1, 2, 3).forEach(e -> {
			if (map.containsKey(e)) {
				System.out.println(map.get(e));
			} else {
				map.put(e, String.valueOf(e));
			}
		});

		System.out.println("-------------");
		System.out.println(map);
	}

	@Test
	public void testLambda() {
		Predicate<String> predicate1 = s -> {
			return !s.equals("c");
		};
		Consumer<String> consumer1 = s -> {
			System.out.println(s);
		};
		Function<String, String> mapper1 = s -> {
			return s + s.length();
		};
		Comparator<String> comparator1 = (s1, s2) -> {
			return s1.compareTo(s2);
		};

		List<String> list = new ArrayList<>(Arrays.asList("aa", "bfds", "acfs", "dfsd", "fsadfsafsafe"));
		Stream<String> s1 = list.stream();
		Stream<String> s2 = s1.filter(predicate1);
		Stream<String> s3 = s2.map(mapper1);
		Stream<String> s4 = s3.sorted(comparator1);
		Stream<String> s5 = s4.skip(2);
		s5.forEach(consumer1);
	}
}
