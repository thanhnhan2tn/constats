package vn.edu.cit.model;

import java.util.List;

/**
 * @author Notexittran
 *
 */
public class User {
	private int userId;
	private String userName;
	private String passWord;
	private String role; // 1 hoac 2
	private String fullName;
	private String email;
	private String sdt;
	List<Server> server;

	public User() {

	}

	public User(int userId, String userName, String passWord, String role,
			String fullName, String email, String sdt) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.passWord = passWord;
		this.role = role;
		this.fullName = fullName;
		this.email = email;
		this.sdt = sdt;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<Server> getServer() {
		return server;
	}

	public void setServer(List<Server> server) {
		this.server = server;
	}

}
