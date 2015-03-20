package Test_ThuaKe;

public class SinhVien extends Nguoi {

	public static void main(String[] args) {
		SinhVien[] sv1 = new SinhVien[3];
		for (int i = 0; i < 3; i++) {
			sv1[i]= new SinhVien();
			System.out.println("Moi ban nhap vao sinh vien thu:" + i + 1);
			sv1[i].nhap();

		}
		// Sap xep
		for (int k = 0; k < 2; k++) {
			for (int l = k + 1; l < 3; l++) {
				if (sv1[k].getNamsinh() < sv1[l].getNamsinh()) {
					int temp;
					temp = sv1[k].namsinh;
					sv1[k].namsinh = sv1[l].namsinh;
					sv1[l].namsinh = temp;
					
					String temp2;
					temp2 = sv1[k].hoten;
					sv1[k].hoten = sv1[l].hoten;
					sv1[l].hoten = temp2;

				}
			}
		}

		// Hien thi
		for (int m = 0; m < 3; m++) {
			sv1[m].hienthi();
		}
	}
}
