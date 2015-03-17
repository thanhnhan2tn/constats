import java.util.Scanner;

public class SinhVien extends Nguoi {

	float DTB;

	// Ham xay dung

	public SinhVien() {
		super();
	}

	// Ben xml convert se dung ham nay
	public SinhVien(String hoten, int ngaysinh, Date date, float dtb) {
		super(hoten, ngaysinh, date);
		this.DTB = dtb;
		// TODO Auto-generated constructor stub
	}

	public float getDTB() {
		return DTB;
	}

	public void setDTB(float dTB) {
		DTB = dTB;
	}

	public void Nhap() {
		super.Nhap();
		Scanner nhap = new Scanner(System.in);
		System.out.println("Moi ban nhap vao DTB:");
		this.DTB = nhap.nextFloat();

	}

	public void Hienthi() {
		super.Hienthi();
		System.out.println("DTB: " + getDTB() + "\n");

	}
}
