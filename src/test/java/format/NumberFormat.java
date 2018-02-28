package format;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberFormat {
	public static void main(String[] args) {
		BigDecimal bd = new BigDecimal("1111111111111111111111111111111111111111111111111111");
		System.out.println(bd.longValue() == Long.MAX_VALUE);
		System.out.println(bd.longValue());
		System.out.println(Integer.MAX_VALUE);
		System.out.println(bd.setScale(15, BigDecimal.ROUND_CEILING).stripTrailingZeros().toEngineeringString());
		
		
		System.out.println(String.format("%15.14e", new BigDecimal("-1111111111111125111111111111111111111111111111111")));
		System.out.println(String.format("%15.14E", new BigDecimal("1221221e16")));
		System.out.println(1 + Math.sin(1));
		System.out.println(String.format("%15.14E", new BigDecimal("1")));
		System.out.println(new BigDecimal("1000000000000000000000").toEngineeringString());
		System.out.println(Double.MAX_VALUE == Double.MAX_VALUE);
		System.out.println(String.format("%d %s", 2, null));
		System.out.println(Integer.MAX_VALUE);
		//bd = new BigDecimal("10E-2147483647").add(BigDecimal.TEN);
		System.out.println(bd);
		
		Pattern p = Pattern.compile("^[-+]?\\d+(\\.\\d*)?([eE][-+]?\\d+)?|[-+]?\\.\\d+([eE][-+]?\\d+)?$");
		Matcher matcher = p.matcher("1.2");
		printGroups(matcher);
		matcher = p.matcher("1.");
		printGroups(matcher);
		matcher = p.matcher(".2");
		printGroups(matcher);
		matcher = p.matcher("1.2E3000");
		printGroups(matcher);
		matcher = p.matcher("1.2E+3");
		printGroups(matcher);
		matcher = p.matcher("1.2E-3");
		printGroups(matcher);
		
		matcher = p.matcher(".2E-3");
		printGroups(matcher);
		
		Boolean bl = null;
		if(bl){
			System.out.println("))))");
		}
	}

	private static void printGroups(Matcher matcher) {
		if(matcher.matches()){
			int c = matcher.groupCount();
			for(int i = 0; i <= c; i++){
				System.out.print(matcher.group(i) + ' ');
			}
			System.out.println();
		}
	}
}
