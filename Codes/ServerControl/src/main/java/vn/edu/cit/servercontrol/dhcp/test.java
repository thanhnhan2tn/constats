package vn.edu.cit.servercontrol.dhcp;

public class test {

	public static void main(String[] args) {
		String a = "   Hieu tran  Minh ngoc   ";
		a = a.trim();
		a = a.replaceAll("\\s+", " ");
		int so = a.lastIndexOf(" ");
		int so2 = a.lastIndexOf(" ", a.lastIndexOf(" ") - 1);
		int so3 = a.lastIndexOf(" ",
				a.lastIndexOf(" ", a.lastIndexOf(" ") - 1) - 1);
		System.out.println(a);

		System.out.println(so);

		System.out.println(so2);
		System.out.println(so3);

	}
}
