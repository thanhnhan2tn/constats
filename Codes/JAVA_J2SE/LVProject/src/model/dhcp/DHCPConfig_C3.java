package model.dhcp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class DHCPConfig_C3 {

	// Doc file - lay chuoi ---------------------------
	public static String getChuoi() {
		try {
			File file = new File("E:\\XML_File\\dhcpd_conf.txt");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();
			String line;
			String chuoilay = "";
			while ((line = bufferedReader.readLine()) != null) {

				chuoilay = chuoilay + line + " \n ";
			}
			fileReader.close();

			return chuoilay;
		} catch (IOException e) {
			e.printStackTrace();
		}
		// ----------------------------------------
		return null;
	}

	public static void main(String[] args) {

		// Map<String, Object>[] myArray = (Map<String, Object>[]) new Map[10];

		// HashMap<String, List<String>>[] hm1 = (HashMap<String,
		// List<String>>[]) new HashMap[10];
		HashMap<String, List<String>> hm1 = new HashMap<String, List<String>>();

		List<String> subnet_multi = new ArrayList<String>();
		List<String> netmask_multi = new ArrayList<String>();
		List<String> range_multi = new ArrayList<String>();
		List<String> routers_multi = new ArrayList<String>();
		List<String> domain_name_multi = new ArrayList<String>();
		List<String> lease_time_multi = new ArrayList<String>();

		System.out.println("Chuoi da lay dc la: \n " + getChuoi());
		// Cau lenh than thanh, \\s+ giup split tat ca cac khoang trang, du "  "
		// hay ""
		String[] mang = getChuoi().split("\\s+");
		String[] mau = { "subnet", "netmask", "range", "routers",
				"domain-name-servers", "default-lease-time" };

		System.out.println(Arrays.asList(mang));

		try {

			for (int i = 0; i < mang.length; i++) {
				for (int k = 0; k < mau.length; k++) {
					if (mang[i].equals(mau[k])) {
						// hm1.put(mang[i], mang[i + 1]);
						if (mau[k].equals("subnet")) {
							subnet_multi.add(mang[i + 1]);
							hm1.put("subnet", subnet_multi);
						}
						else {
							subnet_multi.add(" ");
							hm1.put("subnet", subnet_multi);
						}
						k++;
					}

				}

			}

		} catch (ArrayIndexOutOfBoundsException ar) {

		}
		System.out.println("\n-----------Sau khi dua vao cac array--------");

		System.out.println(hm1.get("subnet"));
		System.out.println(hm1.get("netmask"));

		System.out.println(hm1.get("range"));
		System.out.println(hm1.get("routers"));
		System.out.println(hm1.get("domain-name-servers"));
		System.out.println(hm1.get("default-lease-time"));

	}
}
