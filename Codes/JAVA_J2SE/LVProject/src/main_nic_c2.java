//Giai thuat doc file tu txt va split chuoi -> chuyen thanh doi tuong qua hashmap, su dụng doi tuong.
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class main_nic_c2 {

	public static String getText() throws IOException {

		File file = new File("E:/XML_File/Nic_Config.txt");
		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		StringBuffer stringBuffer = new StringBuffer();
		String line;
		String chuoilay = "";
		while ((line = bufferedReader.readLine()) != null) {

			line = line.trim();
			line = line.replaceAll("\\s+", " ");
			// chuoilay = chuoilay.replaceAll("\\s+", " ");
			chuoilay = chuoilay + line + "\n";
			// chuoilay = chuoilay.replaceAll("\\n+", "\n");
			System.out.println(line.length());

		}
		fileReader.close();
		return chuoilay;

	}

	// Doc file - lay chuoi ---------------------------
	public static List<Nic> getListNic() {

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
		List<Nic> nic_multi = new ArrayList<Nic>();

		// Bat ngoai le giup chuong trinh hien ra ket qua
		try {
			File file = new File("E:/XML_File/Nic_Config.txt");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();
			String line;
			String chuoilay = "";
			int i = 0;
			while ((line = bufferedReader.readLine()) != null) {
				// stringBuffer.append(line);
				// stringBuffer.append("\n");
				// Luu y ki tu "\n" va " " rat quan trong se lam code chay ko ra
				// ket
				// qua
				// line = line.replaceAll("\\n+", "\\n");
				line = line.trim();

				line = line.replaceAll("\\s+", " ");
				System.out.println(line.length());
				if (line.indexOf("iface") != -1) {
					hm1.put("iface", line.substring(6, 10));
					hm1.put("inet", line.substring(16));

					System.out.println(hm1.get("iface"));
					System.out.println(hm1.get("inet"));

				}
				if (line.indexOf("address") != -1) {
					hm1.put("address", line.substring(8));
					System.out.println(hm1.get("address"));
				}

				if (line.indexOf("netmask") != -1) {
					hm1.put("netmask", line.substring(8));
					System.out.println(hm1.get("netmask"));

				} 

				if (line.indexOf("gateway") != -1) {
					hm1.put("gateway", line.substring(8));
					System.out.println(hm1.get("gateway"));

				}

				if (line.indexOf("network") != -1) {
					hm1.put("network", line.substring(8));
					System.out.println(hm1.get("network"));

				}

				if (line.indexOf("broadcast") != -1) {
					hm1.put("broadcast", line.substring(10));
					System.out.println(hm1.get("broadcast"));

				}
				if (line.indexOf("dns-nameservers") != -1) {

				}
				System.out.println("vong lap thu " + i);
				System.out.println("---------------");

				if (line.length() == 0) {

					Nic n = new Nic(hm1.get("iface"), hm1.get("inet"),
							hm1.get("address"), hm1.get("netmask"),
							hm1.get("gateway"), hm1.get("network"),
							hm1.get("broadcast"), null);
					System.out.println("-----------" + i);
					System.out.println(n.getNic_id());
					System.out.println(n.getType());
					System.out.println(n.getAddress());
					System.out.println(n.getNetmask());
					System.out.println(n.getGateway());
					System.out.println(n.getNetwork());
					System.out.println(n.getBroadcast());

					System.out.println("-----end------");
					nic_multi.add(n);
					System.out.println(nic_multi);
					// hm1.put("iface",null);
					// hm1.put("inet",null);
					// hm1.put("address",null);
					// hm1.put("netmask",null);
					// hm1.put("gateway",null);
					// hm1.put("network",null);
					// hm1.put("broadcast",null);

				}

				else {

				}
				i++;
			}
			fileReader.close();
			return nic_multi;

		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) throws Exception {
		//System.out.println(getText());
		// ----

		List<Nic> n1 = getListNic();
		try {
			System.out.println("nic thu 0 = " + n1.get(0).getNic_id());
			System.out.println("nic thu 0 = " + n1.get(0).getType());
			System.out.println("nic thu 0 = " + n1.get(0).getAddress());
			System.out.println("nic thu 0 = " + n1.get(0).getNetmask());
			System.out.println("nic thu 0 = " + n1.get(0).getGateway());
			System.out.println("nic thu 0 = " + n1.get(0).getNetwork());
			System.out.println("nic thu 0 = " + n1.get(0).getBroadcast());
			System.out.println("---------------- ");
			System.out.println("nic thu 1 = " + n1.get(1).getNic_id());
			System.out.println("nic thu 1 = " + n1.get(1).getType());
			System.out.println("nic thu 1 = " + n1.get(1).getAddress());
			System.out.println("nic thu 1 = " + n1.get(1).getNetmask());
			System.out.println("nic thu 1 = " + n1.get(1).getGateway());
			System.out.println("nic thu 1 = " + n1.get(1).getNetwork());
			System.out.println("nic thu 1 = " + n1.get(1).getBroadcast());
			System.out.println("---------------- ");
			System.out.println("nic thu 2 = " + n1.get(2).getNic_id());
			System.out.println("nic thu 2 = " + n1.get(2).getType());
			System.out.println("nic thu 2 = " + n1.get(2).getAddress());
			System.out.println("nic thu 2 = " + n1.get(2).getNetmask());
			System.out.println("nic thu 2 = " + n1.get(2).getGateway());
			System.out.println("nic thu 2 = " + n1.get(2).getNetwork());
			System.out.println("nic thu 2 = " + n1.get(2).getBroadcast());
			System.out.println("---------------- ");

		} catch (IndexOutOfBoundsException ie) {
		}

	}
}