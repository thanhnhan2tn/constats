package vn.edu.cit.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Notexittran
 *
 */
@Document(collection = "users")
public class User {
	private String email;
	private String passWord;
	private int role;
	private String firstName;
	private String lastName;
	private String sdt;
	List<Server> server;

	public User() {

	}

	public User(String email, String passWord, int role, String firstName,
			String lastName) {
		super();
		this.passWord = passWord;
		this.role = role;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public List<Server> getServer() {
		return server;
	}

	public void setServer(List<Server> server) {
		this.server = server;
	}

}
