package vn.edu.cit.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "logs")
public class Log {
	private String dateTime;
	private String logContent;
	
	public Log(String dateTime, String logContent) {
		super();
		this.dateTime = dateTime;
		this.logContent = logContent;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public String getLogContent() {
		return logContent;
	}

	public void setLogContent(String logContent) {
		this.logContent = logContent;
	}

}