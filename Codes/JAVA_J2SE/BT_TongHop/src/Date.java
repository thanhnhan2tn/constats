import java.util.Scanner;

public class Date {
	String ngay;
	String thang;
	String nam;

	public Date(String ngay, String thang, String nam) {
		super();
		this.ngay = ngay;
		this.thang = thang;
		this.nam = nam;
	}

	public Date() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getNgay() {
		return ngay;
	}

	public void setNgay(String ngay) {
		this.ngay = ngay;
	}

	public String getThang() {
		return thang;
	}

	public void setThang(String thang) {
		this.thang = thang;
	}

	public String getNam() {
		return nam;
	}

	public void setNam(String nam) {
		this.nam = nam;
	}

	public void nhap() {
		Scanner nhap = new Scanner(System.in);
		System.out.println("Moi ban nhap vao Ngay:");
		this.ngay = nhap.nextLine();
		System.out.println("Moi ban nhap vao Thang:");
		this.thang = nhap.nextLine();
		System.out.println("Moi ban nhap vao Nam:");
		this.nam = nhap.nextLine();

	}

	public void in() {
		System.out.println(" Ngay:" + this.ngay);
		System.out.println("Thang:" + this.thang);
		System.out.println("Nam:" + this.nam);

	}

}
