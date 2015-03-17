public class QuanLyLopHoc {

	public void Sort_By_NamSinh(SinhVien[] sv) {
		System.out
				.println("------------SAP XEP THEO NGAY SINH--------------------");

		for (int k = 0; k < 2; k++) {
			for (int l = k + 1; l < 3; l++) {
				if (sv[k].ngaysinh < sv[l].ngaysinh) {
					float temp;
					temp = sv[k].DTB;
					sv[k].DTB = sv[l].DTB;
					sv[l].DTB = temp;

					String tempHT;
					tempHT = sv[k].hoten;
					sv[k].hoten = sv[l].hoten;
					sv[l].hoten = tempHT;

					int tempNS;
					tempNS = sv[k].ngaysinh;
					sv[k].ngaysinh = sv[l].ngaysinh;
					sv[l].ngaysinh = tempNS;

				}
			}
		}

	}

	public void Sort_By_DTB(SinhVien[] sv) {
		System.out.println("------------SAP XEP THEO DTB--------------------");

		for (int k = 0; k < 2; k++) {
			for (int l = k + 1; l < 3; l++) {
				if (sv[k].DTB < sv[l].DTB) {
					float temp;
					temp = sv[k].DTB;
					sv[k].DTB = sv[l].DTB;
					sv[l].DTB = temp;

					String tempHT;
					tempHT = sv[k].hoten;
					sv[k].hoten = sv[l].hoten;
					sv[l].hoten = tempHT;

					int tempNS;
					tempNS = sv[k].ngaysinh;
					sv[k].ngaysinh = sv[l].ngaysinh;
					sv[l].ngaysinh = tempNS;

				}
			}
		}

	}

	public void InDS_SinhVien(SinhVien[] sv) {

		System.out.println("--------------------------------");

		System.out.println("DS SV sau khi SX la:");
		for (int f = 0; f < 3; f++) {
			sv[f].Hienthi();
		}
	}

	public void NhapDS_SinhVien(SinhVien[] sv) {
		try {
			for (int i = 0; i < 3; i++) {
				System.out.println("Moi ban nhap vao sinh vien thu" + (i + 1));
				sv[i] = new SinhVien();
				sv[i].Nhap();
			}

			System.out.println("--------------------------------");

			// SX Luu y: nen dung bien chay khac voi cac bien trong vong lap o
			// tren, neu ko se loi nghiem trong

			System.out.println("--------------------------------");
		} catch (ArrayIndexOutOfBoundsException ar) {
			System.out.println("");
		}
	}

	public static void main(String[] args) {
		 LopHoc lh1 = new LopHoc();
		 lh1.Nhap();
		 lh1.HienThi();
		//QuanLyLopHoc ql = new QuanLyLopHoc();
		//SinhVien sv1 = new SinhVien();
		//sv1.setHoten("HiMinh");
		//System.out.println(sv1.getHoten());
		//sv1.Nhap();
		//SinhVien[] sv;
		
		//sv = new SinhVien[10];
		//ql.NhapDS_SinhVien(sv);
		//ql.Sort_By_DTB(sv);
		// ql.Sort_By_NamSinh(sv);
		//ql.InDS_SinhVien(sv);

	}
}
