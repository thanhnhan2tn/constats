package Test_ThuaKe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public class main {

	public static void main(String[] args) {
		String chuoi = "address 192.168.0.103" + " address 10.0.0.1 "
				+ "netmask 255.0.0.0 ";

		HashMap<String, List<String>> hm1 = new HashMap<String, List<String>>();
		List<String> address_multi = new ArrayList<String>();
		List<String> netmask_multi = new ArrayList<String>();

		String mang[] = chuoi.split(" ");

		System.out.println(Arrays.asList(mang));
		try {
			int i = 0;
			while (!mang[i].equals(" ")) {
				if (mang[i].equals("address")) {

					address_multi.add(mang[i + 1]);
					hm1.put("address", address_multi);

				}

				if (mang[i].equals("netmask")) {

					netmask_multi.add(mang[i + 1]);
					hm1.put("netmask", netmask_multi);

				}

				i++;
			}

		} catch (ArrayIndexOutOfBoundsException ar) {

		}
		System.out.println(hm1.get("address").get(1));
		try {
			System.out.println(hm1.get("netmask").get(1));
		} catch (IndexOutOfBoundsException ie) {
		}
	}

}
