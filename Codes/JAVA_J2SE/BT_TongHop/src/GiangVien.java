import java.util.Scanner;

public class GiangVien extends Nguoi {
	String khoa;

	public GiangVien() {
		super();
		this.khoa = "";
	}

	

	public GiangVien(String hoten, int ngaysinh, Date date) {
		super(hoten, ngaysinh, date);
		// TODO Auto-generated constructor stub
	}



	public String getKhoa() {
		return khoa;
	}

	public void setKhoa(String khoa) {
		this.khoa = khoa;
	}

	public void Nhap() {
		Scanner nhap = new Scanner(System.in);
		super.Nhap();
		System.out.println("Moi ban nhap vao Khoa:");
		this.khoa = nhap.nextLine();

	}

	public void HienThi() {
		super.Hienthi();
		System.out.println("Khoa: " + this.khoa + "\n");

	}

}
