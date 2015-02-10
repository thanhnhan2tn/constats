package vn.edu.cit.model;

public class Log_User {
	User user;
	Date date;
	String noidung;

	public Log_User() {
		// TODO Auto-generated constructor stub
	}

	public Log_User(User user, Date date, String noidung) {
		super();
		this.user = user;
		this.date = date;
		this.noidung = noidung;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getNoidung() {
		return noidung;
	}

	public void setNoidung(String noidung) {
		this.noidung = noidung;
	}
	
	

}
