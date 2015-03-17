package vn.edu.cit.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "userlogs")
public class UserLog {
	private User user;
	private String logContent;

	public UserLog(User user, String logContent) {
		super();
		this.user = user;
		this.logContent = logContent;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getLogContent() {
		return logContent;
	}

	public void setLogContent(String logContent) {
		this.logContent = logContent;
	}
}
