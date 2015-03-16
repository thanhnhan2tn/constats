package com.thanhnhantn.constats.components;

public class Link {
	private String id;
	private String name;
	private String value;
	private String title="";
	private String alt ="";
	
	public Link() {
		// TODO Auto-generated constructor stub
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAlt() {
		return alt;
	}
	public void setAlt(String alt) {
		this.alt = alt;
	}
	public Link(String id, String name, String value, String title, String alt) {
		super();
		this.id = id;
		this.name = name;
		this.value = value;
		this.title = title;
		this.alt = alt;
	}
	@Override
	public String toString() {
		return "Link [getId()=" + getId() + ", getName()=" + getName()
				+ ", getAlt()=" + getAlt() + "]";
	}

}
