import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

//Xu ly lai giai thuat o file nay
public class main_test_1_cach_khac {

	public static void swap(String a, String b) {
		String temp = a;
		a = b;
		b = temp;

	}

	public static void sortChuoiArray(String[] a) {
		int i, j;
		try {
			for (i = 0; i < a.length - 1; i++) {
				for (j = i + 2; j < a.length; j++) {
					 if ((!a[i].equals("address")) &&
					 (a[j].equals("address"))) {
					String temp = a[i];
					a[i] = a[j];
					a[j] = temp;
					
					
					 }
				}
			}
		} catch (ArrayIndexOutOfBoundsException ar) {
		}

		for (int m = 0; m < a.length; m++) {
			System.out.println(a[m]);
		}

	}

	public static void xuly(String[] a) {
		HashMap<String, List<String>> hm1 = new HashMap<String, List<String>>();

		List<String> address_multi = new ArrayList<String>();
		List<String> netmask_multi = new ArrayList<String>();
		List<String> gateway_multi = new ArrayList<String>();

		int i = 0;

		try {
			while (!a[i].equals(" ")) {

				if (a[i].equals("address")) {
					address_multi.add(a[i + 1]);
					hm1.put("address", address_multi);
				} else {
					address_multi.add(" ");
					hm1.put("address", address_multi);

				}

				if (a[i].equals("netmask")) {
					netmask_multi.add(a[i + 1]);
					hm1.put("netmask", netmask_multi);

				}

				if (a[i].equals("gateway")) {
					gateway_multi.add(a[i + 1]);
					hm1.put("gateway", gateway_multi);

				}
				i++;

			}

		} catch (ArrayIndexOutOfBoundsException ar) {
		}
		System.out.println(hm1.get("address"));
		System.out.println(hm1.get("netmask"));
		System.out.println(hm1.get("gateway"));

	}

	public static void main(String[] args) {
		// Can co 1 ham xu ly chuoi tot, cat khoang trang de chuyen thanh mang
		// xu ly tot hon
		String chuoi = "address 192.168.0.103 " + "netmask 255.255.255.0 "
				+ "gateway 192.168.0.1 " + "address 10.0.0.6 "
				+ "netmask 255.0.0.0 " + "gateway 10.0.0.1 ";

		String mang[] = chuoi.split(" ");
		System.out.println("------In ra chuoi vua xu ly--------");

		System.out.println(Arrays.asList(mang));
		System.out.println("-----------------------------");
		// -------------------

		// String[] mau = { "address", "netmask", "gateway" };
		// xuly(mang);

		sortChuoiArray(mang);
	}
}
