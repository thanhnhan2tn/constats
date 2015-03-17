package Test_ThuaKe;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class main_test_2_while {

	public static void main(String[] args) {
		try {
			File file = new File("E:\\XML_File\\test.txt");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				// stringBuffer.append(line);
				// stringBuffer.append("\n");
				if (line.equals("iface eth0 inet static")) {
					System.out.println("true");
				} else
					System.out.println("false");

			}
			fileReader.close();
			System.out.println("Contents of file:");
			System.out.println(stringBuffer.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
