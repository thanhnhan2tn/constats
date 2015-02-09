package vn.edu.cit.model;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

/**
 * Server object with JSCH and Server table in DB
 * 
 * @author Thanh
 *
 */
public class Server {
	private int serverId;
	private String serverAddress;
	private int port = 22;
	private String serverName;
	private String serverUsername;
	private String serverPassword;

	public int getServerId() {
		return serverId;
	}

	public void setServerId(int serverId) {
		this.serverId = serverId;
	}

	public String getServerAddress() {
		return serverAddress;
	}

	public void setServerAddress(String serverAddress) {
		this.serverAddress = serverAddress;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getServerName() {
		return serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	public String getServerUsername() {
		return serverUsername;
	}

	public void setServerUsername(String serverUsername) {
		this.serverUsername = serverUsername;
	}

	public String getServerPassword() {
		return serverPassword;
	}

	public void setServerPassword(String serverPassword) {
		this.serverPassword = serverPassword;
	}

	// Xay dung
	public Server(String ip, int port, String username, String password) {
		super();
		this.serverAddress = ip;
		this.port = port;
		this.serverUsername = username;
		this.serverPassword = password;
	}

	// Xay dung
	public Server(String ip, String username, String password) {
		super();
		this.serverAddress = ip;
		this.serverUsername = username;
		this.serverPassword = password;
	}

	// Xay dung mac nhien
	public Server() {
		super();
		// TODO Auto-generated constructor stub
	}

	// Get Session
	public Session getSession(Server sv) {

		try {
			java.util.Properties config = new java.util.Properties();
			config.put("StrictHostKeyChecking", "no");
			JSch jsch = new JSch();
			// Khoi tao doi tuong Session
			Session session = jsch.getSession(sv.getServerUsername(),
					sv.getServerAddress(), sv.getPort());
			session.setPassword(sv.getServerPassword());
			session.setConfig(config);
			session.connect();
			System.out.println("Connected");
			return session;
		} catch (Exception e) {
			System.out.println("Khong the connect den server");
		}
		return null;
	}

}
