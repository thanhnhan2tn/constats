package xml_To_Object;

import java.util.List;

public class Header {
	List<Logo> logo;

	public Header(List<Logo> logo) {
		super();
		this.logo = logo;
	}

	public Header() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<Logo> getLogo() {
		return this.logo;
	}

	public void setLogo(List<Logo> logo) {
		this.logo = logo;
	}

}
