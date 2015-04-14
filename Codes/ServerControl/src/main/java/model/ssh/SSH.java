package model.ssh;

public class SSH {
	private String port;
	private String listenAdd;
	private String loginGraceTime;
	private Boolean permitRootLogin;
	private Boolean passwordAu;
	private Boolean permitEmptyPassword;
	private String allowUsers;

	public SSH() {
		// TODO Auto-generated constructor stub
	}

	public SSH(String port, String listenAdd, String loginGraceTime,
			Boolean permitRootLogin, Boolean passwordAu,
			Boolean permitEmptyPassword, String allowUsers) {
		super();
		this.port = port;
		this.listenAdd = listenAdd;
		this.loginGraceTime = loginGraceTime;
		this.permitRootLogin = permitRootLogin;
		this.passwordAu = passwordAu;
		this.permitEmptyPassword = permitEmptyPassword;
		this.allowUsers = allowUsers;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getListenAdd() {
		return listenAdd;
	}

	public void setListenAdd(String listenAdd) {
		this.listenAdd = listenAdd;
	}

	public String getLoginGraceTime() {
		return loginGraceTime;
	}

	public void setLoginGraceTime(String loginGraceTime) {
		this.loginGraceTime = loginGraceTime;
	}

	public Boolean getPermitRootLogin() {
		return permitRootLogin;
	}

	public void setPermitRootLogin(Boolean permitRootLogin) {
		this.permitRootLogin = permitRootLogin;
	}

	public Boolean getPasswordAu() {
		return passwordAu;
	}

	public void setPasswordAu(Boolean passwordAu) {
		this.passwordAu = passwordAu;
	}

	public Boolean getPermitEmptyPassword() {
		return permitEmptyPassword;
	}

	public void setPermitEmptyPassword(Boolean permitEmptyPassword) {
		this.permitEmptyPassword = permitEmptyPassword;
	}

	public String getAllowUsers() {
		return allowUsers;
	}

	public void setAllowUsers(String allowUsers) {
		this.allowUsers = allowUsers;
	}

}
