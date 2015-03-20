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

public class NicConfig {
	// Bat buot ng dung nhap day du vao cac o trong View - *.jsp
	// Ghep cac phan xu ly chuoi vao day

	// getChuoi
	public static String getChuoi() {
		try {
			File file = new File("E:/XML_File/Nic_Config.txt");
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

	// loadTextConfigtoObject
	public static Nic loadTextConfigToObject() {

		// Yeu cau user cau hinh tuong tu nhu the nay, neu khong se bi loan thu
		// tu, ngoai ra co the bo di network va broadcast vi server tu hieu, ta
		// khong can can thiep
		String chuoi = getChuoi();
		// System.out.println(chuoi);
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
			while (!mang[i].equals("\\s+")) {
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
		// System.out.println("// Tao doi tuong Nic gom nhieu doi tuong eth");

		Nic n = new Nic(nic_multi, dns);

		return n;
	}

	// upload Config to Server
	public boolean uploadConfigToServer() {

		return true;
	}

	// getEth theo index
	public static Eth getEth(int index) {
		try {
			Nic n = loadTextConfigToObject();
			List<Eth> eth_list = new ArrayList<Eth>();
			eth_list = Arrays.asList(n.getEths());
			System.out.println(eth_list.get(index).getName());
			System.out.println(eth_list.get(index).getType());
			System.out.println(eth_list.get(index).getAddress());
			System.out.println(eth_list.get(index).getNetmask());
			System.out.println(eth_list.get(index).getGateway());
			System.out.println(eth_list.get(index).getNetwork());
			System.out.println(eth_list.get(index).getBroadcast());
			System.out.println();
			return eth_list.get(index);
		} catch (NullPointerException nu) {
		}
		return null;
	}

	// get Dns-nameserver
	public static Dns getDns() {
		Nic n = loadTextConfigToObject();

		return n.getMulti_dns();
	}

	// Dieu khien dich vu
	// start
	public boolean start() {
		return true;
	}

	// stop
	public boolean stop() {
		return true;
	}

	// restart
	public boolean restart() {
		return true;
	}

	// Cai dat dich vu
	public boolean install() {
		return true;

	}

	// Huy dich vu
	public boolean remove() {
		return true;

	}

	public static void main(String[] args) {
		getEth(2);
		getEth(1);
		getEth(0);

	}
}
