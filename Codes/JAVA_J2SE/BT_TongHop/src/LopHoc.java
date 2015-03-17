import java.util.Scanner;

public class LopHoc {

	GiangVien gv;
	SinhVien[] sv;
	int n;// Si so lop
	private Scanner nhap;

	public LopHoc() {
		// mac nhien

	}

	public LopHoc(GiangVien gv, SinhVien[] sv, int n) {

		this.gv = gv;
		this.sv = sv;
		this.n = n;
	}

	public GiangVien getGv() {
		return gv;
	}

	public void setGv(GiangVien gv) {
		this.gv = gv;
	}

	public SinhVien[] getSv() {
		return sv;
	}

	public void setSv(SinhVien[] sv) {
		this.sv = sv;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public void Nhap() {
		// Dua luon doi tuong vao
		sv = new SinhVien[5];
		gv = new GiangVien();
		gv.Nhap();
		nhap = new Scanner(System.in);
		System.out.println("Moi ban nhap vao si so lop:");
		int n = nhap.nextInt();
		for (int i = 0; i <= n; i++) {
			System.out.println("Moi ban nhap vao sinh vien thu :" + (i + 1));
			sv[i] = new SinhVien();
			sv[i].Nhap();
		}

	}

	public void HienThi() {
		System.out.println("Ten GVCV:");
		gv.HienThi();
		System.out.println("DS Sinh Vien : ---------------");
		for (int i = 0; i < 3; i++) {
			sv[i].Hienthi();
		}
		System.out.println("-----------------------------------");

	}

}
