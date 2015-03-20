package Test_ThuaKe;

import java.util.Scanner;

public class Nguoi {
	String hoten;
	int namsinh;

	public Nguoi() {
		// TODO Auto-generated constructor stub
	}

	public Nguoi(String hoten, int namsinh) {
		super();
		this.hoten = hoten;
		this.namsinh = namsinh;
	}

	public String getHoten() {
		return hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	public int getNamsinh() {
		return namsinh;
	}

	public void setNamsinh(int namsinh) {
		this.namsinh = namsinh;
	}

	public void nhap() {
		Scanner nhap = new Scanner(System.in);
		System.out.println("Moi ban nhap vao ho ten:");
		this.hoten = nhap.nextLine();
		System.out.println("Moi ban nhap vao nam sinh");
		this.namsinh = nhap.nextInt();
	}

	public void hienthi() {
		System.out.println(" ho ten:" + this.hoten);
		System.out.println(" nam sinh" + this.namsinh);
	}
}
