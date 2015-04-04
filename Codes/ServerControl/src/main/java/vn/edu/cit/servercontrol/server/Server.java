package vn.edu.cit.servercontrol.server;

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

	public Server() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getServerName() {
		return serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	public int getServerId() {
		return serverId;
	}

	public Server(int serverId, String serverAddress, int port,
			String serverName, String serverUsername, String serverPassword) {
		super();
		this.serverId = serverId;
		this.serverAddress = serverAddress;
		this.port = port;
		this.serverName = serverName;
		this.serverUsername = serverUsername;
		this.serverPassword = serverPassword;
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
			System.out.println("Connected to Server Success !!!!");
			return session;
		} catch (Exception e) {
			System.out.println("Khong the connect den server");
		}
		return null;
	}

}
