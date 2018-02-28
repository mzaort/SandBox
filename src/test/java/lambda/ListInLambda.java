package lambda;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

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
}
