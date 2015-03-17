package com.thanhnhantn.constats.components;

public class LinkRel {
	private String rel;
	private String href;
	private String type;

	public LinkRel(String rel, String href, String type) {
		super();
		this.rel = rel;
		this.href = href;
		this.type = type;
	}

	public String getRel() {
		return rel;
	}

	public void setRel(String rel) {
		this.rel = rel;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public LinkRel() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		String str = "";
		str += (getRel() == null) ? "" : "rel = '" + getRel() + "'";
		str += (getHref() == null) ? "" : "href = '" + getHref() + "'";
		str += (getType() == null) ? "" : "type = '" + getType() + "'";
		return str;
	}
}
