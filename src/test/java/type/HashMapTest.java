package type;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class HashMapTest {

	@Test
	public void testConcurrency() throws InterruptedException {
		Map<String, String> op = new HashMap<>();
		Runnable r = () -> {
			for (int i = 0;; i++) {
				op.put(String.valueOf((int) (Math.random() * 100)), String.valueOf(i));
			}
		};
		Thread[] t = new Thread[10];
		for (int i = 0; i < t.length; i++) {
			t[i] = new Thread(r);
			t[i].start();
		}
		for (Thread e : t)
			e.join();
	}

}
