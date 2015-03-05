package vn.edu.cit.model;

public class TinhTrangServer {
	Server server;
	Date date;
	int CPU;
	int Ram;
	int Disk;

	public TinhTrangServer() {
	}

	public TinhTrangServer(Server server, Date date, int cPU, int ram, int disk) {
		super();
		this.server = server;
		this.date = date;
		CPU = cPU;
		Ram = ram;
		Disk = disk;
	}

	public Server getServer() {
		return server;
	}

	public void setServer(Server server) {
		this.server = server;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getCPU() {
		return CPU;
	}

	public void setCPU(int cPU) {
		CPU = cPU;
	}

	public int getRam() {
		return Ram;
	}

	public void setRam(int ram) {
		Ram = ram;
	}

	public int getDisk() {
		return Disk;
	}

	public void setDisk(int disk) {
		Disk = disk;
	}

}
