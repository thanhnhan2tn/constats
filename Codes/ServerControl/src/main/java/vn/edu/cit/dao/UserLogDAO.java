package vn.edu.cit.dao;

public class UserLogDAO {
	private int userlogId;
	private int userId;
	private String logContent;
	
	public int getUserlogId() {
		return userlogId;
	}
	public void setUserlogId(int userlogId) {
		this.userlogId = userlogId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getLogContent() {
		return logContent;
	}
	public void setLogContent(String logContent) {
		this.logContent = logContent;
	}
}
