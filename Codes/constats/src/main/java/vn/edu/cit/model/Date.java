package vn.edu.cit.model;

public class Date {
String ngay;
String thang;
String nam;
int gio;
int phut;
int giay;


	public Date() {
		// TODO Auto-generated constructor stub
	}


	public Date(String ngay, String thang, String nam, int gio, int phut,
			int giay) {
		super();
		this.ngay = ngay;
		this.thang = thang;
		this.nam = nam;
		this.gio = gio;
		this.phut = phut;
		this.giay = giay;
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


	public int getGio() {
		return gio;
	}


	public void setGio(int gio) {
		this.gio = gio;
	}


	public int getPhut() {
		return phut;
	}


	public void setPhut(int phut) {
		this.phut = phut;
	}


	public int getGiay() {
		return giay;
	}


	public void setGiay(int giay) {
		this.giay = giay;
	}

	
}
