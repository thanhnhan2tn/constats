import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CopyOfTest_multi_value_multi_key_main {

	// Ghep cac phan xu ly chuoi vao day

	// Doc file - lay chuoi ---------------------------
	public static String getChuoi() {
		try {
			File file = new File("E:/XML_File/Nic_Config.txt");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();
			String line;
			String chuoilay = "";
			while ((line = bufferedReader.readLine()) != null) {

				chuoilay = chuoilay + line + " ";
			}
			fileReader.close();

			return chuoilay;
		} catch (IOException e) {
			e.printStackTrace();
		}
		// ----------------------------------------
		return null;
	}

	public static Nic loadTextConfigToObject() {

		// Yeu cau user cau hinh tuong tu nhu the nay, neu khong se bi loan thu
		// tu, ngoai ra co the bo di network va broadcast vi server tu hieu, ta
		// khong can can thiep
		String chuoi = getChuoi();
		HashMap<List<Integer>, List<String>> hm1 = new HashMap<List<Integer>, List<String>>();
		HashMap<String, List<String>> hm_dns = new HashMap<String, List<String>>();
		// nen su dung 1 hashmap dung cho dns - nameservers
		List<Integer> key_array = new ArrayList<Integer>();
		List<String> value_array = new ArrayList<String>();
		List<String> list_dns = new ArrayList<String>();
		// ---------
		String mang[] = chuoi.split(" ");

		try {
			int i = 0;
			while (!mang[i].equals(" ")) {
				if (mang[i].equals("iface") || mang[i].equals("inet")
						|| mang[i].equals("address")
						|| mang[i].equals("netmask")
						|| mang[i].equals("gateway")
						|| mang[i].equals("network")
						|| mang[i].equals("broadcast")) {

					key_array.add(i);
					value_array.add(mang[i + 1]);

				}

				if (mang[i].equals("dns-nameservers")) {
					list_dns.add(mang[i + 1]);

				}

				i++;
			}

		} catch (ArrayIndexOutOfBoundsException ar) {

		}

		hm1.put(key_array, value_array);
		hm_dns.put("dns-nameservers", list_dns);
		// System.out.print(hm1.get(key_array) + "\n");
		// System.out.print(hm_dns.get("dns-nameservers") + "\n");

		/*
		 * for (Map.Entry<List<Integer>, List<String>> entry : hm1.entrySet()) {
		 * List<Integer> keys = entry.getKey(); List<String> values =
		 * entry.getValue(); System.out.println("---------------------------");
		 * 
		 * System.out.println("Keys: = " + keys + "\n");
		 * System.out.println("Values " + values + "\n");
		 * System.out.println("---------------------------"); }
		 * 
		 * for (Map.Entry<String, List<String>> entry : hm_dns.entrySet()) {
		 * String keys = entry.getKey(); List<String> values = entry.getValue();
		 * System.out.println("---------------------------");
		 * 
		 * System.out.println("Keys: = " + keys + "\n");
		 * System.out.println("Values " + values + "\n");
		 * System.out.println("---------------------------"); }
		 */

		// Khoi tao mang eth[]
		Eth[] nic_multi;
		nic_multi = new Eth[1000];
		// Tao multi doi tuong eth
		try {
			int k = 0;
			for (int i = 0; i < 3; i++) {
				nic_multi[i] = new Eth(hm1.get(key_array).get(k), hm1.get(
						key_array).get(k + 1), hm1.get(key_array).get(k + 2),
						hm1.get(key_array).get(k + 3), hm1.get(key_array).get(
								k + 4), hm1.get(key_array).get(k + 5), hm1.get(
								key_array).get(k + 6));
				k = k + 7;
			}
		} catch (IndexOutOfBoundsException ib) {
		}
		// Tao doi tuong dns-nameservers;
		Dns dns = new Dns(hm_dns.get("dns-nameservers"));
		// Tao doi tuong Nic gom nhieu doi tuong eth
		System.out.println("// Tao doi tuong Nic gom nhieu doi tuong eth");

		Nic n = new Nic(nic_multi, dns);

		// In ra eth theo vong lap for
		/*
		 * try { for (eth et : n.getEths()) {
		 * 
		 * // get.... System.out.println(et.getName());
		 * System.out.println(et.getType());
		 * System.out.println(et.getAddress());
		 * System.out.println(et.getNetmask());
		 * System.out.println(et.getGateway());
		 * System.out.println(et.getNetwork());
		 * System.out.println(et.getBroadcast()); System.out.println();
		 * 
		 * }
		 * 
		 * }
		 * 
		 * catch (NullPointerException nul1) { }
		 */

		/*
		 * System.out.println(); try { System.out.println("dns-nameservers " +
		 * n.getMulti_dns().getDns().get(0));
		 * System.out.println("dns-nameservers " +
		 * n.getMulti_dns().getDns().get(1));
		 * System.out.println("dns-nameservers " +
		 * n.getMulti_dns().getDns().get(2));
		 * System.out.println("dns-nameservers " +
		 * n.getMulti_dns().getDns().get(3)); } catch (IndexOutOfBoundsException
		 * id) {
		 * 
		 * } System.out.println();
		 * 
		 * // -----------------------test in ra cac nic trong nic_multi[]
		 */
		return n;
	}

	public static void main(String[] args) {
		Nic n = loadTextConfigToObject();
		List<Eth> eth_list = new ArrayList<Eth>();
		eth_list = Arrays.asList(n.getEths());
		System.out.println("Tao doi tuong theo index "
				+ eth_list.get(0).getAddress());

		try {
			for (Eth et : n.getEths()) {

				System.out.println(et.getName());
				System.out.println(et.getType());
				System.out.println(et.getAddress());
				System.out.println(et.getNetmask());
				System.out.println(et.getGateway());
				System.out.println(et.getNetwork());
				System.out.println(et.getBroadcast());
				System.out.println();
			}
		} catch (NullPointerException nu) {
		}
		System.out.println("dns-nameservers  " + n.getMulti_dns().getDns());

	}
}
