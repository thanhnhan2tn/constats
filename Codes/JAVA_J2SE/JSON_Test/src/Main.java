import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Main {
	// Parse test
	public static <T> T parseObjectFromString(String hoten, String namsinh,
			Class<T> clazz) throws Exception {
		return clazz.getConstructor(new Class[] { String.class, String.class })
				.newInstance(hoten, namsinh);
	}

	public static void main(String[] args) throws Exception {
		/*
		 * // Chuỗi JSON mẫu mô tả một đối tượng Nic, ten bien name trong chuoi
		 * phu // thuoc vao phuong thuc get ben duoi, nen dat trung nhau, neu ko
		 * se bao // ket qua = null String jsonString =
		 * "{\"address\" : \"192.168.0.109\", \"netmask\" : \"255.255.255.0\", \"gateway\" : \"192.168.0.1\"}"
		 * ;
		 * 
		 * // Phân tích try {
		 * 
		 * // 1. Tạo ra một JSONParser JSONParser jsonParser = new JSONParser();
		 * 
		 * // 2. Parser chuỗi JSON về một JSONObject JSONObject jsonObject =
		 * (JSONObject) jsonParser.parse(jsonString);
		 * 
		 * // 3. Lấy các giá trị trong jsonObject thông qua các Key
		 * 
		 * String address = (String) jsonObject.get("address");
		 *  String netmask = (String) jsonObject.get("netmask"); 
		 *  String gateway = (String)jsonObject.get("gateway");
		 * 
		 * // Student student = new Student(id, name, email); Nic nic = new
		 * Nic(address, netmask, gateway);
		 * 
		 * System.out.println("Address    : " + nic.getAddress());
		 * System.out.println("Netmask : " + nic.getNetmask());
		 * System.out.println("Gateway   : " + nic.getGateway());
		 * 
		 * } catch (ParseException e) { e.printStackTrace(); }
		 */
		// ---------------Parse test
		SinhVien obj1 = parseObjectFromString("Hieu Minh", "1993",
				SinhVien.class);
		System.out.println("Obj: " + "\n" + obj1.toString() + "hoten:"
				+ obj1.getHoten() + "\n" + "Namsinh " + obj1.getNamsinh());

	}
}