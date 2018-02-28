package cmdline;

import java.util.ArrayList;
import java.util.List;

public class JavaCommandLine {
	public static void main(String[] args) {
		System.out.println(System.getProperty("maven"));
		List<String> list = JavaCommandLine.newArrayList();
		list.add("fsf");
		System.out.println(list);
	}

	public static <E> ArrayList<E> newArrayList() {
		return new ArrayList<E>();
	}
}
