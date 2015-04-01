package vn.edu.cit.model;

import org.springframework.data.mongodb.core.mapping.Document;

import vn.edu.cit.servercontrol.ServerStatus;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

/**
 * Server object with JSCH and Server table in DB
 * 
 * @author Thanh
 *
 */
@Document(collection = "servers")
public class Server {
	private String serverAddress;
	private int port = 22;
	private String serverName;
	private String serverUsername;
	private String serverPassword;
	private ServerStatus status;
	
	public Server() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ServerStatus getStatus() {
		return status;
	}

	public void setStatus(ServerStatus status) {
		this.status = status;
	}

	public String getServerName() {
		return serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	public Server(String serverAddress, int port, String serverName, String serverUsername, String serverPassword) {
		super();
		this.serverAddress = serverAddress;
		this.port = port;
		this.serverName = serverName;
		this.serverUsername = serverUsername;
		this.serverPassword = serverPassword;
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

	/**
	 * Check Server Status
	 * 
	 * @param sv
	 * @return
	 */
	public boolean checkStatus() {
		return (getSession(this) != null);
	}

	/**
	 * Get Session
	 * 
	 * @param sv
	 * @return
	 */
	public Session getSession(Server sv) {

		try {
			java.util.Properties config = new java.util.Properties();
			config.put("StrictHostKeyChecking", "no");
			JSch jsch = new JSch();
			// Khoi tao doi tuong Session
			Session session = jsch.getSession(sv.getServerUsername(), sv.getServerAddress(), sv.getPort());
			session.setPassword(sv.getServerPassword());
			session.setConfig(config);
			// session.setTimeout(10000);
			session.connect();
			// System.out.println("Connected to Server Success !!!!");
			return session;
		} catch (Exception e) {
			return null;
		}

	}

}
