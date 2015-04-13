package model.dns;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class TextPatern {

	public static void main(String[] args) throws IOException,
			PatternSyntaxException, IllegalStateException {
		FileReader fr = new FileReader(new File("E:/chuoi.txt"));
		BufferedReader br = new BufferedReader(fr);
		String line = "";
		String chuoi = "";
		while ((line = br.readLine()) != null) {
			chuoi = chuoi + line.trim() + "\n";
		}
	//	System.out.println(chuoi);

		String regex = "forwarders\\{\n[\\d+.\\d+.\\d+.\\d+;\n]+\\}";
		// String regex2 = "[\\d+.\\d+.\\d+.\\d+;\n]+";
		// String forwarders = "";
		// Boolean boo = chuoi.matches(regex);
		// System.out.println(boo);

		Pattern pt = Pattern.compile(regex);
		Matcher matcher = pt.matcher(chuoi);
		while (matcher.find()) {// Neu cam thay xuat hien doi tuong nhieu lan,
								// co the
			// dung while
			System.out.println(matcher.start());
			System.out.println(matcher.end());
			System.out.println(matcher.group());
		}
		// forwarders = matcher.group();
		// System.out.println(forwarders);
		// pt = Pattern.compile(regex2);
		// matcher = pt.matcher(forwarders);
		// matcher.find();
		// System.out.println("<forwarders>" + matcher.group() +
		// "</forwarders>");

	}
}
