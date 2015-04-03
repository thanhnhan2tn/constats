package vn.edu.cit.servercontrol.dhcp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class DHCPConfig_C1 {

	// Doc file - lay chuoi ---------------------------
	public static String getChuoi() {
		try {
			File file = new File("E:/XML_File/dhcpd_conf.txt");
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
//
//	public static void main(String[] args) {
//		// Map<String, Object>[] myArray = (Map<String, Object>[]) new Map[10];
//
//		// HashMap<String, List<String>>[] hm1 = (HashMap<String,
//		// List<String>>[]) new HashMap[10];
//		HashMap<String, List<String>> hm1 = new HashMap<String, List<String>>();
//
//		List<String> subnet_multi = new ArrayList<String>();
//		List<String> netmask_multi = new ArrayList<String>();
//		List<String> range_multi = new ArrayList<String>();
//		List<String> routers_multi = new ArrayList<String>();
//		List<String> domain_name_multi = new ArrayList<String>();
//		List<String> lease_time_multi = new ArrayList<String>();
//
//		System.out.println("Chuoi da lay dc la: \n " + getChuoi());
//		String[] mang = getChuoi().split("\\s+");
//		// System.out.println(Arrays.asList(mang));
//		try {
//			int i = 0;
//			int k = 0;
//			while (!mang[i].equals(" ")) {
//				if (mang[i].equals("subnet")) {
//					subnet_multi.add(mang[i + 1]);
//					hm1.put("subnet", subnet_multi);
//				}
//				if (mang[i].equals("netmask")) {
//
//					netmask_multi.add(mang[i + 1]);
//					hm1.put("netmask", netmask_multi);
//				}
//				if (mang[i].equals("range")) {
//					if (mang[i + 1].endsWith(";")) {
//						mang[i + 1] = mang[i + 1].substring(0,
//								mang[i + 1].length() - 1);
//					}
//					if (mang[i + 2].endsWith(";")) {
//						mang[i + 2] = mang[i + 2].substring(0,
//								mang[i + 2].length() - 1);
//					}
//					range_multi.add(mang[i + 1]);
//					range_multi.add(mang[i + 2]);
//					hm1.put("range", range_multi);
//
//				}
//
//				if (mang[i].equals("routers")) {
//					if (mang[i + 1].endsWith(";")) {
//						mang[i + 1] = mang[i + 1].substring(0,
//								mang[i + 1].length() - 1);
//					}
//					routers_multi.add(mang[i + 1]);
//
//					hm1.put("routers", routers_multi);
//
//				}
//
//				if (mang[i].equals("domain-name-servers")) {
//					if (mang[i + 1].endsWith(";")) {
//						mang[i + 1] = mang[i + 1].substring(0,
//								mang[i + 1].length() - 1);
//					}
//					domain_name_multi.add(mang[i + 1]);
//					hm1.put("domain-name-servers", domain_name_multi);
//
//				}
//				if (mang[i].equals("default-lease-time")) {
//					if (mang[i + 1].endsWith(";")) {
//						mang[i + 1] = mang[i + 1].substring(0,
//								mang[i + 1].length() - 1);
//					}
//					lease_time_multi.add(mang[i + 1]);
//					hm1.put("lease-time", lease_time_multi);
//
//				}
//				i++;
//				// k++;
//				// System.out.println("dem = " + k);
//			}
//
//		} catch (ArrayIndexOutOfBoundsException ar) {
//
//		}
//		System.out.println("--------------In ra hashmap-----------------");
//
//		System.out.println(hm1.get("subnet"));
//		System.out.println(hm1.get("netmask"));
//		System.out.println(hm1.get("domain-name-servers"));
//		System.out.println(hm1.get("range"));
//		try {
//			System.out.println(hm1.get("routers"));
//		} catch (IndexOutOfBoundsException io) {
//		}
//		System.out.println(hm1.get("lease-time"));
//
//		System.out.println();
//
//		System.out.println("------------Khoi tao doi tuong------");
//
//		try {
//			Subnet sn1 = new Subnet(hm1.get("subnet").get(1), hm1
//					.get("netmask").get(1), hm1.get("range").get(2), hm1.get(
//					"range").get(3), hm1.get("domain-name-servers").get(1),
//					"hieuminh.com", hm1.get("routers").get(1),
//					"10.255.255.255", hm1.get("lease-time").get(1), "7200");
//			System.out.println(sn1.getSubnet());
//			System.out.println(sn1.getNetmask());
//			System.out.println(sn1.getRange1());
//			System.out.println(sn1.getRange2());
//			System.out.println(sn1.getDomain_name_server());
//			System.out.println(sn1.getRouter_gateway());
//
//		} catch (IndexOutOfBoundsException io) {
//		}
//	}
}
