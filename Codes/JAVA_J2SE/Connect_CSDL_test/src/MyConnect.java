import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MyConnect {
	// Khai báo ClassName dùng cho Class.forName
	private final String className = "com.mysql.jdbc.Driver";
	// Luu y o day la ket noi toi localhost chu ko phai chay port tren trinh
	// duyet
	private final String url = "jdbc:mysql://localhost/mydb";
	// Khai bao connection
	private java.sql.Connection connection;
	// Khai bao truy van
	private java.sql.Statement statement;

	private void connect() {
		try {
			// ----------------------
			Class.forName(className);
			try {
				// Tao connection (url, "username", "password") dung de dang
				// nhap vao database, password o day tau de rong
				connection = DriverManager.getConnection(url, "root", "");
				System.out.println("Success!!!!");

			} catch (SQLException e) {
				System.out.print("Class not found!!!!");
			}
		} catch (ClassNotFoundException e) {
			System.out.print("Error Connect !!!");

		}
	}

	private void query() {
		try {
			// tao doi tuong truy van tu connection
			statement = connection.createStatement();
			// Set truy van
			String sql = "select * from sinhvien";
			// Set insert vao du lieu
			String insert = "insert into sinhvien values (1000, 'Hieu minh')";
			// Thuc thi insert
			statement.execute(insert);

			String delete = "delete from sinhvien where mssv = 1000";
			statement.execute(delete);
			// Kiem tra du lieu trung
ResultSet rsCheck = statement.executeQuery(sql);
			// Set ket qua tu truy van
			ResultSet rs = statement.executeQuery(sql);
			int count = 0;
			while (rs.next()) {
				int mssv = rs.getInt(1);
				String hoten = rs.getString(2);

				System.out.println("mssv : " + mssv);
				System.out.println("hoten : " + hoten);
				System.out.println("-------------------");
				count++;

			}
			System.out.print("so dong trong bang: " + count);
		} catch (SQLException e) {
			System.out.print("Loi ko truy van dc");
		}
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		MyConnect myConnect = new MyConnect();
		myConnect.connect();
		myConnect.query();

	}
}
