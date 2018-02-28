package regex;

import java.util.regex.Pattern;

import org.junit.Test;

public class RegularExpress {

	@Test
	public void testRange() {
		String reg = "(\\[[^\\]]+\\])?([^:,$!' +\\-*/%()&\"~@#^|\\\\;<>.?`={}\\[\\]]+!|'([^']|'')+'!)?[$]?[a-zA-Z]+[$]?\\d+"
				+ // like[ess-id]Sheet1!A2
				"|(\\[[^\\]]+\\])?([^:,$!' +\\-*/%()&\"~@#^|\\\\;<>.?`={}\\[\\]]+!|'([^']|'')+'!)?[$]?[a-zA-Z]+[$]?\\d*:[$]?[a-zA-Z]+[$]?\\d*"
				+ // like [ess-id]Sheet1!A:B
				"|(\\[[^\\]]+\\])?([^:,$!' +\\-*/%()&\"~@#^|\\\\;<>.?`={}\\[\\]]+!|'([^']|'')+'!)?[$]?[a-zA-Z]+[$]?\\d*:[$]?[a-zA-Z]*[$]?\\d+"
				+ // like [ess-id]Sheet1!A:1
				"|(\\[[^\\]]+\\])?([^:,$!' +\\-*/%()&\"~@#^|\\\\;<>.?`={}\\[\\]]+!|'([^']|'')+'!)?[$]?[a-zA-Z]*[$]?\\d+:[$]?[a-zA-Z]*[$]?\\d+"
				+ // like [ess-id]Sheet1!1:2
				"|(\\[[^\\]]+\\])?([^:,$!' +\\-*/%()&\"~@#^|\\\\;<>.?`={}\\[\\]]+!|'([^']|'')+'!)?[$]?[a-zA-Z]*[$]?\\d+:[$]?[a-zA-Z]+[$]?\\d*"; // like
		Pattern re = Pattern.compile(reg);
		System.out.println(re.matcher("'Shee!@#$%?,.<>[]t1'!A1").matches());
	}

	@Test
	public void testNumber() {
		Pattern numPattern = Pattern.compile("^[-+]?\\d+(\\.\\d*)?([eE][-+]?\\d+)?|[-+]?\\.\\d+([eE][-+]?\\d+)?$");
		System.out.println(numPattern.matcher("-1a").matches());
		System.out.println(numPattern.matcher(null).matches());
	}
}
