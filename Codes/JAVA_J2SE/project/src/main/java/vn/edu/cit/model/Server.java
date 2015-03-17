package vn.edu.cit.model;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

/**
 * Server object with JSCH
 * @author Thanh
 *
 */
public class Server {
	String ip;
	int port=22;
	String username;
	String password;
	public Server(String ip, int port, String username, String password) {
		super();
		this.ip = ip;
		this.port = port;
		this.username = username;
		this.password = password;
	}
	
	/**
	 * Contrustor Server without port
	 * @param ip
	 * @param username
	 * @param password
	 */
	public Server(String ip, String username, String password) {
		super();
		this.ip = ip;
		this.username = username;
		this.password = password;
	}
	public Server() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Connect method to server
	 * @param sv
	 */
	public Session Connect(Server sv){
		System.out.println(sv.getIp()+sv.getUsername()+sv.getPort()+sv.getPassword());
		try{
            java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            JSch jsch = new JSch();
            Session session=jsch.getSession(sv.getUsername(),sv.getIp(), sv.getPort());
            session.setPassword(sv.getPassword());
            session.setConfig(config);
            session.connect();
            System.out.println("Connected");
            return session;
        }catch(Exception e){
        	System.out.println("Khong the connect den server");
        	e.printStackTrace();
        }
		return null;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}

