package model.nic;
//Giai thuat doc file tu txt va split chuoi -> chuyen thanh doi tuong qua hashmap, su dụng doi tuong.
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

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
				line = line.trim();
				if (line.indexOf("\\s+") != -1) {
					line.replaceAll("\\s+", "");
				} else {
					chuoilay = chuoilay + line + "\n";
				}
			}
			fileReader.close();

			return chuoilay;
		} catch (IOException e) {
			e.printStackTrace();
		}
		// ----------------------------------------
		return null;
	}

	public static String TextXMl() {
		HashMap<String, String> hm1 = new HashMap<String, String>();

		// System.out.println("Chuoi da lay dc la: \n " + getChuoi());

		String[] mang = getChuoi().split("\\s+");
		// System.out.println(Arrays.asList(mang));
		// System.out.println(mang.length);

		String lay = "";
		try {
			int i = 0;
			while (!mang[i].equals(null)) {
				// System.out.println("Vong lap thu " + i);

				if (mang[i].equals("iface") || mang[i].equals("address")
						|| mang[i].equals("inet") || mang[i].equals("netmask")
						|| mang[i].equals("gateway")
						|| mang[i].equals("network")
						|| mang[i].equals("broadcast")) {
					// Put vao hash key and value hien co cua array
					// mang
					hm1.put(mang[i], mang[i + 1]);
					if (mang[i].equals("iface") && i != 0
							&& i != mang.length - 1) {
						lay = lay + "\n</eth>\n<eth>\n" + "<" + mang[i] + ">"
								+ mang[i + 1] + "</" + mang[i] + ">" + "\n";
					} else {
						lay = lay + "<" + mang[i] + ">" + mang[i + 1] + "</"
								+ mang[i] + ">" + "\n";
					}
					// System.out.println(lay);

				}

				i++;

			}

		} catch (ArrayIndexOutOfBoundsException ar) {

		} catch (NullPointerException nu) {
		}
		// chen vao the dau-cuoi
		return "<nic>" + "\n" + "<eth>\n" + lay + "\n" + "</eth>\n" + "</nic>";// Bien
																				// return
																				// tra
																				// ve
																				// phai
		// nam o ngoai
		// try moi co hieu luc
		// luu y neu return dat trong vong lap se break ra ngoai vong lap
	}

	public static void main(String[] args) throws Exception {

		System.out.println("Text to XML : \n " + TextXMl());

		
	}
}