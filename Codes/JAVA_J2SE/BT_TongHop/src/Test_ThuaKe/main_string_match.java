package Test_ThuaKe;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class main_string_match {

	public static void main(String[] args) {
		HashMap<String, List<String>> hm1 = new HashMap<String, List<String>>();
		List<String> address = new ArrayList<String>();
		List<String> netmask = new ArrayList<String>();

		String s3 = "broadcast 192.168.0.255";
		System.out.println("Chuoi lay dc = " + s3);
		Boolean match = s3.matches("broadcast \\d\\d\\d.\\d\\d\\d.\\d.255");

		System.out.println(match);
		
	}
}
