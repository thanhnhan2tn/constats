import java.util.ArrayList;
import java.util.List;

public class Nic {
	Eth[] eths;
	Dns multi_dns;

	public Nic() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Nic(Eth[] eths, Dns multi_dns) {
		super();
		this.eths = eths;
		this.multi_dns = multi_dns;
	}

	public Eth[] getEths() {
		return eths;
	}

	public void setEths(Eth[] eths) {
		this.eths = eths;
	}

	public Dns getMulti_dns() {
		return multi_dns;
	}

	public void setMulti_dns(Dns multi_dns) {
		this.multi_dns = multi_dns;
	}

	

}
