import java.util.Scanner;

/**
 * 
 */

/**
 * @author Notexittran
 *
 */
public class Nguoi {
	protected String hoten;
	protected int ngaysinh;
	Date date;

	public Nguoi() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Nguoi(String hoten, int ngaysinh, Date date) {
		super();
		this.hoten = hoten;
		this.ngaysinh = ngaysinh;
		this.date = date;
	}

	public String getHoten() {
		return hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	public int getNgaysinh() {
		return ngaysinh;
	}

	public void setNgaysinh(int ngaysinh) {
		this.ngaysinh = ngaysinh;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void Nhap() {
		Scanner nhap = new Scanner(System.in);
		System.out.println("Moi ban nhap vao ho ten:");
		this.hoten = nhap.nextLine();
		System.out.println("Moi ban nhap vao ngay sinh:");
		this.ngaysinh = nhap.nextInt();
		date = new Date();
		System.out.println("Moi ban nhap vao Date:");
		date.nhap();

	}

	public void Hienthi() {
		System.out.println("Ho ten: " + this.hoten + "\n");
		System.out.println("Ngay sinh: " + this.ngaysinh + "\n");
		System.out.println("Ngay: " + date.ngay + "\n");
		System.out.println("Thang: " + date.thang + "\n");
		System.out.println("Nam : " + date.nam + "\n");

	}

}
