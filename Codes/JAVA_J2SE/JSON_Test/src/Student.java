import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONAware;

public class Student implements JSONAware {

	int id;
	String name;
	String email;

	public Student() {

	}

	public Student(int id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}

	// Các phương thức get và set ...de su dung get va set sau nay

	String getEmail() {
		// TODO Auto-generated method stub
		return email;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	int getId() {
		// TODO Auto-generated method stub
		return id;
	}

	// Phần quan trọng nhất: ObjectToJSONString()

	@Override
	public String toJSONString() {

		StringBuffer sb = new StringBuffer();

		sb.append("{ \n"); // Bắt đầu một đối tượng JSON là dấu mở ngoặc nhọn

		sb.append("\"id\":\"" + getId() + "\""); // dòng này có nghĩa là
													// "id":"Giá_Trị"
		sb.append(", \n"); // sau mỗi cặp key/value là một dấu phẩy

		sb.append("\"name\":\"" + getName() + "\"");
		sb.append(",\n");

		sb.append("\"email\":\"" + getEmail() + "\"");

		sb.append("\n}\n"); // Kết thúc một đối tượng JSON là dấu đóng ngoặc
							// nhọn

		return sb.toString();

	}

	public static void main(String[] args) {
/*
		Student student = new Student(1, "Duy hung", "duyhung.ws@gmail.com");
		Student student2 = new Student(2, "Hieu Minh", "duyhung.ws@gmail.com");
		Student student3 = new Student(3, "Duyen do", "duyhung.ws@gmail.com");

		String JSONResult = student.toJSONString();
		String JSONResult2 = student2.toJSONString();
		String JSONResult3 = student3.toJSONString();

		System.out.println(JSONResult);
		System.out.println(JSONResult2);
		System.out.println(JSONResult3);
*/
		
		// Dung JSON Array
		List<Student> list = new ArrayList<Student>();
		list.add(new Student(2, "Hieu Minh", "duyhung.ws@gmail.com"));
		list.add(new Student(3, "Duyen do", "duyhung.ws@gmail.com"));
		
		   String JSONResult = JSONArray.toJSONString(list);
		   
	        System.out.println(JSONResult);

	}
}
