package model.dhcp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class DHCPConfig_C2 {

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
		List<String> domain_name_multi_options = new ArrayList<String>();
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
		System.out.println(Arrays.asList(mang));
		try {
			int i = 0;
			while (!mang[i].equals(" ")) {
				if (mang[i].equals("subnet")) {

					subnet_multi.add(mang[i + 1]);
					hm1.put("subnet", subnet_multi);

					if (mang[i + 2].equals("netmask")) {

						netmask_multi.add(mang[i + 3]);
						hm1.put("netmask", netmask_multi);

					} else {
						netmask_multi.add(" ");
						hm1.put("netmask", netmask_multi);
					}
					if (mang[i + 5].equals("range")) {

						range_multi.add(mang[i + 6]);
						range_multi.add(mang[i + 7]);
						hm1.put("range", range_multi);

					} else {
						range_multi.add(" ");
						range_multi.add(" ");

						hm1.put("range", range_multi);
					}

					if (mang[i + 9].equals("routers")) {

						routers_multi.add(mang[i + 10]);

						hm1.put("routers", routers_multi);

					} else {
						routers_multi.add(" ");
						hm1.put("routers", routers_multi);

					}
					if (mang[i + 12].equals("domain-name-servers")) {

						domain_name_multi.add(mang[i + 13]);
						hm1.put("domain-name-servers", domain_name_multi);

					} else {
						domain_name_multi.add(" ");
						hm1.put("domain-name-servers", domain_name_multi);
					}
					if (mang[i + 14].equals("default-lease-time")) {

						lease_time_multi.add(mang[i + 15]);
						hm1.put("lease-time", lease_time_multi);

					} else {
						lease_time_multi.add(" ");
						hm1.put("lease-time", lease_time_multi);
					}

				} else {
					if (mang[i].equals("domain-name-servers")) {
						domain_name_multi_options.add(mang[i + 1]);

						hm1.put("domain-name-options",
								domain_name_multi_options);

					}

				}

				i++;
			}

		} catch (ArrayIndexOutOfBoundsException ar) {

		}
		System.out.println("\n-----------Sau khi dua vao cac array--------");

		System.out.println(hm1.get("subnet"));
		System.out.println(hm1.get("netmask"));

		System.out.println(hm1.get("range"));
		System.out.println(hm1.get("routers"));
		System.out.println(hm1.get("domain-name-servers"));
		System.out.println(hm1.get("lease-time"));
		System.out.println(hm1.get("domain-name-options"));

	}

}
