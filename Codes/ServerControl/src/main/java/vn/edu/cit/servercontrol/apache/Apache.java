package vn.edu.cit.servercontrol.apache;

import java.util.List;

public class Apache {
	ConfigChung configchung;
	List<Directory> directorys;
	List<VirtualHost> vitualhosts;

	public Apache() {

	}

	public Apache(ConfigChung configchung, List<Directory> directorys,
			List<VirtualHost> vitualhosts) {
		super();
		this.configchung = configchung;
		this.directorys = directorys;
		this.vitualhosts = vitualhosts;
	}

	public ConfigChung getConfigchung() {
		return configchung;
	}

	public void setConfigchung(ConfigChung configchung) {
		this.configchung = configchung;
	}

	public List<Directory> getDirectorys() {
		return directorys;
	}

	public void setDirectorys(List<Directory> directorys) {
		this.directorys = directorys;
	}

	public List<VirtualHost> getVitualhosts() {
		return vitualhosts;
	}

	public void setVitualhosts(List<VirtualHost> vitualhosts) {
		this.vitualhosts = vitualhosts;
	}

}
