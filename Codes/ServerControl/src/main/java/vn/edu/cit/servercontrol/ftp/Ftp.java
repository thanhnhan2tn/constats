package vn.edu.cit.servercontrol.ftp;

public class Ftp {
	String listen;
	String anonymous_enable;
	String local_enable;
	String write_enable;
	String anon_upload_enable;
	String anon_mkdir_write_enable;
	String connect_from_port_20;
	String deny_email_enable;
	String chroot_local_user;
	String chroot_list_enable;
	String chroot_list_file;

	public Ftp() {
		// TODO Auto-generated constructor stub
	}

	public Ftp(String listen, String anonymous_enable, String local_enable,
			String write_enable, String anon_upload_enable,
			String anon_mkdir_write_enable, String connect_from_port_20,
			String deny_email_enable, String chroot_local_user,
			String chroot_list_enable, String chroot_list_file) {
		super();
		this.listen = listen;
		this.anonymous_enable = anonymous_enable;
		this.local_enable = local_enable;
		this.write_enable = write_enable;
		this.anon_upload_enable = anon_upload_enable;
		this.anon_mkdir_write_enable = anon_mkdir_write_enable;
		this.connect_from_port_20 = connect_from_port_20;
		this.deny_email_enable = deny_email_enable;
		this.chroot_local_user = chroot_local_user;
		this.chroot_list_enable = chroot_list_enable;
		this.chroot_list_file = chroot_list_file;
	}

	public String getListen() {
		return listen;
	}

	public void setListen(String listen) {
		this.listen = listen;
	}

	public String getAnonymous_enable() {
		return anonymous_enable;
	}

	public void setAnonymous_enable(String anonymous_enable) {
		this.anonymous_enable = anonymous_enable;
	}

	public String getLocal_enable() {
		return local_enable;
	}

	public void setLocal_enable(String local_enable) {
		this.local_enable = local_enable;
	}

	public String getWrite_enable() {
		return write_enable;
	}

	public void setWrite_enable(String write_enable) {
		this.write_enable = write_enable;
	}

	public String getAnon_upload_enable() {
		return anon_upload_enable;
	}

	public void setAnon_upload_enable(String anon_upload_enable) {
		this.anon_upload_enable = anon_upload_enable;
	}

	public String getAnon_mkdir_write_enable() {
		return anon_mkdir_write_enable;
	}

	public void setAnon_mkdir_write_enable(String anon_mkdir_write_enable) {
		this.anon_mkdir_write_enable = anon_mkdir_write_enable;
	}

	public String getConnect_from_port_20() {
		return connect_from_port_20;
	}

	public void setConnect_from_port_20(String connect_from_port_20) {
		this.connect_from_port_20 = connect_from_port_20;
	}

	public String getDeny_email_enable() {
		return deny_email_enable;
	}

	public void setDeny_email_enable(String deny_email_enable) {
		this.deny_email_enable = deny_email_enable;
	}

	public String getChroot_local_user() {
		return chroot_local_user;
	}

	public void setChroot_local_user(String chroot_local_user) {
		this.chroot_local_user = chroot_local_user;
	}

	public String getChroot_list_enable() {
		return chroot_list_enable;
	}

	public void setChroot_list_enable(String chroot_list_enable) {
		this.chroot_list_enable = chroot_list_enable;
	}

	public String getChroot_list_file() {
		return chroot_list_file;
	}

	public void setChroot_list_file(String chroot_list_file) {
		this.chroot_list_file = chroot_list_file;
	}
	
	

}
