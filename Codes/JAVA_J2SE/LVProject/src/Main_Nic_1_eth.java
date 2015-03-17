//Giai thuat doc file tu txt va split chuoi -> chuyen thanh doi tuong qua hashmap, su dụng doi tuong.
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main_Nic_1_eth {

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

				chuoilay = chuoilay + line + "\n";

			}
			fileReader.close();

			return chuoilay;
		} catch (IOException e) {
			e.printStackTrace();
		}
		// ----------------------------------------
		return null;
	}

	public static void main(String[] args) throws Exception {

		//
		// hm1 dung luu tru gia tri values don le
		HashMap<String, String> hm1 = new HashMap<String, String>();
		// map dung de luu tru hang loat cac gia tri values vao 1 specified key
		// theo list array
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		// Dung List <String> de luu cac gia tri cung kieu String
		// (dns-nameservers, ...), dung phuong thuc List.add de add 1 phan tu
		// vao List
		List<String> valSetOne = new ArrayList<String>();

		// -------

		// Bat ngoai le giup chuong trinh hien ra ket qua
		System.out.println("Chuoi da lay dc la: \n " + getChuoi());

		String[] mang = getChuoi().split("\\s+");
		System.out.println(Arrays.asList(mang));

		try {
			int i = 0;
			String lay = "";
			String tong = "";
			while (!mang[i].equals(" ")) {

				if (mang[i].equals("iface") || mang[i].equals("address")
						|| mang[i].equals("inet")

						|| mang[i].equals("netmask")
						|| mang[i].equals("gateway")
						|| mang[i].equals("network")
						|| mang[i].equals("broadcast")) {
					// Put vao hash Table key and value hien co cua array
					// mang
					// []
					hm1.put(mang[i], mang[i + 1]);
					lay = lay + "<" + mang[i] + ">" + mang[i + 1] + "</"
							+ mang[i] + ">";
					// lay = "<nic>" + lay + "</nic>";
					System.out.println(lay);
				}

				if (mang[i].equals("broadcast")) {
					Nic n = new Nic(hm1.get("iface"), hm1.get("inet"),
							hm1.get("address"), hm1.get("netmask"),
							hm1.get("gateway"), hm1.get("network"),
							hm1.get("broadcast"), null);
					System.out.println("-------");
					System.out.println("iface " + n.getNic_id());
					System.out.println("inet " + n.getType());

					System.out.println("Address " + n.getAddress());
					System.out.println("Netmask " + n.getNetmask());
					System.out.println("Gateway " + n.getGateway());
					System.out.println("Network " + n.getNetwork());
					System.out.println("Broadcast " + n.getBroadcast());
					System.out.println("-------");

				}
				i++;
			}
			

		} catch (ArrayIndexOutOfBoundsException ar) {

		} catch (NullPointerException nu) {
		}

		System.out.println(Arrays.asList(mang));
		// System.out.println(hm1);
		// Map (1 key, n value)
		map.put("dns-nameservers", valSetOne);

		// Vong lap lay mang ra
		for (Map.Entry<String, List<String>> entry : map.entrySet()) {

			List<String> values = entry.getValue();
			System.out.println("Values con cua dns = " + values + "\n");
			System.out.println("---------------------------");
		}

	}
}