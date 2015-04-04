package model.dns;

import java.util.List;

public class Option {
	String directory;
	String recursion;
	AllowTransfer allow_transfer;
	AllowNotify allow_notify;
	AllowQuery allow_query;
	Forwarders forwarders;
	String forward_only;

	public Option() {
	}

}
