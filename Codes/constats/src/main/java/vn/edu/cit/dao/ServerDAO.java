package vn.edu.cit.dao;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

/**
 * Server object with JSCH and Server table in DB
 * 
 * @author Thanh
 *
 */
public class ServerDAO {
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

	public ServerDAO(String ip, int port, String username, String password) {
		super();
		this.serverAddress = ip;
		this.port = port;
		this.serverUsername = username;
		this.serverPassword = password;
	}

	/**
	 * Contrustor Server without port
	 * 
	 * @param ip
	 * @param username
	 * @param password
	 */
	public ServerDAO(String ip, String username, String password) {
		super();
		this.serverAddress = ip;
		this.serverUsername = username;
		this.serverPassword = password;
	}

	public ServerDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Connect method to server
	 * 
	 * @param sv
	 */
	public Session Connect(ServerDAO sv) {
//		System.out.println(sv.getServerAddress() + sv.getServerUsername()
//				+ sv.getPort() + sv.getServerPassword());
		try {
			java.util.Properties config = new java.util.Properties();
			config.put("StrictHostKeyChecking", "no");
			JSch jsch = new JSch();
			Session session = jsch.getSession(sv.getServerUsername(),
					sv.getServerAddress(), sv.getPort());
			session.setPassword(sv.getServerPassword());
			session.setConfig(config);
			session.connect();
			System.out.println("Connected");
			return session;
		} catch (Exception e) {
			System.out.println("Khong the connect den server");
			// e.printStackTrace();
		}
		return null;
	}

}
